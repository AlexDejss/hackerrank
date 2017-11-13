import java.util.*;

public class Solution {

    private static final char BOMB = 'O';
    private static final char OLD_BOMB = 'o';
    private static final char EMPTY = '.';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        char[][] map_FirstBomb = new char[R][C];//1 type
        char[][] map_SecondBomb = new char[R][C];//2 type
        char[][] map_ThirdBomb = new char[R][C];//3 type
        char[][] map_ForthBomb = new char[R][C];//4 type

        // 1 2 3 2 1 2 3...
        // 1 2 3 2 4 2 3 2 4 2 3 2 4 2...

        for (int i = 0; i < R; i++) {
            String row = scanner.next();
            for (int j = 0; j < C; j++) {
                map_FirstBomb[i][j] = row.charAt(j);
                map_ThirdBomb[i][j] = row.charAt(j) == BOMB ? OLD_BOMB : row.charAt(j);
                map_SecondBomb[i][j] = BOMB;
            }
        }

        calcLast(map_ThirdBomb, map_ForthBomb);

//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map_FirstBomb[i]).replaceAll("[^A-Z.]", ""));
//        }
//        System.out.println();
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map_SecondBomb[i]).replaceAll("[^A-Z.]", ""));
//        }
//        System.out.println();
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map_ThirdBomb[i]).replaceAll("[^A-Z.]", ""));
//        }
//        System.out.println();
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map_ForthBomb[i]).replaceAll("[^A-Z.]", ""));
//        }

        char[][] answer;

        if(N == 1){
            answer = map_FirstBomb;
        }else if(N%2 == 0){
            answer = map_SecondBomb;
        }else if((N-2)%4 == 1){
            answer = map_ThirdBomb;
        }else{
            answer = map_ForthBomb;
        }


        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(answer[i]).replaceAll("[^A-Z.]", ""));
        }

    }

    static void calcLast(char third[][], char forth[][]){
        for (int i = 0; i < third.length; i++) {
            for (int j = 0; j < third[i].length; j++) {

                boolean fine = true;

                if(i < third.length-1 && third[i+1][j] == OLD_BOMB){fine = false;}
                if(i > 0 && third[i-1][j] == OLD_BOMB){fine = false;}
                if(j < third[i].length-1 && third[i][j+1] == OLD_BOMB){fine = false;}
                if(j > 0 && third[i][j-1] == OLD_BOMB){fine = false;}
                if(fine && third[i][j] != OLD_BOMB){
                    third[i][j] = BOMB;
                }
            }
        }
        for (int i = 0; i < third.length; i++) {
            for (int j = 0; j < third[i].length; j++) {

                if(third[i][j] == OLD_BOMB){
                    third[i][j] = EMPTY;
                }
            }
        }
        
        for (int i = 0; i < third.length; i++) {
            System.arraycopy(third[i], 0, forth[i], 0, third[i].length);
        }
        for (int i = 0; i < forth.length; i++) {
            for (int j = 0; j < forth[i].length; j++) {

                if(forth[i][j] == BOMB){
                    forth[i][j] = OLD_BOMB;
                }
            }
        }
        
        for (int i = 0; i < forth.length; i++) {
            for (int j = 0; j < forth[i].length; j++) {

                boolean fine = true;

                if(i < forth.length-1 && forth[i+1][j] == OLD_BOMB){fine = false;}
                if(i > 0 && forth[i-1][j] == OLD_BOMB){fine = false;}
                if(j < forth[i].length-1 && forth[i][j+1] == OLD_BOMB){fine = false;}
                if(j > 0 && forth[i][j-1] == OLD_BOMB){fine = false;}
                if(fine && forth[i][j] != OLD_BOMB){
                    forth[i][j] = BOMB;
                }
            }
        }
        for (int i = 0; i < forth.length; i++) {
            for (int j = 0; j < forth[i].length; j++) {

                if(forth[i][j] == OLD_BOMB){
                    forth[i][j] = EMPTY;
                }
            }
        }
        

    }

    static void calcLast(char arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                boolean fine = true;

                if(i < arr.length-1 && arr[i+1][j] == OLD_BOMB){fine = false;}
                if(i > 0 && arr[i-1][j] == OLD_BOMB){fine = false;}
                if(j < arr[i].length-1 && arr[i][j+1] == OLD_BOMB){fine = false;}
                if(j > 0 && arr[i][j-1] == OLD_BOMB){fine = false;}
                if(fine && arr[i][j] != OLD_BOMB){
                    arr[i][j] = BOMB;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if(arr[i][j] == OLD_BOMB){
                    arr[i][j] = EMPTY;
                }
            }
        }
    }



}
/*
3 6 2
..O..O
.OO.O.
OOOO.O

3 6 3
..O..O
.OO.O.
OOOO.O

3 6 1
..O..O
.OO.O.
OOOO.O

 */