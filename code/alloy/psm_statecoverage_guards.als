module psm_statecoverage

open util/integer

abstract sig System {}
abstract sig State {system: one System}
abstract sig Transition {from, to: one State}

one sig Initial, End extends State {}

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
one sig A, B, C extends State {}
some sig S extends System {
	a: Int
}
sig T0 extends Transition {}{
	from = Initial
	to = A
	initSystem[from.system]
	E0[from.system, to.system]
}
sig T1 extends Transition {}{
	from = A
	to = B
	inheritSystem[from.system, to.system]
}
sig T5 extends Transition {}{
	from = A
	to = B
	inheritSystem[from.system, to.system]
	G0[from.system]
}
sig T2 extends Transition {}{
	from = B
	to = End
	inheritSystem[from.system, to.system]
}
sig T3 extends Transition {}{
	from = A
	to = C
	inheritSystem[from.system, to.system]
}
sig T4 extends Transition {}{
	from = C
	to = End
	inheritSystem[from.system, to.system]
}

pred initSystem(s:System) {
	s.a = 0
}
pred E0(s1, s2: System) {
	s2.a = add[s1.a, 1]
}
pred G0(s: System) {
	s.a > 1
}
/*** GENERATED CODE END ***/

pred state_coverage() {
	all s:State | some p:Path | s in steps[p].from + steps[p].to
}

run state_coverage for 10 but exactly 1 Coverage, 4 System
