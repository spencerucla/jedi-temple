// https://www.hackerrank.com/challenges/ctci-lonely-integer

#!/bin/python
import sys

d = {}
def lonely_integer(a):
    for num in a:
        if num in d:
            d.pop(num)
        else:
            d[num] = None
    return d.keys()[0]

n = int(raw_input().strip())
a = map(int,raw_input().strip().split(' '))
print lonely_integer(a)
