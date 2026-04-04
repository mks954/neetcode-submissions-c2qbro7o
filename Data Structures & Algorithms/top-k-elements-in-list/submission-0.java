class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int max_freq = 0;
        for(int num:nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
            if(max_freq<mp.get(num)){
                max_freq = mp.get(num);
            }
        }
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: mp.entrySet()){
            arr.add(new int[]{e.getValue(), e.getKey()});
        }
        arr.sort((a,b) -> b[0] - a[0]);
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
