#!/usr/bin/env python3

import networkx as nx
import random

def sequence(n):
    a, m, c = [], random.randint(1, int(n / 4)), n
    while n > m > 0:
        a.append(m)
        n -= m
        m = random.randint(0, int(n / 4))
    if n: a += [n]
    return a

def two_sequence(size):
    sequences = [sequence(size)]
    second_sequence = sequence(size)
    while len(second_sequence) != len(sequences[0]):
        second_sequence = sequence(size)
    sequences.append(second_sequence)
    return sequences

def graph(size):
    sequences = two_sequence(size)
    ins = [0] + sequences[0] + [1]
    outs = [1] + sequences[1] + [0]
    graph = nx.DiGraph(nx.directed_configuration_model(ins, outs))
    while not nx.is_connected(nx.Graph(graph)):
        graph = nx.DiGraph(nx.directed_configuration_model(ins, outs))
    graph.remove_edges_from(graph.selfloop_edges())
    return graph

sizes = [10, 100, 200, 400, 800]

for size in sizes:
    nx.write_graphml(graph(size), "scalability_test{0}.graphml".format(size))
