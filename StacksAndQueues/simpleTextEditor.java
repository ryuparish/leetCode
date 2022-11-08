public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner input = new Scanner(System.in);
//        Stack<String> history = new Stack<String>();
//        input.nextInt();
//        
//        while (input.hasNextInt()) {
//          int action = input.nextInt();
//          // Appending
//          if(action == 1){
//            if (history.isEmpty()) {
//              history.add(input.next());
//            } else {
//              history.add(history.peek().concat(input.next()));
//            }
//          // Deleting
//          } else if (action == 2) {
//            history.add(history.peek().substring(0, history.peek().length() - input.nextInt()));
//          // Printing
//          } else if (action == 3) {
//            System.out.println(history.peek().charAt(input.nextInt() - 1));
//          // Reverting
//          } else {
//            history.pop();
//          }
//        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ops=Integer.parseInt(br.readLine());
        Stack<StringBuilder> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ops;i++)
        {
            String z[]=br.readLine().split(" "); 
                      
            if(z[0].equals("1")){
                st.add(new StringBuilder(sb.toString()));
                sb.append(z[1]);
            }
            if(z[0].equals("2")){
                st.add(new StringBuilder(sb.toString()));
                sb.delete(sb.length()-Integer.parseInt(z[1]),sb.length());
            }
            if(z[0].equals("3")){
                System.out.println(sb.charAt(Integer.parseInt(z[1])-1));
            }
            if(z[0].equals("4")){
                sb=st.pop();
            }
        }
    }
}
