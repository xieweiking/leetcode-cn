#!/usr/bin/ruby

# @param {String} str
# @return {Integer}
def my_atoi(str)
    if match = str.match(/^\s*(([\-\+]?)(0*)(\d+)).*$/)
        begin
            _, s, z, n = match.captures
            result = Integer(s + n)
            if result < INT_MIN
                return INT_MIN
            elsif result > INT_MAX
                return INT_MAX
            else
                return result
            end
        rescue ArgumentError => ignored
        end
    end
    return 0;
end

INT_MAX = 2**31 - 1
INT_MIN = -2**31
