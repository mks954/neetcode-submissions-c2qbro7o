class Solution {
    public boolean isanagram(String a, String b){
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for(int i = 0 ; i < a.length(); i++){
            if(freq1.containsKey(a.charAt(i))){
                int temp = freq1.get(a.charAt(i));
                freq1.put(a.charAt(i), temp+1);
            }else{
                freq1.put(a.charAt(i),1);
            }
        }
        for(int i = 0 ; i < b.length(); i++){
            if(freq2.containsKey(b.charAt(i))){
                int temp = freq2.get(b.charAt(i));
                freq2.put(b.charAt(i), temp+1);
            }else{
                freq2.put(b.charAt(i),1);
            }
        }
        return freq1.equals(freq2);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0 ; i < strs.length;i++){
            List<String> temp = new ArrayList<>();
            if(visited[i]){
                continue;
            }
            temp.add(strs[i]);
            for(int j = i+1; j<strs.length;j++){
                if(visited[j]){
                    continue;
                }
                if(isanagram(strs[i],strs[j])){
                    temp.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
