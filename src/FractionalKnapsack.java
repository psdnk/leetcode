import java.util.Arrays;
import java.util.Comparator;

class ItemComparator implements Comparator<ItemValue>{

    @Override
    public int compare(ItemValue o1, ItemValue o2) {
        if (o2.cost > o1.cost) return 1;
        else if (o1.cost > o2.cost) return -1;
        else return 0;
    }
}

class ItemValue{
    int weight;
    int value;
    int cost;
    ItemValue(int weight, int value){
        this.weight = weight;
        this.value = value;
        this.cost = value/weight;
    }
}
public class FractionalKnapsack {


    public static void main(String[] args) {
        int []  value ={120,100,60};
        int []  weight  = {30,20,10};
        int capacity = 50;

        System.out.println(fractionalKnapsack(weight,value,capacity));
    }
    public static int fractionalKnapsack(int [] weight, int [] value , int capacity){
        ItemValue [] list = new ItemValue[weight.length];
        int currCapacity = 0;
        int currValue = 0;
        for (int i=0;i<weight.length;i++){
            list[i] =new ItemValue(weight[i],value[i]);
        }

        Arrays.sort(list,new ItemComparator());

        for (int i=0;i<list.length;i++) System.out.println(list[i].weight);
        for (int i=0;i<list.length;i++){
            if (currCapacity + list[i].weight <= capacity){
                currCapacity = currCapacity + list[i].weight;
                currValue = currValue + list[i].value;
            }else {
                System.out.println("  ... " + list[i].cost);
                currValue = currValue + list[i].value*list[i].cost;
                break;
            }
        }
        return currValue;
    }
}
