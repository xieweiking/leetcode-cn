<?php
class Solution {
    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Float
     */
    function findMedianSortedArrays($nums1, $nums2) {
        $A = $nums1;
        $B = $nums2;
        $m = count($A);
        $n = count($B);
        if ($m > $n) {
            $A = $nums2;
            $B = $nums1;
            $tmp = $m;
            $m = $n;
            $n = $tmp;
        }
        $total = $m + $n;
        $h = intdiv($total, 2);
        $isOdd = ($total % 2 == 1);
        for ($iBegin = 0, $iEnd = $m; $iBegin <= $iEnd;) {
            $i = intdiv($iBegin + $iEnd, 2);
            $j = $h - $i;
            if ($i < $iEnd && 0 < $j && $A[$i] < $B[$j - 1])
                $iBegin = $i + 1;
            else if ($iBegin < $i && $j < $n && $B[$j] < $A[$i - 1])
                $iEnd = $i - 1;
            else {
                $minGreater = ($i == $m ?
                        $B[$j] :
                        ($j == $n ?
                            $A[$i] :
                            min($A[$i], $B[$j])));
                if ($isOdd)
                    return $minGreater;
                $maxLesser = ($i == 0 ?
                        $B[$j - 1] :
                        ($j == 0 ?
                            $A[$i - 1] :
                            max($A[$i - 1], $B[$j - 1])));
                return ($maxLesser + $minGreater) / 2;
            }
        }
        throw new Exception("Should NOT be HERE!");
    }
}
