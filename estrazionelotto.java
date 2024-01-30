import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fine = true;
        int quantiNumeri;
        String[] Opzioni = {"Estrazioni lotto", "[1] Ruota Venezia", "[2] Visualizza", "[3] Exit"};
        //Ruota venezia: estrarre 5 numeri casuali nel range 1-90
        //Visualizza:visualizzare i valori estratti
        //Impostare le opzioni
        int[] vetNumeri = null;
        do {
            switch (menu(Opzioni, sc)) {
                case 1:
                    System.out.println("Ruota Venezia");
                    estraiNumeri2();
                    break;
                case 2:
                    System.out.println("Opzione 2");
                    if (estraiNumeri2() != null) {
                        visualizza(estraiNumeri2());
                    } else System.out.println("non è stato creato il vettore");
                    break;
                case 3:
                    System.out.println("esci");
                    fine = false;
                    break;
            }
        } while (fine);


    }

    private static int menu(String[] Opzioni, Scanner sc) {
        int scelta;
        do {
            cls();
            System.out.println("----" + Opzioni[0] + "----");
            for (int i = 1; i < Opzioni.length; i++) {
                System.out.println(Opzioni[i]);
            }
            System.out.println("--------");
            scelta = sc.nextInt();
            attesa(1000);
        } while (scelta < 1 || scelta > Opzioni.length - 1);


        return scelta;
    }

    private static int[] numeriCasuali(int n) {
        int casuale;
        int[] vettore = new int[n];
        Random rn = new Random();
        for (int i = 0; i < n; i++) {
            casuale = rn.nextInt(1, 101);
            vettore[i] = casuale;
        }
        return vettore;
    }

    private static void visualizza(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println(i + "=" + v[i]);
        }
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void attesa(int secondi) {
        try {
            Thread.sleep(secondi);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int[] estraiNumeri2() {
        Random casuale = new Random();
        int[] numeri = new int[5];
        int contaNumeri = 0;
        int numeroEstratto;
        boolean trovato;
        while (contaNumeri < 5) {
            numeroEstratto = casuale.nextInt(90) + 1;
            trovato = false;
            for (int i = 0; i < 5 && !trovato; i++)
                trovato = numeroEstratto == numeri[i];
            /*{
                if (numeroEstratto == numeri[i]) {
                    trovato = true;
                }*/

            if (!trovato) {
                numeri[contaNumeri] = numeroEstratto;
                contaNumeri++;
            }
        }
        return numeri;
    }
}
