// https://www.hackerrank.com/challenges/plus-minus

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

void plus_minus(int *arr, int n) {
    size_t i;
    unsigned int plus = 0, minus = 0, zero = 0;
    for (i = 0; i < n; i++) {
        if (arr[i] > 0)
            plus++;
        else if (arr[i] < 0)
            minus++;
        else
            zero++;
    }
    printf("%f\n", ((double)plus)/n);
    printf("%f\n", ((double)minus)/n);
    printf("%f\n", ((double)zero)/n);
}

int main(){
    int n; 
    scanf("%d",&n);
    int arr[n];
    for(int arr_i = 0; arr_i < n; arr_i++){
       scanf("%d",&arr[arr_i]);
    }
    plus_minus(arr, n);
    return 0;
}

