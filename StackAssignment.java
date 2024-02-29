
1. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
         int n = height.length;
		int totalRainWater = 0;
		Stack<Integer> index = new Stack<> ();
		for (int i = 0; i < n; i++){
			while (!index.isEmpty() && height[index.peek()] < height[i]){
				int prevIndx = index.peek();
				index.pop();
				if (!index.isEmpty()) {
					int waterLevel = Math.min (height[i], height[index.peek()]) - height[prevIndx];
					totalRainWater += waterLevel * (i - 1 - index.peek());
				}
			}
			index.push(i);
		}
		return totalRainWater;
    }
}

=========================================================================
2.  