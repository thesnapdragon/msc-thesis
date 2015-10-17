package simpletransitioncoverage;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SimpleTransitionCoverageTest extends TestCase {
	protected SimpleTransitionCoverage simpletransitioncoverage = null;
	protected SimpleTransitionCoverageTestAdapter adapter = null;
	   
	@Before 
	public void setUp() {
		simpletransitioncoverage = new SimpleTransitionCoverage();
		adapter = new SimpleTransitionCoverageTestAdapter(simpletransitioncoverage);
	}

	@Test
	public void testPath1() {
		assertEquals(1, adapter.t0());
		assertEquals(4, adapter.t3());
		assertEquals(3, adapter.t4());
	}

	@Test
	public void testPath2() {
		assertEquals(1, adapter.t0());
		assertEquals(2, adapter.t1());
		assertEquals(3, adapter.t2());
	}

}
