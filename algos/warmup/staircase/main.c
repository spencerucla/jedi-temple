// https://www.hackerrank.com/challenges/staircase

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

void print_staircase(int n)
{
    int i, j;
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (j < n - i - 1)
                printf(" ");
            else
                printf("#");
        }
        printf("\n");
    }
}

int main(){
    int n; 
    scanf("%d",&n);
    print_staircase(n);
    return 0;
}

