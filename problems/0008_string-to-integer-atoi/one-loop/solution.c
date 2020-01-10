int myAtoi(char * str) {
    if (str[0] == '\0')
        return 0;
    size_t i = 0;
    for (; str[i] == ' '; ++i);
    long sign = 1;
    if (str[i] == '-') {
        ++i;
        sign = -1;
    } else if (str[i] == '+')
        ++i;
    long result = 0;
    for (char c = str[i]; c != '\0' && '0' <= c && c <= '9'; c = str[++i]) {
        result = result * 10 + sign * (c - '0');
        if (result < INT_MIN)
            return INT_MIN;
        else if (result > INT_MAX)
            return INT_MAX;
    }
    return result;
}
