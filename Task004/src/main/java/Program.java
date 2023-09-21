public class Program {
    public static void main(String[] args) {
        UserArray userArray = new UserArray();
        for (int x = 0; x < 10; x++) {
            try {
                String[][] uArray = userArray.getuArray();
                for (int i = 0, lenI = uArray.length; i < lenI; i++) {
                    for (int j = 0, lenJ = uArray[i].length; j < lenJ; j++) {
                        System.out.print(uArray[i][j]+"\t");
                    }
                    System.out.println();
                }
                System.out.printf("Сумма всех элементов массива = %d\n",userArray.getSumAllItemsOfArray());
            } catch (MyArraySizeException e){
                System.out.println(e.getMessage());
                System.out.println("Размерность массива должна быть 4x4");
                System.out.printf("Разменость вашего массива %dx%d \n", e.getI(), e.getJ());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
                System.out.printf("Позиция элемента %dx%d, значение элемента %s\n", e.getI(), e.getJ(), e.getItemOfArray());
            }
            System.out.println("********************************************************");
        }

    }
}
