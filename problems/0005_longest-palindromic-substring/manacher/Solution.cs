public class Solution {
    public string LongestPalindrome(string s) {
        if (s.Length <= 1)
            return s;
        var size = 2 * s.Length + 1;
        var t = new char[size];
        for (var i = 0; i < s.Length; ++i)
            t[2 * i + 1] = s[i];
        var pLens = new int[size];
        int c = 0, r = 0, maxPLen = 0, idx = 0;
        for (var i = 0; i < size; ++i) {
            var j = 2 * c - i;
            var pLen = (r > i ?
                    Math.Min(r - i, pLens[j]) : 0);
            for (int incrPLen = pLen + 1,
                     posLeft = i - incrPLen,
                     posRight = i + incrPLen;
                    0 <= posLeft && posRight < t.Length &&
                        t[posLeft] == t[posRight];
                    --posLeft, ++posRight)
                ++pLen;
            var newR = i + (pLens[i] = pLen);
            if (newR > r) {
                c = i;
                r = newR;
            }
            if (pLen > maxPLen) {
                maxPLen = pLen;
                idx = i;
            }
        }
        var start = (idx - maxPLen) / 2;
        return s.Substring(start, maxPLen);
    }
}
