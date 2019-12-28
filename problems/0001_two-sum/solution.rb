#!/usr/bin/ruby

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    m = Hash.new(nums.length)
    nums.each_with_index do |num, i|
        r = target - num
        if (m.has_key?(r))
            return [m[r], i]
        end
        m[num] = i
    end
    raise 'No match value for #{nums}, #{target}!'
end
