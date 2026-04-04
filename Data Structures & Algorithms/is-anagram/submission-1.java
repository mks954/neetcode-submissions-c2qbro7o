class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char temparray1[] = s.toCharArray();
        Arrays.sort(temparray1);
        char temparray2[] = t.toCharArray();
        Arrays.sort(temparray2);
        for(int i = 0 ; i< temparray1.length;i++){
            if(temparray1[i] != temparray2[i]){
                return false;
            }
        }
        return true;
    }
}
