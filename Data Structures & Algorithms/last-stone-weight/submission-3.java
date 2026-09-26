class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int num: stones) pq.add(num);
        
        while(pq.size() > 1){
            int curr = pq.poll();
            int secondmax = pq.poll();
            if(secondmax == curr){
                continue;
            }else{
                curr = Math.abs(curr-secondmax);
                pq.add(curr);
            }
        }
        return pq.isEmpty()? 0: pq.poll();
    }
}
