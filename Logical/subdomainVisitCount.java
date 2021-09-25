// Gist: We split the string by space, then only the right side by dots and then we convert the left side a number.
// We then iterate the lists of dot-split strings backwards and conditionally add it to a empty string, feeding a 
// hashmap with every iterationg.
//
// Both solutions are good. The first beats the second largely in space and the second beats the first slightly in speed.
// TC: O(n^2), SC: O(n)
//class Solution {
//    public List<String> subdomainVisits(String[] cpdomains) {
//        
//        // If we have already seen it, we just add to the prexisting one
//        HashMap<String, Integer> visitedDomains = new HashMap<String, Integer>();
//        List<String> answer = new ArrayList<String>();
//        for(int i = 0; i < cpdomains.length; ++i){
//            int rep = getNum(cpdomains[i]);
//            List<String> subdomains = getSubdomains(cpdomains[i]);
//            for(int j = 0; j < subdomains.size(); ++j){
//                String currSubdomain = subdomains.get(j);
//                if(visitedDomains.containsKey(currSubdomain)){
//                    visitedDomains.put(currSubdomain, visitedDomains.get(currSubdomain) + rep);
//                }
//                else{
//                    visitedDomains.put(currSubdomain, rep);
//                }
//            }
//        }
//        
//        // Adding all of the pairs to the final list as a big string
//        for(Map.Entry<String, Integer> item : visitedDomains.entrySet()){
//            String numString = String.valueOf(item.getValue());
//            System.out.println(numString);
//            System.out.println(item.getKey());
//            answer.add(numString + " " + item.getKey());
//        }
//        return answer;
//    }
//    
//    // parse all subdomains from domain
//    private List<String> getSubdomains(String domain){
//        List<String> subdomains = new ArrayList<String>();
//        for(int i = 0; i < domain.length(); ++i){
//            if(domain.charAt(i) == ' ' || domain.charAt(i) == '.'){
//                subdomains.add(domain.substring(i+1,domain.length()));
//            }
//        }
//        return subdomains;
//    }
//    
//    // parse rep from domain
//    private int getNum(String domain){
//        int number = 0, stopHead = 0;
//        // StopHead will stop on the space between the number and the domain
//        while(Character.isDigit(domain.charAt(stopHead))){
//            number = number * 10 + domain.charAt(stopHead++) - '0';
//        }
//        domain = domain.substring(stopHead+1);
//        return number;
//    }
//}
class Solution{
    public List<String> subdomainVisits(String[] cpdomains){
        List<String> answer = new ArrayList<String>();
        HashMap<String, Integer> domainMap = new HashMap<>();
        for(String domain : cpdomains){
            // Two backslashes must be used in order to turn \ (regular escape character) to \\ (just a \ now)
            // Using split in general takes in regex.
            // Splitting on any number of spaces
            String[] intAndDomain = domain.split("\\s+");
            // Getting string split by dots
            String[] splitDomain = intAndDomain[1].split("\\.");
            int number = Integer.parseInt(intAndDomain[0]);
            String currString = new String();
            for(int i = splitDomain.length-1; i >= 0; --i){
                currString = splitDomain[i] +  (i < splitDomain.length-1 ? "." : "") + currString;
                domainMap.put(currString, domainMap.getOrDefault(currString, 0) + number);
            }
        }
        for(String domain : domainMap.keySet()){
            answer.add(domainMap.get(domain) + " " + domain);
        }
        return answer;
    }
}
