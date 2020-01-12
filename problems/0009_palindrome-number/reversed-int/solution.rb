#!/usr/bin/ruby

# @param {Integer} x
# @return {Boolean}
def is_palindrome(x)
    if x < 0
        return false
    elsif x < 10
        return true
    end
    reversed, k = [0, x]
    while k != 0
        reversed = reversed * 10 + (k % 10)
        k /= 10
    end
    return x == reversed
end
