class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String d : tokens){
            if(!d.equals("+") && !d.equals("-") && 
               !d.equals("*") && !d.equals("/")){
                
                st.push(Integer.parseInt(d));
            
            } else {
                int b = st.pop();
                int a = st.pop();

                if(d.equals("+")){
                    st.push(a + b);
                } else if(d.equals("-")){
                    st.push(a - b);
                } else if(d.equals("*")){
                    st.push(a * b);
                } else {
                    st.push(a / b);
                }
            }
        }
        return st.peek();
    }
}