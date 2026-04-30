class Solution {
    private int count(int l, int r, int[] nums){
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]>=l && nums[i]<=r){
                ans++;
            }
        }
        return ans;
    }
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int cnt = count(l,mid,nums);
            int exp = mid-l+1;
            if(l==r && cnt>exp){
                return mid;
            }else if(l==r && cnt<=exp){
                break;
            }else if(cnt>exp){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return -1;
    }
}
