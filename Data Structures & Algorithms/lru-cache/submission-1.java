class LRUCache {
    private HashMap<Integer, Integer> mp;
    private LinkedList ll;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>(); // Initialize here
        this.ll = new LinkedList<>(); // Initialize here
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            ll.remove(Integer.valueOf(key));
            ll.add(key);
            return mp.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!mp.containsKey(key) && mp.size()==capacity){
            mp.remove(ll.getFirst());
            ll.removeFirst();
            mp.put(key,value);
            ll.add(key);
        }else{
            if(mp.containsKey(key)){
                ll.remove(Integer.valueOf(key));
            }
            mp.put(key,value);
            ll.add(key);
        }
    }
}
