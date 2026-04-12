class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int n = temperatures.length;
        int[] out = new int[n];
        for(int i = 1; i < n ; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                out[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            out[st.pop()] = 0;
        }
        return out;
    }
}
