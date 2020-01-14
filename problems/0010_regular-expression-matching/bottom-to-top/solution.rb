#!/usr/bin/ruby

# @param {String} s
# @param {String} p
# @return {Boolean}
def is_match(s, p)
    memo = Array.new(s.length + 1) {
        Array.new(p.length + 1, false)
    }
    memo[s.length][p.length] = true
    for i in (s.length).downto(0)
        for j in (p.length - 1).downto(0)
            match_char = (i < s.length and
                    (p[j] == s[i] or p[j] == '.'))
            if j < p.length - 1 and p[j + 1] == '*'
                memo[i][j] = (memo[i][j + 2] or (match_char and memo[i + 1][j]))
            elsif
                memo[i][j] = (match_char and memo[i + 1][j + 1])
            end
        end
    end
    return memo[0][0]
end
