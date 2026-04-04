class Solution {
    private boolean check(String s, HashMap<Character, Integer> mp){
        HashMap<Character, Integer> mp_2 = new HashMap<>();
        for(char c: s.toCharArray()){
            mp_2.put(c, mp_2.getOrDefault(c, 0) + 1);
        }
        if(mp.equals(mp_2)){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkInclusion(String s1, String s2) {
        int s1_l = s1.length();
        int s2_l = s2.length();
        HashMap<Character, Integer> map_s1 = new HashMap<>();
        // frequency map s1
        for(int i = 0; i < s1_l; i++){
            map_s1.put(s1.charAt(i), map_s1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // make substring
        // check if true or not
        for(int i = 0 ; i <= s2_l-s1_l ; i++){
            if(check(s2.substring(i, i+s1_l), map_s1)){
                return true;
            }
        }

        return false;
    }
}
