<?php
class Solution {
    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Float
     */
    function findMedianSortedArrays($nums1, $nums2) {
        $nums = [];
        array_push($nums, ...$nums1);
        array_push($nums, ...$nums2);
        sort($nums);
        $size = count($nums);
        $i = intdiv($size, 2);
        return ($size % 2 == 0 ? ($nums[$i - 1] + $nums[$i]) / 2 : $nums[$i]);
    }
}
