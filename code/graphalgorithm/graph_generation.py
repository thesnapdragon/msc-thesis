#!/usr/bin/env python3

import networkx as nx
import random

def sequence(n):
    a, m, c = [], random.randint(0, n), n
    while n > m > 0:
        a.append(m)
        n -= m
        m = random.randint(0, n)
    if n: a += [n]
    return a

def two_sequence(size):
    sequences = [sequence(size)]
    second_sequence = sequence(size)
    while len(second_sequence) != len(sequences[0]):
        second_sequence = sequence(size)
    sequences.append(second_sequence)
    return sequences

def generate_graph(factor):
    sequences = two_sequence(factor)
    ins = [0] + sequences[0] + [1]
    outs = [1] + sequences[1] + [0]
    graph = nx.DiGraph(nx.directed_configuration_model(ins, outs))
    while not nx.is_connected(nx.Graph(graph)):
        graph = nx.DiGraph(nx.directed_configuration_model(ins, outs))
    graph.remove_edges_from(graph.selfloop_edges())
    return graph

def graph_with_size(size):
    factor = random.randint(0, 200)
    graph = generate_graph(factor)
    while graph.number_of_edges() != size:
        factor = random.randint(0, 200)
        graph = generate_graph(factor)
    return graph

for size in range(40, 51):
    nx.write_graphml(graph_with_size(size), "scalability_test_t{0}.graphml".format(size))
