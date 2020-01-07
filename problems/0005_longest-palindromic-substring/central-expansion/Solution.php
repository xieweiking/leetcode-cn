<?php
class Solution {
    /**
     * @param String $s
     * @return String
     */
    function longestPalindrome($s) {
        $sLen = strlen($s);
        $iEnd = $sLen * 2 - 1;
        $start = 0;
        $maxLen = 0;
        for ($i = 0; $i < $iEnd; ++$i) {
            $posLeft = intdiv($i, 2);
            $posRight = ($i % 2 == 1 ? $posLeft + 1 : $posLeft);
            while (0 <= $posLeft && $posRight < $sLen &&
                    $s[$posLeft] == $s[$posRight]) {
                --$posLeft;
                ++$posRight;
            }
            $len = $posRight - (++$posLeft);
            if ($len > $maxLen) {
                $start = $posLeft;
                $maxLen = $len;
            }
        }
        return substr($s, $start, $maxLen);
    }
}
