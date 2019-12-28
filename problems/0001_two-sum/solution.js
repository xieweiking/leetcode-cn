/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    'use strict'
    const m = new Map()
    for (let i = 0; i < nums.length; ++i) {
        const num = nums[i],
              j = m.get(target - num)
        if (j !== undefined)
            return [j, i]
        m.set(num, i)
    }
    throw `No match value for ${nums}, ${target}!`
};
