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
one sig RUNNABLE, End, Initial, TIMED_WAITING, BLOCKED, WAITING extends State {}
some sig S extends System {
	output: Int
}
lone sig start extends Transition {}{
	from = Initial
	to = RUNNABLE
	initSystem[from.system]
}



lone sig terminate1 extends Transition {}{
	from = RUNNABLE
	to = End
	inheritSystem[from.system, to.system]
}



lone sig terminate2 extends Transition {}{
	from = TIMED_WAITING
	to = End
	inheritSystem[from.system, to.system]
}



lone sig terminate3 extends Transition {}{
	from = WAITING
	to = End
	inheritSystem[from.system, to.system]
}



lone sig sleep extends Transition {}{
	from = RUNNABLE
	to = TIMED_WAITING
	inheritSystem[from.system, to.system]
}



lone sig wait1 extends Transition {}{
	from = RUNNABLE
	to = TIMED_WAITING
	inheritSystem[from.system, to.system]
}



lone sig join1 extends Transition {}{
	from = RUNNABLE
	to = TIMED_WAITING
	inheritSystem[from.system, to.system]
}



lone sig wait2 extends Transition {}{
	from = RUNNABLE
	to = WAITING
	inheritSystem[from.system, to.system]
}



lone sig join2 extends Transition {}{
	from = RUNNABLE
	to = WAITING
	inheritSystem[from.system, to.system]
}



lone sig waitForLock extends Transition {}{
	from = RUNNABLE
	to = BLOCKED
	inheritSystem[from.system, to.system]
}



lone sig timeout extends Transition {}{
	from = TIMED_WAITING
	to = RUNNABLE
	inheritSystem[from.system, to.system]
}



lone sig notify1 extends Transition {}{
	from = WAITING
	to = RUNNABLE
	inheritSystem[from.system, to.system]
}



lone sig notifyAll1 extends Transition {}{
	from = WAITING
	to = RUNNABLE
	inheritSystem[from.system, to.system]
}



lone sig monitorLockAcquired extends Transition {}{
	from = BLOCKED
	to = RUNNABLE
	inheritSystem[from.system, to.system]
}



pred initSystem(s:System) {
	s.output = 0
}
/*** GENERATED CODE END ***/
pred state_coverage() {
	all s:State | some p:Path | s in steps[p].from + steps[p].to
}
run state_coverage for 10 but exactly 1 Coverage, 4 System
