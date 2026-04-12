class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] out = new int[n];
        out[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--){
            int j = i+1;
            while(j<n && temperatures[j]<=temperatures[i]){
                if(out[j]==0){
                    j=n;
                    break;
                }
                j += out[j];
            }
            if(j<n){
                out[i] = j-i;
            }
        }
        return out;
    }
}
