#!/usr/bin/ruby

# @param {Integer} x
# @return {Boolean}
def is_palindrome(x)
    if x < 0
        return false
    elsif x < 10
        return true
    end
    s = x.to_s
    i, j = [0, s.length - 1]
    while i < j
        if s[i] != s[j]
            return false
        end
        i += 1
        j -= 1
    end
    return true
end
