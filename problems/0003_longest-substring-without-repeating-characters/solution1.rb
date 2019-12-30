#!/usr/bin/ruby

# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    max, start, e = [0, 0, 0]
    for i in 0..(s.length - 1)
        idx = find(s, s[i], start, e)
        e += 1
        if idx == nil
            max = [max, e - start].max
        else
            start = idx + 1
        end
    end
    return max
end

def find(s, c, start, e)
    for i in start..(e - 1)
        if s[i] == c
            return i
        end
    end
    return nil
end
