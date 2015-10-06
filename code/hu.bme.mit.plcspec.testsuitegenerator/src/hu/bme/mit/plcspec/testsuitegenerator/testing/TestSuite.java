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

	/**
	 * Returns the value of the '<em><b>Sut Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sut Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sut Name</em>' attribute.
	 * @see #setSutName(String)
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage#getTestSuite_SutName()
	 * @model
	 * @generated
	 */
	String getSutName();

	/**
	 * Sets the value of the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite#getSutName <em>Sut Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sut Name</em>' attribute.
	 * @see #getSutName()
	 * @generated
	 */
	void setSutName(String value);
}
