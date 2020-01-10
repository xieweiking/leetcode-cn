#include <stdlib.h>

int myAtoi(char * str){
    const long result = strtol(str, NULL, 10);
    if (result < INT_MIN)
        return INT_MIN;
    else if (result > INT_MAX)
        return INT_MAX;
    else
        return (int) result;
}
