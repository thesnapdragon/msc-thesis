module statecoverage
open util/integer
open util/boolean

abstract sig System {}
abstract sig State {system: one System}
abstract sig Transition {from, to: one State}

sig Coverage { paths: some Path }
sig Path { firstStep: Step }
sig Step {
	from, to: State,
	via: Transition,
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
	all p:Path | some c:Coverage | p in c.paths // all path belongs to a coverage
	no p1,p2:Path | p1! = p2 && steps[p1] = steps[p2] && transitions[p1] = transitions[p2] // there are no two equivalent paths
	no s1,s2:Step | s1! = s2 && s1.via = s2.via // there are no two equivalent steps
	all s:Step | some p:Path | s in p.firstStep.*nextStep // all steps belongs to a path

	// model consistency
	all p:Path | p.firstStep.from = Initial // all path starts with an Initial state
	all p:Path | some s:Step | s in steps[p] && s.to = End // all path end with End state
	
	// state machine properties
	all t:Transition | one s:Step | s.via = t // all transitions belongs to a step
	all curr:Step, next:curr.nextStep | next.from = curr.to // all steps are contionueos
	all sys:System | some s:State | sys = s.system // all system belongs to a state
	all s:State | some t:Transition | t.from = s or t.to = s // all state belongs to a transition
}
pred inheritSystem(s1, s2: System) {
	s1 = s2
}
/*** GENERATED CODE START ***/
one sig Initial, B, A, End extends State {}

some sig S extends System {
	a: Int
,	output: Int
}
sig t0 extends Transition {}{
	from = Initial
	to = A
	initSystem[from.system]
	E0[from.system, to.system]
}
pred E0(s1, s2: System) {
	s2.a = add[s1.a, 1]	
}



sig t1 extends Transition {}{
	from = A
	to = B
	inheritSystem[from.system, to.system]
}



sig t2 extends Transition {}{
	from = B
	to = End
	inheritSystem[from.system, to.system]
}



sig t3 extends Transition {}{
	from = A
	to = End
	inheritSystem[from.system, to.system]
	G_t3[from.system]
}

pred G_t3(s: System) {
	s.a < 1
}


pred initSystem(s:System) {
	s.a = 0

	s.output = 0
}
/*** GENERATED CODE END ***/
pred state_coverage() {
	all s:State | some p:Path | s in steps[p].from + steps[p].to
}
run state_coverage for 10 but exactly 1 Coverage, 2 System
