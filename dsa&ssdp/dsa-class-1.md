




# Hello Everyone

Class - 1.



array ?



```java

	int search(int[] arr, int x) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == x) return i;
		}
		throw new Exception("Element not present");
	}


	boolean isElementPresent(int[] arr, int x) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == x) return true;
		}
		return false;
	}

```



Given an array of size much larger then N and this array contains N elements only. All the elements are present in the left side means there is not gap between elements.
Imagine comparison is an expensive operation in our system. 
Given such array find the element with minimum no of comparison in your code.


Example

arr = [4, 1, 5, 6, 7, 8, 10, 2, -10, -11, null, null, null, null, null, null]


N = 10


x = 8

```java
	
	boolean isElementPresent(int[] arr, int N, int x) {
		for(int i = 0; ; i++) {
			if(arr[i] == null) break;
			if(arr[i] == x) return true;
		}
		return false;
	}

	boolean isElementPresent(int[] arr, int N, int x) {
		for(int y: arr){
			if(y == x) return true;
		}
		return false;
	}

```


```java

```

We are doing 2N comparisons

Can we solve this with N+1 or N+2 comprisons


arr = [4, 1, 5, 6, 7, 8, 10, 2, -10, -11, null, null, null, null, null, null]

N = 10

x = 8

arr[10] = 8

arr = [4, 1, 5, 6, 7, 8, 10, 2, -10, -11, 8, null, null, null, null, null]

```java
	boolean isElementPresent(int[] arr, int N, int x) {
		arr[N] = x;
		int i = 0;
		while(arr[i] != x) i++;
		if(i == N) return false;
		return true;
	}
```



arr = [3, 1, 4, 5, null, null]

N = 4

x = 7


arr = [3, 1, 4, 5, 7, null]

i = 4


arr = [3, 1, 4, 5, null, null]

N = 4

x = 4

arr = [3, 1, 4, 5, 4, null]




N+2 comparison.