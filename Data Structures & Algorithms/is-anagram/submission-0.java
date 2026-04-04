class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> char_num = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(char_num.containsKey(c)){
                int temp = char_num.get(c);
                temp++;
                char_num.remove(c);
                char_num.put(c,temp);
            }else{
                char_num.put(c,1);
            }
        }
        for(char c: t.toCharArray()){
            if(char_num.containsKey(c)){
                int temp = char_num.get(c);
                temp--;
                char_num.remove(c);
                char_num.put(c,temp);
            }else{
                char_num.put(c,1);
            }
        }
        for(HashMap.Entry<Character, Integer> e: char_num.entrySet()){
            if(e.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
