#!/usr/bin/ruby

# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays(nums1, nums2)
    a, b = [nums1, nums2]
    if a.length > b.length
        b, a = [a, b]
    end
    m, n = [a.length, b.length]
    total = m + n
    h = total / 2
    is_odd = (total % 2 == 1)
    i_begin, i_end = [0, m]
    while i_begin <= i_end
        i = (i_begin + i_end) / 2
        j = h - i
        if i < i_end and 0 < j and a[i] < b[j - 1]
            i_begin = i + 1
        elsif i_begin < i and j < n and b[j] < a[i - 1]
            i_end = i - 1
        else
            min_greater = (i == m ?
                    b[j] :
                    (j == n ?
                        a[i] :
                        [a[i], b[j]].min))
            if is_odd
                return min_greater
            end
            max_lesser = (i == 0 ?
                    b[j - 1] :
                    (j == 0 ?
                        a[i - 1] :
                        [a[i - 1], b[j - 1]].max))
            return (max_lesser + min_greater) / 2.0
        end
    end
    raise 'Should NOT be HERE!'
end
