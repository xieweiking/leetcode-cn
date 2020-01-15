#!/usr/bin/ruby

# @param {String} s
# @param {String} p
# @return {Boolean}
def is_match(s, p)
    if p.length == 0
        return (s.length == 0)
    end
    p0 = p[0]
    match_p0 = (s.length > 0 and
            (p0 == s[0] or p0 == '.'))
    if p.length >= 2 and p[1] == '*'
        return (is_match(s, p[2..-1]) or
                (match_p0 and is_match(s[1..-1], p)))
    else
        return (match_p0 and is_match(s[1..-1], p[1..-1]))
    end
end
