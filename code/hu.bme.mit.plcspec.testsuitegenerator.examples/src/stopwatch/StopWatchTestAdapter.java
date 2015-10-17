package stopwatch;

public class StopWatchTestAdapter {
	private StopWatch stopwatch = null;

	public StopWatchTestAdapter(StopWatch stopwatch) {
    	this.stopwatch = stopwatch;
	}

	public int on() {
		return stopwatch.on();
	}

	public int start() {
		return stopwatch.start();
	}

	public int stop() {
		return stopwatch.stop();
	}

	public int split() {
		return stopwatch.split();
	}

	public int off() {
		return stopwatch.off();
	}

	public int reset() {
		return stopwatch.reset();
	}

	public int unsplit() {
		return stopwatch.unsplit();
	}

	public int stop2() {
		return stopwatch.stop();
	}

}
