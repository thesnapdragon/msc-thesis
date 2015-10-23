module statecoverage
open util/integer
open util/boolean

abstract sig System {}
abstract sig State {system: one System}
abstract sig Transition {from, to: one State}

sig Coverage { paths: some Path }
sig Path { firstStep: one Step }
sig Step {
	from, to: one State,
	via: one Transition,
	nextStep: lone Step
} {
	via.from = from
	via.to = to
}
fun steps (p:Path): set Step {
	p.firstStep.*nextStep
}
fun transitions (p:Path): set Transition {
	p.firstStep.via + p.firstStep.*nextStep.via
}
fact {
	// test generation properties
	all p:Path | one c:Coverage | p in c.paths // all path belongs to a coverage
    all s:Step | one p:Path | s in p.firstStep.*nextStep // all steps belongs to a path

	// model consistency
	all p:Path | p.firstStep.from = Initial // all path starts with an Initial state
    all p:Path | one s:Step | s in steps[p] && s.to = End // all path end with End state
	
	// state machine properties
	all curr:Step, next:curr.nextStep | next.from = curr.to // all steps are contionueos
    all sys:System | some s:State | sys = s.system // all system belongs to a state
}
pred inheritSystem(s1, s2: System) {
	s1 = s2
}
/*** GENERATED CODE START ***/
one sig Initial, ACTIVE, CLOSED, SUSPENDED, NEW, End extends State {}
some sig S extends System {
	output: Int
,	isUnique: Bool
}
lone sig create extends Transition {}{
	from = Initial
	to = NEW
	initSystem[from.system]
	setIsUnique[from.system, to.system]
}
pred setIsUnique(s1, s2: System) {
	s2.isUnique = Or[s1.isUnique, True]
}



lone sig activate extends Transition {}{
	from = NEW
	to = ACTIVE
	inheritSystem[from.system, to.system]
	G_activate[from.system]
}

pred G_activate(s: System) {
	s.isUnique = True
}


lone sig suspend1 extends Transition {}{
	from = NEW
	to = SUSPENDED
	inheritSystem[from.system, to.system]
}



lone sig cancel1 extends Transition {}{
	from = NEW
	to = CLOSED
	inheritSystem[from.system, to.system]
}



lone sig cancel2 extends Transition {}{
	from = ACTIVE
	to = CLOSED
	inheritSystem[from.system, to.system]
}



lone sig cancel3 extends Transition {}{
	from = SUSPENDED
	to = CLOSED
	inheritSystem[from.system, to.system]
}



lone sig delete extends Transition {}{
	from = CLOSED
	to = End
	inheritSystem[from.system, to.system]
}



lone sig lock extends Transition {}{
	from = ACTIVE
	to = SUSPENDED
	inheritSystem[from.system, to.system]
}



lone sig unlock extends Transition {}{
	from = SUSPENDED
	to = ACTIVE
	inheritSystem[from.system, to.system]
}



lone sig suspend2 extends Transition {}{
	from = ACTIVE
	to = SUSPENDED
	inheritSystem[from.system, to.system]
}



lone sig resume extends Transition {}{
	from = SUSPENDED
	to = ACTIVE
	inheritSystem[from.system, to.system]
}



pred initSystem(s:System) {
	s.output = 0

	s.isUnique = False
}
/*** GENERATED CODE END ***/
pred state_coverage() {
	all s:State | some p:Path | s in steps[p].from + steps[p].to
}
run state_coverage for 10 but exactly 1 Coverage, 4 System
