





# Binary search 

## Topics:
	+ variations of simple binary search
	+ Precautions while writing binary search
	+ Understanding that binary search can be applied to monotonic functions.




Q1. `Find last occurence of target in a sorted array`

input [1,2,5,7,8, 10,10,10,10,10, 21, 26, 31, 42]
output 9

```java

	int findFirstOccurence(int[] arr, int target) {
		int lo = 0, hi = arr.length-1;

		while(lo < hi) {
			int mid = lo + (hi-lo)/2;
			if(target <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid+1;
			}
		}

		return arr[lo] == target ? lo : -1;
	}

	/*
		expected output is 5
		
		lo = 0, hi = 13

		mid = 6

		lo = 0 hi = 6
		mid = 3

		target > 7

		lo = 4 hi = 6

		mid = 5

		arr[5] target <= 10

		lo=4 hi=5

		mid = 4

		target > 8

		lo=5 hi 5

		return lo => 5


	*/



	// buggy code
	int findLastOccurence(int[] arr, int target) {
		int lo = 0, hi = arr.length-1;

		while(lo < hi) {
			int mid = lo + (hi-lo)/2;
			if(target >= arr[mid]) {
				lo = mid;
			} else {
				hi = mid-1;
			}
		}

		return arr[lo] == target ? lo : -1;
	}



	int findLastOccurence(int[] arr, int target) {
		int lo = 0, hi = arr.length-1;

		while(lo < hi) {
			int mid = lo + (1+hi-lo)/2;
			if(target >= arr[mid]) {
				lo = mid;
			} else {
				hi = mid-1;
			}
		}

		return arr[lo] == target ? lo : -1;
	}
	/*
	[2,2] target = 2

	lo = 0 hi = 1
	mid = o + (1+1)/2 = > 1

	lo = 1 hi = 1

	1

	*/


	int findLastOccurence(int[] arr, int target) {
		int lo = 0, hi = arr.length-1;
		int ans = -1;

		while(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			if(arr[mid] == target) {
				ans = mid;
				lo = mid+1;
			} else if(target > arr[mid]) {
				lo = mid+1;
			} else {
				hi = mid-1;
			}
		}
		return ans;
	}

	/*
	[2,2] target = 2

	lo = 0 hi = 1
	mid = 0
	if(2 >= arr[mid]) {
		lo = mid
	}

	lo = 0 hi = 1

	mid = 0

	lo =0 hi =1,
	......




	[i,i+1]
	mid = 

	[1,2,3,4,5,6]
	mid = 3
	*/

```



## 2D array

[
[1,2,3,4,5],
[2,3,4,5,6],
[8,9,10,11,12]
]

traget = 5;

search a target.

saddleback search.

After comparison we decide to move towards right or up.

```java
	isPresentIn2DArray(int[][] mat, int targer) {
		int rows = mat.length;
		int cols = mat[0].length;

		int i = rows-1;
		int j = 0;

		while(i >= 0 && j < cols) {
			if(mat[i][j] == target) return true;

			if(target < mat[i][j]) {
				i--;
			} else {
				j++;
			}
		}

		return false;
	}

	// O(M+N)
```

NXM

N = 1 

[
[1,2,3,4,5]
]


O(1 + M) => O(M)



Note: saddleback search is optimal when N == M or Differenec between M and N should be less.


[
	[1,2,3,4,5,6,7,8,9,10,13,16,17,18,18....],
	[1,2,3,4,5,6,7,8,9,10,13,16,17,18,1819,....]
	[1,2,3,4,5,6,7,8,9,10,13,16,17,18,1819.....]
]

3 10000 => O(10003)


3*log(10000) => 3*13 => 39



Q3
We have N different apps with different user growth rates. At a given time t, measured in days, the number of users using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app. These apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many total users there are when you add together the number of users from each app.

After how many full days will we have 1 billion total users across the N apps?


growthRates = [1.5]
output = 52


1.5^x = 1000000000

growthRates = [2, 3, 2]


2^t + 3^t + 2^t >= 1000000000


growthRates = [2, 3, 2]

2+ 3+ 2 => 7 day1 

4 + 9 + 4 => 17 day2 

8 + 27 + 8 => 43 day3

.
.
.
.


monotonic function.


f(1), f(2), f(3), f(4)........f(k), f(k+1), f(k+1).......f(n)


[1,n]



logb(a) => logc(a) / logc(b)


n = 

logb(a)

```java

/*
no of growth rates is M

let assume log base max(growthRates) (1B) is K

O(M + log(K) * M * log(D))
*/



for(int i = 0; i < n; i++) {
	something();
}

something() {
	for(int i = 0; i < n; i++) {
		print();
	}
}


int noOfDaysToReachBillionUsers(double[] growthRates) {
	int maxGrowthRate = getMax(growthRates);

	int lo = 1;
	int hi = noOfDaysToReachBillionUsersforSingleGrowthRate(maxGrowthRate);

	// hi = 10000;
	int ans = 0;
	while(lo <= hi) {
		int mid = lo + (hi-lo)/2;
		double noOfUsersOnMidDay = noOfUsersOnNthDay(mid, growthRates);
		if(noOfUsersOnMidDay >= 1_000_000_000) {
			ans = mid;
			hi = mid-1;
		} else {
			lo = mid+1;
		}
	}
	return ans;
	// log of 1 billion base maxGrowthRate

}

double noOfUsersOnNthDay(int n, double[] growthRates) {
	double noOfUsers = 0;
	for(double rate: growthRates) {
		noOfUsers += Math.pow(rate, n);
	}
	return noOfUsers;
}

double getMax(double[] growthRates) {

}

int noOfDaysToReachBillionUsersforSingleGrowthRate(double growthRate) {
	int days = 1;

	int noOfUsers = growthRate;

	while(noOfUsers < 1_000_000_000) {
		noOfUsers = noOfUsers * growthRate;
		days++;
	}

	return days;
}

```
