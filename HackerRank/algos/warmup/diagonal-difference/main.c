// https://www.hackerrank.com/challenges/diagonal-difference

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int diag_diff(int n, int arr[][n]) {
    int primary = 0, secondary = 0;
    size_t i;
    for (i = 0; i < n; i++) {
        primary += arr[i][i];
        secondary += arr[i][n-1-i];
    }
    int diff = primary - secondary;
    return (diff > 0) ? diff : -diff;
}

int main(){
    int n; 
    scanf("%d",&n);
    int a[n][n];
    for(int a_i = 0; a_i < n; a_i++){
       for(int a_j = 0; a_j < n; a_j++){
          
          scanf("%d",&a[a_i][a_j]);
       }
    }
    int diff = diag_diff(n, a);
    printf("%d\n", diff);
    return 0;
}

