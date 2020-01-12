<?php
class Solution {
    /**
     * @param Integer $x
     * @return Boolean
     */
    function isPalindrome($x) {
        if ($x < 0)
            return false;
        else if ($x < 10)
            return true;
        $s = strval($x);
        for ($i = 0, $j = strlen($s) - 1; $i < $j; ++$i, --$j)
            if ($s[$i] != $s[$j])
                return false;
        return true;
    }
}
