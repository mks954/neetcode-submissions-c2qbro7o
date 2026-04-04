class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newstr = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                newstr.append(Character.toLowerCase(c));
            }
        }
        return newstr.toString().equals(newstr.reverse().toString());
    }
}
