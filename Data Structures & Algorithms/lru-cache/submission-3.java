class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = nums1.length + nums2.length;
        int half = (total+1)/2;
        int l = -1;
        int r = nums2.length -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int ind = half - mid - 2;
            int left_bs = mid>=0? nums2[mid]: Integer.MIN_VALUE;
            int right_bs = mid+1>=nums2.length? Integer.MAX_VALUE: nums2[mid+1];
            int left_ind  = ind>=0? nums1[ind] : Integer.MIN_VALUE;
            int right_ind = ind+1<nums1.length? nums1[ind+1]: Integer.MAX_VALUE;
            if(left_bs<=right_ind && left_ind<=right_bs){
                if(total%2==0){
                    return (double) (Math.max(left_bs,left_ind) + Math.min(right_bs, right_ind))/2.0;
                }else{
                    return (double) Math.max(left_bs, left_ind);
                }
            }else if(left_bs > right_ind){
                r=mid-1;
            }else{
                l = mid+1;
            }
        }

        return -1;
    }
}
