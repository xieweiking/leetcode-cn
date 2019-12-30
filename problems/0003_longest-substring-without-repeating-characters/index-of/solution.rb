#!/usr/bin/ruby

# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    max, start, ed = [0, 0, 0]
    while ed < s.length
        idx = index_of(s, s[ed], start, ed)
        ed += 1
        if idx == nil
            max = [max, ed - start].max
        else
            start = idx + 1
        end
    end
    return max
end

def index_of(s, c, start, ed)
    for i in start..(ed - 1)
        if s[i] == c
            return i
        end
    end
    return nil
end
