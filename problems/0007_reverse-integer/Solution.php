<?php
class Solution {
    /**
     * @param Integer $x
     * @return Integer
     */
    function reverse($x) {
        $result = 0;
        for (; $x != 0; $x = intdiv($x, 10))
            $result = $result * 10 + ($x % 10);
        return ($result < -pow(2, 31) || pow(2, 31) - 1 < $result ?
               0 : $result);
    }
}
