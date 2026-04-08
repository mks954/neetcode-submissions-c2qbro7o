class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String str: strs){
            StringBuilder temp = new StringBuilder();
            temp.append(str.length());
            temp.append(str);
            temp.append("#");
            ans.append(temp);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int length = str.charAt(0) - '0';
        int i = 1;
        while(i < str.length()){
            ans.add(str.substring(i, i+length));
            i+= length+2;
            if(i+length+1<str.length()){
                length = str.charAt(i+length+1) - '0';
            }
        }
        return ans;
    }
}
