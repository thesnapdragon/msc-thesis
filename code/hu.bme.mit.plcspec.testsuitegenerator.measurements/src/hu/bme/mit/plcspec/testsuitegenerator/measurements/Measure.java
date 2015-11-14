package hu.bme.mit.plcspec.testsuitegenerator.measurements;

import java.io.File;
import java.util.HashMap;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options.SatSolver;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class Measure {
	public static void main(String[] args){
		A4Reporter rep = new A4Reporter() {
            @Override public void warning(ErrorWarning msg) {
                System.out.flush();
            }
        };
        String[] files = {
        		"statecoverage_t02.als", "statecoverage_t03.als", "statecoverage_t04.als",
        		"statecoverage_t05.als", "statecoverage_t06.als", "statecoverage_t07.als",
        		"statecoverage_t08.als", "statecoverage_t09.als", "statecoverage_t10.als",
        		"statecoverage_t11.als", "statecoverage_t12.als", "statecoverage_t13.als",
        		"statecoverage_t14.als", "statecoverage_t15.als", "statecoverage_t16.als",
        		"statecoverage_t17.als", "statecoverage_t18.als", "statecoverage_t19.als",
        		"statecoverage_t20.als", "statecoverage_t21.als", "statecoverage_t22.als",
        		"statecoverage_t23.als", "statecoverage_t24.als", "statecoverage_t25.als"
        };
        int[] symmetries = {0};
        int[] skolemDepths = {4};
        
        for(String file : files) {
        	System.out.println(file);
        	for(int skolemDepth : skolemDepths) {
//        		System.out.println(skolemDepth);
	        	for(int symmetry : symmetries) {
//	        		System.out.println(symmetry);
			        File alloyFile = new File("resources/" + file);
					Module world = null;
					try {
						world = CompUtil.parseEverything_fromFile(rep, null, alloyFile.getAbsolutePath());
					} catch (Err e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Command cmd = world.getAllCommands().get(0);
					A4Options opt = new A4Options();
					opt.originalFilename = alloyFile.getAbsolutePath();
//					opt.symmetry = symmetry;
//					opt.skolemDepth = skolemDepth;
					for(int i = 0; i < 10; i++) {
						HashMap<String, Long> results = new HashMap<String, Long>();
//						for (SatSolver solver : A4Options.SatSolver.values()) {
							opt.solver = A4Options.SatSolver.GlucoseJNI;
							try {
								results.put(opt.solver.id(), measure(rep, world, cmd, opt));
							} catch (Err e) {
								// TODO Auto-generated catch block
				//				e.printStackTrace();
							}
//						}
						System.out.println(results);
					}
	        	}
        	}
        }
	}
	
	private static long measure(A4Reporter rep, Module world, Command cmd, A4Options opt) throws Err {
		long start = System.currentTimeMillis();
		process(rep, world, cmd, opt);
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	private static void process(A4Reporter rep, Module world, Command cmd, A4Options opt) throws Err {
		TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), cmd, opt);
	}
}
