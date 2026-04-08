class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int temp = 1;
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for(int j = i+1 ; j < n ; j++){
                if(set.add(s.charAt(j))){
                    temp++;
                }else{
                    ans = Math.max(ans, temp);
                    break;
                }
            }
        }
        return ans;
    }
}
