package simpletransitioncoverage;

public class SimpleTransitionCoverageTestAdapter {
	private SimpleTransitionCoverage simpletransitioncoverage = null;

	public SimpleTransitionCoverageTestAdapter(SimpleTransitionCoverage simpletransitioncoverage) {
    	this.simpletransitioncoverage = simpletransitioncoverage;
	}

	public int t0() {
		return simpletransitioncoverage.t0();
	}

	public int t1() {
		return simpletransitioncoverage.t1();
	}

	public int t2() {
		return simpletransitioncoverage.t2();
	}

	public int t3() {
		return simpletransitioncoverage.t3();
	}

	public int t4() {
		return simpletransitioncoverage.t4();
	}

}
