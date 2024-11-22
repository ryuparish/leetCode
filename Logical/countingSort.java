// TC: O(n), SC: O(n)
// First count each indexes count in an int array, then fill a List with the counts in the int array.
public static List<Integer> countingSort(List<Integer> arr) {
        // Then create count array
        int[] countArray = new int[100];
        for (int i = 0; i < arr.size(); ++i){
            countArray[arr.get(i)]++;
        }
        
        // Then fill in the list
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 100; ++i){
            res.add(countArray[i]);
        }
        return res;
}

    
