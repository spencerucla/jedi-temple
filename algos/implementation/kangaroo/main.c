// https://www.hackerrank.com/challenges/kangaroo

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

char* kangaroo(int x1, int v1, int x2, int v2) {
    char *ret = (char *)malloc(4*sizeof(char));
    if (x1 > x2) {
        if (v1 >= v2) {
            ret = strcpy(ret, "NO");
        } else {
            while (x1 > x2) {
                x1 += v1;
                x2 += v2;
                if (x1 == x2) {
                    ret = strcpy(ret, "YES");
                    return ret;
                }
            }
            ret = strcpy(ret, "NO");
        }
    } else if (x1 < x2) {
        if (v1 <= v2) {
            ret = strcpy(ret, "NO");
        } else {
            while (x1 < x2) {
                x1 += v1;
                x2 += v2;
                if (x1 == x2) {
                    ret = strcpy(ret, "YES");
                    return ret;
                }
            }
            ret = strcpy(ret, "NO");
        }
    } else
        ret = strcpy(ret, "YES");
    return ret;
}

int main() {
    int x1; 
    int v1; 
    int x2; 
    int v2; 
    scanf("%i %i %i %i", &x1, &v1, &x2, &v2);
    int result_size;
    char* result = kangaroo(x1, v1, x2, v2);
    printf("%s\n", result);
    return 0;
}

