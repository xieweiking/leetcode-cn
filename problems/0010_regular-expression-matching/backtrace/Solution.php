<?php
class Solution {
    /**
     * @param String $s
     * @param String $p
     * @return Boolean
     */
    function isMatch($s, $p) {
        $sLen = strlen($s);
        $pLen = strlen($p);
        if ($pLen == 0) return ($sLen == 0);
        $p0 = $p[0];
        $matchP0 = ($sLen > 0 &&
                ($p0 == $s[0] || $p0 == '.'));
        if ($pLen >= 2 && $p[1] == '*')
            return ($this->isMatch($s, substr($p, 2, $pLen - 2)) ||
                    ($matchP0 && $this->isMatch(substr($s, 1, $sLen - 1), $p)));
        else
            return ($matchP0 && $this->isMatch(substr($s, 1, $sLen - 1), substr($p, 1, $pLen - 1)));
    }
}
