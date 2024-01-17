public class Pattern{
    public static void main (String[] args){
       // pattern1(4);
       // pattern2(8);
       // pattern3(5);
       pattern4(5);
    }

     public static void pattern1(int n){
        //use nested loops to print patterns, you can use nested loops inside a method to print a specific pattern
        for(int row=1;row<=n;row++){
            for(int col=1;col<=n;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n){
        //use nested loops to print patterns, you can use nested loops inside a method to print a specific pattern
        for(int row=1;row<=n;row++){
            for(int col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     public static void pattern3(int n){
        //use nested loops to print patterns, you can use nested loops inside a method to print a specific pattern
        for(int row=1;row<=n;row++){
            for(int col=n;row<=col;col--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
     public static void pattern4(int n){
        //use nested loops to print patterns, you can use nested loops inside a method to print a specific pattern
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
}