class MinStack {

    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(0L);
            min = val;
        } else {
            long diff = val - min;
            st.push(diff);

            if (diff < 0) {
                min = val;
            }
        }
    }
    
    public void pop() {
        long diff = st.pop();

        if (diff < 0) {
            min = min - diff;
        }
    }
    
    public int top() {
        long diff = st.peek();

        if (diff >= 0) {
            return (int)(min + diff);
        } else {
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}