import static utility.Tools.*;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera=new Scanner(System.in);
        String[]opzioni={"App","1-Genera Random","2-Visualizzazione","3-Fine"};

        boolean esci=true;
        final int MAXNUMERI=100;
        int[] nGenerati=new int[MAXNUMERI];

        do {
            switch (Menu(opzioni,tastiera)){
                case 1:
                    System.out.println("GENERA RANDOM");
                    /*for(int i=0;i<nGenerati.length;i++){
                        nGenerati[i]= numeroRandom.nextInt(1,MAXNUMERI)+1;
                    }*/
                     generaNumeri(nGenerati,MAXNUMERI);
                    break;
                case 2:
                    System.out.println("VISUALIZZAZIONE");
                    for(int i=0;i<nGenerati.length;i++){
                        System.out.println(nGenerati[i]);
                    }
                    break;
                case 3:
                    System.out.println("FINE");
                    esci=false;
                    break;
            }
        }while (esci);
    }
    public static void generaNumeri(int[]nGenerati, int MAXNUMERI){
        Random numeroRandom=new Random();
        for(int i=0;i<nGenerati.length;i++) {
            nGenerati[i] = numeroRandom.nextInt(0, MAXNUMERI) + 1;
        }
    }
}
