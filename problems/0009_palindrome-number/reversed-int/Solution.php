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
        $reversed = 0;
        for ($k = $x; $k != 0; $k = intdiv($k, 10))
            $reversed = $reversed * 10 + ($k % 10);
        return $x == $reversed;
    }
}
