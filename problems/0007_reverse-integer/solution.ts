function reverse(x: number): number {
    let result = 0
    for (; x != 0; x = Math.trunc(x / 10))
        result = result * 10 + (x % 10)
    return (result < -Math.pow(2, 31) || Math.pow(2, 31) - 1 < result ?
            0 : result);
};
