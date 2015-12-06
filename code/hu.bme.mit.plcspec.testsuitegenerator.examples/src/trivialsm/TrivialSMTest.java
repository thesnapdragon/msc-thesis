package trivialsm;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TrivialSMTest extends TestCase {
	protected TrivialSM trivialsm = null;
	protected TrivialSMTestAdapter adapter = null;
	   
	@Before 
	public void setUp() {
		trivialsm = new TrivialSM();
		adapter = new TrivialSMTestAdapter(trivialsm);
	}

	@Test
	public void testPath1() {
		assertEquals(1, adapter.T0());
	}

}
