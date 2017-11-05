// https://www.hackerrank.com/challenges/migratory-birds

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int migratoryBirds(int n, int* ar) {
    int counts[5] = {0};
    size_t i;
    for (i = 0; i < n; i++)
        counts[ar[i]-1]++;
    int max = 0, max_count = 0;
    for (i = 0; i < 5; i++)
        if (counts[i] > max_count) {
            max = i;
            max_count = counts[i];
        }
    return max+1;
}

int main() {
    int n; 
    scanf("%i", &n);
    int *ar = malloc(sizeof(int) * n);
    for(int ar_i = 0; ar_i < n; ar_i++){
       scanf("%i",&ar[ar_i]);
    }
    int result = migratoryBirds(n, ar);
    printf("%d\n", result);
    return 0;
}

