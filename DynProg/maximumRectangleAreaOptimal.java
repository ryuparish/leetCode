public static int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    // Dynamic programming from both sides of a one dimensional array is the path that this solution takes.
    int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
    int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current

	// Setting the first smallest pillar from any i (Horrible naming of the arrays, awful. They should just be "firstInvalidPillarToTheRight").
    lessFromRight[height.length - 1] = height.length;
    lessFromLeft[0] = -1;

    // Setting the first smallest pillar to the left of all i
    for (int i = 1; i < height.length; i++) {
        // p is the index of the pillar immediately to the left of the ith pillar
        int p = i - 1;

        // p will become the firstInvalidPillarToTheRight of i if it is shorter and it will check the grid of p if larger or equal.

        // If the index of the smallest pillar of the pillar immediately to the left of the ith pillar points to a pillar that is larger than or equal to the ith pillar.
        while (p >= 0 && height[p] >= height[i]) {
            // This works in the case where the pillar is lower than the pillar immediately to the left and still taller than the ith pillar as well
            // since it then checks that pillar's smallest pillar to the left.
            p = lessFromLeft[p];
        }
        lessFromLeft[i] = p;
    }

    // Setting the first smallest pillar to the right of all i
    // Vice versa of the loop above.
    for (int i = height.length - 2; i >= 0; i--) {
        int p = i + 1;

        while (p < height.length && height[p] >= height[i]) {
            p = lessFromRight[p];
        }
        lessFromRight[i] = p;
    }

    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
        // Minus one since it is the first INVALID pillar (ie. from 5, 4 to 7 [7-4 = 3] instead of 5 to 6 [5 and 6 = 2])
        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }

    return maxArea;
}
