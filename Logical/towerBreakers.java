public static int towerBreakers(int n, int m) {
    // Write your code here
      // Gist: The clearest way to see this is that if there are 
      // an odd number of towers, player 2 will always lose.
      // And when there are an even number of towers, player 2 will
      // always lose.
      // This is because the number of towers will determine the winner.
      // Each time, the winning player will just shrink the tower all
      // the way to 1. If the other player does not do the same, the 
      // winning player can just do the same thing that the other player
      // does in a "counter" move, which will STILL result in an odd 
      // or even number of moves which just easily determines the winner.
      if (n % 2 == 0 || m == 1) {return 2;}
      else {return 1;}
    }
