<?php
class Solution {
    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $max = 0;
        $start = 0;
        $l = strlen($s);
        for ($end = 0; $end < $l;) {
            $idx = self::indexOf($s, $s[$end], $start, $end);
            ++$end;
            if ($idx === FALSE)
                $max = max($max, $end - $start);
            else
                $start = $idx + 1;
        }
        return $max;
    }
    static function indexOf($s, $c, $start, $end) {
        for ($i = $start; $i < $end; ++$i)
            if ($s[$i] === $c)
                return $i;
        return FALSE;
    }
}
