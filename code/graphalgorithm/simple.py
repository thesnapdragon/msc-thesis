#!/usr/bin/env python

import networkx as nx

from stopwatch import StopWatch
from chinesepostman import ChinesePostman

if __name__ == '__main__':
    graph = nx.read_graphml("../fsm/stopwatch.graphml")
    chinese_postman = ChinesePostman(graph)
    eulerian_graph = chinese_postman.eulerize()
    tests = []
    for edge in nx.eulerian_circuit(eulerian_graph):
        tests.append({'method': eulerian_graph[edge[0]][edge[1]][0]['id'],
                        'result': eulerian_graph[edge[0]][edge[1]][0]['event']})

    watch = StopWatch()

    for i, testcase in enumerate(tests):
        print 'TEST' + str(i) + ': ' + testcase['method']
        print 'Result: ' + testcase['result']
        if testcase['result'] == watch.next_method(testcase['method']):
            print 'PASSED\n'
        else:
            print 'FAILED\n'
