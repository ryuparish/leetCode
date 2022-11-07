public static String timeConversion(String s) {
// Write your code here
  String amOrPm = s.substring(s.length() - 2);
  int hours = Integer.parseInt(s.substring(0, 2));
  String hoursString = null;
  String minAndSecs = s.substring(3, s.length() - 2);
  StringBuilder sb = new StringBuilder();
  if (amOrPm.equals("AM")) {
    if (hours == 12) {
      sb.append("00");
    } else if ((hours / 10) != 1){ // If earlier than 10AM
      sb.append("0" + String.valueOf(hours));
    } else {
      sb.append(String.valueOf(hours));
    }
  } else { // If PM
    if (hours != 12) {
      sb.append(String.valueOf(12 + hours));
    } else {
      sb.append("12");
    }
  }
  sb.append(":").append(minAndSecs);
  return sb.toString();
}
    
