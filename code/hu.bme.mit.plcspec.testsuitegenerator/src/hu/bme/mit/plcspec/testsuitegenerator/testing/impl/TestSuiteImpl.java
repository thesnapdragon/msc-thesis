/**
 */
package hu.bme.mit.plcspec.testsuitegenerator.testing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite;
import hu.bme.mit.plcspec.testsuitegenerator.testing.TestingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestSuiteImpl#getTestCoverages <em>Test Coverages</em>}</li>
 *   <li>{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestSuiteImpl#getSutName <em>Sut Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSuiteImpl extends MinimalEObjectImpl.Container implements TestSuite {
	/**
	 * The cached value of the '{@link #getTestCoverages() <em>Test Coverages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCoverages()
	 * @generated
	 * @ordered
	 */
	protected EList<TestCoverage> testCoverages;
	/**
	 * The default value of the '{@link #getSutName() <em>Sut Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSutName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUT_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSutName() <em>Sut Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSutName()
	 * @generated
	 * @ordered
	 */
	protected String sutName = SUT_NAME_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestingPackage.Literals.TEST_SUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestCoverage> getTestCoverages() {
		if (testCoverages == null) {
			testCoverages = new EObjectContainmentEList<TestCoverage>(TestCoverage.class, this, TestingPackage.TEST_SUITE__TEST_COVERAGES);
		}
		return testCoverages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSutName() {
		return sutName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSutName(String newSutName) {
		String oldSutName = sutName;
		sutName = newSutName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackage.TEST_SUITE__SUT_NAME, oldSutName, sutName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestingPackage.TEST_SUITE__TEST_COVERAGES:
				return ((InternalEList<?>)getTestCoverages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestingPackage.TEST_SUITE__TEST_COVERAGES:
				return getTestCoverages();
			case TestingPackage.TEST_SUITE__SUT_NAME:
				return getSutName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestingPackage.TEST_SUITE__TEST_COVERAGES:
				getTestCoverages().clear();
				getTestCoverages().addAll((Collection<? extends TestCoverage>)newValue);
				return;
			case TestingPackage.TEST_SUITE__SUT_NAME:
				setSutName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestingPackage.TEST_SUITE__TEST_COVERAGES:
				getTestCoverages().clear();
				return;
			case TestingPackage.TEST_SUITE__SUT_NAME:
				setSutName(SUT_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestingPackage.TEST_SUITE__TEST_COVERAGES:
				return testCoverages != null && !testCoverages.isEmpty();
			case TestingPackage.TEST_SUITE__SUT_NAME:
				return SUT_NAME_EDEFAULT == null ? sutName != null : !SUT_NAME_EDEFAULT.equals(sutName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sutName: ");
		result.append(sutName);
		result.append(')');
		return result.toString();
	}

} //TestSuiteImpl
