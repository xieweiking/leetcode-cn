<?php
class Solution {
    /**
     * @param String $s
     * @param String $p
     * @return Boolean
     */
    function isMatch($s, $p) {
        $sLen = strlen($s);
        $pLen = strlen($p);
        $memo = array_fill(0, $sLen + 1,
                           array_fill(0, $pLen + 1, false));
        $memo[$sLen][$pLen] = true;
        for ($i = $sLen; $i >= 0; --$i)
            for ($j = $pLen - 1; $j >= 0; --$j) {
                $matchChar = ($i < $sLen &&
                        ($p[$j] == $s[$i] || $p[$j] == '.'));
                $memo[$i][$j] = ($j < $pLen - 1 && $p[$j + 1] == '*' ?
                        ($memo[$i][$j + 2] || ($matchChar && $memo[$i + 1][$j])) :
                        ($matchChar && $memo[$i + 1][$j + 1]));
            }
        return $memo[0][0];
    }
}
