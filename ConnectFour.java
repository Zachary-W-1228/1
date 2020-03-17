import java.util.Scanner;

public class ConnectFour {
    public static Scanner scan = new Scanner(System.in);
    //打印
    public static void printBoard(char[][]array){
        int a = array.length;
        int b = array[0].length;
        for(int i = a - 1; i >= 0; --i){
            for(int j = 0; j < b; ++j){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    //初始化棋盘
    public static void initializeBoard(char[][]array){
        int a = array.length;
        int b = array[0].length;
        for(int i = 0; i < a; ++i){
            for(int j = 0; j < b; ++j){
               array[i][j] = '-' ;
            }
        }
    }
    //落子
    public static int insertChip(char[][]array, int col, char chipType) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                break;
            }
        }
        return i ;
    }
    //判赢
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        boolean I = false;
        int count1 = 0;
        int count2 = 0;
        //横
        for(int i = 0; i < array[row].length && count1 < 4; i++) {
            if (array[row][i] == chipType) {
                count1 += 1;
            } else {
                count1 = 0;
            }
        }
        //纵
        for(int j = 0; j < array.length && count2 < 4; j++){
                if (array[j][col] == chipType){
                    count2 += 1;
                }
                else {
                    count2 = 0;
                }
        }
        if (count1 == 4 || count2 == 4){
            I = true;
        }
        return I;
    }
    //平局
    public static boolean TieTest(char array [][]){
        boolean I = true;
        int row = array.length - 1;
        for(int i = 0; i < array[1].length; i++){
            if (array[row][i] == '-'){
                I = false;
            }
        }
        return I;
    }
    //主
    public static void main (String []args) {
        //棋盘展开
        System.out.println("What would you like the height of the board to be?");
        int y = scan.nextInt();
        System.out.println("What would you like the length of the board to be?");
        int x = scan.nextInt();
        char array [][] = new char[y][x];
        initializeBoard(array);
        printBoard(array);
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        boolean IO = true;
        //游戏开始
        do{
            System.out.println("Player 1: Which column would you like to choose?");
            int P1 = scan.nextInt();
            int row1 = insertChip(array, P1, 'x');
            printBoard(array);
            if (checkIfWinner(array, P1, row1, 'x' )){
                System.out.println("Player 1 won the game!");
                IO = false;
                break;
            }
            if(TieTest(array)){
                System.out.println("Draw. Nobody wins.");
                break;
            }


            System.out.println("Player 2: Which column would you like to choose?");
            int P2 = scan.nextInt();
            int row2 = insertChip(array, P2, 'o');
            printBoard(array);
            if (checkIfWinner(array, P2, row2, 'o' )) {
                System.out.println("Player 2 won the game!");
                IO = false;
                break;
            }
            if(TieTest(array)){
                System.out.println("Draw. Nobody wins.");
                break;
            }

        }while(IO);
    }

}
