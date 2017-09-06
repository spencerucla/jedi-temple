// https://www.hackerrank.com/challenges/mini-max-sum

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

void mini_max_sum(int *arr, int n)
{
    long int min = INT_MAX, max = INT_MIN, sum = 0;
    size_t i;
    for (i = 0; i < n; i++) {
        if (arr[i] < min)
            min = arr[i];
        if (arr[i] > max)
            max = arr[i];
        sum += arr[i];
    }
    printf("%ld %ld\n", sum-max, sum-min);
}

int main() {
    int *arr = malloc(sizeof(int) * 5);
    for(int arr_i = 0; arr_i < 5; arr_i++){
       scanf("%d",&arr[arr_i]);
    }
    mini_max_sum(arr, 5);
    return 0;
}

