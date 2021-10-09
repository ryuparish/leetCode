// Gist: Get Two hashmaps, one mapping the person to their starting station and time (pair) and the other mapping
// the route name to the total time taken on that route and the number of times that route has been taken. When
// calling the getAverageTime function, we return the total time divided by the number of times the route has
// been taken.
class UndergroundSystem {
    
    // routeToPair maps the route to the pair in which the total time and the number of passengers that have taken
    // that route
    HashMap<String, Pair<Double, Double>> routeToPair;
    
    // personToStatoin maps the person to their start location and the time they left that respective station
    HashMap<Integer, Pair<String, Double>> personToStation;

    public UndergroundSystem() {
        routeToPair = new HashMap<>();
        personToStation = new HashMap<>();
    }
    
    public void checkOut(int id, String stationName, int t) {
            
        // Getting information from the person's travel
        Pair<String, Double> currStart = personToStation.get(id);
        String routeName = currStart.getKey() + "_" + stationName;
        double routeTime = t - currStart.getValue();
        
        // Getting infomation about the route itself
        routeToPair.putIfAbsent(routeName, new Pair(0.0, 0.0));
        Pair<Double, Double> currRoute = routeToPair.get(routeName);
        Double newTotal = currRoute.getKey() + routeTime;
        routeToPair.put(routeName, new Pair(newTotal, currRoute.getValue() + 1.0));
    }
    
    public void checkIn(int id, String stationName, int t) {
        personToStation.put(id, new Pair(stationName, (double)t));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        // Dividing the total time by the total number of trips taken on this route
        Pair<Double, Double> currRoute = routeToPair.get(startStation + "_" + endStation);
        return currRoute.getKey() / currRoute.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
