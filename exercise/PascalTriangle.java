public class PascalTriangle {

        public static void main(String[] args) {
              
               printTriangle(5);
              
       }

       public static void printTriangle(int n) {  

        for(int i=0;i<n;i++) {
                     
                      //spaces
                    for(int j=1;j<n-i;j++) {
                           
                           System.out.print(" ");
                           
                     }
                     
                      //Numbers
                      int number = 1;
                     
                      for(int k=0;k<=i;k++) {
                           
                           System.out.print(number +" ");
                           
                            number = number*(i-k)/(k+1);
                           
                     }
                     
                     System.out.println();
                     
              }
       }
       
}

