package simplestatecoverage;

public class SimpleStateCoverageTestAdapter {
	private SimpleStateCoverage simplestatecoverage = null;

	public SimpleStateCoverageTestAdapter(SimpleStateCoverage simplestatecoverage) {
    	this.simplestatecoverage = simplestatecoverage;
	}

	public int t0() {
		return simplestatecoverage.t0();
	}

	public int t1() {
		return simplestatecoverage.t1();
	}

	public int t2() {
		return simplestatecoverage.t2();
	}

	public int t3() {
		return simplestatecoverage.t3();
	}

}
