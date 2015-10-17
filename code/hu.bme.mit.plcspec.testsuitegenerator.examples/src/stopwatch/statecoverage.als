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
one sig RUNNING, End, PAUSED, READY, STOPPED, Initial extends State {}

some sig S extends System {
	output: Int
}
sig on extends Transition {}{
	from = Initial
	to = READY
	initSystem[from.system]
}



sig start extends Transition {}{
	from = READY
	to = RUNNING
	inheritSystem[from.system, to.system]
}



sig stop extends Transition {}{
	from = RUNNING
	to = STOPPED
	inheritSystem[from.system, to.system]
}



sig split extends Transition {}{
	from = RUNNING
	to = PAUSED
	inheritSystem[from.system, to.system]
}



sig off extends Transition {}{
	from = STOPPED
	to = End
	inheritSystem[from.system, to.system]
}



sig reset extends Transition {}{
	from = STOPPED
	to = READY
	inheritSystem[from.system, to.system]
}



sig unsplit extends Transition {}{
	from = PAUSED
	to = RUNNING
	inheritSystem[from.system, to.system]
}



sig stop2 extends Transition {}{
	from = PAUSED
	to = STOPPED
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
