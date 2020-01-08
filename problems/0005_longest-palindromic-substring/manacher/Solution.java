class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        final int size = 2 * s.length() + 1;
        final char[] t = new char[size];
        for (int i = 0; i < s.length(); ++i)
            t[2 * i + 1] = s.charAt(i);
        final int[] pLens = new int[size];
        int c = 0, r = 0, maxPLen = 0, idx = 0;
        for (int i = 0; i < size; ++i) {
            final int j = 2 * c - i;
            int pLen = (r > i ?
                    Math.min(r - i, pLens[j]) : 0);
            for (int incrPLen = pLen + 1,
                     posLeft = i - incrPLen,
                     posRight = i + incrPLen;
                    0 <= posLeft && posRight < t.length &&
                        t[posLeft] == t[posRight];
                    --posLeft, ++posRight)
                ++pLen;
            final int newR = i + (pLens[i] = pLen);
            if (newR > r) {
                c = i;
                r = newR;
            }
            if (pLen > maxPLen) {
                maxPLen = pLen;
                idx = i;
            }
        }
        final int start = (idx - maxPLen) / 2;
        return s.substring(start, start + maxPLen);
    }
}
