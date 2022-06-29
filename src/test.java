//import java.util.*;
///*
///*
//We are working on a security system for a badged-access room in our company's building.
//
//Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
//
//1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)
//
//2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)
//
//Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.
//
//badge_records_1 = [
//  ["Martha",   "exit"],
//  ["Paul",     "enter"],
//  ["Martha",   "enter"],
//  ["Steve",    "enter"],
//  ["Martha",   "exit"],
//  ["Jennifer", "enter"],
//  ["Paul",     "enter"],
//  ["Curtis",   "exit"],
//  ["Curtis",   "enter"],
//  ["Paul",     "exit"],
//  ["Martha",   "enter"],
//  ["Martha",   "exit"],
//  ["Jennifer", "exit"],
//  ["Paul",     "enter"],
//  ["Paul",     "enter"],
//  ["Martha",   "exit"],
//  ["Paul",     "enter"],
//  ["Paul",     "enter"],
//  ["Paul",     "exit"],
//  ["Paul",     "exit"]
//]
//
//Expected output: ["Paul", "Curtis", "Steve"], ["Martha", "Curtis", "Paul"]
//
//Other test cases:
//
//badge_records_2 = [
//  ["Paul", "enter"],
//  ["Paul", "exit"],
//]
//
//Expected output: [], []
//
//badge_records_3 = [
//  ["Paul", "enter"],
//  ["Paul", "enter"],
//  ["Paul", "exit"],
//  ["Paul", "exit"],
//]
//
//Expected output: ["Paul"], ["Paul"]
//
//badge_records_4 = [
//  ["Paul", "enter"],
//  ["Paul", "exit"],
//  ["Paul", "exit"],
//  ["Paul", "enter"],
//]
//
//Expected output: ["Paul"], ["Paul"]
//
//n: length of the badge records array
//
//state - 1 ,  exit -1 = 0 stae > 1  ->. exit is not done ->. add exit list
//state<0  enter is o enter list
//
// enter-> enter -> exit -> exit
//*/
//
//
//public class Solution {
//    public static void main(String[] argv) {
//
//        String badgeRecords1[][] = new String[][] {
//                {"Martha",   "exit"},
//                {"Paul",     "enter"},
//                {"Martha",   "enter"},
//                {"Steve",    "enter"},
//                {"Martha",   "exit"},
//                {"Jennifer", "enter"},
//                {"Paul",     "enter"},
//                {"Curtis",   "exit"},
//                {"Curtis",   "enter"},
//                {"Paul",     "exit"},
//                {"Martha",   "enter"},
//                {"Martha",   "exit"},
//                {"Jennifer", "exit"},
//                {"Paul",     "enter"},
//                {"Paul",     "enter"},
//                {"Martha",   "exit"},
//                {"Paul",     "enter"},
//                {"Paul",     "enter"},
//                {"Paul",     "exit"},
//                {"Paul",     "exit"}
//        };
//
//        String badgeRecords2[][] = new String[][] {
//                {"Paul", "enter"},
//                {"Paul", "exit"},
//        };
//
//        String badgeRecords3[][] = new String[][] {
//                {"Paul", "enter"},
//                {"Paul", "enter"},
//                {"Paul", "exit"},
//                {"Paul", "exit"},
//        };
//
//        String badgeRecords4[][] = new String[][] {
//                {"Paul", "enter"},
//                {"Paul", "exit"},
//                {"Paul", "exit"},
//                {"Paul", "enter"},
//        };
//
//        helper(badgeRecords1);
//
//    }
//
//    public static void helper(String [][] badgeRecords ){
//
//        HashMap<String ,List<String>> hm = new HashMap<String,List<String>>();
//        for(int i = 0;i<badgeRecords.length;i++){
//            String key = badgeRecords[i][0];
//            String val = badgeRecords[i][1];
//            List<String> l;
//            if(hm.containsKey(key)){
//                l = hm.get(key);
//                l.add(val);
//            }else{
//                l = new ArrayList<>();
//                l.add(val);
//            }
//            hm.put(key,l);
//        }
//        //state - 1 ,  exit -1 = 0 stae > 1  ->. exit is not done ->. add exit list
////state<0  enter is o enter list
//
//        Set<String> enter = new LinkedHashSet<>();
//        Set<String> exit = new LinkedHashSet<>();
//        for(Map.Entry<String,List<String>> entry : hm.entrySet()){
//            int state =0 ;
//            boolean in = false;
//            String name = entry.getKey();
//            for(String val : entry.getValue()){
//                if(val == "exit" && in != true){
//                    exit.add(name);
//                }
//                if(val == "enter" && in == true){
//                    enter.add(name);
//                }
//                in =!in;
//            }
//            if (in) {
//                enter.add(name);
//            }
//
//        }
//
//
//        System.out.println(enter.toString());
//        System.out.println(exit.toString());
//    }
//}
//
// */

import java.io.*;
import java.util.*;
public class test {
    public static void main(String[] argv) {

        String badgeRecords1[][] = new String[][] {
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Martha",   "enter"},
                {"Steve",    "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "enter"},
                {"Paul",     "enter"},
                {"Curtis",   "exit"},
                {"Curtis",   "enter"},
                {"Paul",     "exit"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "exit"},
                {"Paul",     "enter"},
                {"Paul",     "enter"},
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Paul",     "enter"},
                {"Paul",     "exit"},
                {"Paul",     "exit"}
        };

        String badgeRecords2[][] = new String[][] {
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String badgeRecords3[][] = new String[][] {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String badgeRecords4[][] = new String[][] {
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
        };

        helper(badgeRecords1);

    }

    public static void helper(String [][] badgeRecords ){

        HashMap<String , List<String>> hm = new HashMap<String,List<String>>();
        for(int i = 0;i<badgeRecords.length;i++){
            String key = badgeRecords[i][0];
            String val = badgeRecords[i][1];
            List<String> l;
            if(hm.containsKey(key)){
                l = hm.get(key);
                l.add(val);
            }else{
                l = new ArrayList<>();
                l.add(val);
            }
            hm.put(key,l);
        }
        //state - 1 ,  exit -1 = 0 stae > 1  ->. exit is not done ->. add exit list
//state<0  enter is o enter list

        Set<String> enter = new LinkedHashSet<>();
        Set<String> exit = new LinkedHashSet<>();
        for(Map.Entry<String,List<String>> entry : hm.entrySet()){
            boolean in = false;
            String name = entry.getKey();
            for(String val : entry.getValue()){
                if(val == "exit" && in != true){
                    exit.add(name);
                }
                else if(val == "enter" && in == true){
                    enter.add(name);
                }else {
                    if (val == "exit") in = false;
                    if (val == "enter") in = true;
                }
            }
            if (in) {
                enter.add(name);
            }

        }


        System.out.println(enter.toString());
        System.out.println(exit.toString());
    }
}