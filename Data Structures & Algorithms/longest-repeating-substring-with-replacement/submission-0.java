class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            HashMap<Character, Integer> mp = new HashMap<>();
            int maxf = 0;
            for(int j = i ; j < n ; j++){
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
                maxf = Math.max(maxf, mp.get(s.charAt(j)));
                if(j-i+1 - maxf <= k){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}
