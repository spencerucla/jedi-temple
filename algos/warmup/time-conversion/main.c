// https://www.hackerrank.com/challenges/time-conversion

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

char* timeConversion(char* s) {
    int hour = atoi(s);
    if (s[8] == 'P' && hour != 12)
        hour += 12;
    else if (s[8] == 'A' && hour == 12)
        hour -= 12;
    sprintf(s, "%02d%s", hour, &s[2]);
    s[8] = 0;
    return s;
}

int main() {
    char* s = (char *)malloc(512000 * sizeof(char));
    scanf("%s", s);
    int result_size;
    char* result = timeConversion(s);
    printf("%s\n", result);
    return 0;
}

