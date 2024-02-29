public class FindElementInArray{

    public static void main(String[] args) {

        int arr[] = { 5, 1, 1, 9, 7, 2, 6, 10};
        int target = 5;
        int n = arr.length;  
        int newArr[] = new int[n+1];  

        for(int i = 0; i<n; i++) {  
        newArr[i] = arr[i];  
        }  

        //Adding the target element at the end of the array.
        newArr[n] = target; 

        
        System.out.println("Is "+target+" found in the array? :"+findElement(newArr, target));

    }

    public static boolean findElement(int[] arr, int target) {

        int i = 0;
        int N = arr.length-1;
        while(arr[i]!=target) i++;
        if(i==N) return false;
        return true;
    }
}