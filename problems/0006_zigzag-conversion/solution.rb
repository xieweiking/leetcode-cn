#!/usr/bin/ruby

# @param {String} s
# @param {Integer} num_rows
# @return {String}
def convert(s, num_rows)
    if (s.length <= 2 || num_rows == 1)
        return s
    end
    cols_per_pad = num_rows - 1
    chars_per_pad = cols_per_pad - 1 + num_rows
    last_row = cols_per_pad
    buf = StringIO.new
    for r in 0..(num_rows - 1)
        for i in (r..(s.length - 1)).step(chars_per_pad)
            buf << s[i]
            j = i + chars_per_pad - 2 * r
            if (r != 0 and r != last_row and j < s.length)
                buf << s[j]
            end
        end
    end
    return buf.string
end
