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
    isOdd = (total % 2 == 1)
    iBegin, iEnd = [0, m]
    while iBegin <= iEnd
        i = (iBegin + iEnd) / 2
        j = h - i
        if i < iEnd and 0 < j and a[i] < b[j - 1]
            iBegin = i + 1
        elsif iBegin < i and j < n and b[j] < a[i - 1]
            iEnd = i - 1
        else
            minGreater = (i == m ?
                    b[j] :
                    (j == n ?
                        a[i] :
                        [a[i], b[j]].min))
            if isOdd
                return minGreater
            end
            maxLesser = (i == 0 ?
                    b[j - 1] :
                    (j == 0 ?
                        a[i - 1] :
                        [a[i - 1], b[j - 1]].max))
            return (maxLesser + minGreater) / 2.0
        end
    end
    raise 'Should NOT be HERE!'
end
