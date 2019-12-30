<?php
class Solution {
    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $map = [];
        $max = 0;
        $start = 0;
        $l = strlen($s);
        for ($end = 0; $end < $l;) {
            $c = $s[$end];
            $idx = $map[$c];
            $map[$c] = $end++;
            if (!isset($idx) || $idx < $start)
                $max = max($max, $end - $start);
            else
                $start = $idx + 1;
        }
        return $max;
    }
}
