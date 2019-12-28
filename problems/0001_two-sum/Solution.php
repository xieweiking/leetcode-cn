<?php
class Solution {
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $m = [];
        $l = count($nums);
        for ($i = 0; $i < $l; ++$i) {
            $num = $nums[$i];
            $r = $target - $num;
            if (array_key_exists($r, $m))
                return [$m[$r], $i];
            $m[$num] = $i;
        }
        throw new Exception('No match value for $nums, $target!');
    }
}
