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
one sig C, A, B, Initial, End extends State {}
some sig S extends System {
	a: Int
,	output: Int
}
lone sig t0 extends Transition {}{
	from = Initial
	to = A
	initSystem[from.system]
	E0[from.system, to.system]
}
pred E0(s1, s2: System) {
	s2.a = add[s1.a, 1]	
}



lone sig t1 extends Transition {}{
	from = A
	to = B
	inheritSystem[from.system, to.system]
}



lone sig t2 extends Transition {}{
	from = B
	to = End
	inheritSystem[from.system, to.system]
}



lone sig t3 extends Transition {}{
	from = A
	to = C
	inheritSystem[from.system, to.system]
	G_t3[from.system]
}

pred G_t3(s: System) {
	s.a = 1
}


lone sig t4 extends Transition {}{
	from = C
	to = End
	inheritSystem[from.system, to.system]
}



pred initSystem(s:System) {
	s.a = 0

	s.output = 0
}
/*** GENERATED CODE END ***/
pred state_coverage() {
	all s:State | some p:Path | s in steps[p].from + steps[p].to
}
run state_coverage for 10 but exactly 1 Coverage, 3 System
