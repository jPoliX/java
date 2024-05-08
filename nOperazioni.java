public class Main {
    public static void main(String[] args) {
        int elemento=0,contatore=0;
       int []array={3,7,1,8,4,45,6,0,23,21};
       int []array2={3,7,1,8,4,45,6,0,23,21};
       for(int i=0;i< array.length;i++){
           array2[elemento]=array[i];
           elemento++;
       }
       selectionSort(array,contatore);
       for(int i=0;i<array.length;i++) {
           System.out.println("Array: "+array[i]);
       }
        System.out.println("Numero di azioni: "+contatore);
    }
    public static void selectionSort(int [] array,int contatore) {
        for (int i = 0; i < array.length - 1; i++) {
                int minimo = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[minimo] > array[j]) {
                        minimo = j;
                        contatore++;
                    }
                }
                if (minimo != i) {
                    int k = array[minimo];
                    array[minimo] = array[i];
                    array[i] = k;
                    contatore++;
                }
        }
    }
}
