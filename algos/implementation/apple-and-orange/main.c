// https://www.hackerrank.com/challenges/apple-and-orange

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

unsigned int count(int *loc, int n, int min, int max) {
    size_t i;
    unsigned int count = 0;
    for (i = 0; i < n; i++)
        if (min <= loc[i] && loc[i] <= max)
            count++;
    return count;
}

int main(){
    int s; 
    int t; 
    scanf("%d %d",&s,&t);
    int a; 
    int b; 
    scanf("%d %d",&a,&b);
    int m; 
    int n; 
    scanf("%d %d",&m,&n);
    int *apple = malloc(sizeof(int) * m);
    for(int apple_i = 0; apple_i < m; apple_i++){
       scanf("%d",&apple[apple_i]);
        apple[apple_i] += a;
    }
    int *orange = malloc(sizeof(int) * n);
    for(int orange_i = 0; orange_i < n; orange_i++){
       scanf("%d",&orange[orange_i]);
        orange[orange_i] += b;
    }
    printf("%d\n", count(apple, m, s, t));
    printf("%d\n", count(orange, n, s, t));
    return 0;
}

