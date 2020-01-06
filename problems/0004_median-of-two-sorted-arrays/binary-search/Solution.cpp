using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& A, vector<int>& B) {
        if (A.size() > B.size())
            A.swap(B);
        const int m = A.size(),
                  n = B.size(),
                  total = m + n,
                  h = total / 2;
        const bool isOdd = (total % 2 == 1);
        for (int iBegin = 0, iEnd = m; iBegin <= iEnd;) {
            const int i = (iBegin + iEnd) / 2,
                      j = h - i;
            if (i < iEnd && 0 < j && A[i] < B[j - 1])
                iBegin = i + 1;
            else if (iBegin < i && j < n && B[j] < A[i - 1])
                iEnd = i - 1;
            else {
                const int minGreater = (i == m ?
                        B[j] :
                        (j == n ?
                            A[i] :
                            min(A[i], B[j])));
                if (isOdd)
                    return minGreater;
                const int maxLesser = (i == 0 ?
                        B[j - 1] :
                        (j == 0 ?
                            A[i - 1] :
                            max(A[i - 1], B[j - 1])));
                return (maxLesser + minGreater) / 2.0;
            }
        }
        throw runtime_error("Should NOT be HERE!");
    }
};
