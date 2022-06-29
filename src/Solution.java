/**
 Thrilling Teleporters allows players to randomize the teleporters each game. However, during development they found that sometimes this can lead to boards where a player cannot get to the end of the board. We want to figure out if this has happened.

 You'll be given the following inputs:
 - A collection of teleporter strings
 - The number of sides on the die
 - The square the player starts on
 - The last square on the board

 Write a function that returns whether or not it is possible to get to the last square from the starting square in any number of turns.

 Examples:
 teleporters1 = ["10,8", "11,5", "12,7", "13,9"]
 +------------------+
 |        +-----+   |
 v        v     |   |
 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
 ^     ^          |   |
 +-----|----------+   |
 +--------------+
 // 4

 With a 4 sided die, starting at square 0 with a board ending at square 20 (as pictured above)
 No matter what you roll, it's not possible to get past the teleporters from 10-13.
 finishable(teleporters1, 4, 0, 20) => False

 If an additional teleporter was added from square 2 to square 15, this would be possible to finish.
 teleporters2 = ["10,8", "11,5", "12,7", "13,9", "2,15"]
 finishable(teleporters2, 4, 0, 20) => True

 But if we started on square 9, then it is still impossible as square 2 cannot be reached.
 finishable(teleporters2, 4, 9, 20) => False

 Additional Input:
 teleporters3 = ["10,8", "11,5", "12,1", "13,9", "2,15"]
 teleporters4 = ["2,4", "9,8", "11,7", "12,6", "18,14",
 "19,16", "20,9", "21,14", "22,6", "23,26",
 "25,10", "28,19", "29,27", "31,29", "38,33",
 "39,17", "41,30", "42,28", "45,44", "46,36"]
 teleporters5 = ["4,21", "11,18", "13,17", "16,17", "18,21",
 "22,11", "26,25", "27,9", "31,38", "32,43",
 "34,19", "35,19", "36,39", "38,25", "41,31"]

 Complexity variable:
 B = size of the board
 Note: The number of teleporters and size of the die are bounded by B.

 All Test Cases:
 die, start, end
 finishable(teleporters1, 4,   0,    20)  => False (Above)
 finishable(teleporters2, 4,   0,    20)  => True  (Above)
 finishable(teleporters2, 4,   9,    20)  => False (Above)
 finishable(teleporters3, 4,   9,    20)  => True
 finishable(teleporters4, 4,   0,    50)  => False
 finishable(teleporters4, 6,   0,    50)  => True
 finishable(teleporters5, 4,   0,    50)  => True
 finishable(teleporters5, 2,   0,    50)  => False
 **/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] argv) {
        // String[] teleporters1 = {"3,1", "4,2", "5,10"};
        // String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
        // String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
        //                         "71,58", "74,77", "78,76", "80,73", "92,85"};
        // String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
        //                         "82,75", "4,1", "84,79", "54,4", "88,53",
        //                         "91,37", "60,57", "61,7", "62,51", "31,19"};

        String[] teleporters1 = {"10,8", "11,5", "12,7", "13,9"};
        String[] teleporters2 = {"10,8", "11,5", "12,7", "13,9", "2,15"};
        String[] teleporters3 = {"10,8", "11,5", "12,1", "13,9", "2,15"};
        String[] teleporters4 = {"2,4", "9,8", "11,7", "12,6", "18,14",
                "19,16", "20,9", "21,14", "22,6", "23,26",
                "25,10", "28,19", "29,27", "31,29", "38,33",
                "39,17", "41,30", "42,28", "45,44", "46,36"};
        String[] teleporters5 = {"4,21", "11,18", "13,17", "16,17", "18,21",
                "22,11", "26,25", "27,9", "31,38", "32,43",
                "34,19", "35,19", "36,39", "38,25", "41,31"};

        // System.out.println(destinations(teleporters1,  6,   0,    20));
        // System.out.println(destinations(teleporters2,  6,  46,   100));
        // System.out.println(destinations(teleporters2, 10,   0,    50));
        // System.out.println(destinations(teleporters3, 10,  95,   100));
        // System.out.println(destinations(teleporters3, 10,  70,   100));
        // System.out.println(destinations(teleporters4,  6,   0,   100));



        System.out.println(finishable(teleporters1, 4,   0,    20));
        System.out.println(finishable(teleporters2, 4,   0,    20));
        // System.out.println(destinations(teleporters2, 10,   0,    50));
        // System.out.println(destinations(teleporters3, 10,  95,   100));
        // System.out.println(destinations(teleporters3, 10,  70,   100));
        // System.out.println(destinations(teleporters4,  6,   0,   100));



    }

    ///destinations(teleporters1, 6, 0, 20) => [1, 2, 6, 10]
    public static Set<Integer> destinations(String[] teleporters, int die_sides , int startIndex, int max){
        Set<Integer> ret = new HashSet<>();
        HashMap<Integer,Integer> routes = generateRoutes(teleporters);
        for(int i=1;i<=die_sides;i++){
            int newIndex = startIndex + i;
            if(newIndex<=max){
                if(routes.containsKey(newIndex)) ret.add(routes.get(newIndex));
                else ret.add(newIndex);
            }
        }
        return ret;
    }


    public static boolean finishable(String[] teleporters, int die_sides , int startIndex, int max){
        HashMap<Integer,Integer> routes = generateRoutes(teleporters);
        boolean [] visited = new boolean[max+1];
        return helper(routes,visited,startIndex,die_sides,max);

    }


    public static boolean helper(HashMap<Integer,Integer> routes,boolean[] visited ,  int index , int die_sides, int max){

        if(index == max) return true;
        if(visited[index]) return false;
        for(int i=1;i<=die_sides;i++){
            boolean flag = false;
            int newIndex = index + i;
            if(newIndex<=max){
               // visited[newIndex] = true;
                if(routes.containsKey(newIndex)){
                    visited[routes.get(newIndex)] = true;
                    if (helper(routes,visited,routes.get(newIndex),die_sides,max)){
                        flag =  true;
                    }
                }else {
                      if (helper(routes,visited,newIndex,die_sides,max)){
                          flag =  true;
                      }
                }
            }
            if (flag){
                return true;
            }
        }

        return false;
    }

    public static HashMap<Integer,Integer> generateRoutes(String [] teleporters){
        HashMap<Integer,Integer> routes = new HashMap<>();

        for(String teleporter : teleporters){
            String [] s = teleporter.split(",");
            routes.put(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
        return routes;
    }
}
