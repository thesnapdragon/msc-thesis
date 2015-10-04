package hu.bme.mit.plcspec.testsuitegenerator.testing;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface TestCase extends EObject {
	/**
	 * @model
	 */
	String getInput();
	
	/**
	 * Sets the value of the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(String value);

	/**
	 * @model
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);
}
