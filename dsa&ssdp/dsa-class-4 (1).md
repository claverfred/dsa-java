









## Array

```java

int[] arr = new int[20]

arr[0]

arr[1]

arr[2]

arr points to the first address of allocated memory
arr[i] = (arr + i)

int[] arr = {1,2,3,4,5};

```

### Problem 1.

Given array of characters reverse this arrays



```java
/*
"abcdef"
012345 N = 6

0 <-> 5
1 <-> 4

i <-> N-1-i

"fbcdea"

"fecdba"


*/

void reverse(char[] arr) {
	for(int i = 0, j = arr.length-1; i < j; i++,j--) {
		swap(arr, i, j);
	}
}

void swap(char[] arr, int i, int j) {
	char temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}


```

followup question: Reverse a range

```java
void reverse(char[] arr, int i, int j) {
	for(; i < j; i++,j--) {
		swap(arr, i, j);
	}
}

void swap(char[] arr, int i, int j) {
	char temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

```


## problem 2 rotate an array

"abcdefgh" after rotation "fghabcde"

[a,b,c,d,e,f,g,h] rotate from index 3

[d,e,f,g,h,a,b,c]


[a,b,c,d,e,f,g,h] 

part  1 [d,e,f,g,h] => reverse => [h,g,f,e,d]
part  2 [a, b, c] => reverse => [c, b, a]
[c,b,a,h,g,f,e,d] => reverse => [d,e,f,g,h,a,b,c]




```java
	void rotatefrom(char[] arr, int from) {
		reverse(arr, from, arr.length-1);
		reverse(arr, 0, from-1);
		reverse(arr, 0, arr.length-1);
	}
```

## Problem 3


Run length encoding. Compression algorithm

"abbbcdddddeeefaaaa" => "ab3cd5e3fa4"


## problem 4
Run length encoding type 2. 

Note: Output will never be longer then input.

"abbbcdddddeeefaaaa" => "a1b3c1d5e3f1a4"

"abcd" => "a1b1c1d1"  Wrong input
"aaabcd" => "a3b1c1d1" Invalid input.


Note: Solve this problem without additional space or solve it inplace.

[a,b,c,d,e,e,e,e,e,e,e] => [a,1,b,1,c,1,d,1,e,7]

temp c

[a,1,b,1]

benifit of compression: 
a => a1 => -1

bb => b2 => 0

aaaaa => a5 => 3

[a,b,c,d,e,e,e,e,e,e,e]

