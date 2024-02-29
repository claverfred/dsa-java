




## Operators in java.

Binary and Unary.


### Arithmetic operator.

+, -, *, /, %


### Assignment operator
=, +=, -=, *=, 

### Bitwise operator are used for bit manipulations.

&, |, ^, ~,  || <<, >>, >>>


1 Most significant bit



int x;

x % 2 == 0 ? "EVEN" : "ODD";

x&1 ? "ODD":"EVEN";



10001010101010111

>> 3

10000001010101010


>>> 3

00010001010101010




int x = 1;

=>

ASSIGN x 1 => Assembly level language.


100100100 1001001 10010100 10110101


a += 1; a = a + 1;

10001
   +1  10
=====





&

1 & 1 => 1
1 & 0 => 0
0 & 1 => 0
0 & 0 => 0


1 ^ 1 => 0
0 ^ 0 => 0
1 ^ 0 => 1
0 ^ 1 => 1



10 << 1 => 10*2

10 >> 1 => 10/2;

632987327207327029303207209272307 * 2698936292692682969836236827368744856235728 => O(m*n)

Karatsuba algorithm O(N*logN)


### relational operators

==, !=, <, > <= , >=



condition ? do this : else this


### Logical operator

&&  || !


left Condition && right condition

true && true = true
false && false = false
false && true = false
true && false = false


left Condition || right condition

false || false => false
everything else will result in true.


Short circuiting


func1() {
	complex calculations


	return true/false;
}

func2() {
	complex calculations

	return true/false;
}


boolean check = func1() && func2();



boolean check = func1() || func2();



func1() => 10 minutes

func2() => 1 sec

boolean check = func1() && func2();  // 10 m 100*10

boolean check = func2() && func1();  //  50*10 





a+=2;

a = a+2;



++ and --

Increment and decrement operators

a++.       a-- => a=a-1;

a+=1;

Pre 
post

++a

a++


--a
a--;


pre

int a = 5;

int x = ++a;

x => 6;
a => 6;


post

int a = 5;

int x = a++;

x => 5;
a => 6




========================================================

problem: count and say

1 -> L1
11 -> L2


21 -> L3
1211 -> L4


111221 -> L5
312211 -> L6


13112221 -> L7
1113213211 -> L8


111
31

11122
3122

1111122
51


```java
String countAndSay(int level) {
	if(level < 0) {
		throw new IllegalArgumentException("level cannot be negative");
	}

	if(level == 1) return "1";

	String prevValue = "1";


	for(int times = 0; times < level-1; times++) {
		String nextValue = createNextValue(prevValue);
		prevValue = nextValue;
	}

	return prevValue;
}


String createNextValue(String prevValue) {
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < prevValue.length();) {
		char currCharacter = prevValue.charAt(i);
		int count = countConsecutiveSameCharacter(prevValue, currCharacter, i);
		sb.append(count);
		sb.append(currCharacter);
		i = i + count;
	}
	return sb.toString();
}


int countConsecutiveSameCharacter(String str, Character c, int i) {
	int cnt = 0;
	for(int k = i; k < str.length() && str.charAt(k) == c; k++) {
		cnt++;
	}
	return cnt;
}


/*
111221


sb="";

currChar=1


"111221" i = 0 '1'
cnt = 3

sb: "31"

i = 3

----------

"111221" i=3 '2'
cnt: 2

sb:"3122"






*/


```

