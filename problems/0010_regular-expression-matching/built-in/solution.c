#include <regex.h>

bool isMatch(char * s, char * p) {
    regex_t r;
    char pp[strlen(p) + 3];
    sprintf(pp, "^%s$", p);
    regcomp(&r, pp, 0);
    return !regexec(&r, s, 0, NULL, 0);
}
