import java.util.*;

public class AmazonReorderLines {

    public static void main(String[] args) {

    }


    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        // WRITE YOUR CODE HERE
        List<String> words = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        logLines.forEach(s -> {
            String[] temp = s.split(" ");
            if (temp[1].chars().allMatch(Character::isDigit)){
                numbers.add(s);
            }else {
                words.add(s);
            }

        });




        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] s1 = o1.split(" ");
                String [] s2 = o2.split(" ");
                return s1[1].compareTo(s2[1]);
            }
        });

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] s1 = o1.split(" ");
                String [] s2 = o2.split(" ");

                if(s1[1].equals(s2[1])){
                    char t1[] = s1[0].toCharArray();
                    char t2[] = s2[0].toCharArray();
                    Arrays.sort(t1);
                    Arrays.sort(t2);
                    return String.valueOf(t1).compareTo(String.valueOf(t2));
                }
                return s1[1].compareTo(s2[1]);
//                return s1[1].compareTo(s2[1]);
            }
        });

         words.addAll(numbers);
         return words;


    }
}
