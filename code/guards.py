#!/usr/bin/env python

import networkx as nx

from chinesepostman import ChinesePostman

variables = {}

def get_item(key, type, graph):
    if type == 'node':
        for node in graph.nodes(data = True):
            if node[0] == key:
                return node
    elif type == 'edge':
        for edge in graph.edges(data = True):
            if edge[0] == key[0] and edge[1] == key[1]:
                return edge

def evaluate(expr):
    if '=' in expr:
        expr = expr.split('=')
        variables[expr[0]] = int(expr[1])
    else:
        from math import sin, cos
        safe_list = ['sin', 'cos']
        operators = ['<', '<=', '==', '>=', '>']
        broken_expr = set()
        for operator in operators:
            pieces = expr.split(operator)
            if len(pieces) > 1:
                broken_expr.update(pieces)
        for piece in broken_expr:
            if not piece.isdigit() and piece not in safe_list:
                expr = expr.replace(piece, 'variables[\'{0}\']'.format(piece))
        safe_dict = dict([ (k, locals().get(k, None)) for k in safe_list ])
        safe_dict['variables'] = variables
        return eval(expr, {"__builtins__": None}, safe_dict)

def create_tests(graph, tests):
    for edge in nx.eulerian_circuit(graph):
        tests.append({'method': graph[edge[0]][edge[1]][0]['id'],
                        'result': graph[edge[0]][edge[1]][0]['event']})
    return tests

if __name__ == '__main__':
    graph = nx.read_graphml("../fsm/guard1.graphml")
    tests = []

    chinese_postman = ChinesePostman(graph)
    eulerian_graph = chinese_postman.eulerize()
    create_tests(eulerian_graph, tests)
    commands = []
    for edge in nx.eulerian_circuit(eulerian_graph):
        datas = get_item(edge[0], 'node', eulerian_graph)[1]
        if datas.has_key('command'):
            commands.append(datas['command'])
    for command in commands:
        evaluate(command)
        for edge in nx.eulerian_circuit(eulerian_graph):
            edge_data = get_item(edge, 'edge', eulerian_graph)[2]
            if edge_data.has_key('guard'):
                if evaluate(edge_data['guard']):
                    eulerian_graph.remove_edge(*edge)
                    eulerian_graph = chinese_postman.eulerize()
                    create_tests(eulerian_graph, tests)
    print tests
