class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            ans.append(str.length()).append("#").append(str);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            // Step 1: read length
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            // Step 2: extract string
            String word = str.substring(j + 1, j + 1 + length);
            ans.add(word);

            // Step 3: move pointer
            i = j + 1 + length;
        }

        return ans;
    }
}
