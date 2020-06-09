function isPalindrome(x: number): boolean {
    if (x < 0)
        return false
    else if (x < 10)
        return true
    const s = String(x)
    for (let i = 0, j = s.length - 1; i < j; ++i, --j)
        if (s[i] !== s[j])
            return false
    return true
};
