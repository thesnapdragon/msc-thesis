package stopwatch;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class StopWatchTest extends TestCase {
	protected StopWatch stopwatch = null;
	protected StopWatchTestAdapter adapter = null;
	   
	@Before 
	public void setUp() {
		stopwatch = new StopWatch();
		adapter = new StopWatchTestAdapter(stopwatch);
	}

	@Test
	public void testPath1() {
		assertEquals(1, adapter.on());
		assertEquals(2, adapter.start());
		assertEquals(3, adapter.stop());
		assertEquals(5, adapter.off());
	}

	@Test
	public void testPath2() {
		assertEquals(1, adapter.on());
		assertEquals(2, adapter.start());
		assertEquals(4, adapter.split());
		assertEquals(2, adapter.unsplit());
		assertEquals(3, adapter.stop());
		assertEquals(5, adapter.off());
	}

}
