class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();   
        int n = temperatures.length;
        st.push(n-1);
        int[] output = new int[n];
        output[n-1] = 0;
        for(int i = n-2; i >=0 ; i--){
            while(!st.isEmpty() && temperatures[st.peek()]<= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                output[i] = 0;
            }else{
                output[i] = st.peek() - i;
            }

            st.push(i);
        }
        return output;
    }
}
