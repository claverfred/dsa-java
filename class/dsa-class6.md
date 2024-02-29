









Big O notation

O(f(N))


f(N) is a function of N.


O(N)  is approximate to a*N + b where a and b are constants.


linear function of N => a*N + b => O(N)

Quadratic function of N => a*N^2 + b*N + c => O(N^2)

cubic function of N => a*N^3 + b*N^2 + c*N + d => O(N^3)



O(N) means no of operations performed in our program can be presented as linear function of N or in the form a*N+b.


```java
// find avg of array

	int mean(int[] arr) {
		int sum = 0;         -> 1
		for(int ele: arr) {
			sum += ele;      -> N
		}
		return sum / arr.length; -> 1
	}
```

total no of operations = N+2 => a*N+b => a = 1 b =2

O(N)


```java
// find avg of array

	int mean(int[] arr) {
		int sum = 0;         -> 1
		for(int i = 0; i < arr.length;i++) { 1 + N, N
			sum += ele;   N
		}
		return sum / arr.length; -> 1
	}

```

1 + 1 + N + N + N + 1 => 3N + 3 => O(N)



O(1) < O(log(logN)) < O(logN) < O(N^1/2) or O(sqrt(N)) < O(N) < O(NlogN) < 
O(N*sqrt(N)) < O(N^2) < O(N^3) < O(2^N) < O(3^N) < O(N!)... 




[a0, a1, a2, a3, a4, a5,........ an-2, an-1]

2 parts or 3 parts or 4parts....

more then or 1 parts equal parts.

[a0, ax] [ax+1, ay] [ay, an-1]


logb(a) => log of a base b.

lets assume log2 means log base 2

log2(8) => 3
log3(9) => 2




Binary search.


1024 pages 

512

page to find < 512 or greater then 512

[0, 512]
   256

[0, 256]

  128

[0, 128]

   64
[0, 64]

32

[0, 32]

16

[0, 16]

8

[0, 8]
4
[0 4]
2
[0,2]
1
0



log2(1024) => 10






[1,2,3,4,5,6,7,8,9]

10 % of the numbers.

Initially if my search space contains 100 numbers
then in next step if have 90
    

100
90
81
.
.
.
.
.


log base  (100)



1/2 =>  4

log base 3 (N)


exponential time complexities

O(2^n)

{1,2,3,4} how many subsets are possible

{}
{1} {2} {3} {4}
{1,2} {1,3} {1, 4} {2,3} {2,4} {3,4}
{1,2,3} {1,2,4} {1,3,4} {2,3,4} 
{1,2,3,4}

1 + 4 + 6 + 4 + 1 => 16

4C0 + 4C1 + 4C2 + 4C3 + 4C4 =>

1 + 4 + 6 + 4 + 1

NCR = NCN-R

NC0 + NC1 + NC2 .... + NCN => 2^n



N = 1  => 2
N = 2 => 4

....

N = 10 => 1024


N = 64 => 




fobonocci sequence

0, 1, 1, 2, 3, 5, 8, 13, 21, 34....


f(N) = {
    0 if N = 1
    1 if N = 2
    else f(N-1) + f(N-2)
}


f(N) => f(N-1) + f(N-2)

recursion

```java
	int fibo(int N) {
		if(N == 1) return 0;
		int (N == 2) return 1;
		return fibo(N-1) + fibo(N-2);
	}
```

It has exponential time complexity.

						f(6).          -> 1 => 2^0
				f(5)            f(4).  -> 2 = 2^1
		  f(4)         f(3)   f(3) f(2)-> 4 => 2^2
		  									   2^6


f(n) => 2f(n-1) + f(n-2) + 4f(n-3) + 5f(n-4)

O(4^n)


O(N!) nearly equal to O(N^N)

any big O notation can be replaced by bigger big O notation.


O(N) O(N^2)


O(N!) N*(N-1)*(N-2)...1 

O(N^N) N*N*N*N....N


O(N!)

N-1 < N

N-2 < N

N-3 < N

============================================================

Algorithm:
Binary search


Game: Guess the no with minimum no of attempts.

P1 -> choose a no between a range [start, end]
P2 -> make a guess on which p1 needs to tell if the no is correct of no is lower or no is higher.


100


100


100

[1, 100] 10

guess: 50

[1, 49]

guess 25

[1, 24]

guess 12

[1,11]
guess 6

[7, 11]
guess 9

[10,11]
guess 10


[0,    10000000000000000000]

[999999999999999999999, 10000000000000000000]
integer overflow


x*2+ y => x + x + y

Q1. Given a sorted array of integers find an element in this array.

a0 < a1 < a2......


[2,3,5,6,8,11,15,18,19,20,34,38,41]

```java
	// if element is present return its index else return -1
	int binarySearch(int[] arr, int searchEle) {
		int lo = 0, hi = arr.length-1;

		while(lo <= hi) {
			// int mid = (lo+hi)/2;  => 
			int mid = lo + (hi-lo)/2;

			if(arr[mid] == searchEle) {
				return mid;
			}

			if(searchEle < arr[mid]) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}

		return -1;
	}
```


BinarySearch
kadane's algorithm
quick sort
merge sort
heap (creation and heapsort)
Dijkastra algorithm
prims
kruskals
khan's

