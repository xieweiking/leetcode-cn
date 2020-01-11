#!/usr/bin/ruby

# @param {String} str
# @return {Integer}
def my_atoi(str)
    if str.length == 0
        return 0
    end
    i = 0
    while i < str.length and str[i] == ' '
        i += 1
    end
    sign = 1
    if i < str.length
        if str[i] == '-'
            i += 1
            sign = -1
        elsif str[i] == '+'
            i += 1
        end
    end
    result = 0
    while i < str.length and '0' <= str[i] and str[i] <= '9'
        result = result * 10 + sign * (str[i].ord - '0'.ord)
        if result < INT_MIN
            return INT_MIN
        elsif result > INT_MAX
            return INT_MAX
        end
        i += 1
    end
    return result
end

INT_MAX = 2**31 - 1
INT_MIN = -2**31
