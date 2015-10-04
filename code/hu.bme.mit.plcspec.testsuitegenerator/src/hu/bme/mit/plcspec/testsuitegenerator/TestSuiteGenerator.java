package hu.bme.mit.plcspec.testsuitegenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicMonitor;

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
import hu.bme.mit.plcspec.testsuitegenerator.alloy.GenerationType;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestingFactory;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage;

public class TestSuiteGenerator {

	private File targetFolder;
	private GenerationType generationType;

	public TestSuiteGenerator(File targetFolder, GenerationType generationType) {
		this.targetFolder = targetFolder;
		this.generationType = generationType;
	}

	public void generate() {
		A4Solution solution = getAlloySolution();
		if (solution.equals(null)) {
			// TODO Popup window with the error
			System.err.println("Can not compile the current model!");
		} else {
			if (solution.satisfiable()) {
				ArrayList<Sig> paths = new ArrayList<Sig>();
				for (Sig sig : solution.getAllReachableSigs()) {
					System.out.println(sig.label);
					if (sig.label.matches("this/Path"))
						paths.add(sig);
				}
				System.out.println(paths.get(0).getFields());

				// creating model
				TestingPackage.eINSTANCE.eClass();
				TestingFactory factory = TestingFactory.eINSTANCE;
				TestSuite testSuite = factory.createTestSuite();
				
				for (Sig path : paths) {
					TestCase testCase = factory.createTestCase();
					testCase.setInput("input");
					testCase.setOutput("output");
					testSuite.getTestCases().add(testCase);
				}
				
				try {
					GenerateJava generator = new GenerateJava(testSuite, new File("/tmp/"), new ArrayList<String>());
					generator.doGenerate(new BasicMonitor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				// TODO Popup window with the error
				System.err.println("The current model is unsatisfiable!");
			}	
		}
	}
	
	public A4Solution getAlloySolution() {
		A4Reporter rep = new A4Reporter() {
			@Override
			public void warning(ErrorWarning msg) {
				// TODO Correct error handling
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
			return TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), cmd, opt);
		} catch (Err e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
