int reverse(int x){
    const int sign = (x < 0 ? -1 : 1);
    long n = ((long) x) * sign,
         result = 0;
    for (; n != 0; n /= 10)
        result = result * 10 + (n % 10);
    result *= sign;
    return (result < INT_MIN || INT_MAX < result ?
           0 : (int) result);
}
