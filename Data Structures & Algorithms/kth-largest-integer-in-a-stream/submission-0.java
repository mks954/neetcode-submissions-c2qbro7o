class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k_val;
    public KthLargest(int k, int[] nums) {
        for(int num: nums){
            pq.add(num);
        }
        k_val = k;
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k_val){
            pq.poll();
        }
        return pq.peek();
    }
}
