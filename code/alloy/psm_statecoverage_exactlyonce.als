module psm_statecoverage
open util/ordering[Time]

abstract sig State {}
sig Time, Actor {}
one sig PSM {state : State some  -> Actor  -> Time }
one sig Initial, End extends State {}
one sig A, B, C extends State {}

fact Traces {
    all a : Actor | PSM.state.first.a = Initial and PSM.state.last.a = End
    all t : Time, t' : t.next | some a : Actor |
		 t_0[a, t, t'] or  t_1[a, t, t'] or  t_2[a, t, t']  or  t_3[a, t, t']
}

pred t_0 [a : Actor , t,t' : Time] {
    Initial in PSM.state.t.a
    PSM.state.t' = PSM.state.t - (Initial->a) + (A->a)
}

pred t_1 [a : Actor , t,t' : Time] {
    A in PSM.state.t.a
    PSM.state.t' = PSM.state.t - (A->a) + (B->a)
}

pred t_2 [a : Actor , t,t' : Time] {
    B in PSM.state.t.a
    PSM.state.t' = PSM.state.t - (B->a) + (C->a)
}

pred t_3 [a : Actor , t,t' : Time] {
    C in PSM.state.t.a
    PSM.state.t' = PSM.state.t - (C->a) + (End->a)
}

run { all s: State | some t: Time, a: Actor | s in PSM.state.t.a } for 1 but exactly 1 Actor, 5 Time
