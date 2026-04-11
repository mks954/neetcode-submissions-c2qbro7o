class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c == '{' || st.isEmpty()){
                st.push(c);
                continue;
            }
            if(c==')' && st.peek()=='('){
                st.pop();
            }else if(c==']' && st.peek()=='['){
                st.pop();
            }else if(c=='}' && st.peek()=='{'){
                st.pop();
            }else{
                st.push(c);
            }
        }
        if(st.isEmpty()){
            return true;
        }

        return false;
    }
}
