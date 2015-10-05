/**
 */
package hu.bme.mit.plcspec.testsuitegenerator.testing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Coverage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage#getTestCases <em>Test Cases</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage#getTestCoverage()
 * @model
 * @generated
 */
public interface TestCoverage extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Cases</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Cases</em>' containment reference list.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage#getTestCoverage_TestCases()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestCase> getTestCases();

} // TestCoverage
