using System.Text.RegularExpressions;

public class Solution {
    public int MyAtoi(string str) {
        var matcher = NUM_FMT.Match(str);
        if (matcher.Success) {
            str = matcher.Groups[1].Value;
            try {
                return Int32.Parse(str);
            } catch (FormatException) {
            } catch (OverflowException) {
                foreach (var c in str)
                    if (c == '-')
                        return Int32.MinValue;
                    else if (c == '+' || '0' <= c && c <= '9')
                        return Int32.MaxValue;
            }
        }
        return 0;
    }
    static Regex NUM_FMT = new Regex(@"^\s*([\-\+]?\d+).*$");
}
