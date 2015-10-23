package useraccount;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class UserAccountTest extends TestCase {
	protected UserAccount useraccount = null;
	protected UserAccountTestAdapter adapter = null;
	   
	@Before 
	public void setUp() {
		useraccount = new UserAccount();
		adapter = new UserAccountTestAdapter(useraccount);
	}

	@Test
	public void testPath1() {
		assertEquals(0, adapter.create());
		assertEquals(1, adapter.activate());
		assertEquals(2, adapter.suspend2());
		assertEquals(1, adapter.unlock());
		assertEquals(3, adapter.cancel2());
		assertEquals(4, adapter.delete());
	}

	@Test
	public void testPath2() {
		assertEquals(0, adapter.create());
		assertEquals(1, adapter.activate());
		assertEquals(3, adapter.cancel2());
		assertEquals(4, adapter.delete());
	}

}
