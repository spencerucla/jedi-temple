// https://www.hackerrank.com/challenges/between-two-sets

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

bool all_divide(int size, int *arr, int num) {
    size_t i;
    for (i = 0; i < size; i++)
        if (num % arr[i] != 0)
            return false;
    return true;
}

bool all_divide2(int size, int *arr, int num) {
    size_t i;
    for (i = 0; i < size; i++)
        if (arr[i] % num != 0)
            return false;
    return true;
}

int getTotalX(int a_size, int* a, int b_size, int* b) {
    int i, count = 0;
    for (i = 1; i <= 100; i++)
        if (all_divide(a_size, a, i) && all_divide2(b_size, b, i))
            count++;
    return count;
}

int main() {
    int n; 
    int m; 
    scanf("%i %i", &n, &m);
    int *a = malloc(sizeof(int) * n);
    for (int a_i = 0; a_i < n; a_i++) {
       scanf("%i",&a[a_i]);
    }
    int *b = malloc(sizeof(int) * m);
    for (int b_i = 0; b_i < m; b_i++) {
       scanf("%i",&b[b_i]);
    }
    int total = getTotalX(n, a, m, b);
    printf("%d\n", total);
    return 0;
}

