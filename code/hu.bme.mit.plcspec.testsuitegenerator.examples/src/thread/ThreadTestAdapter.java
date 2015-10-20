package thread;

public class ThreadTestAdapter {
	private Thread thread = null;

	public ThreadTestAdapter(Thread thread) {
    	this.thread = thread;
	}

	public int start() {
		return thread.start();
	}

	public int terminate1() {
		return thread.terminate();
	}

	public int terminate2() {
		return thread.terminate();
	}

	public int terminate3() {
		return thread.terminate();
	}

	public int sleep() {
		return thread.sleep();
	}

	public int wait1() {
		return thread.wait1();
	}

	public int join1() {
		return thread.join1();
	}

	public int wait2() {
		return thread.wait2();
	}

	public int join2() {
		return thread.join2();
	}

	public int waitForLock() {
		return thread.waitForLock();
	}

	public int timeout() {
		return thread.timeout();
	}

	public int notify1() {
		return thread.notify1();
	}

	public int notifyAll1() {
		return thread.notifyAll1();
	}

	public int monitorLockAcquired() {
		return thread.monitorLockAcquired();
	}

}
