package thread;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ThreadTest extends TestCase {
	protected Thread thread = null;
	protected ThreadTestAdapter adapter = null;
	   
	@Before 
	public void setUp() {
		thread = new Thread();
		adapter = new ThreadTestAdapter(thread);
	}

	@Test
	public void testPath1() {
		assertEquals(1, adapter.start());
		assertEquals(5, adapter.waitForLock());
		assertEquals(1, adapter.monitorLockAcquired());
		assertEquals(5, adapter.waitForLock());
		assertEquals(1, adapter.monitorLockAcquired());
		assertEquals(4, adapter.wait2());
		assertEquals(1, adapter.notify1());
		assertEquals(2, adapter.wait1());
		assertEquals(3, adapter.terminate2());
	}

}
