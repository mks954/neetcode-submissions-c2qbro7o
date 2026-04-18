class TimeMap {
    private HashMap<String, TreeMap<Integer,String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new TreeMap<>());
        TreeMap<Integer,String> innermap = mp.get(key);
        innermap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> innermap = mp.get(key);
        if(innermap == null){
            return "";
        }
        Map.Entry<Integer, String> floor = innermap.floorEntry(timestamp);
        return floor !=null? floor.getValue() : "";
    }
}
