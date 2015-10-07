package hu.bme.mit.plcspec.testsuitegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlloySolutionParser {
	private HashMap<String, String> firstSteps = null;
	private HashMap<String, String> via = null;
	private HashMap<String, String> nextStep = null;
	private ArrayList<ArrayList<String>> paths = null;
	
	public AlloySolutionParser() {
		firstSteps = new HashMap<String, String>();
		via = new HashMap<String, String>();
		nextStep = new HashMap<String, String>();
		paths = new ArrayList<ArrayList<String>>();
	}
	
	public ArrayList<ArrayList<String>> generatePaths(String solution) {
		parse(solution);
		for (String firstStep : firstSteps.values()) {
			String currentStep = firstStep;
			ArrayList<String> path = new ArrayList<String>();
			while(nextStep.containsKey(currentStep)) {
				path.add(via.get(currentStep));
				currentStep = nextStep.get(currentStep);
			}
			paths.add(path);
		}
		return paths;
	}
	
	private void parse(String solution) {
		String[] lines = solution.split("\\r?\\n");
		Pattern firstStepPattern = Pattern.compile("this/Path<:firstStep=\\{(.*)\\}");
		Pattern viaPattern = Pattern.compile("this/Step<:via=\\{(.*)\\}");
		Pattern nextStepPattern = Pattern.compile("this/Step<:nextStep=\\{(.*)\\}");
		for (String line : lines) {
			Matcher matcher = firstStepPattern.matcher(line);
			if (matcher.find()) {
				firstSteps = parseAssignments(matcher.group(1), firstSteps);
			}
			matcher = viaPattern.matcher(line);
			if (matcher.find()) {
				via = parseAssignments(matcher.group(1), via);
			}
			matcher = nextStepPattern.matcher(line);
			if (matcher.find()) {
				nextStep = parseAssignments(matcher.group(1), nextStep);
			}
		}
	}
	
	private HashMap<String, String> parseAssignments(String input, HashMap<String, String> result) {
		String[] assignments = input.split(", ");
		for (String assignment : assignments) {
			String[] splittedAssignment = assignment.split("->");
			result.put(splittedAssignment[0], splittedAssignment[1]);
		}
		return result;
	}
}
