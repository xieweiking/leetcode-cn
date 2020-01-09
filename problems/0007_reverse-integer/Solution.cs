public class Solution {
    public int Reverse(int x) {
        long result = 0;
        for (; x != 0; x /= 10)
            result = result * 10 + (x % 10);
        return (result < Int32.MinValue || Int32.MaxValue < result ?
               0 : (int) result);
    }
}
