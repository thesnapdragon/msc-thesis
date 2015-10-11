/**
 */
package hu.bme.mit.plcspec.testsuitegenerator.testing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.plcspec.testsuitegenerator.testing.Adapter#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage#getAdapter()
 * @model
 * @generated
 */
public interface Adapter extends EObject {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.plcspec.testsuitegenerator.testing.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage#getAdapter_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // Adapter
