bool isPalindrome(int x){
    if (x < 0)
        return false;
    else if (x < 10)
        return true;
    char s[12];
    sprintf(s, "%d", x);
    for (int i = 0, j = strlen(s) - 1; i < j; ++i, --j)
        if (s[i] != s[j])
            return false;
    return true;
}
