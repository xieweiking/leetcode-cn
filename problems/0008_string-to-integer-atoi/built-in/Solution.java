import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;

class Solution {
    public int myAtoi(String str) {
        try {
            final Matcher matcher = NUM_FMT.matcher(str);
            if (matcher.matches()) {
                final BigInteger result = new BigInteger(matcher.group(1));
                if (result.compareTo(INT_MIN) < 0)
                    return Integer.MIN_VALUE;
                else if (result.compareTo(INT_MAX) > 0)
                    return Integer.MAX_VALUE;
                else
                    return result.intValue();
            } else
                return 0;
        } catch (final NumberFormatException ignored) {
            return 0;
        }
    }
    static final Pattern NUM_FMT = Pattern.compile("\\s*([\\-\\+]?\\d+).*");
    static final BigInteger INT_MIN = BigInteger.valueOf(Integer.MIN_VALUE),
                            INT_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
}
