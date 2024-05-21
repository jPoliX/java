import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantiNumeri = 0, n = 0,contatorePari=0,indice=0;
        do {
            System.out.println("inserisci la dimensione");
            quantiNumeri = sc.nextInt();
        } while (quantiNumeri < 8 || quantiNumeri > 11); //controllo se la dimensione è coerente
        int[] array = new int[quantiNumeri];

        System.out.println("inserisci un numero");
            for (int i = 0; i < array.length; i++) {
                do {
                    n = sc.nextInt();
                    array[i] = n; //inserisco i numeri nell'array
                }while(n<0||n>31); //controllo se i valori sono coerenti
            }
            int[] indiciPari = new int[quantiNumeri]; // memorizza gli indici dei numeri pari
            
             for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                indiciPari[contatorePari] = i;
                contatorePari++;
            }
        }
           int[] arrayPari = new int[contatorePari];
        for (int i = 0; i < contatorePari; i++) {
            arrayPari[i] = array[indiciPari[i]];
        }
        selectionSort(arrayPari);

        for (int i = 0; i < contatorePari; i++) {
            array[indiciPari[i]] = arrayPari[i];
        }
            
            for(int i=0;i<array.length;i++){
                System.out.println("Array ordinato: "+array[i]);
            }
            
    }
    public static void selectionSort(int[]array){
      for(int i = 0; i < array.length-1; i++) {
            int minimo = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[minimo]>array[j]) {
                    minimo = j;
                }
            }
            if(minimo!=i) {
                int k = array[minimo];
                array[minimo]= array[i];
                array[i] = k;
            }
        }
}
}
