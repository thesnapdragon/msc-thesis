package hu.bme.mit.plcspec.testsuitegenerator.measurements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Iterators;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

import ch.cern.en.ice.plcspec.model.plchsm.CompositeState;
import ch.cern.en.ice.plcspec.model.plchsm.Constant;
import ch.cern.en.ice.plcspec.model.plchsm.EventSemantics;
import ch.cern.en.ice.plcspec.model.plchsm.InState;
import ch.cern.en.ice.plcspec.model.plchsm.LogicOperation;
import ch.cern.en.ice.plcspec.model.plchsm.LogicOperator;
import ch.cern.en.ice.plcspec.model.plchsm.PrimitiveType;
import ch.cern.en.ice.plcspec.model.plchsm.PrimitiveTypes;
import ch.cern.en.ice.plcspec.model.plchsm.SingleState;
import ch.cern.en.ice.plcspec.model.plchsm.StatemachineModule;
import ch.cern.en.ice.plcspec.model.plchsm.SwitchCaseRow;
import ch.cern.en.ice.plcspec.model.plchsm.SwitchCaseTable;
import ch.cern.en.ice.plcspec.model.plchsm.Transition;
import ch.cern.en.ice.plcspec.model.plchsm.VariableDeclaration;
import ch.cern.en.ice.plcspec.model.plchsm.VariableDefinitionExpression;
import ch.cern.en.ice.plcspec.model.plchsm.plchsmFactory;
import ch.cern.en.ice.plcspec.model.plchsm.plchsmPackage;

public class PlchsmModelGenerator {
	private plchsmFactory factory = null;
	private GraphReader graphReader = null;
	private HashMap<String, SingleState> statesByName = null;
	
	public PlchsmModelGenerator() {
		plchsmPackage.eINSTANCE.eClass();
		factory = plchsmFactory.eINSTANCE;
		graphReader = new GraphReader();
		statesByName = new HashMap<String, SingleState>();
	}
	
	public void generate(String file) {
		graphReader.read(file);
		
		ch.cern.en.ice.plcspec.model.plchsm.System system = factory.createSystem();
		StatemachineModule statemachineModule = factory.createStatemachineModule();
		statemachineModule.setName("ScalabilityTest");
		statemachineModule.setEventSemantics(EventSemantics.FIRST_ACTIVE_TRIGGERS);
		
		VariableDeclaration output = createVariable("output", "0");
		statemachineModule.getDefinedVariables().add(output);
		
		CompositeState compositeState = factory.createCompositeState();
		createStates(compositeState);
		statemachineModule.setRootState(compositeState);

		createTransitions(statemachineModule);
		
		statemachineModule.getO_outputDefinitions().add(createOutputAssignments(output));
		
		system.getModules().add(statemachineModule);
		saveSystem(system, file);
	}

	private VariableDeclaration createVariable(String name, String value) {
		VariableDeclaration variable = factory.createVariableDeclaration();
		variable.setName(name);
		Constant variableValue = factory.createConstant();
		variableValue.setValue(value);
		PrimitiveType variableType = factory.createPrimitiveType();
		variableType.setType(PrimitiveTypes.INT16);
		variable.setType(variableType);
		variable.setDefaultValue(variableValue);
		return variable;
	}
	
	private VariableDefinitionExpression createOutputAssignments(VariableDeclaration output) {
		VariableDefinitionExpression outputAssignment = factory.createVariableDefinitionExpression();
		outputAssignment.setVariable(output);
		SwitchCaseTable outputSwitchCaseTable = factory.createSwitchCaseTable();
		int i = 0;
		for (String name : statesByName.keySet()) {
			if (statesByName.get(name).getName().matches("Initial")) continue;
			SwitchCaseRow row = createOutputAssignment(statesByName.get(name), String.valueOf(i));
			outputSwitchCaseTable.getRows().add(row);
			i += 1;
		}
		outputAssignment.setExpression(outputSwitchCaseTable);
		return outputAssignment;
	}
	
	private SwitchCaseRow createOutputAssignment(SingleState state, String value) {
		SwitchCaseRow row = factory.createSwitchCaseRow();
		LogicOperation logicOperation = factory.createLogicOperation();
		logicOperation.setOperator(LogicOperator.AND);
		InState inState = factory.createInState();
		inState.setState(state);
		logicOperation.getArguments().add(inState);
		row.setCondition(logicOperation);
		Constant constant = factory.createConstant();
		constant.setValue(value);
		PrimitiveType constantType = factory.createPrimitiveType();
		constantType.setType(PrimitiveTypes.INT16);
		constant.setType(constantType);
		row.setValue(constant);
		return row;
	}
	
	private SingleState createState(CompositeState compositeState, String name) {
		SingleState state = factory.createBasicState();
		state.setContainerState(compositeState);
		state.setName(name);
		// TODO: set in and out transitions?
		return state;
	}
	
	private Transition createTransition(String name, SingleState from, SingleState to) {
		Transition transition = factory.createTransition();
		transition.setName(name);
		transition.setFrom(from);
		transition.setTo(to);
		return transition;
	}
	
	private void saveSystem(ch.cern.en.ice.plcspec.model.plchsm.System system, String file) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("plchsm", new XMIResourceFactoryImpl());
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.createResource(URI.createURI("plchsm/" + file + ".plchsm"));
	    resource.getContents().add(system);
	    try {
	      resource.save(new FileOutputStream(new File("resources/" + file + ".plchsm").getAbsolutePath()), Collections.EMPTY_MAP);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	private void createStates(CompositeState compositeState) {
		for (Vertex vertex : graphReader.getGraph().getVertices()) {
			String name = vertex.getId().toString();
			if (name.matches("0")) {
				name = "Initial";
			} else if (name.matches(String.valueOf(Iterators.size(graphReader.getGraph().getVertices().iterator()) - 1))) {
				name = "End";
			} else {
				name = "s" + name;
			}
			
			SingleState state = createState(compositeState, name);
			statesByName.put(vertex.getId().toString(), state);
			compositeState.getContainedStates().add(state);
		}
	}
	
	private void createTransitions(StatemachineModule statemachineModule) {
		for (Edge edge : graphReader.getGraph().getEdges()) {
			String in = edge.getVertex(Direction.OUT).getId().toString();
			String out = edge.getVertex(Direction.IN).getId().toString();
			Transition transition = createTransition("t" + edge.getId(), statesByName.get(in), statesByName.get(out));
			statemachineModule.getTransitions().add(transition);
		}
	}
}
