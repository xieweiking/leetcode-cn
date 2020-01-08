<?php
class Solution {
    /**
     * @param String $s
     * @return String
     */
    function longestPalindrome($s) {
        $sLen = strlen($s);
        if ($sLen <= 1)
            return $s;
        $size = 2 * $sLen + 1;
        $t = [];
        for ($i = 0; $i < $sLen; ++$i) {
            $j = 2 * $i;
            $t[$j] = 0;
            $t[$j + 1] = $s[$i];
        }
        $t[$size - 1] = 0;
        $pLens = [];
        $c = 0;
        $r = 0;
        $maxPLen = 0;
        $idx = 0;
        for ($i = 0; $i < $size; ++$i) {
            $j = 2 * $c - $i;
            $pLen = ($r > $i ?
                    min($r - $i, $pLens[$j]) : 0);
            $posLeft = $i - ($pLen + 1);
            $posRight = $i + ($pLen + 1);
            while (0 <= $posLeft && $posRight < $size &&
                    $t[$posLeft] == $t[$posRight]) {
                ++$pLen;
                --$posLeft;
                ++$posRight;
            }
            $newR = $i + ($pLens[] = $pLen);
            if ($newR > r) {
                $c = $i;
                $r = $newR;
            }
            if ($pLen > $maxPLen) {
                $maxPLen = $pLen;
                $idx = $i;
            }
        }
        $start = intdiv($idx - $maxPLen, 2);
        return substr($s, $start, $maxPLen);
    }
}
