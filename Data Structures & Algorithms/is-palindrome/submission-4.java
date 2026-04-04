class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(Character.isLetterOrDigit(a)) {
                st.append(Character.toLowerCase(a));
            }
        }
        return st.toString().equals(st.reverse().toString());
    }
}

