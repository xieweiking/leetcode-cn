public class Solution {
    public int MyAtoi(string str) {
        if (str.Length == 0)
            return 0;
        var i = 0;
        for (; i < str.Length && str[i] == ' '; ++i);
        var sign = 1L;
        if (i < str.Length)
            if (str[i] == '-') {
                i++;
                sign = -1L;
            } else if (str[i] == '+')
                i++;
        var result = 0L;
        for (; i < str.Length && '0' <= str[i] && str[i] <= '9'; ++i) {
            result = result * 10 + sign * (str[i] - '0');
            if (result < Int32.MinValue)
                return Int32.MinValue;
            else if (result > Int32.MaxValue)
                return Int32.MaxValue;
        }
        return (int) result;
    }
}
