public class Pattern{
    public static void main (String[] args){
       //pattern1(4);
       // pattern2(8);
       // pattern3(5);
       //pattern4(5);
       //pattern5(5);
       pattern28(5);
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

    public static void pattern5(int n){
        //use nested loops to print patterns, you can use nested loops inside a method to print a specific pattern
        for(int row=0;row<2*n;row++){
         
         int totalCols = row > n ? 2*n-row : row; 
         for(int col=0;col<totalCols;col++) {
             System.out.print("* ");
         }
            System.out.println();
        }
    }

    static void pattern28(int n){

        for(int row=0;row<2*n;row++){

            int totalCols = row > n ? 2*n-row : row;
            int noOfSpaces = n - totalCols;

            //print spaces
            for(int s=0;s<noOfSpaces;s++){
                System.out.print("  ");
            }
            for(int col=0;col<totalCols;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}