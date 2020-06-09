function twoSum(nums: number[], target: number): number[] {
    const m: { [index: number]: number } = {}
    for (let i = 0; i < nums.length; ++i) {
        const num = nums[i],
              j = m[target - num]
        if (j !== undefined)
            return [j, i]
        m[num] = i
    }
    throw `No match value for ${nums}, ${target}!`
};
