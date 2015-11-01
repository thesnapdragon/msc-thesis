package hu.bme.mit.plcspec.testsuitegenerator.measurements;

public class ScalabilityTestHelper {

	public static void main(String[] args) {
		PlchsmModelGenerator generator = new PlchsmModelGenerator();
		for (int i = 2; i <= 50; i++) {
			generator.generate("scalability_test_t0" + i);
		}
	}

}
