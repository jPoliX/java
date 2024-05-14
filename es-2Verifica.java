import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantiNumeri = 0, n = 0,contaPari=0,posizione;
        do {
            System.out.println("inserisci la dimensione");
            quantiNumeri = sc.nextInt();
        } while (quantiNumeri < 8 || quantiNumeri > 11);
        int[] array = new int[quantiNumeri];

        System.out.println("inserisci un numero");
            for (int i = 0; i < array.length; i++) {
                do {
                    n = sc.nextInt();
                    array[i] = n;
                }while(n<0||n>31);
            }
            for(int i=0;i< array.length;i++){
                System.out.println("Array: "+array[i]);
            }
    }
    public static void selectionSort(int[]array){
        for (int i = 0; i < array.length - 1; i++) {
            int minimo = i;
            if(array[i]%2==0) {
                for (int j = i + 1; j < array.length; j++)
                {
                    if(array[j]%2==0) {
                        if (array[minimo] > array[j]) {
                            minimo = j;
                        }
                    }
                }
            }
            if (minimo != i) {
                int k = array[minimo];
                array[minimo] = array[i];
                array[i] = k;
            }
        }
    }

}
