class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{heights[0], 0});
        int ans = 0;
        int n = heights.length;
        for(int i = 1; i < n; i++){
            // smaller value comes
            while(!st.isEmpty() && st.peek()[0] >heights[i]){
                int[] temp = st.pop();
                ans = Math.max(temp[0]*(i-temp[1]), ans);
                if(st.isEmpty() || st.peek()[0] < heights[i] ){
                    st.push(new int[]{heights[i], temp[1]});
                }
            }
            //larger or equal value
            // equal value case i think we don't need
            if(!st.isEmpty() && st.peek()[0]==heights[i]){
                continue;
            }
            st.push(new int[]{heights[i], i});
        }
        while(!st.isEmpty()){
            int[] temp = st.pop();
            ans = Math.max(temp[0]*(n-temp[1]), ans);
        }

        return ans;
    }
}
