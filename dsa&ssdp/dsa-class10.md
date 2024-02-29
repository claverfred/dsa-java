



# stock span problem

The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate the span of the stock’s price for all N days. The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before (including today) the given day, for which the price of the stock on the current day is less than or equal to its price on the given day. 


						
Input: N = 7, price[] = [100 80 60 70 80 85]
Output: 1 1 1 2 1 4 6


Previous greater element?

for every element I want  go to previous greater element mean I can pop from stack all the elemnt which are less and equal.


s: {-1}

O -> 100.   0 -(-1) = 1 {-1,0}

1 -> 80   1 - 0 = 1 {0,-1}

2 -> 60 1 {2, 1,0,-1} => {60, 80, 100, -1}

3 -> 70 
	{-1,0,1} 2 {-1, 0, 1, 3}
			   {-1, 100, 80, 70}

Monotonic increasing stack.



```java
	List<Integer> calculateSpan(List<Integer> stockPrices) {
		List<Integer> spans = new ArrayList();
		Stack<Integer> stack = new Stack();

		for(int i = 0; i < stockPrices.size(); i++) {
			while(!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i)) {
				stack.pop();
			}
			spans.add(stack.isEmpty() ? i+1: i-stack.peek());

			stack.push(i);
		}
		return spans;
	}
```

```java
	List<Integer> calculateSpan(List<Integer> stockPrices) {
		List<Integer> spans = new ArrayList();
		Stack<Integer> stack = new Stack();
		stack.push(-1);

		for(int i = 0; i < stockPrices.size(); i++) {
			while(stack.peek() != -1 && arr.get(stack.peek()) <= arr.get(i)) {
				stack.pop();
			}
			spans.add(i-stack.peek());
			stack.push(i);
		}
		return spans;
	}
```


# next greater element to the right

Input [10,4,1,3,5,7,3]
Output [-1,5,3,5,7,-1,-1]

[2,3,4,5,6,10] 

```java
	public static List<Integer> findNextGreaterToRight(List<Integer> arr) {
        Stack<Integer> st = new Stack();
        List<Integer> res = new LinkedList();
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                res.addFirst(-1);
            } else {
                res.addFirst(st.peek());
            }
            st.push(arr.get(i));
        }
        return res;
    }
```

# next smaller element to the right

```java
	public static List<Integer> findNextSmallerToRight(List<Integer> arr) {
        Stack<Integer> st = new Stack();
        List<Integer> res = new LinkedList();
        for (int i = arr.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                res.addFirst(-1);
            } else {
                res.addFirst(st.peek());
            }
            st.push(arr.get(i));
        }
        return res;
    }
```

# next greater element to the left

```java
	public static List<Integer> findNextGreaterToLeft(List<Integer> arr) {
        Stack<Integer> st = new Stack();
        List<Integer> res = new LinkedList();

        for (int i = 0; i < arr.size(); i++) {
            while (!st.isEmpty() && st.peek() <= arr.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                res.add(-1);
            } else {
                res.add(st.peek());
            }
            st.push(arr.get(i));
        }
        return res;
    }
```

# next smaller element to the left

```java
	public static List<Integer> findNextSmallerToLeft(List<Integer> arr) {
        Stack<Integer> st = new Stack();
        List<Integer> res = new LinkedList();

        for (int i = 0; i < arr.size(); i++) {
            while (!st.isEmpty() && st.peek() >= arr.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                res.add(-1);
            } else {
                res.add(st.peek());
            }
            st.push(arr.get(i));
        }
        return res;
    }
```


```java
// Template for monotonic stack based problems

Iterate over elements
	while( condition() ) {
		pop();
	}

	// apply custom logic  on current element and stack top to find ans 

	push(curEle)

```

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



[2, 4, 7, 3, 2, 8, 4]



for every tower of height h find the maximum width possible?


2

next smaller element and prev smaller element for every element.


```java
public static List<Integer> findNextSmallerToRight(List<Integer> arr) {
    Stack<Integer> st = new Stack();
    List<Integer> res = new LinkedList();
    for (int i = arr.size() - 1; i >= 0; i--) {
        while (!st.isEmpty() && arr[st.peek()] >= arr.get(i)) {
            st.pop();
        }
        if (st.isEmpty()) {
            res.addFirst(arr.size());
        } else {
            res.addFirst(st.peek());
        }
        st.push(i);
    }
    return res;
}
public static List<Integer> findNextSmallerToLeft(List<Integer> arr) {
    Stack<Integer> st = new Stack();
    List<Integer> res = new LinkedList();

    for (int i = 0; i < arr.size(); i++) {
        while (!st.isEmpty() && arr[st.peek()] >= arr.get(i)) {
            st.pop();
        }
        if (st.isEmpty()) {
            res.add(-1);
        } else {
            res.add(st.peek());
        }
        st.push(i);
    }
    return res;
}

public static int largestRectangleHistogram(List<Integer> heights) {
	List<Integer> prevSmallerHeightIndex = findNextSmallerToLeft(heights);
	List<Integer> nextSmallerHeightIndex = findNextSmallerToRight(heights);
	int maxRectArea = 0;
	for(int i = 0; i < heights.size(); i++) {
		int width = nextSmallerHeightIndex.get(i) - prevSmallerHeightIndex.get(i) - 1;
		maxRectArea = Math.max(maxRectArea, width * heights.get(i));
	}
}

/*

6, 7, 3, 4, 8

6 (-1,2) -> (lb, rb)

7 (1,2)

3 (-1, 5)

4 (2,5)

8 (3,5)


0 1 

7 -> right (1,2)



1,2,3,4,5






3, 4, 5, 2, 3, 4


st: 2, 1, 0

idx: 3

5 -> 2 3 => 5

4 -> 1 3 => 2*4 => 8

3 -> 0 3 =>3*3 => 9


st: 5, 4, 3
















*/


public static int largestRectangleHistogram(int[] heights) {
	Stack<Integer> stack = new Stack();
	for(i = 0; i < heights.length; i++) {
		while(!stack.isEmpty() && heights[i] < height[stack.peek()]) {
			int rightBoundary = i;
			int leftBoundary = stack.pop();
			int curHeight = arr[leftBoundary];
			int width = (rightBoundary-leftBoundary);
			maxRectArea = Math.max(maxRectArea, width*curHeight);
		}
		stack.push(i);
	}
	int rightBoundary = heights.length;
	while(!stack.isEmpty()) {
		int leftBoundary = stack.peek();
		int curHeight = arr[leftBoundary];
		maxRectArea = Math.max(maxRectArea, (rightBoundary-leftBoundary)*curHeight);
	}
}





```




















