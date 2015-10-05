/**
 */
package hu.bme.mit.plcspec.testsuitegenerator.testing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestingFactory
 * @model kind="package"
 * @generated
 */
public interface TestingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///hu/bme/mit/plcspec/alloygenerator/testing.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.bme.mit.plcspec.alloygenerator.testing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestingPackage eINSTANCE = hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl.init();

	/**
	 * The meta object id for the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCaseImpl <em>Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCaseImpl
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl#getTestCase()
	 * @generated
	 */
	int TEST_CASE = 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__INPUT = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__OUTPUT = 1;

	/**
	 * The number of structural features of the '<em>Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestSuiteImpl <em>Test Suite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestSuiteImpl
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl#getTestSuite()
	 * @generated
	 */
	int TEST_SUITE = 1;

	/**
	 * The feature id for the '<em><b>Test Coverages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__TEST_COVERAGES = 0;

	/**
	 * The number of structural features of the '<em>Test Suite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Test Suite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCoverageImpl <em>Test Coverage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCoverageImpl
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl#getTestCoverage()
	 * @generated
	 */
	int TEST_COVERAGE = 2;

	/**
	 * The feature id for the '<em><b>Test Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_COVERAGE__TEST_CASES = 0;

	/**
	 * The number of structural features of the '<em>Test Coverage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_COVERAGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Test Coverage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_COVERAGE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase
	 * @generated
	 */
	EClass getTestCase();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase#getInput()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_Input();

	/**
	 * Returns the meta object for the attribute '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestCase#getOutput()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_Output();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite <em>Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite
	 * @generated
	 */
	EClass getTestSuite();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite#getTestCoverages <em>Test Coverages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Coverages</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestSuite#getTestCoverages()
	 * @see #getTestSuite()
	 * @generated
	 */
	EReference getTestSuite_TestCoverages();

	/**
	 * Returns the meta object for class '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage <em>Test Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Coverage</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage
	 * @generated
	 */
	EClass getTestCoverage();

	/**
	 * Returns the meta object for the containment reference list '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage#getTestCases <em>Test Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Cases</em>'.
	 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.TestCoverage#getTestCases()
	 * @see #getTestCoverage()
	 * @generated
	 */
	EReference getTestCoverage_TestCases();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestingFactory getTestingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCaseImpl <em>Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCaseImpl
		 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl#getTestCase()
		 * @generated
		 */
		EClass TEST_CASE = eINSTANCE.getTestCase();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__INPUT = eINSTANCE.getTestCase_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__OUTPUT = eINSTANCE.getTestCase_Output();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestSuiteImpl <em>Test Suite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestSuiteImpl
		 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl#getTestSuite()
		 * @generated
		 */
		EClass TEST_SUITE = eINSTANCE.getTestSuite();

		/**
		 * The meta object literal for the '<em><b>Test Coverages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE__TEST_COVERAGES = eINSTANCE.getTestSuite_TestCoverages();

		/**
		 * The meta object literal for the '{@link hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCoverageImpl <em>Test Coverage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestCoverageImpl
		 * @see hu.bme.mit.plcspec.testsuitegenerator.testing.impl.TestingPackageImpl#getTestCoverage()
		 * @generated
		 */
		EClass TEST_COVERAGE = eINSTANCE.getTestCoverage();

		/**
		 * The meta object literal for the '<em><b>Test Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_COVERAGE__TEST_CASES = eINSTANCE.getTestCoverage_TestCases();

	}

} //TestingPackage
