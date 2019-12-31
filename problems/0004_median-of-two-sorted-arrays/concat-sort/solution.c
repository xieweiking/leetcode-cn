int cmp(const int* a, const int* b) {
    return *a - *b;
}

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    const int size = nums1Size + nums2Size,
              i = size / 2;
    int nums[size];
    memcpy(nums, nums1, nums1Size * sizeof(int));
    memcpy(nums + nums1Size, nums2, nums2Size * sizeof(int));
    qsort(nums, size, sizeof(int), cmp);
    return (size % 2 == 0 ? (nums[i - 1] + nums[i]) / 2.0 : nums[i]);
}
