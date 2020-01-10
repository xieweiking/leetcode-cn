<?php
class Solution {
    /**
     * @param String $str
     * @return Integer
     */
    function myAtoi($str) {
        if (preg_match('/^\s*([\-\+]?\d+).*$/', $str, $matches)) {
            $result = intval($matches[1]);
            if ($result < -pow(2, 31))
                return -pow(2, 31);
            else if ($result > pow(2, 31) - 1)
                return pow(2, 31) - 1;
            else
                return $result;
        }
        return 0;
    }
}
