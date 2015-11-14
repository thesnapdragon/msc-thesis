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
one sig End, s5, s6, s3, s7, Initial, s8, s2, s4, s1 extends State {}
some sig S extends System {
	output: Int
}
lone sig t19 extends Transition {}{
	from = s7
	to = s2
	inheritSystem[from.system, to.system]
}



lone sig t17 extends Transition {}{
	from = s6
	to = s2
	inheritSystem[from.system, to.system]
}



lone sig t18 extends Transition {}{
	from = s6
	to = s4
	inheritSystem[from.system, to.system]
}



lone sig t15 extends Transition {}{
	from = s5
	to = s7
	inheritSystem[from.system, to.system]
}



lone sig t16 extends Transition {}{
	from = s6
	to = s1
	inheritSystem[from.system, to.system]
}



lone sig t13 extends Transition {}{
	from = s5
	to = s1
	inheritSystem[from.system, to.system]
}



lone sig t14 extends Transition {}{
	from = s5
	to = s2
	inheritSystem[from.system, to.system]
}



lone sig t11 extends Transition {}{
	from = s4
	to = s1
	inheritSystem[from.system, to.system]
}



lone sig t12 extends Transition {}{
	from = s4
	to = s2
	inheritSystem[from.system, to.system]
}



lone sig t3 extends Transition {}{
	from = s2
	to = s1
	inheritSystem[from.system, to.system]
}



lone sig t20 extends Transition {}{
	from = s8
	to = s2
	inheritSystem[from.system, to.system]
}



lone sig t2 extends Transition {}{
	from = s1
	to = s3
	inheritSystem[from.system, to.system]
}



lone sig t1 extends Transition {}{
	from = s1
	to = s2
	inheritSystem[from.system, to.system]
}



lone sig t10 extends Transition {}{
	from = s3
	to = s1
	inheritSystem[from.system, to.system]
}



lone sig t0 extends Transition {}{
	from = Initial
	to = s1
	initSystem[from.system]
	inheritSystem[from.system, to.system]
}



lone sig t7 extends Transition {}{
	from = s2
	to = s7
	inheritSystem[from.system, to.system]
}



lone sig t6 extends Transition {}{
	from = s2
	to = s5
	inheritSystem[from.system, to.system]
}



lone sig t5 extends Transition {}{
	from = s2
	to = s4
	inheritSystem[from.system, to.system]
}



lone sig t4 extends Transition {}{
	from = s2
	to = s3
	inheritSystem[from.system, to.system]
}



lone sig t9 extends Transition {}{
	from = s2
	to = End
	inheritSystem[from.system, to.system]
}



lone sig t8 extends Transition {}{
	from = s2
	to = s8
	inheritSystem[from.system, to.system]
}



pred initSystem(s:System) {
	s.output = 0
}
/*** GENERATED CODE END ***/
pred state_coverage() {
	all s:State | some p:Path | s in steps[p].from + steps[p].to
}
run state_coverage for 10 but exactly 1 Coverage, 8 System
