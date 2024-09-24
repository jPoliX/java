import static utility.Tools.*;
/*
Generare un valore contenente numeri casuali
*/
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String[] opzioni = {"Menu", "1- Genera Random", "2- Visualizzazione", "3-Verifica","4- Fine"};
        boolean esci = true;
        int[] nEstratti = null;
        final int MAXNUMERI = 50;
        int[] nEstratti2 = new int[MAXNUMERI];
        int numero=0;
        //int[] nEstratti2;
        do {
            switch (Menu(opzioni, tastiera)) {
                case 1:
                    System.out.println("Generazione");
                    generaNumeri2(nEstratti2);
                    break;
                case 2:
                    System.out.println("Visualizzazione");
                   Visualizza(nEstratti2);
                    break;
                case 3:
                    System.out.println("inserisci un numero: ");
                    numero=(Integer.parseInt(tastiera.nextLine()));
                    int posizione=presente(nEstratti2,numero);
                    System.out.println("Posizione: "+ posizione);
                    break;
                case 4:
                    System.out.println("Fine");
                    esci = false;
                    break;
            }
        } while (esci);
    }

    public static void generaNumeri2(int[] vettore) {
        Random numeroRandom = new Random();
        for (int i = 0; i < vettore.length; i++) {
            vettore[i] = numeroRandom.nextInt(0, 99) + 1;
        }
    }
    public static void Visualizza(int[] nEstratti2){
        int cont=0;
        for(int i: nEstratti2){
            System.out.printf("%3d", i);
            cont++;
            if(cont==10){
                cont=0;
                System.out.println();
            }
        }
    }
    public static int presente(int[]vettore, int numero){
        int posizione=0;
        for(int i=0;i< vettore.length-1;i++){
                if(numero==vettore[i]){
                    posizione=i;
            }
        }
        return posizione;
    }
}
