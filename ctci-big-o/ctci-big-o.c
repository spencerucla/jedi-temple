// https://www.hackerrank.com/challenges/ctci-big-o

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

bool is_prime(int n) {
    if (n == 1)
        return false;
    
    int sqrt_n = (int)sqrt(n);
    for (int i = 2; i <= sqrt_n; i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}

int main(){
    int p; 
    scanf("%d",&p);
    for(int a0 = 0; a0 < p; a0++){
        int n; 
        scanf("%d",&n);
        if (is_prime(n))
            printf("Prime\n");
        else
            printf("Not prime\n");
    }
    return 0;
}
