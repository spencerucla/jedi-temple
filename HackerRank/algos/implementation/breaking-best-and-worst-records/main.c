// https://www.hackerrank.com/challenges/breaking-best-and-worst-records

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int* getRecord(int s_size, int* s, int *result_size){
    size_t i;
    unsigned int min = s[0];
    unsigned int max = s[0];
    unsigned int num_new_mins = 0;
    unsigned int num_new_maxs = 0;
    int *ret = (int *)malloc(2*sizeof(int));
    for (i = 1; i < s_size; i++) {
        if (s[i] < min) {
            min = s[i];
            num_new_mins++;
        }
        if (s[i] > max) {
            max = s[i];
            num_new_maxs++;
        }
    }
    *result_size = 2;
    ret[0] = num_new_maxs;
    ret[1] = num_new_mins;
    return ret;
}

int main() {
    int n; 
    scanf("%d",&n);
    int *s = malloc(sizeof(int) * n);
    for(int s_i = 0; s_i < n; s_i++){
       scanf("%d",&s[s_i]);
    }
    int result_size;
    int* result = getRecord(n, s, &result_size);
    for(int i = 0; i < result_size; i++) {
        if (i) {
            printf(" ");
        }
        printf("%d", result[i]);
    }
    puts("");
    return 0;
}

