
Given a stream of Integers find the median.


median: 
1,2,3 median = 2

1,2,3,4 => (2+3)/2 => 2.5




3,2,4,5,1,2,10,3,....
3,2.5,3,3.5,...



Solution1.

void add(int ele)

double getMedian()

time complexity
add -> O(NlogN)
getMedian -> O(1)


for N elements 
O(N*N*logN)
getMedian -> O(N)



[1,2,3,4,5]



Insertion sort.

sortedList

4,5,1,3,2



[4]
[4,5] -> O(N)
[1,4,5]
[1,3,4,5]
[1,2,3,4,5]


add -> O(N)
getMedian -> O(1)


Self balancing binary search Tree which keeps the median at the root.

balanced binary search tree

difference between height of every node's left and right subtree should not be more than 1.


4,5,1,3,2,7,6

						4
					1		5   
						3

						4
					3		5     
					   1

4,5,1,3

1,3,4,5

[1,2,3,4,5,6,7,10]

4,5,1,3,2,7,6


[4,3,1,2]  [5,7,6] => 4

[4,3,1,2]  [5,10,7,6] => (4+5)/2


maxHeap    minHeap


size should be almost equal
if no of elements are even then it should be equal
else size of maxHeap = size of minHeap + 1

all the elements in maxHeap should be smaller then all the elements in minHeap





4,5,1,3,2,7,6


max 1,3,2,4

min 5,7,6


---------------------
steps1
+ always add element to maxHeap first.
+ remove max element from maxHeap and add it to minHeap
+ check if size of minHeap is greater than size of maxHeap then rebalance
	+ take top element from minHeap and add it to maxHeap.


4,5,1,3,2,7,6

max => [4]
min => []

5
max => [4]
min => [5]

1
max=>[4,1]
min => [5]






max => [1,3,7]

min => [6,8,10]

[1,3]
[6,7,8,10]

[1,3,6]
[7,8,10]









```java
class MedianInStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue();
	PriorityQueue<Integer> maxHeap = new PriorityQueue((a,b) -> b-a);
	void add(int ele) {
		maxHeap.add(ele);
		minHeap.add(maxHeap.poll());
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	double getMedian() {
		return maxHeap.size() == minHeap.size() ? (minHeap.peek()+maxHeap.peek())/2.0 : maxHeap.peek();
	}
}
```



```java
class MedianInStream {
	TreeSet<Integer> minHeap = new TreeSet();
	TreeSet<Integer> maxHeap = new TreeSet();
	void add(int ele) {
		maxHeap.add(ele);
		minHeap.add(maxHeap.last());
		maxheap.remove(maxHeap.last());
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.first());
			minHeap.remove(minHeap.first());
		}
	}

	double getMedian() {
		return maxHeap.size() == minHeap.size() ? (minHeap.first()+maxHeap.last())/2.0 : maxHeap.last();
	}
}
```

TreeSet and TreeMap => Red black tree.


https://leetcode.com/problems/sliding-window-median













