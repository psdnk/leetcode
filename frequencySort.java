import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class frequencySort {

    public static void main(String[] args) {
        System.out.println(frequencySortV1( "tree" ));
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for ( char c : s.toCharArray() ){
            hashMap.put( c, hashMap.getOrDefault(c,0)+1 );
       }
        StringBuilder stringBuilder = new StringBuilder();
        hashMap.entrySet().stream().sorted(Map.Entry.<Character,Integer>comparingByValue().reversed()).map( x ->{
            for ( int i=0;i<x.getValue();i++ )stringBuilder.append( x.getKey() );return x;
        }).collect(Collectors.toList());

        return stringBuilder.toString();
    }

    public static String frequencySortV1(String s) {

        Pair<Integer, Character>[] map = new Pair[122];
        Arrays.fill( map,new Pair<Integer, Character>(0,'a') );
        for ( char c : s.toCharArray() ){
            int index = c-'A';
            Pair<Integer, Character> integerCharacterPair = map[ index ];
            map[index] = new Pair<>( map[index].getKey()+1,c );
        }
        Arrays.sort(map);
        for ( int i=0;i<map.length;i++ ){
            System.out.println(map[i].getValue());
        }
    return "";
    }
}
