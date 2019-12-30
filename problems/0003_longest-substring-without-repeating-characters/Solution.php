<?php
class Solution {
    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $max = 0;
        $start = 0;
        $end = 0;
        $l = strlen($s);
        for ($i = 0; $i < $l; ++$i) {
            $idx = self::find($s, $s[$i], $start, $end);
            ++$end;
            if ($idx === FALSE)
                $max = max($max, $end - $start);
            else
                $start = $idx + 1;
        }
        return $max;
    }
    static function find($s, $c, $start, $end) {
        for ($i = $start; $i < $end; ++$i)
            if ($s[$i] === $c)
                return $i;
        return FALSE;
    }
}
