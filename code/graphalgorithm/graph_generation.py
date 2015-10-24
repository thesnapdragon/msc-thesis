#!/usr/bin/env python3

import networkx as nx
import random

def sequence(n):
    a, m, c = [], random.randint(1, int(n/4)), n
    while n > m > 0:
        a.append(m)
        n -= m
        m = random.randint(0, int(n/4))
    if n: a += [n]
    return a

def two_sequence(size):
    s = [sequence(size)]
    n = sequence(size)
    while len(n) != len(s[0]):
        n = sequence(size)
    s.append(n)
    return s

def graph(n):
    s = two_sequence(n)
    ins = [0] + s[0] + [1]
    outs = [1] + s[1] + [0]
    d = nx.DiGraph(nx.directed_configuration_model(ins, outs))
    while not nx.is_connected(nx.Graph(d)):
        d = nx.DiGraph(nx.directed_configuration_model(ins, outs))
    d.remove_edges_from(d.selfloop_edges())
    return d

nx.write_graphml(graph(10), "scalability_test.graphml")
