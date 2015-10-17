package simplestatecoverage;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SimpleStateCoverageTest extends TestCase {
	protected SimpleStateCoverage simplestatecoverage = null;
	protected SimpleStateCoverageTestAdapter adapter = null;
	   
	@Before 
	public void setUp() {
		simplestatecoverage = new SimpleStateCoverage();
		adapter = new SimpleStateCoverageTestAdapter(simplestatecoverage);
	}

	@Test
	public void testPath1() {
		assertEquals(1, adapter.t0());
		assertEquals(2, adapter.t1());
		assertEquals(3, adapter.t2());
	}

}
