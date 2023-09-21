public class MyArrayDataException extends Exception{
    private String itemOfArray;
    private int i;
    private int j;
    public MyArrayDataException(String message, int i, int j, String itemOfArray) {
        super(message);
        this.itemOfArray = itemOfArray;
        this.i = i;
        this.j = j;
    }

    public String getItemOfArray() {
        return this.itemOfArray;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }
}
