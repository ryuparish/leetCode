public static String timeConversion(String s) {
// Write your code here
    int hour = Integer.parseInt(s.substring(0, 2));
    String min = s.substring(3,5);
    String seconds = s.substring(6,8);
    String amPm = s.substring(8,10);
    
    // Convert to PM time, check for 12
    if (amPm.equals("PM")){
        if (hour != 12){
            hour += 12;
        }
    } else {
        if (hour == 12){
            hour = 0;
        }
    }
    return String.format("%02d:%s:%s", hour, min, seconds);
}
