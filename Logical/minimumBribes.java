public static void minimumBribes(List<Integer> q) {
    // Write your code here
    int bribes = 0;
    for(int i = 0; i < q.size(); ++i){
        int diff = q.get(i) - (i+1);
        if (diff > 2) {
            System.out.println("Too chaotic");
            return;
        } else if (i > 0){
            // Focusing on the "took-the-bribe" customers to catch
            // the case where bribes happen between two customers
            // who are both behind in their position relative to 
            // their assigned starting spots.
            for (int j = i-1; j >= q.get(i) -2 && j > -1; --j){
                // We also use the fact that it is not possible
                // for any number greater than the number AT the 
                // current index to surpass the number itself
                // or else the less-than-3-bribes rule is borked.
                if (q.get(j) > q.get(i)){
                    bribes++;
                }
            }
        }
    }
    System.out.println(bribes);
    return;
}
