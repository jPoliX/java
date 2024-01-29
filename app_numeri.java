import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {


        Scanner tastiera = new Scanner(System.in);
        int opzioni, quantiNumeri = 0, posizione = 0;
        boolean fine = true;
        int[] vetNumeri = null;
        int[] vetPari = null;
        int[] vetDispari = null;
        boolean[] nonPresenti = new boolean[102];
        for(int i=0;i<101;i++){
            nonPresenti[i]=false;
        }

        do {
            ClrScr();
            menu();
            System.out.println("seleziona un'opzione");
            opzioni = tastiera.nextInt();


            switch (opzioni) {
                case 1:
                    System.out.println(" quanti numeri vuoi generare?");
                    quantiNumeri = tastiera.nextInt();
                    vetNumeri = numeriCasuali(quantiNumeri, nonPresenti);
                    break;
                case 2:
                    System.out.println("visualizza numeri");
                    if (vetNumeri != null)
                        visualizza(vetNumeri);
                    else
                        System.out.println("non è stato creato il vettore");
                    break;
                case 3:
                    System.out.println(" numeri pari");
                    if (vetNumeri != null) {
                        vetPari = new int[quantiNumeri];
                        posizione = 0;
                        for (int i = 0; i < quantiNumeri; i++) {
                            if (vetNumeri[i] % 2 == 0) {
                                vetPari[posizione] = vetNumeri[i];
;
                                posizione = posizione + 1;
                            } else {

                            }
                        }
                    } else
                        System.out.println("non è stato creato il vettore");
                    break;
                case 4:
                    if(vetPari!=null)
                        visualizza(vetPari);
                    else System.out.println("non è stato creato il vettore");
                    break;
                case 5:
                    System.out.println("[5] numeri dispari");
                    if (vetNumeri != null) {
                        vetDispari = new int[vetNumeri.length];

                        posizione = 0;
                        for (int i = 0; i < vetNumeri.length; i++) {
                            if (vetNumeri[i] % 2 != 0) {
                                vetDispari[posizione] = vetNumeri[i];

                                posizione++;
                            } else {

                            }
                        }
                    }
                    break;
                case 6:
                    if(vetDispari!=null){
                        visualizza(vetDispari);
                    }else System.out.println("non è stato creato il vettore");
                    break;


                case 7:
                    if (vetNumeri!= null) {
                        visualizzaNonPresenti(nonPresenti);
                        visualizzaNonPresenti(nonPresenti);
                    } else
                        System.out.println("non è stato creato il vettore");
                    break;
                case 8:
                    System.out.println(" exit");
                    fine = false;
                    break;
                default:
                    System.out.println("opzione errata");
            }
            Wait(2000);
        } while (fine);
    }


    private static void menu() {
        System.out.println("== app numeri casuali");
        System.out.println("[1] genera numeri");
        System.out.println("[2] visualizza numeri");
        System.out.println("[3] genera numeri pari");
        System.out.println("[4] visualizza numeri pari");
        System.out.println("[5] genera numeri dispari");
        System.out.println("[6] visualizza numeri dispari");
        System.out.println("[7] visualizza numeri non presenti");
        System.out.println("[8] exit");
    }


    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void Wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static int[] numeriCasuali(int n, boolean[] nonPresenti){
        int casuale;
        int[] vettore = new int[n];
        Random rn = new Random();
        for(int i=0;i<n;i++) {
            casuale = rn.nextInt(1, 101);
            vettore[i] = casuale;
            nonPresenti[casuale] = true;
        }
        return vettore;
    }






    private static void visualizza(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println(i + "=" + v[i]);
        }
    }


    private static void visualizzaNonPresenti(boolean[] nonPresenti) {

        for (int i = 0; i < nonPresenti.length; i++) {
            if(nonPresenti[i]==false)
            System.out.println(i);
        }
    }
}
