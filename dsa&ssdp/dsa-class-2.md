



# Loops

for
while
forEach

### Print numbers from 1 to 10

```java

void printFrom1to10() {
	for(int i = 1; i <= 10; i++) {
		System.out.println(i);
	}
}

/*
1
2
3
4
5
6
7
8
9
10
*/
```

### Print a pascal triangle
```java
/*
		1.   -> level 1
	   1 1.  -> level 2
	  1 2 1. -> level 3
	 1 3 3 1 -> level 4
	1 4 6 4 1

     0 1
	[1,1]

     0,1,2
	[1,2,1]

	value at index k will be sum of values of index k-1 and k

	 0,1,2
	[1,2,1]
	

	[1,3,3,1]



prev = [1,3,3,1]
new = [1,4,6,4,1]

prev = [1,4,6,4,1]
new = [1,5,10,10,5,1]

*/

void printPascalTriangle(int level) {
	if (level == 1) {
		System.out.println(1);
	}
	if (level == 2) {
		System.out.println(1);
		System.out.println(2);
	}
	int[]prevValues = new int[level];
	int[]newValues = new int[level];

	prevValues[0] = 1;
	prevValues[1] = 1;


	for(int i = 3; i <= level; i++) {
		newValues[0] = 1;
		newValues[level-1] = 1;
		for(int k = 1; k < level-1; k++) {
			newValues[k] = prevValues[k-1] + prevValues[k];
		}
		for(int i = 0; i < level; i++) {
			prevValues[i] = newValues[i];
		}
	}

	for(int i = 0; i < level; i++) {
		System.out.println(newValues[i]);
	}

	for(int val: newValues) {
		System.out.println(val);
	}
}

void swap(int[] a1, int[] a2) {
	int[] temp = a1;
	a1 = a2;
	a2 = temp;
}

```

### 


0,0 1,1 2,2 3,3 .... N-1,N-1
0,1 1,2 2,3 ...
0,2 1,3 2,4 ...
0,3 1,4 2,5 ...
.
.
.
0,N-1




N=4


0,0 1,1 2,2 3,3


0,1 1,2 2,3


0,2 1,3


0,3



(i,j) 

j-i = diff?


j = i+diff;


0,0 


diff = 2

i = 3
j = 5

```java

void printPattern1(int N) {
	for(int diff = 0; diff < N; diff++) {
		for(int i = 0; i + diff < N; i++) {
			int j = i + diff;
			System.out.print("("+i+"," + j + ")  ");
		}
		System.out.println();
	}
}


void printPattern2(int N) {
	for(int l = 0; l < N; l++) {
		for(int i = 0; i + l < N; i++) {
			int j = i+l;
		}
	}
}
```



N=4

0,0 1,1 2,2 3,3


0,1 -> 1,2 -> 2,3


0,2 1,3


0,3


```java


void printPatternA(int N) {
	for(int diff = 0; diff < N; diff++) {
		for(int i = 0; i + diff < N; i++) {
			int j = i + diff;
			System.out.print("("+i+"," + j + ")  ");
		}
		System.out.println();
	}
}

void printPatternB(int N) {
	for(int diff = 0; diff < N; diff++) {
		int i = 0;
		int j = i+diff;
		while(j < N) {
			System.out.print("("+i+"," + j + ")  ");
			i++;
			j++;
		}
	}
}

```


[[0,0], [0,1], [0,2], [0,3], [0,4]]
[[1,0], [1,1], [1,2], [1,3], [1,4]]
[[2,0], [2,1], [2,2], [2,3], [2,4]]
[[3,0], [3,1], [3,2], [3,3], [3,4]]
[[4,0], [4,1], [4,2], [4,3], [4,4]]



[[0,0], 
[[1,0], [1,1], 
[[2,0], [2,1], [2,2],
[[3,0], [3,1], [3,2], [3,3], 
[[4,0], [4,1], [4,2], [4,3], [4,4]]




[[0,0], [0,1], [0,2], [0,3], [0,4]]
	, 	[1,1], [1,2], [1,3], [1,4]]
			   [2,2], [2,3], [2,4]]
					  [3,3], [3,4]]
						     [4,4]]