import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean isMatch(String s, String p) {
        return Pattern.comiple(p).matcher(s).matches();
    }
}
