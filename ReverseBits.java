public class ReverseBits {

    public static void main(String[] args) {
        System.out.println (reverseBits ( 43261596 ));
    }
    public static int reverseBits(int n) {
        int sum = 0;
        for ( int i=0;i<32;i++ ){
            if ( getBit ( n,i ) ){
                sum =  setBit ( sum,31-i );
            }
        }
        return sum;
    }
    public static int setBit(int n,int bit){

        return n | (1<<bit);

    }

    public static boolean getBit(int n,int bit){
        return (n & (1 << bit)) !=0;
    }

    public int clearBit(int n, int bit){
        int mask = ~(1 << bit);
        return n & mask;
    }
}
