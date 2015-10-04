package hu.bme.mit.plcspec.alloygenerator.compiler;

import java.io.File;
import java.util.ArrayList;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import hu.bme.mit.plcspec.alloygenerator.common.GenerationType;

public class Compiler {
	
	private File targetFolder;
	private GenerationType generationType;
	
	public Compiler(File targetFolder, GenerationType generationType) {
		this.targetFolder = targetFolder;
		this.generationType = generationType;
	}

	public void compile() {
		A4Reporter rep = new A4Reporter() {
            @Override public void warning(ErrorWarning msg) {
//            	TODO Correct error handling
            }
        };
        String fileName = null;
        if (this.generationType.equals(GenerationType.STATE_COVERAGE)) {
        	fileName = "statecoverage.als";
        } else {
        	fileName = "transitioncoverage.als";
        }
        File alloyFile = new File(targetFolder, fileName); 
        try {
			Module world = CompUtil.parseEverything_fromFile(rep, null, alloyFile.getAbsolutePath());
			A4Options opt = new A4Options();
	        opt.originalFilename = alloyFile.getAbsolutePath();
	        if (this.generationType.equals(GenerationType.STATE_COVERAGE)) {
	        	opt.solver = A4Options.SatSolver.MiniSatJNI;
	        } else {
	        	opt.solver = A4Options.SatSolver.LingelingJNI;
	        }
	        Command cmd = world.getAllCommands().get(0);
	        A4Solution sol = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), cmd, opt);
	        if (sol.satisfiable()) {
	        	ArrayList<Sig> paths = new ArrayList<Sig>();
	        	for (Sig sig : sol.getAllReachableSigs()) {
	        		System.out.println(sig.label);
					if (sig.label.matches("this/Path")) paths.add(sig);
				}
	        	System.out.println(paths.get(0).getFields());
	        } else {
	        	// TODO Popup window with the error
	        	System.err.println("The current model is unsatisfiable!");
	        }
        } catch (Err e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
