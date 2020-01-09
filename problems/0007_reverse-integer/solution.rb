#!/usr/bin/ruby

# @param {Integer} x
# @return {Integer}
def reverse(x)
    sign = (x < 0) ? -1 : 1
    x *= sign
    result = 0
    while x != 0
        result = result * 10 + (x % 10)
        x /= 10
    end
    result *= sign
    return (result < -2**31 or 2**31 - 1 < result) ? 0 : result
end
