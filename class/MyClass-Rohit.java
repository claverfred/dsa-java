import java.util.*;
public class MyClass {
    public static void main(String[] args) {
        char[][] ss = {"abcdTTTTTTTTTTTTTTTTTefg".toCharArray(), 
        "abcdefghihhhhhhhhhhhhhhhhhhhhklmn".toCharArray(), 
        "abcdTTTTTT".toCharArray(), "TTTTTTTTTabcd".toCharArray(), 
        "abcTTTTTTGGGGGHHHHefgh".toCharArray(), 
        "abccdddefggggghhhhh".toCharArray(),
        "ABYYYYYYYRT".toCharArray(),
        "ABCDDEFGGGGGHIJKKKKKL78965432JTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOPQRSTUVYYYYYYYPQRSTbcdefi".toCharArray()
        };
        for(char[] str: ss) {
            System.out.println("----------------------------------START----------------------------------");
            System.out.println("Before Compression: " + String.valueOf(str));
            try {
                compress(str);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("----------------------------------END----------------------------------");
        }
    }

    static void compress(char[] str) {
        int p = findPos(str);
        if(p >= str.length) {
            throw new IllegalArgumentException("Invalid argument");
        }
        int q = runLength(str, p, str.length-1, p);
        System.out.println("Step1: " + String.valueOf(str));
        int r = runLength(str, 0, p-1, q);
        System.out.println("Step2: " + String.valueOf(str));
        markElementsAsDeleted(str, r, p);
        
        int q1 = q - (p - r < 0 ? p : p - r);
        
        if(p == 0) return;
        
        int k = countHashBeforeStart(str, q-1);
        
        System.out.println(p+", " + q + ", "+r + ", "+k);
        q = q - k;
        
        System.out.println(q+", " + q1);
        
        int emptySpaces = moveHashToEnd(str);
        System.out.println("Step3: " + String.valueOf(str));
        
        int e = str.length - emptySpaces -1;
        rotate(str, 0, e, q);
        
        System.out.println("Step4: " + String.valueOf(str));
    }

    static int findPos(char[] str) {
        int btotal = 0;
        int pos = 0;
        for(int i = 0, j = 0; i < str.length; i = j) {
            while(j < str.length && str[j] == str[i])j++;
            btotal += calculateBenefit(i,j);
            if(btotal < 0) {
                pos = j;
            }
        }
        return pos;
    }

    static int calculateBenefit(int i, int j) {
        int cnt = j - i;
        return (j-i) - (1 + String.valueOf(cnt).length());
    }
    
    static int runLength(char[] str, int start, int end, int k) {
        for(int i = start, j = i; i <= end; i = j) {
            while(j < str.length && str[j] == str[i])j++;
            char[] countAsStr = String.valueOf(j-i).toCharArray();
            str[k] = str[i]; 
            k = (k+1) % str.length;
            k = copytoStr(str, countAsStr, k);
        }
        return k;
    }

    static int copytoStr(char[] str, char[] toCopy, int from) {
        for(char c: toCopy) {
            str[from] = c;
            from = (from +1) % str.length;
        }
        return from;
    }
    

    static void markElementsAsDeleted(char[] str, int r, int p) {
        for(int i = r; i != p; i = (i+1)%str.length) {
            str[i] = '#';
        }
    }

    static int countHashBeforeStart(char[] str, int i) {
        int cnt = 0;
        while(i >= 0) {
            if(str[i] == '#') cnt++;
            i--;
        }
        return cnt;
    }

    static int moveHashToEnd(char[] str) {
        int idx = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] != '#') {
                str[idx] = str[i];
                idx++;
            }
        }

        int hashCount = str.length - idx;
        while(idx < str.length) {
            str[idx] = '#';
            idx++;
        }
        return hashCount;
    }

    static void rotate(char[]str, int start, int end, int from) {
        rev(str, start, from-1);
        rev(str, from, end);
        rev(str, start, end);
    }
    
    static void rev(char[]str, int p, int q) {
        while(p < q) {
            char t = str[p];
            str[p] = str[q];
            str[q] = t;
            p++;
            q--;
        }
    }
}