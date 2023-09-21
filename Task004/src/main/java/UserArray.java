import java.util.Random;

public class UserArray {
    Random random;
    private String[][] uArray;
    private int i;
    private int j;

    private int sumAllItemsOfArray;

    public UserArray() {
        random = new Random();
    }

    private void generateUserArray(){
        if(random.nextInt(2) == 0){
            this.uArray = new String[4][4];
        }else {
            this.i = random.nextInt(2,10);
            this.j = random.nextInt(2,10);
            this.uArray = new String[this.i][this.j];
        }
        for (int i = 0, lenI = this.uArray.length; i < lenI; i++) {
            for (int j = 0, lenJ = this.uArray[i].length; j < lenJ; j++) {
                this.uArray[i][j] = Integer.toString(random.nextInt(100));
            }
        }
        if(this.random.nextInt(3) == 0){
            this.addBadItem();
        }
    }

    public String[][] getuArray() throws MyArraySizeException{
        this.generateUserArray();
        if(this.uArray.length != 4 || this.uArray[0].length != 4){
            throw new MyArraySizeException("Массив неверного размера", this.i, this.j);
        }
        return uArray;
    }

    public int getSumAllItemsOfArray() throws MyArrayDataException{
        this.sumAllItemsOfArray = 0;
        for (int k = 0, lenK = this.uArray.length; k < lenK; k++) {
            for (int l = 0, lenL = this.uArray[k].length; l < lenL; l++) {
               try{
                   this.sumAllItemsOfArray+=Integer.parseInt(this.uArray[k][l]);
               } catch (NumberFormatException e){
                    throw new MyArrayDataException("Элемент массива невозможно конвертировать в число!", k, l,this.uArray[k][l]);
               }
            }
        }
        return sumAllItemsOfArray;
    }

    private void addBadItem(){
        int i = random.nextInt(this.uArray.length);
        int j = random.nextInt(this.uArray[0].length);

        this.uArray[i][j] = this.uArray[i][j]+"BAD";

    }
}
