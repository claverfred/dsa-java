



# Stack and queues



Linear data structures. which provide certain way of accessing the data.



## Stack.
LIFO -> last in first out
OR
FILO -> first in last out


operations supported by stack data structure
+ push
+ pop
+ peek
+ isEmpty
+ size

Basic contract of a stack
```java
interface Stack<T> {
	void push(T val);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}

class ArrayBasedStack<T> implements Stack<T> {
	private T[] stack;
	private int top = -1;
	public ArrayBasedStack(int capacity) {
		stack = new T[capacity];
	}

	public void push(T val) {
		if(top == stack.length-1) {
			throw new Exception("stack overflow");
		}
		top++;
		stack[top] = val;
	}

	public T pop() {
		if(isEmpty()) {
			throw new Exception("stack underflow");
		}
		T topValue = stack[top];
		top--;
		return topValue;
	}

	public T peek() {
		if(isEmpty()) {
			throw new Exception("stack underflow");
		}
		return stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top+1;
	}
}
```


container {}
push 2     {2}
pop  2     {}

push 3
push 4
push 5
		{3,4,5}
peek() 5
pop() 5 {3,4}




Given a string containing opening and closing brackets, check if its a valid expression.

().  ->valid
))() invalid
(())() valid
)))(( invalid


(())()

(((())()()))

Algorithm:
	1. Scan the string
		if current char is opening then push on to stack
		else if current char is closing then
			check if stack is empty
				return false
			else pop 1 element from stack

	2. check if stack is empty
		return true
	else false;

))(( invalid


> at every point no of opening brackets >= no of closing brackets.
> At the end opening should be equal to closing


(()())

0 -> 1 0
1 -> 2 0
2 -> 2 1
3 -> 3 1
4 -> 3 2
5 -> 3 3

(()()

1 0
2 0
2 1
3 1
3 2

))

0 1

(()))

2 3

```java
boolean isValidParanthesisExp(String s) {

}

```

Q2: Given a string containing '(' and ')' character find the length of longest valid substring

(()()
()()

```java
for(int i = 0; i < s.length()-1; i++) {
	for(int j = i+1; j < s.length(); j++) {
		// call isValidParanthesisExp(s.substring(i,j+1))
	}
}
```

O(n^3)

"abcd"

1 + 2 + 3 +...+ 4 => n(n+1)/2 => (n^2 + n)/2 => O(n^2)


"a"
"b"
"c"
"d"

"ab"
"bc"
"cd"

"abc"
"bcd"

"abcd"

)))(((



)))()()((( -> ()() -> 4

((()))))) -> ((())) -> 6


(((((((()()((
8 0
8 1
9 1
10 2


```java
int findLongestValidParenthesisSubstring(String s) {
	return Math.max(maxWhileScanningLeftToRight(s), maxWhileScanningRightToLeft(s));
}

int maxWhileScanningLeftToRight(String s) {
	int open = 0, close = 0;
	int maxSubstringSize = 0;
	for(char c: s.toCharArray()) {
		if(c == '(') open++;
		else close++;

		if(close > open) {
			open=close = 0;
		}

		if(open > 0 && open == close) {
			maxSubstringSize = Math.max(maxSubstringSize, open+close);
		}
	}
	return maxSubstringSize;
}

/*
i = 0

s.charAt(i);

s.charAt(n - i -1);

*/

int maxWhileScanningRightToLeft(String s) {
	int open = 0, close = 0;
	int maxSubstringSize = 0;
	for(int i = s.length()-1; i >= 0; i--) {
		char c = s.charAt(i);
		if(c == '(') open++;
		else close++;

		if(open > close) {
			open=close = 0;
		}

		if(open > 0 && open == close) {
			maxSubstringSize = Math.max(maxSubstringSize, open+close);
		}
	}
	return maxSubstringSize;
}


int longestValidParentheses(String s) {
        int l1 = 0, r1 = 0, l2 =0, r2 = 0;
        int maxlength = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                l1++;
            } else {
                r1++;
            }
            if (s.charAt(len-i-1) == '(') {
                l2++;
            } else {
                r2++;
            }
            
            if (l1 == r1) {
                maxlength = Math.max(maxlength, 2 * r1);
            } else if (r1 >= l1) {
                l1 = r1 = 0;
            }
            if (l2 == r2) {
                maxlength = Math.max(maxlength, 2 * r2);
            } else if (l2 >= r2) {
                l2 = r2 = 0;
            }
        }
        return maxlength;
    }


```


(((((())


## More applications of stack.

[5, 6, 1, 2, 4, 8, 9, 3, 6, 2]

Find the next greater element to the right of every

[6, 8, 2, 4, 9, -1, 6, -1, -1]


stack: {}

5.             -1

s: {5}
				
6

s: {6}.        6

1

s: {1,6}.      1

2

s: {2, 6}.     2

4

s: {4, 6}.    4

8

s: {8}.       8

9

s: {9}.       9

3

s: {3, 9}.    3

6

s: {6, 9}.    6



[4, 5, 2, 4]

[5, -1, 4, -1]

4
		-1
{4}.    4

5
		4
{5}.    5


{2,5}.   2

{4, 5}.  4



// standard stack based problems solution template
```java

	// scan over elements
		while(!stack.isEmpty() && condition(topElement, curElement)) {
			stack.pop();
			// some operation
		}

		// some operation

		stack.push(curElement);
```

monotonic stack (either increasing or decreasing)




# Rain trapping problem

find next greater
find next smaller
find prev greater
find prev smaller.
rain trapping
finding largest histogram area.