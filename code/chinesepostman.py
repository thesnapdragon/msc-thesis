#!/usr/bin/env python

import networkx as nx

def create_odd_graph(graph):
    """
    Given a graph G, construct a graph containing only the vertices with odd degree from G. The resulting graph is
    fully connected, with each weight being the shortest path between the nodes in G.

    Complexity: O(V'*(E + V log(V)) )
    """
    if nx.is_directed(graph):
        result = nx.DiGraph()
        odd_nodes = [n for n in graph.nodes() if graph.in_degree(n) - graph.out_degree(n) != 0]
    else:
        result = nx.Graph()
        odd_nodes = [n for n in graph.nodes() if graph.degree(n) % 2 == 1]

    for u in odd_nodes:
        # We calculate the shortest paths twice here, but the overall performance hit is low
        paths = nx.shortest_path(graph, source = u, weight = 'weight')
        lengths = nx.shortest_path_length(graph, source = u, weight = 'weight')
        for v in odd_nodes:
            if u <= v:
                # We only add each edge once
                continue
            # The edge weights are negative for the purpose of max_weight_matching (we want the minimum weight)
            try:
                result.add_edge(u, v, weight = -lengths[v], path = paths[v])
            except KeyError:
                result.add_edge(v, u, weight = -lengths[u], path = paths[u])

    return result

def add_shadow_nodes(graph, odd, matching):
    """
    Build an Eulerian graph from a matching. The result is a MultiGraph.
    """

    # Copy the original graph to a multigraph (so we can add more edges between the same nodes)
    if nx.is_directed(graph):
        eulerian_graph = nx.MultiDiGraph(graph)
    else:
        eulerian_graph = nx.MultiGraph(graph)

    # For each matched pair of odd vertices, connect them with the shortest path between them
    for u, v in matching.items():
        if v <= u:
            # Each matching occurs twice in the matchings: (u => v) and (v => u). We only count those where v > u
            continue
        # We try to add the edge, but if its a directed graph sometimes it must be reverted
        try:
            edge = odd[u][v]
        except KeyError:
            edge = odd[v][u]
        path = edge['path']  # The shortest path between the two nodes, calculated in odd_graph()

        # Add each segment in this path to the graph again
        for p, q in zip(path, path[1:] + path[:1])[:-1]:
            weight = 0
            if graph[p][q].has_key('weight'):
                weight = graph[p][q]['weight']
            else:
                weight = 1
            eulerian_graph.add_edge(p, q, weight = weight)

    return eulerian_graph

def eulerize(graph):
    """
    Eulerize the graph
    """

    # Build a fully-connected graph containing only the odd edges.  Complexity: O(V'*(E + V log(V)) )
    odd = create_odd_graph(graph)

    # Find the best matching of pairs of odd nodes. Complexity: O(V'^3)
    matching = nx.max_weight_matching(odd, True)

    # Complexity of the remainder is less approximately O(E)
    eulerian_graph = add_shadow_nodes(graph, odd, matching)

    return eulerian_graph

if __name__ == '__main__':
    graph = nx.read_graphml("../fsm/calculator.graphml")
    eulerian_graph = eulerize(graph)
    test = []
    for edge in nx.eulerian_circuit(eulerian_graph):
        test.append({'method': eulerian_graph[edge[0]][edge[1]][0]['id'],
                        'result': eulerian_graph[edge[0]][edge[1]][0]['event']})

    from calculator import Calculator
    calc = Calculator()

    for i, testcase in enumerate(test):
        print 'TEST' + str(i) + ': ' + testcase['method']
        print 'Result: ' + testcase['result']
        if testcase['result'] == calc.next_method(testcase['method']):
            print 'PASSED'
        else:
            print 'FAILED'

