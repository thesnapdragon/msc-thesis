#!/usr/bin/env python

import networkx as nx

def bfs(graph):
    openList = ['S']
    closedList = []
    while len(openList) != 0 or 'E' not in closedList:
        next = openList.pop(0)
        for neighbour in graph.neighbors(next):
            if neighbour not in closedList and neighbour not in openList:
                openList.append(neighbour)
        closedList.append(next)
    return closedList

def dfs(graph):
    openList = ['S']
    closedList = []
    while len(openList) != 0 or 'E' not in closedList:
        next = openList.pop()
        for neighbour in graph.neighbors(next):
            if neighbour not in closedList and neighbour not in openList:
                openList.append(neighbour)
        closedList.append(next)
    return closedList

if __name__ == '__main__':
    graph = nx.read_graphml("../fsm/guard1.graphml")
    print bfs(graph)
    print dfs(graph)
