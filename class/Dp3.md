Optimal Binary search tree.

Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches for keys[i]. Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.


[4,5]

		4
			5     => 8*1 + 10*2 => 28
--------------------
		5         => 8*2 + 10*1 => 26 
	4

freq=[8,10]

search cost = no of nodes compared to search an element.



[1,2]




[1,2,3]
[4,3,5]

		1
			2
				3.       => 1*4 + 2*3 + 3*5 => 4 + 6 + 15 => 25

-------------------------

			2
		1       3

---------------------------

			3
		2
	1

----------------------------

			1
				3
			2

-------------------------

			3
		1
			2
---------------------------

2n!/(n+1)!

1, 1, 2, 5, 14, 42, 132, 429, 1430

((()))




Input
array frequency[] where frequency[i] represent search frequency of value at i index.
Dp state
dp[i][j] represents minimum cost of search for elements from index i to j
dp[i][i] = frequency[i]
// Another example of diagonally aligned dp state
len = 2 to s.length
i = 0 to s.length - len
j = i+len-1
dp[i][j] =
  for k in i to j
    sum(i, j) + min(dp[i][k-1], dp[k+1][j])


```java
	int optimalCostBST(int[] freq) {
		int n = freq.length;
		int[][]dp = new int[n][n];

		for(int i = 0; i < n; i++) {
			dp[i][i] = freq[i];
		}

		for(int i = 1; i < n; i++) {
			freq[i]+=freq[i-1];
		}


		for(int len = 2; len <= n; len++) {
			for(int i = 0; i < n-len; i++) {
				int j = i+len-1;
				dp[i][j] = calOptimalBSTFrom(i,j,dp,freq);
			}
		}

		return dp[0][n-1];
	}

	int sum(int[] cumulativeSum, int i, int j) {
		return cumulativeSum[j] - (i > 0 ? cumulativeSum[i-1] : 0);
	}

	int calOptimalBSTFrom(int i, int j, int[][] dp, int[] freq) {
		int minCost = Integer.MAX_VALUE;
		int sumFromItoJ = sum(freq,i,j);
		for(int k = i; i <= j; k++) {
			int curCost = sumFromItoJ + (i > k-1 ? 0 : dp[i][k-1]) + (k+1 > j ? 0 : dp[k+1][j]);
			minCost = Math.min(minCost, curCost);
		}
		return minCost;
	}
```

n matrix

2X3 3X6 6X8 8X5

[2,3,6,8,5]



2X3 3X6 | 6X8 8X5

2X6   |  6X5

2*6*5 + cost of left + cost of the right

[i,j]

k 



2X3 3X6 6X8 | 8X5


2*8*5 + cost of left + cost of right

2X3 3X6
        => 2*3*6


r1XC1 
C1xC2 => r1*c1*c2





ABCD

((AB)(CD)) 

((A(BC))D)

(A((BC)D))


dp[i][i] = 0;



i,j

for(int k = i; k < j;k++) {
	dp[i,k]
	dp[k+1,j]



}


[3, 6]

[3,4,5,6]






Input
array arr[] representing size of matrix {rows, cols}
Dp state
dp[i][j] represents minimum cost of multiplying matrices from index i to j
// Another example of diagonally aligned dp state
dp[i][i] = 0 // single matrix don't have any cost of multiplicaton
dp[i][i+1] = arr[i].rows * arr[i].cols*arr[i+1].cols

len = 3 to arr.length
i = 0 to arr.length - len
j = i+len-1
dp[i][j] =
  for k in i to j-1
    min(dp[i][k] + dp[k+1][j] + arr[i].rows*arr[k].cols*arr[j].cols)








3X4 4X5 => 3*4*5











[.....i.....j.....]

dp[i][j]

dp[i][i] ?


dp[i][j] where j = i+1

dp[0][0]
dp[1][1]
dp[2][2]

dp[1][2]

[1,2]

[3,4]


[1] => 3

[2] => 4


dp[0][0] = 3
dp[1][1] = 4

dp[0][1]

		if I make 0th element my root
						1.   => 1
							2 => 1 

							3 + 4
		1 => 7 + dp[1][1] => 7 + 4 => 3 + 4 + 4 => 3 + 4*2 => 11



		2

		 dp[0][0] + 7 => 3 + 7 => 10




[i,j]


i

i+1

i+2

i+3
.
.
.
j




k belongs to [i,j]

[i....k....j]


				k
	[i,...k-1].     [k+1,...j]


sum of freq from i to j + dp[i][k-1]  + dp[k+1][j]





i,j

int min = +Inf
for(int k = i; k <= j; k++) {
	val = sum(i,j) + dp[i][k-1] + dp[k+1][j];
	min = min(min, val);
}




































