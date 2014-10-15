#!/usr/bin/env python

import time

class StopWatch(object):

    def __init__(self):
        self.state = 'ready'
        self.time_start = None
        self.time_stop = None

    def next_method(self, method):
        methods = ['watch.start', 'watch.split', 'watch.unsplit', 'watch.stop', 'watch.reset']

        if method in methods:
            if method == 'watch.start':
                return self.start()
            elif method == 'watch.split':
                return self.split()
            elif method == 'watch.unsplit':
                return self.unsplit()
            elif method == 'watch.stop':
                return self.stop()
            elif method == 'watch.reset':
                return self.reset()
        else:
            raise ValueError('invalid method')

    def start(self):
        self.time_start = time.time()
        self.state = 'running'
        return self.state

    def split(self):
        self.time_stop = time.time()
        self.state = 'paused'
        return self.state

    def unsplit(self):
        self.state = 'running'
        return self.state

    def stop(self):
        self.time_stop = time.time()
        self.state = 'stopped'
        return self.state

    def reset(self):
        self.time_start = None
        self.time_stop = None
        self.state = 'ready'
        return self.state

    def get_time(self):
        return time.time()
