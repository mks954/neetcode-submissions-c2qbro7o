class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int reslen = Integer.MAX_VALUE;
        int l = 0;
        int have = 0;
        int need = countT.size();
        int[] res = {-1, -1};
        for(int r = 0 ; r < s.length(); r++){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r),0)+1);
            if(countT.containsKey(s.charAt(r)) && countT.get(s.charAt(r))==window.get(s.charAt(r))){
                have++;
            }

            while(have==need){
                if(r-l+1<reslen){
                    reslen = r-l+1;
                    res[0] = l;
                    res[1] = r+1;
                }
                window.put(s.charAt(l), window.get(s.charAt(l))-1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
        }
        if(reslen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(res[0], res[1]); 
    }
}
