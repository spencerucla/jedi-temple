// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers

#include <stdio.h>

int fib(int n, int curr, int prev) {
    if (n == 0)
        return prev;
    if (n == 1)
        return curr;
    return fib(n - 1, curr + prev, curr);
    
}

int fibonacci(int n) {
    // call efficient tail recursive fibonacci
    return fib(n, 1, 0);
    
    // BAD: inefficient
    /*
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return fibonacci(n-1) + fibonacci(n-2);
    */
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%d", fibonacci(n));
    return 0;
}

mem = { 0:0, 1:1 }
def fibonacci(n):
    if n not in mem:
        mem[n] = fibonacci(n-1) + fibonacci(n-2)
    return mem[n]

n = int(raw_input())
print(fibonacci(n))
