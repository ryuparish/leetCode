// Gist: Use a hashmap for the O(1) retrieval, insertion, and removal. For get random, we will need an arraylist. This
// requires making removals to the arraylist O(1) time, which is shown below; we replace the target value's index with
// the value of the last index. Then we update the hashmap and then remove the last element of the arraylist.
// TC: O(1), SC: O(n)
class RandomizedSet {
    List<Integer> selection;
    HashMap<Integer, Integer>selectionMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        selection = new ArrayList<Integer>();
        selectionMap = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(selectionMap.containsKey(val)){return false;}
        selectionMap.put(val, selection.size());
        selection.add(selection.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!selectionMap.containsKey(val)){return false;}
        
        // Removing an element in O(1) time from the array to maintain the required complexity
        int lastElement = selection.get(selection.size()-1);
        int replaceIdx = selectionMap.get(val);
        selection.set(replaceIdx, lastElement);
        selectionMap.put(lastElement, replaceIdx);
        selection.remove(selection.size()-1);
        selectionMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIdx = new Random().nextInt(selection.size());
        return selection.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
