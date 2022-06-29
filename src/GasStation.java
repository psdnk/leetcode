public class GasStation {
    public static void main(String[] args) {
//        int [] gas = {1,2,3,4,5};
//        int [] cost = {3,4,5,1,2};
        int [] gas = {3,1,1};
        int [] cost = {1,2,2};

        int ret = canCompleteCircuit(gas,cost);
        System.out.println(ret);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i=0;i<len;i++){
            int tank = gas[i];
            int c = cost[i];
            int index = i+1;
            while (index != i){
                index = index%len;
                tank = tank - c;
                if (tank<0) break;
                tank = tank + gas[index];
                c = cost[index];
                System.out.print(i + " : " + tank + " : " + index + " , ");
                index++;
            }
            System.out.println();
            if (tank-c>=0) return i;
        }
        return -1;

    }
}
