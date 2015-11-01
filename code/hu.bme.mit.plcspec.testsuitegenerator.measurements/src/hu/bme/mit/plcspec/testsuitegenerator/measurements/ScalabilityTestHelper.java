package hu.bme.mit.plcspec.testsuitegenerator.measurements;

public class ScalabilityTestHelper {

	public static void main(String[] args) {
		String[] files = {
				"scalability_test10",
				"scalability_test100",
				"scalability_test200",
				"scalability_test400",
				"scalability_test800"
		};
		PlchsmModelGenerator generator = new PlchsmModelGenerator();
		for (String file : files) {
			generator.generate(file);
		}
	}

}
