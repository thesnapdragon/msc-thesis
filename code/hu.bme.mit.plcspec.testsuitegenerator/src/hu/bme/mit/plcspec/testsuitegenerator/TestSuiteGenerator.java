package hu.bme.mit.plcspec.testsuitegenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicMonitor;

import ch.cern.en.ice.plcspec.model.plchsm.Constant;
import ch.cern.en.ice.plcspec.model.plchsm.InState;
import ch.cern.en.ice.plcspec.model.plchsm.StatemachineModule;
import ch.cern.en.ice.plcspec.model.plchsm.SwitchCaseRow;
import ch.cern.en.ice.plcspec.model.plchsm.SwitchCaseTable;
import ch.cern.en.ice.plcspec.model.plchsm.Transition;
import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import hu.bme.mit.plcspec.testsuitegenerator.alloy.GenerationType;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestingFactory;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage;

public class TestSuiteGenerator {

	private File targetFolder;
	private GenerationType generationType;
	private StatemachineModule model;

	public TestSuiteGenerator(File targetFolder, GenerationType generationType, ch.cern.en.ice.plcspec.model.plchsm.System system) {
		this.targetFolder = targetFolder;
		this.generationType = generationType;
		this.model = (StatemachineModule) system.getModules().get(0);
	}

	public void generate() {
		A4Solution solution = getAlloySolution();
		if (solution.equals(null)) {
			// TODO Popup window with the error
			System.err.println("Can not compile the current model!");
		} else {
			if (solution.satisfiable()) {
				AlloySolutionParser parser = new AlloySolutionParser();
				ArrayList<ArrayList<String>> paths = parser.generatePaths(solution.toString());

				// creating model
				TestingPackage.eINSTANCE.eClass();
				TestingFactory factory = TestingFactory.eINSTANCE;
				TestSuite testSuite = factory.createTestSuite();
				testSuite.setSutName(this.model.getName());
				SwitchCaseTable switchCase = (SwitchCaseTable) this.model.getO_outputDefinitions().get(0).getExpression();
				
				for (ArrayList<String> path : paths) {
					TestCoverage testCoverage = factory.createTestCoverage();
					for (String transition : path) {
						TestCase testCase = factory.createTestCase();
						testCase.setInput(transition);
						testCase.setOutput(getOutput(model, switchCase, transition));
						testCoverage.getTestCases().add(testCase);
					}
					testSuite.getTestCoverages().add(testCoverage);
				}
				
				try {
					GenerateJava generator = new GenerateJava(testSuite, targetFolder, new ArrayList<String>());
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
	
	private String getOutput(StatemachineModule model, SwitchCaseTable switchCase, String transition) {
		return getOutputInState(switchCase, getStateFromTransition(model, transition));
	}
	
	private String getStateFromTransition(StatemachineModule model, String transitionName) {
		for (Transition transition : model.getTransitions()) {
			if (transition.getName().matches(transitionName))
				return transition.getFrom().getName();
		}
		return null;
	}

	private String getOutputInState(SwitchCaseTable switchCase, String state) {
		for (SwitchCaseRow row : switchCase.getRows()) {
			InState inState = (InState) row.getCondition().getArguments().get(0);
			if (inState.getState().getName().matches(state)) {
				Constant value = (Constant) row.getValue();
				return value.getValue();
			}
		}
		return null;
	}

	private A4Solution getAlloySolution() {
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
