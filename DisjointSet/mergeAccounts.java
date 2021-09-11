lass Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int id = 0;
        DSJ dis = new DSJ();
        // To map each email to a name. We need to keep track of all the unique emails for each name
        HashMap<String, String> emailToName = new HashMap<String, String>();
        // For uniquity among the DSJ (DSJ IDer)
        // The DSU will function when we see the same name twice in this hashmap.
        HashMap<String, Integer> emailToID = new HashMap<String, Integer>();
        for(List<String> account : accounts){
            String name = account.get(0);
            String email;
            for(int i = 1; i < account.size(); ++i){
                email = account.get(i);
                emailToName.put(email, name);
                if(!emailToID.containsKey(email)){
                    emailToID.put(email, id++);
                }
                // Unioning the current email the head email together, unless this is dupe and in that
                // case the prefix of this current graph would be unioned with the parent of the dupe.
                DSJ.union(emailToID.get(email), emailToID.get(account.get(1)));
            }
        }
        HashMap<Integer, List<String>> answer = new HashMap<Integer, List<String>>();
        // Getting each parent node and attaching all the corresponding emails to it
        // Emails are graphically connected by ID, so we cannot use names or else we will 
        // accidentally give all emails to a single corresponding name even if they are different people
        for(String address : emailToID.keySet()){
            int currParent = DSJ.find(emailToID.get(address));
            answer.computeIfAbsent(currParent, k -> new ArrayList<String>()).add(address);
        }
        // Now to create each of the answer lists into their rightful names
        for(List<String> profile : answer.values()){
            Collections.sort(profile);
            profile.add(0, emailToName.get(profile.get(0)));
        }
        return new ArrayList(answer.values());
    }
}

// This represents a 
class DSJ {
    static int[] parent;
    // Setting each of the nodes to be pointing at themselves
    public DSJ(){
        parent = new int[10001];
        for(int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public static int find(int x){
        if(parent[x] != x){return find(parent[x]);}
        return parent[x];
    }
    public static void union(int x, int y){
        // Unioning by setting 
        parent[find(x)] = find(y);
    }
}
