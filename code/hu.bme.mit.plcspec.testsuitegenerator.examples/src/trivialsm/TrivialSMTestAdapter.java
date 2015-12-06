package trivialsm;

public class TrivialSMTestAdapter {
	private TrivialSM trivialsm = null;

	public TrivialSMTestAdapter(TrivialSM trivialsm) {
    	this.trivialsm = trivialsm;
	}

	public int T0() {
		return trivialsm.T0();
	}

}
