#!/usr/bin/ruby

# @param {String} s
# @return {String}
def longest_palindrome(s)
    max_left, max_right = [0, 0]
    for i in 0..(s.length * 2)
        pos_left = i / 2
        pos_right = (i % 2 == 1 ? pos_left + 1: pos_left)
        while 0 <= pos_left and pos_right < s.length and \
                s[pos_left] == s[pos_right]
            pos_left -= 1
            pos_right += 1
        end
        pos_left += 1
        if pos_right - pos_left > max_right - max_left
            max_left, max_right = [pos_left, pos_right]
        end
    end
    return s[max_left..(max_right - 1)]
end
