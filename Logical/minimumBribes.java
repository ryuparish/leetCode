public static void minimumBribes(List<Integer> q) {
  // Write your code here
  int minBribes = 0;
  for (int i = 0; i < q.size(); i++) {
    // In order for someone to move left along the line more than 2 times,
    // they must have bribed more than 2 times, too chaotic.
    if (q.get(i) - 2 > i + 1) {
      System.out.println("Too chaotic");
      return;
    }
    // We do not really need to count the number of bribes GIVEN,
    // since that is complicated. We can just count the bribes 
    // TAKEN (which can be count since [explanation below]).
    // 
    // Reason for j >= q.get(i) - 2:
    //  If there are no more than 2 bribes (left-moves)allowed by a single person,
    //  we do not need to check anymore than original-position - 2 since
    //  it is not possible for any number larger than or equal to q.get(i)
    //  to go past that boundary (we are talking about the value AT i in q, not the index i).
    for (int j = i - 1; j >= q.get(i) - 2 && j >= 0; j--) {
      // In order for someone larger than you to get past you,
      // it MUST be the case that you TOOK a bribe and let them
      // pass you.
      if (q.get(j) > q.get(i)) minBribes++;
    }
  }
  System.out.println(minBribes);
}
