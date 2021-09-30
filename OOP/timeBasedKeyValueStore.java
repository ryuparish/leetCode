// Gist: Abuse the treemap's floorKey function and just store keys every time they are given in set. When implementing get,
// make sure to first check for the existence of the treemap, then also make sure there is a floorKey value that is less than
// or equal to the requested timestamp.
// SC: O(n), TC: O(1)
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> mapOfMaps;
    public TimeMap() {
        mapOfMaps = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapOfMaps.putIfAbsent(key, new TreeMap<Integer, String>());
        mapOfMaps.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> currMap = mapOfMaps.get(key);
        if(currMap == null){return "";}
        Integer earliestTime = currMap.floorKey(timestamp);
        if(earliestTime == null){return "";}
        return currMap.get(earliestTime);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
