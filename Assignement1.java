    //1. Find max of 3 elements
	
	import java.util.Scanner;  
    public class LargestNumberExample1  
    {  
    public static void main(String[] args)   
    {  
    int a, b, c, largest, temp;  
    //object of the Scanner class  
    Scanner sc = new Scanner(System.in);  
    //reading input from the user  
    System.out.println("Enter the first number:");  
    a = sc.nextInt();  
    System.out.println("Enter the second number:");  
    b = sc.nextInt();  
    System.out.println("Enter the third number:");  
    c = sc.nextInt();  
    //comparing a and b and storing the largest number in a temp variable  
    temp=a>b?a:b;  
    //comparing the temp variable with c and storing the result in the variable  
    largest=c>temp?c:temp;  
    //prints the largest number  
    System.out.println("The largest number is: "+largest);  
    }  
    }  
	
	==================================================
	//2. Find min of 3 elements
	import java.io.*;
 
	class GFG {
	   
		public static void main (String[] args) {
				int a = 5, b = 7, c = 10;
	 
		if (a <= b && a <= c)
			System.out.println( a + " is the smallest");
	 
		else if (b <= a && b <= c)
			System.out.println( b + " is the smallest");
	 
		else
			System.out.println( c + " is the smallest");
	 
		}
	}
	 
	
	=====================================================
	//3. Find mid elements out of 3 elements.
	import java.util.*;
	 
	class Middle
	{   
		// Function to find the middle of three number
		public static int middleOfThree(int a, int b, 
											  int c)
		{
			// Compare each three number to find 
			// middle number. Enter only if a > b
			if (a > b) 
			{
				if (b > c)
					return b;
				else if (a > c)
					return c;
				else
					return a;
			}
			else
			{
				// Decided a is not greater than b.
				if (a > c)
					return a;
				else if (b > c)
					return c;
				else
					return b;
			}
		}
		 
		// driver code
		public static void main(String[] args)
		{
			int a = 20, b = 30, c = 40;
			System.out.println(middleOfThree(a, b, c));
		}
	}
	
	=================================================
	
	//4. Print below series for n=5
	
	public class MyClass {
	public static void main(String args[]) {
	 printPattern(5);
	}
   public static void printPattern(int n){
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j);
			}
			System.out.println();
		}
	 }
	}

============================================================
	//5. Print below series for n=5
	public class MyClass {
		public static void main(String args[]) {
		 printPattern(5);
		}
	   public static void printPattern(int n){
			for(int i=n;i>=1;i--){
				for(int j=1;j<=i;j++){
					System.out.print(j);
				}
				System.out.println();
			}
		}
	}