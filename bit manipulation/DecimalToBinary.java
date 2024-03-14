import java.util.Scanner;

public class DecimalToBinary {
    static String decimalToBinary(int n) {
        String b = "";
        while(n >=1){
            int x = n%2;
            n = n/2;
            b = x + b;
        }
        return b;
    }

    static int binaryToDecimal(String b) {
        int result = 0;
        int powerOf2 = 1;
        for(int i = b.length()-1; i >= 0; i--){
            if(b.charAt(i) == '1'){
                result = result + powerOf2;
            }
            powerOf2 = powerOf2 * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        String binary = decimalToBinary(decimal);
        System.out.println("Binary number is: " + binary);    
        int decimal2 = binaryToDecimal(binary);
        System.out.println("Decimal number is: " + decimal2);
    }
}