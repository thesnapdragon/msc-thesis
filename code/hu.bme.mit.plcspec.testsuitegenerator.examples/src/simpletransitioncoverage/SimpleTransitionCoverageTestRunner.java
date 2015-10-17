package simpletransitioncoverage;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SimpleTransitionCoverageTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SimpleTransitionCoverageTest.class);
  		System.out.println(String.format("Finished in %.4f seconds", (float) result.getRunTime()));
		System.out.println(String.format("%d examples, %d failures, %d ignored", result.getRunCount(), result.getFailureCount(), result.getIgnoreCount()));
		if (!result.wasSuccessful()) {
			System.out.println("\nFailed examples:\n");
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}
	}
}
