import java.util.Arrays;

class Bitset {

    int [] bits;
    int ones;
    boolean flip;
    public Bitset(int size) {
        bits = new int[size];
        ones = 0;
        flip = false;
    }

    public void fix(int idx) {
        if (!flip){
            bits[idx] = 1;
        }
        if (!flip && bits[idx]==0){
            ones++;
            bits[idx] = 1;
        }
        else {
            if (flip)ones--;
            bits[idx] = 1;
        }

    }

    public void unfix(int idx) {
        if (!flip && bits[idx]==1) ones--;
        bits[idx] = 0;

    }

    public void flip() {
        
        int c =0;
        for (int i=0;i< bits.length;i++){
            bits[i] = bits[i] == 1 ? 0 :  1;
            if (bits[i] == 1) c++;
        }
        ones = c;
    }

    public boolean all() {
       return ones == bits.length-1 ? true : false;

    }

    public boolean one() {
        return ones>0 ? true : false;
    }

    public int count() {
       return ones;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i< bits.length;i++){
            sb.append(bits[i]);
        }
        return sb.toString();
    }
}
