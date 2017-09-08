// https://www.hackerrank.com/challenges/grading

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int* solve(int grades_size, int* grades, int *result_size){
    size_t i;
    *result_size = grades_size;
    for (i = 0; i < grades_size; i++) {
        int rem5 = (5 - (grades[i] % 5));
        if (rem5 < 3 && grades[i] >= 38) {
            grades[i] += rem5;
        }
    }
    return grades;
}

int main() {
    int n; 
    scanf("%d", &n);
    int *grades = malloc(sizeof(int) * n);
    for(int grades_i = 0; grades_i < n; grades_i++){
       scanf("%d",&grades[grades_i]);
    }
    int result_size;
    int* result = solve(n, grades, &result_size);
    for(int result_i = 0; result_i < result_size; result_i++) {
        if(result_i) {
            printf("\n");
        }
        printf("%d", result[result_i]);
    }
    puts("");
    

    return 0;
}

