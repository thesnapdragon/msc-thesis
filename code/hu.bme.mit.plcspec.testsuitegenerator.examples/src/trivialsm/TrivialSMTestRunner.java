package trivialsm;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TrivialSMTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TrivialSMTest.class);
  		System.out.println(String.format("Finished in %.3f seconds", (float) result.getRunTime() / 1000));
		System.out.println(String.format("%d examples, %d failures, %d ignored", result.getRunCount(), result.getFailureCount(), result.getIgnoreCount()));
		if (!result.wasSuccessful()) {
			System.out.println("\nFailed examples:\n");
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.getDescription());
				System.out.println(failure.getTrace());
			}
		}
	}
}
