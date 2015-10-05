/**
 */
package hu.bme.mit.plcspec.testsuitegenerator.testing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase;
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
		}
		return super.eIsSet(featureID);
	}

} //TestSuiteImpl
