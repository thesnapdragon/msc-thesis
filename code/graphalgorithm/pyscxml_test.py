#!/usr/bin/env python

from scxml.pyscxml import StateMachine

sm = StateMachine("../fsm/simple1.scxml")
sm.start_threaded()
