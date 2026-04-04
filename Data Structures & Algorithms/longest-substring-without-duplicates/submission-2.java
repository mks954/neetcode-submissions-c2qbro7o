class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set =  new HashSet<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r<=n){
            if(r<n && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                ans = Math.max(r-l, ans);
                l++;
            }else if(r==n){
                ans = Math.max(r-l, ans);
                break;
            }
            else{
                set.add(s.charAt(r));
                r++;
            }
        }
        return ans;
    }
}
