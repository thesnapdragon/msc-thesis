package hu.bme.mit.plcspec.testsuitegenerator.testing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface TestSuite extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Coverages</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Coverages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Coverages</em>' containment reference list.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage#getTestSuite_TestCoverages()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestCoverage> getTestCoverages();
}
