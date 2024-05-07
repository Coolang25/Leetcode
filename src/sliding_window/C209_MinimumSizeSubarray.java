package sliding_window;

/*
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/

public class C209_MinimumSizeSubarray {
    public static void main(String[] args) {
        int arr[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        // Vét cạn
//        int n = nums.length;
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int sum = 0;
//                for (int k = i; k <= j; k++) {
//                    sum += nums[k];
//                }
//                if (sum >= target) {
//                    ans = Math.min(ans, (j - i + 1));
//                }
//            }
//        }
//
//        return (ans != Integer.MAX_VALUE) ? ans : 0;

        // Cải tiến vét cạn bằng cách dùng thêm biến lưu trữ
        // sum = sum[j] - sum[i] + num[i]
//        int n = nums.length;
//        int ans = Integer.MAX_VALUE;
//        int[] sums = new int[n];
//        sums[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            sums[i] = sums[i - 1] + nums[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int sum = sums[j] - sums[i] + nums[i];
//
//                if (sum >= target) {
//                    ans = Math.min(ans, (j - i + 1));
//                }
//            }
//        }
//
//        return (ans != Integer.MAX_VALUE) ? ans : 0;

        // Binary + cửa sổ trượt
//        public:
//        bool windowfind(int size, vector<int>&nums, int target) {
//            int sum = 0;
//            int i=0;
//            int j=0;
//            int mx=INT_MIN;
//            int n=nums.size();
//            while(j<n){
//                sum+=nums[j];
//                if(j-i+1==size){
//                    mx=max(sum,mx);
//                    sum-=nums[i];
//                    i++;
//                }
//                j++;
//            }
//            if(mx>=target)
//                return true;
//            return false;
//        }
//
//        int minSubArrayLen(int target, vector<int>& nums) {
//            int low = 1, high = nums.size(), mn = 0;
//            while (low <= high) {
//                int mid = (low + high) / 2;
//                if (windowfind(mid, nums, target)) {
//                    high = mid-1;
//                    mn = mid;
//                } else low = mid + 1;
//            }
//            return mn;
//        }

        int i = 0;
        int j = 0;
        int sum = 0;
        int mn = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j];
            while(sum >= target){
                sum -= nums[i];
                mn = Math.min(j - i + 1, mn);
                i++;
            }
            j++;
        }
        if(mn == Integer.MAX_VALUE){
            return 0;
        }
        return mn;
    }
}
