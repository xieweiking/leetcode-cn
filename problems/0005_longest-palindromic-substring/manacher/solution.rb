#!/usr/bin/ruby

# @param {String} s
# @return {String}
def longest_palindrome(s)
    if s.length <= 1
        return s
    end
    size = 2 * s.length + 1
    t = Array.new(size)
    for i in 0..(s.length - 1)
        t[2 * i + 1] = s[i]
    end
    p_lens = Array.new(size)
    c, r, max_p_len, idx = [0, 0, 0, 0]
    for i in 0..(size - 1)
        j = 2 * c - i
        p_len = (r > i ?
                [r - i, p_lens[j]].min : 0)
        pos_left, pos_right = [i - (p_len + 1), i + (p_len + 1)]
        while 0 <= pos_left and pos_right < size and \
                t[pos_left] == t[pos_right]
            p_len += 1
            pos_left -= 1
            pos_right += 1
        end
        new_r = i + (p_lens[i] = p_len)
        if new_r > r
            c, r = [i, new_r]
        end
        if p_len > max_p_len
            max_p_len, idx = [p_len, i]
        end
    end
    start = (idx - max_p_len) / 2
    return s[start..(start + max_p_len - 1)]
end
