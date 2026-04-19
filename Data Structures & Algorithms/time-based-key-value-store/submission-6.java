class Pair{
   int timestamp;
   String value;
   public Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
   } 
}
// class mysort implements Comparator<Pair>{
//     @Override
//     public int compare(Pair p1, Pair p2){
//         //ascending order
//         return p1.timestamp-p2.timestamp;
//     }
// }
class TimeMap {
    private Pair binary_search(List<Pair> arr, int target){
        int l = 0;
        int r = arr.size()-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr.get(mid).timestamp == target){
                return arr.get(mid);
            }else if(arr.get(mid).timestamp < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        if(r>=0){
            return arr.get(r);
        }
        return new Pair(-1,"");
    }
    private HashMap<String, List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new ArrayList<>());
        List<Pair> array_list = mp.get(key);
        Pair pair = new Pair(timestamp, value);
        array_list.add(pair);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> array_list = mp.get(key);
        // skipping the sort as timestamp are already coming in sorted
        // Collections.sort(array_list, new mysort());
        if(array_list == null){
            return "";
        }
        Pair pair = binary_search(array_list, timestamp);
        return pair.value;
    }
}
