public class MyArraySizeException extends Exception{
    private int i;
    private int j;

    public MyArraySizeException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }
}
