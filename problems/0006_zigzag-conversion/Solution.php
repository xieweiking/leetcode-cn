<?php
class Solution {
    /**
     * @param String $s
     * @param Integer $numRows
     * @return String
     */
    function convert($s, $numRows) {
        $sLen = strlen($s);
        if ($sLen <= 2 || $numRows == 1)
            return $s;
        $colsPerPad = $numRows - 1;
        $charsPerPad = $colsPerPad - 1 + $numRows;
        $lastRow = $colsPerPad;
        $result = '';
        for ($r = 0; $r < $numRows; ++$r)
            for ($i = $r; $i < $sLen; $i += $charsPerPad) {
                $result .= $s[$i];
                if ($r != 0 && $r != $lastRow) {
                    $j = $i + $charsPerPad - 2 * $r;
                    if ($j < $sLen)
                        $result .= $s[$j];
                }
            }
        return $result;
    }
}
