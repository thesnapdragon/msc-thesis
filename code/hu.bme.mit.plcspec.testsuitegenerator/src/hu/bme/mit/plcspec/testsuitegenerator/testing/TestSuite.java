package hu.bme.mit.plcspec.testsuitegenerator.testing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface TestSuite extends EObject {
	/**
	 * @model containment="true"
	 */
	EList<TestCase> getTestCases();
}
