class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] time = new double[n][2];
        for(int i = 0; i < n ; i++){
            time[i][0] = position[i];
            time[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(time, (a,b) -> Double.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        st.push(time[0][1]);
        for(int i = 1 ; i < n ; i++){
            if(st.peek()<time[i][1]){
                st.push(time[i][1]);
            }
        }
        return st.size();
    }
}
