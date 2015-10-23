package useraccount;

public class UserAccount {
	private Boolean isUnique = false;
	public int create() {
		isUnique = true;
		return 0;
	}
	public int activate() {
		if (isUnique) {
			return 1;
		}
		return -1;
	}
	public int suspend() {
		return 2;
	}
	public int resume() {
		return 1;
	}
	public int cancel() {
		return 3;
	}
	public int delete() {
		return 4;
	}
	public int lock() {
		return 2;
	}
	public int unlock() {
		return 1;
	}
}
