#!/usr/bin/ruby

# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    m = Hash.new(256)
    max, start, e = [0, 0, 0]
    while e < s.length
        c = s[e]
        ok, idx = [m.has_key?(c), m[c]]
        m[c] = e
        e += 1
        if not ok or idx < start
            max = [max, e - start].max
        else
            start = idx + 1
        end
    end
    return max
end
