package useraccount;

public class UserAccountTestAdapter {
	private UserAccount useraccount = null;

	public UserAccountTestAdapter(UserAccount useraccount) {
    	this.useraccount = useraccount;
	}

	public int create() {
		return useraccount.create();
	}

	public int activate() {
		return useraccount.activate();
	}

	public int suspend1() {
		return useraccount.suspend();
	}

	public int cancel1() {
		return useraccount.cancel();
	}

	public int cancel2() {
		return useraccount.cancel();
	}

	public int cancel3() {
		return useraccount.cancel();
	}

	public int delete() {
		return useraccount.delete();
	}

	public int lock() {
		return useraccount.lock();
	}

	public int unlock() {
		return useraccount.unlock();
	}

	public int suspend2() {
		return useraccount.suspend();
	}

	public int resume() {
		return useraccount.resume();
	}

}
