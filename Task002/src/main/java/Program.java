
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final int WIN_COUNT = 5;// Вигрышная комбинация
    private static final char DOT_HUMAN = 'X'; //Фишка игрока - человек
    private static final char DOT_AI = '0'; //Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; //Признак пустого поля

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX;// Размерность игрового поля
    private static int fieldSizeY;// Размерность игрового поля

    public static void main(String[] args) {
        while(true){
            initialize(15,9);
            printField();
            while(true){
                humanTurn();
                printField();
                if(checkGameState(DOT_HUMAN, "Вы победили")){
                    printField();
                    break;
                }
                aiTurn();
                printField();
                if(checkGameState(DOT_AI, "Компьютер победил!")){
                    printField();
                    break;
                }
            }
            System.out.println("Желаете сыграть ещё раз? (Y - да)");
            if(!scanner.next().equalsIgnoreCase("Y")){
                break;
            }
        }

    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize(int fX, int fY){
        fieldSizeX = fX;
        fieldSizeY = fY;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0 ; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля 
     */
    private static void printField(){
        System.out.println();
        System.out.print("+\t");
        for (int x = 0; x < fieldSizeY*2+1; x++) {
            System.out.print((x % 2 == 0 ? "-" : x / 2 +1 ));
        }
        System.out.println();
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x+1+"\t|");
            for (int y = 0 ; y < fieldSizeY; y++) {
                System.out.print(field[x][y]+"|");
            }
            System.out.println();
        }
        for (int x = 0; x < fieldSizeY*2+2; x++) {
            System.out.print("-");

        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn(){
        int x, y;
        do{
            System.out.println();
            System.out.print("Введите координаты хода X и Y от 1 до 3\nчерез пробел:");
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;
        }while(!isCellValid(x,y) || !isCellEmpty(x,y));

        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     * @param x
     * @param y
     * @return
     */
    public static boolean isCellValid(int x, int y){
        return x >=0 && x  < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn(){
        int x, y;
        do{
            System.out.print("Введите координаты хода X и Y от 1 до 3\nчерез пробел:");
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }while(!isCellEmpty(x,y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     * @param c фишка игрока
     * @param s победный слоган
     */
    private static boolean checkGameState(char c, String s){

        if(checkWin(c)){
            System.out.println(s);
            return true;
        }
        if(checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false;//Игра продолжается
    }

    /**
     * Проверка победы.
     * @param c
     * @return
     */
    private static boolean checkWin(char c){
        int count = 0;
        //Проверка по  горизонталям
        if(field.length > field[0].length){
            for (int rows = 0; rows <= field.length-1; rows++) {
                count = 0;
                for (int row = rows, column = field[0].length-1; row >= 0 && column >=0; row--, column--) {
//                    System.out.print(field[row][column] + "\t");
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
            for (int columns = field[0].length - 1; columns >= 0; columns--) {
                count = 0;
                for (int row = field.length-1, column = columns; row >= 0 && column >= 0 ; row--, column--){
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
            for (int rows = 0; rows <= field.length - 1 ; rows++) {
                count = 0;
                for (int row = rows, column = 0; row >= 0 && column <= field[0].length - 1; row--, column++) {
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
            for (int columns = field[0].length - 1; columns >=0 ; columns--) {
                count = 0;
                for (int row = field.length - 1, column = columns; row >= 0 && column <= field[0].length - 1; row--, column++) {
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
        }
        else {
            for (int columns = field[0].length-1; columns >= 0; columns--) {
                count = 0;
                for (int column = columns, row = 0; column <= field[0].length - 1 && row <= field.length - 1; column++, row++) {
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
            for (int rows = field.length - 1; rows > 0; rows--) {
                count = 0;
                for (int row = rows, column = 0; row <= field.length - 1 && column < field[0].length; row++, column++) {
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
            for (int columns = 0; columns <= field[0].length - 1; columns++) {
                count = 0;
                for (int column = columns, row = 0; column >= 0 && row <= field.length - 1; column--, row++) {
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
            for (int rows = field.length - 1; rows >=0 ; rows--) {
                count = 0;
                for (int column = field[0].length - 1, row = rows; column <= field[0].length - 1 && row <= field.length - 1; column--, row++) {
                    if(field[row][column]== c)
                        count++;
                    if(count == WIN_COUNT)
                        return true;
                }
            }
        }
        // проверка по горизонталям
        for (int row = 0; row < field.length; row++) {
            count = 0;
            for (int column = 0; column < field[0].length; column++) {
                if(field[row][column]== c)
                    count++;
                if(count == WIN_COUNT)
                    return true;
            }
        }

        for (int column = 0; column < field[0].length; column++) {
            count = 0;
            for (int row = 0; row < field.length; row++) {
                if(field[row][column]== c)
                    count++;
                if(count == WIN_COUNT)
                    return true;
            }
        }
        return false;
    }

    /**
     * Проверка на ничью.
     * @return
     */
    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0 ; y < fieldSizeY; y++) {
                if(isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }



}
