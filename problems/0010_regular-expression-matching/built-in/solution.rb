#!/usr/bin/ruby

# @param {String} s
# @param {String} p
# @return {Boolean}
def is_match(s, p)
    return s.match(Regexp.new('^' + p + '$')) != nil
end
