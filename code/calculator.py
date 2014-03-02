#!/usr/bin/env python

class Calculator(object):

    def __init__(self):
        self.state = 'ready'

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
        if self.state == 'ready':
            self.state = 'running'
        else:
            raise ValueError('invalid event')
        return self.state

    def split(self):
        if self.state == 'running':
            self.state = 'paused'
        else:
            raise ValueError('invalid event')
        return self.state

    def unsplit(self):
        if self.state == 'paused':
            self.state = 'running'
        else:
            raise ValueError('invalid event')
        return self.state

    def stop(self):
        if self.state == 'running' or self.state == 'paused':
            self.state = 'stopped'
        else:
            raise ValueError('invalid event')
        return self.state

    def reset(self):
        if self.state == 'stopped':
            self.state = 'ready'
        else:
            raise ValueError('invalid event')
        return self.state
