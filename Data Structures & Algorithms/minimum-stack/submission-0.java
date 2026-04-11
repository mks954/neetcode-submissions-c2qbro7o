class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> min_st;

    public MinStack() {
        st = new Stack<>();
        min_st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!min_st.isEmpty()){
            if(min_st.peek()>val){
                min_st.push(val);
            }else{
                min_st.push(min_st.peek());
            }
        }else{
            min_st.push(val);
        }
    }
    
    public void pop() {
        st.pop();
        min_st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min_st.peek();
    }
}