[a,b,c,d,e,7,#,#,#,#,#]

[#,#,#,#,#,a,b,c,d,e,7]

[a,1,b,1,c,1,d,1,e,7]




[a,b,c,d,e,e,e,e,e,e,e,g,a,a,a,a]

step-1

[a,b,c,d,e,7,#,#,#,#,#,g,a,4,#,#]

step-2 shifting

[#,#,#,#,#,#,#,a,b,c,d,e,7,g,a,4]

Step-3
[a,1,b,1,c,1,d,1,e,7,g,1,a,4,#,#,#]


"abcdefffffffghijk" => null


"aaaaaaaaaaaaaaaaaaaaaaaa....."

[a,2,5,6]



"aaaaaaaaaabbbccc" => "a10b3c2"



### Next followup question

"aabbbbbb22235555555" => "a2b6233157"



"aaaaabb" => "a5###b2"



```java

void compress(char[] arr) {

}

void runLength(char[] arr) {
	int idx = 0;
	for(int i = 0, j = 0; i < arr.length; i = j) {
		while(j < arr.length && arr[j] == arr[i]) j++;
		int cnt = j-i;
		arr[idx] = arr[i];
		idx++;

		char[] charInCnt = String.valueOf(cnt).toCharArray();

		for(char c: charInCnt) {
			arr[idx] = c;
			idx++;
		}
	}
}

```

"abcdTTTTTTTT" => "a1b1c1d1T8##"



k, k+1, k+2.....0,1,2,3,...k-1

"abcdTTTQQYYYYYYYYw" => 

"TTTTabcdeQQQPPPRRRTTT" => 



"AAAAABCDETTTUUUYYYY"

benefits() => 3 => start = 0


3 -1 -1, -1, -1, -1, 1, 1, 2

3  2 1  0  -1  -2  -1 0 2


"AAAAABCDETTTUUUYYYY"
 
"1C1D1E1T3###U3Y4A5B"




"ABCTTTTTTTTEFG"


```java

int findStartingPoint(char[] arr) {
	int totalBefenits = 0;
	int startPos = 0;

	for(int i = 0, j = 0; i < arr.length; i = j) {
		while(j < arr.length && arr[j] == arr[i]) j++;
		int cnt = j-i;
		totalBefenits+= benefits(cnt);

		if(totalBefenits < 0) {
			startPos = j;
		}
	}
	return startPos;
}

int benefits(int cnt) {
	return cnt - (1 + String.valueOf(cnt).length);
}

```

i
0,1,2,3,4,5,6,7,8...
i%5
0,1,2,3,4,0,1,2,3

5




```java
int runLength(char[] arr, int start, int end, int idx) {
	for(int i = start, j = start; i <= end; i = j) {
		while(j < arr.length && arr[j] == arr[i]) j++;
		int cnt = j-i;
		arr[idx] = arr[i];
		idx = (idx+1) % arr.length;
		char[] charInCnt = String.valueOf(cnt).toCharArray();
		for(char c: charInCnt) {
			arr[idx] = c;
			idx = (idx+1) % arr.length;
		}
	}
	return idx;
}
```

Ex:

"TTTTABCDYYYUUU"
								8 starting point
								idx = 8


[0,13]

start = 8
idx = 8
idx = 12
"TTTTABCDY3U3.."


"TTTTABCDY3U3T4"
idx = 0

"A1B1C1D1"


"abcTTTTTTGGGGGHHHHefgh" => 22

pos = 3
idx = 3

"1##T6G5H4e1f1g1h1a1b1c"

"1T6G5H4e1f1g1h1a1b1c##"

"ABC##PQR"
rotating point is Q



```java

void compress(char[] arr) {
	int pos0 = findStartingPoint(arr);
	int pos1 = runLength(arr, pos0, arr.length-1, pos0);
	int pos2 = runLength(arr, 0, pos-1, pos1);

	markAsDeleted(arr, pos2, pos0);

	int emptyBeforeStart = countEmptySpaceBeforeStart(arr, pos1);

	int totalEmptySpace = shiftEmptyToEnd(arr);

	pos1 = pos1 - emptyBeforeStart;

	rotatefrom(arr, 0, arr.length-totalEmptySpace-1, pos1);
}

void rotatefrom(char[] arr, int star, int end, int from) {
		reverse(arr, from, end);
		reverse(arr, start, from-1);
		reverse(arr, start, end);
}

void reverse(char[] arr) {
	for(int i = 0, j = arr.length-1; i < j; i++,j--) {
		swap(arr, i, j);
	}
}

void swap(char[] arr, int i, int j) {
	char temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

void markAsDeleted(char[] arr, int start, int end) {
	for(int i = start; i != end; i = (i+1) % arr.length) {
		arr[i] = '#';
	}
}

int shiftEmptyToEnd(char[] arr) {
	int idx = 0;

	for(int i = 0; i < arr.length; i++) {
		if(arr[i] != '#') {
			arr[idx] = arr[i];
			idx++;
		}
	}
	int cnt = arr.length-idx;
	while(idx < arr.length) {
		arr[i] = '#';
	}
	return cnt;
}

int countEmptySpaceBeforeStart(char[] arr, int pos) {
	int cnt = 0;
	for(int i = 0; i < pos; i++) {
		if(arr[i] == '#') cnt++;
	}
	return cnt;
}

int runLength(char[] arr, int start, int end, int idx) {
	for(int i = start, j = start; i <= end; i = j) {
		while(j < arr.length && arr[j] == arr[i]) j++;
		int cnt = j-i;
		arr[idx] = arr[i];
		idx = (idx+1) % arr.length;
		char[] charInCnt = String.valueOf(cnt).toCharArray();
		for(char c: charInCnt) {
			arr[idx] = c;
			idx = (idx+1) % arr.length;
		}
	}
	return idx;
}


int findStartingPoint(char[] arr) {
	int totalBefenits = 0;
	int startPos = 0;

	for(int i = 0, j = 0; i < arr.length; i = j) {
		while(j < arr.length && arr[j] == arr[i]) j++;
		int cnt = j-i;
		totalBefenits+= benefits(cnt);

		if(totalBefenits < 0) {
			startPos = j;
		}
	}
	return startPos;
}

int benefits(int cnt) {
	return cnt - (1 + String.valueOf(cnt).length);
}


```

`dry run`
           |
"ABCDEFGHHIJJJJJJJJJJJJJJKLMMM"

+ step-1:
	- pos0 = 10

+ step-2: compress right part from pos0 to str.length-1
	- ABCDEFGHHIJ14K1L1M3JJJJJKLMMM
	- pos1 = 19

+ step-3: compress left part 0 to pos0-1
   - F1G1H2I1HIJ14K1L1M3A1B1C1D1E1
   - pos2 = 8

+ step-4: delete elements marking them as #
	- F1G1H2I1##J14K1L1M3A1B1C1D1E1

+ step-5: how many # are there before pos1 = 19
	- 2
	- pos1 = pos1 - 2 => 17

+ step-6: Move hash to right
	- F1G1H2I1J14K1L1M3A1B1C1D1E1##

+ step-7: 
	- rotate array between 0 to arr.length-3 from pos1 = 17

+ output: A1B1C1D1E1F1G1H2I1J14K1L1M3##






```java
// final code
public class RunLengthEncode {
    void compress(char[] arr) {
        int pos0 = findStartingPoint(arr);
        int pos1 = runLength(arr, pos0, arr.length-1, pos0);
        int pos2 = runLength(arr, 0, pos0-1, pos1);
    
        markAsDeleted(arr, pos2, pos0);
    
        int emptyBeforeStart = countEmptySpaceBeforeStart(arr, pos1);
    
        int totalEmptySpace = shiftEmptyToEnd(arr);
    
        pos1 = pos1 - emptyBeforeStart;
    
        rotatefrom(arr, 0, arr.length-totalEmptySpace-1, pos1);

        System.out.println(String.valueOf(arr));
    }
    
    void rotatefrom(char[] arr, int start, int end, int from) {
            reverse(arr, from, end);
            reverse(arr, start, from-1);
            reverse(arr, start, end);
    }
    
    void reverse(char[] arr, int i, int j) {
        for(; i < j; i++,j--) {
            swap(arr, i, j);
        }
    }
    
    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void markAsDeleted(char[] arr, int start, int end) {
        for(int i = start; i != end; i = (i+1) % arr.length) {
            arr[i] = '#';
        }
    }
    
    int shiftEmptyToEnd(char[] arr) {
        int idx = 0;
    
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != '#') {
                arr[idx] = arr[i];
                idx++;
            }
        }
        int cnt = arr.length-idx;
        while(idx < arr.length) {
            arr[idx] = '#';
            idx++;
        }
        return cnt;
    }
    
    int countEmptySpaceBeforeStart(char[] arr, int pos) {
        int cnt = 0;
        for(int i = 0; i < pos; i++) {
            if(arr[i] == '#') cnt++;
        }
        return cnt;
    }
    
    int runLength(char[] arr, int start, int end, int idx) {
        for(int i = start, j = start; i <= end; i = j) {
            while(j < arr.length && arr[j] == arr[i]) j++;
            int cnt = j-i;
            arr[idx] = arr[i];
            idx = (idx+1) % arr.length;
            char[] charInCnt = String.valueOf(cnt).toCharArray();
            for(char c: charInCnt) {
                arr[idx] = c;
                idx = (idx+1) % arr.length;
            }
        }
        return idx;
    }
    
    
    int findStartingPoint(char[] arr) {
        int totalBefenits = 0;
        int startPos = 0;
    
        for(int i = 0, j = 0; i < arr.length; i = j) {
            while(j < arr.length && arr[j] == arr[i]) j++;
            int cnt = j-i;
            totalBefenits+= benefits(cnt);
    
            if(totalBefenits < 0) {
                startPos = j;
            }
        }
        return startPos;
    }
    
    int benefits(int cnt) {
        return cnt - (1 + String.valueOf(cnt).length());
    }
    
    public static void main(String[] args) {
        RunLengthEncode runLengthEncode = new RunLengthEncode();
        runLengthEncode.compress("ABCDTTTTTTTTTTYYYYU".toCharArray());
    }
}


```

