class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map =  new HashMap<>();
        int l = 0;
        int ans = 0;
        for(int r = 0; r<n;r++){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r))+1,l);
            }
            map.put(s.charAt(r), r);
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
