#!/usr/bin/env python

import networkx as nx
import itertools

def chinese_postman(graph, source):
    # find nodes with odd degree
    odd_nodes = []
    for node in graph.nodes():
        if (graph.degree(node) % 2 == 1):
            odd_nodes.append(node)

    # create cartesian product from different odd_nodes
    products = list(i for i in itertools.product(odd_nodes, odd_nodes) if (i[0] != i[1] and nx.has_path(graph, i[0], i[1])))

    # calculate path between product nodes
    odd_nodes_weights = []
    for prod in products:
        odd_nodes_weights.append(nx.dijkstra_path_length(graph, prod[0], prod[1]))

    # create all new duplicated edges
    while len(products) != 0:
        idx = odd_nodes_weights.index(min(odd_nodes_weights))

        new_edge = products.pop(idx)
        new_edge_weight = odd_nodes_weights.pop(idx)
        graph.add_edge(*new_edge, weight = new_edge_weight)

        new_products = products[:]
        for i, prod in enumerate(new_products):
            if (prod[0] == new_edge[0] or prod[0] == new_edge[1] or prod[1] == new_edge[0] or prod[1] == new_edge[1]):
                del products[i]
                del odd_nodes_weights[i]

    # the graph must have an eulerian circuit
    return list(nx.eulerian_circuit(graph, source = source))

if __name__ == '__main__':
    input_graph = nx.read_graphml("simple1.graphml")
    graph = nx.MultiGraph(input_graph)
    print chinese_postman(graph, 'S')
