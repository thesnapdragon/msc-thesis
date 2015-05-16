module psm_statecoverage

abstract sig State {}
abstract sig Transition {from, to: one State}

one sig Initial, End extends State {}

one sig A,B extends State {}
one sig T0 extends Transition {}{
	from = Initial
	to = A
}
one sig T1 extends Transition {}{
	from = A
	to = B
}
one sig T2 extends Transition {}{
	from = B
	to = End
}
one sig T3 extends Transition {}{
	from = Initial
	to = End
}

sig Path { firstStep: Step }
sig Step {
	from, to: State,
	via: Transition,
	nextStep: lone Step
} {
	via.from = from
	via.to = to
}

fact {
	all s:Step, p:Path | s in p.firstStep.*nextStep
	all p:Path | p.firstStep.from = Initial
	all curr:Step, next:curr.nextStep | next.from = curr.to
}

fun steps (p:Path): set Step {
	p.firstStep.*nextStep
}

pred transition_coverage() {
	some p:Path | steps[p].via = Transition
}

pred state_coverage() {
	some p:Path | all s:State | s in steps[p].from or  s in steps[p].to
}

run state_coverage for 10 but exactly 1 Path
