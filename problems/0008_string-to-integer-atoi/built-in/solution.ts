function myAtoi(str: string): number {
    const result = parseInt(str)
    if (isNaN(result))
        return 0
    else if (result < INT_MIN)
        return INT_MIN
    else if (INT_MAX < result)
        return INT_MAX
    else
        return result
};

const INT_MAX = Math.pow(2, 31) - 1,
      INT_MIN = -Math.pow(2, 31)
