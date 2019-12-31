using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> nums(nums1);
        copy(nums2.begin(), nums2.end(), back_inserter(nums));
        sort(nums.begin(), nums.end());
        const int size = nums.size(),
                  i = size / 2;
        return (size % 2 == 0 ? (nums[i - 1] + nums[i]) / 2.0 : nums[i]);
    }
};
