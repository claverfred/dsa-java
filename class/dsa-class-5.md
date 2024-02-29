







# Arrays


fixed size array

```java
// fixed size array
int[] arr  = new int[10];

// dynamic array
List<Integer> arr = new ArrayList();

vector<int> arr;

arr = []



List<Integer> arr = new ArrayList();

2

4

8

16

32
```



# Set 

It contains unique elements

Checking if element exits or not is very fast.


[1,2,3,2,3,1] into a set {1,2,3}





Question: COVID got spread around the world and imagine every know how he/she got infected. Google developed an app where you can send this information.
Imagine every person in the world has unique ID.
Imagine everyone in the world provide this information.



Your task is to find first person who got infected by covid.


[{1,2}, {3,2}, {2, 4}]


[{1,2}]
	 		4
	 		|
	 		2
	 	1      3


1. Create a graph Tree

2. DSU 





[{1,2}, {3,2}, {2, 4}]
```
Set<Integer> infectors;
  {2,4}

  {4}

```

Algorithm:
S1: Insert all the infectors into a set.
S2: Remove all the infecteds from the above set.
Whatever is left in the set is my answer.



add 2,2,4 to set
remove 1,3,2 from set


Event {
	infector:
	infected
}

```java
	class Event {
		int infector;
		int infected;
	}

	Set<Integer> findFirstInfectedPerson(List<Event> events) {
		Set<Integer> candidates = new HashSet();
		for(Event e: events) {
			candidates.add(e.infector);
		}
		for(Event e: events) {
			candidates.remove(e.infected);
		}
		return candidates;
	}
```

[{1,2},{3,4}]


## Array

Given an array Where every element occur only once except one element which occured twice. Also every element is in range [1, N] and N is the size of array.


Ex: 
N = 7

[1,2,3,4,5,6,7]
[3,1,2,6,5,4,6] 
missing: 7
repeated: 6

Find repeated and missing number.



Sol1: We can use a set

Sol2: We can use another array to solve this


[3,1,2,6,5,4,6] 
[false, false, false, false, false, false, false]

3
[false, false, true, false, false, false, false]

1
[true, false, true, false, false, false, false]
.
.
.
.

```java
boolean[] temp = new boolean[N];
for(int i = 0; i < N; i++) {

	if(temp[arr[i]-1] == true) {
		repteadNo = arr[i];
	}
	temp[arr[i]-1] = true;
}

for(int i = 0; i < N; i++) {
	if(temp[i] == false) {
		missing = i+1;
	}
}
```

Using maths
sum of natural no: N*(N+1)/2

[1,2,3,4,5,6,7] 
[3,1,2,6,5,4,6] 
=> 1

[1,2,3,4,5,6,7] 
[1,2,3,4,5,6]  => 7

// What if you are not allowed to use any additional space?


Sort the input
[1,2,3,4,5,6,6]


[1,4,3,1,1]

## We can use array itself to mark.

[4,2,6,3,4,7,1]


4
[4,2,6,-3,4,7,1]

2
[4,-2,6,-3,4,7,1]

6
[4,-2,6,-3,4,-7,1]

-3
[4,-2,-6,-3,4,-7,1]

4
[4,-2,-6,-3,4,-7,1]
4 is repeated element

7
[4,-2,-6,-3,4,-7,-1]

-1
[-4,-2,-6,-3,4,-7,-1]



[0,1,2,3,4,5,6]


missing no is 5.


Follow up question: 

What is Given array is immutable.





Extra space not allowed
Modification of array is also not allowed.
We need solve with O(N) complexity.

[7,2,6,3,4,4,1]



1,2,3,4,5,6,7 => 7*8/2 => 28


7,2,6,3,4,4,1 => 27

M+R = 55




5 -  4

M - R = X -> eq no 1.

sum(1,N) - sum(arr) => X



M - R = value1 -> eq no 1.




1*2*3*4...N
-----------   => M/R

1*2*3..R*R..N



M/R = value2

M - R = value1
M/R = value2
----------------


Followup 

M-R

1 + 2 + 3 ....M.. N

1 + 2 + 3 ....R R ...N

=================

M-R = value1



1^2 + 2^2 + 3^2 ....M^2.. N^2 = > 

1^2 + 2^2 + 3^2 ....R^2 R ...N^2

=================

M^2 - R^2 = value2

(M+R)(M-R) = value2

(M+R)value1 = value2

M+R = value2/value1
M-R = value1
----------------
M = (value1 + value2/value1)/2
R = (value1 + value2/value1)/2 - value1


```java
int[] findMissingAndRepeated(int[] arr) {
	int N = arr.length;
	int diff = 0;
	int squarDiff = 0;
	for(int i = 1; i <= N; i++) {
		diff += (i - arr[i-1]);
		squarDiff += (i*i - arr[i-1]*arr[i-1]);
	}

	int missing = (diff + squarDiff/diff)/2;
	int repeated = missing - diff;

	return new int[]{missing, repeated}
}
```

[1,2,3,4,4,5,6]

[1,2,3,4,5,6,7]


diff = [1,2,3,4,5,6,7] - [1,2,3,4,4,5,6] => 3

squarDiff = [1^2,2^2,3,4,5,6,7] - [1,2,3,4,4,5,6] => 49 - 16 => 33


missing = (3 + 33/3)/2 => (3 + 11)/2 => 7
repeated = 4

M^R = value

[1,2,3,4,5]
[1,2,3,4,4]

t1 = 15
t2 = 14

dt1 = 3
dt2 = 14/5 => 2

5 
1

