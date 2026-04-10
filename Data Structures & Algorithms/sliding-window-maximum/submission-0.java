class Solution {
    void build(int ind, int left, int right, int[] nums, int[] seg){
        if(left==right){
            seg[ind] = nums[left];
            return;
        }
        int mid = (left+right)/2;
        build(2*ind+1, left, mid, nums, seg);
        build(2*ind+2, mid+1, right, nums, seg);
        seg[ind] = Math.max(seg[2*ind+1], seg[2*ind+2]);
    }
    int query(int ind, int left, int right, int l, int r, int[] seg){
        //overlap completely
        if(left>=l && right<=r){
            return seg[ind];
        }
        //no overlap
        if(right < l || left > r){
            return Integer.MIN_VALUE;
        }
        //PARTIALLY THEN GO TO LEFT AND RIGHT CHILD
        int mid = (left + right)/2;
        return Math.max(query(2*ind+1, left, mid, l, r, seg), query(2*ind+2, mid+1, right, l, r, seg));

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] seg = new int[4*n];
        build(0, 0, n-1, nums, seg);
        int[] ans = new int[n-k+1];
        for(int i = k-1 ; i < n ; i++){
            ans[i-(k-1)] = query(0, 0, n-1, i-(k-1), i, seg);
        }
        return ans;
    }
}
