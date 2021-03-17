import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Permutation {

    public static void main(String[] args) {
        Permutation p = new Permutation ();
        System.out.println (p.getPermutation ( 4,14 ));

    }
    public String getPermutation(int n, int k) {
        int [] fact = new int[10];
        fact[0]=1;
        for ( int i=1;i<=9;i++ ){
            fact[i]  = fact[i-1]*i;
        }
        int [] c = new int[n];
        for ( int i=0;i<n;i++ ){
            c[i] = i+1;
        }
        String ans = "";
        int [] temp;
        while (n>0){
            System.out.println (k);
            int index = k/(factorial ( n-1 ));
            if ( (k % factorial ( n-1 )) == 0 ){
                index = index-1;
            }
            ans = ans + String.valueOf ( c[index] );
            //remove element from array
            temp = new int[c.length-1];
            for ( int i=0, l=0;i<c.length;i++ ){
               if ( i == index ){
                   continue;
               }
               temp[l++] = c[i];
            }
            c = temp;
            //new k
            k = k - fact[n-1]*index;
            n= n-1;
        }
        return ans;


    }


    public int factorial(int n){

        if(n==0 || n==1){
            return 1;
        }else {
            return n*factorial ( n-1 );
        }
    }



}
