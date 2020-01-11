<?php
class Solution {
    /**
     * @param String $str
     * @return Integer
     */
    function myAtoi($str) {
        $sLen = strlen($str);
        if ($sLen == 0)
            return 0;
        $i = 0;
        for (; $i < $sLen && $str[$i] == ' '; ++$i);
        $sign = 1;
        if ($i < $sLen)
            if ($str[$i] == '-') {
                ++$i;
                $sign = -1;
            } else if ($str[$i] == '+')
                ++$i;
        $result = 0;
        for (; $i < $sLen && '0' <= $str[$i] && $str[$i] <= '9'; ++$i) {
            $result = $result * 10 + $sign * ($str[$i] - '0');
            if ($result < -pow(2, 31))
                return -pow(2, 31);
            else if ($result > pow(2, 31) - 1)
                return pow(2, 31) - 1;
        }
        return $result;
    }
}
