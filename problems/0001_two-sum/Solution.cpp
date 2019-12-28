using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> m;
        const int size = nums.size();
        for (int i = 0; i < size; ++i) {
            const int num = nums[i];
            const unordered_map<int, int>::iterator it = m.find(target - num);
            if (it != m.end()) {
                const int j = it->second;
                return vector<int>{ j, i };
            }
            m.insert(make_pair(num, i));
        }
        stringstream ss;
        ss << "No match value for ";
        copy(nums.begin(), nums.end(), ostream_iterator<int>(ss, " "));
        ss << ", " << target << "!" << endl;
        throw runtime_error(ss.str());
    }
};
