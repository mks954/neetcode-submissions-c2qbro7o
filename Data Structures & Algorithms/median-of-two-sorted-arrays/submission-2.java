class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = nums2.length;
        int total = nums1.length + nums2.length;
        int half = (total+1)/2;
        while(true){
            int mid = (l+r)/2;
            int left_bs_ind = mid-1;
            int right_bs_ind = mid;
            int left_arr_ind = half-mid-1;
            int right_arr_ind = left_arr_ind+1;

            //the real elements
            int left_bs = left_bs_ind >= 0 ? nums2[left_bs_ind]: Integer.MIN_VALUE;
            int right_bs = right_bs_ind < nums2.length ? nums2[right_bs_ind]: Integer.MAX_VALUE;
            int left_arr = left_arr_ind >=0 ? nums1[left_arr_ind]: Integer.MIN_VALUE;
            int right_arr = right_arr_ind < nums1.length ? nums1[right_arr_ind]: Integer.MAX_VALUE;

            // checking logic
            if(left_bs <= right_arr && left_arr <= right_bs){
                if((total & 1)==0){
                    return (double) (Math.max(left_bs, left_arr) + Math.min(right_bs, right_arr))/2;
                }else{
                    return (double) (Math.max(left_bs, left_arr));
                }
            }else if(left_bs > right_arr){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
    }
}
