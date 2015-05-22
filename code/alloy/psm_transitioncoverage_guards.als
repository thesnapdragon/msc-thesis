module psm_statecoverage

open util/integer

abstract sig System {}
abstract sig State {system: one System}
abstract sig Transition {from, to: one State}

one sig Initial, End extends State {}

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

fact {
	all s:Step, p:Path | s in p.firstStep.*nextStep
	all p:Path | p.firstStep.from = Initial
	all t:Transition | one s:Step | s.via = t
	all curr:Step, next:curr.nextStep | next.from = curr.to
	all sys:System | some s:State | sys = s.system
	all s:State | some t:Transition | t.from = s or t.to = s
}

pred inheritSystem(s1, s2: System) {
	s1 = s2
}

/***GENERATE START***/
one sig A, B extends State {}
sig S extends System {
	a: Int
}
lone sig T0 extends Transition {}{
	from = Initial
	to = A
	initSystem[from.system]
	E0[from.system, to.system]
}
lone sig T1 extends Transition {}{
	from = A
	to = B
	inheritSystem[from.system, to.system]
	G0[from.system]
}
lone sig T2 extends Transition {}{
	from = B
	to = End
	inheritSystem[from.system, to.system]
}
lone sig T3 extends Transition {}{
	from = A
	to = B
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
/***GENERATE END***/

pred transition_coverage() {
	some p:Path | steps[p].via = Transition
}

pred state_coverage() {
	some p:Path | all s:State | s in steps[p].from + steps[p].to
}

run state_coverage for 10 but exactly 1 Path
