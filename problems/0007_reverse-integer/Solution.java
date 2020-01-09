class Solution {
    public int reverse(int x) {
        long result = 0;
        for (; x != 0; x /= 10)
            result = result * 10 + (x % 10);
        return (result < Integer.MIN_VALUE || Integer.MAX_VALUE < result ?
               0 : (int) result);
    }
}
