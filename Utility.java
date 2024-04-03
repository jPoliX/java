package Tools;
import java.util.Scanner;
    public class Utility {
        Scanner tastiera = new Scanner(System.in);

        public static void main(String[] args) {
            String[] opzioni = {"Titolo", "[1] Opzione 1", "[2] Opzione 2", "[3] Opzione 3", "[4] Exit"};
            Scanner tastiera = new Scanner(System.in);
            boolean fine = false;
            do {
                switch (menu(opzioni, tastiera)) {
                    case 1:
                        //Escuzione opzione 1
                        System.out.println("Escuzione opzione 1");
                        break;
                    case 2:
                        //Escuzione opzione 2
                        System.out.println("Escuzione opzione 2");
                        break;
                    case 3:
                        //Escuzione opzione 3
                        System.out.println("Escuzione opzione 3");
                        break;
                    case 4:
                        // exit
                        System.out.println("Uscita dal programma");
                        fine = true;
                        break;
                }
                Wait(1000);
            } while (!fine);
        }


        //Metodo Menu
        public static int menu(String[] opzioni, Scanner tastiera) {
            int scelta;
            do {
                ClrScr();
                System.out.println("----" + opzioni[0] + "----");
                for (int i = 1; i < opzioni.length; i++) {
                    System.out.println(opzioni[i]);
                }
                System.out.println("------------");
                scelta = Integer.parseInt(tastiera.nextLine());
                if (!(scelta >= 1 && scelta <= opzioni.length)) {
                    System.out.println("Scelta errata");
                    Wait(1000);
                }
                Wait(1000);
            } while (!(scelta >= 1 && scelta <= opzioni.length));
            return scelta;
        }

        //Metodo Wait
        private static void Wait(int tempo) {
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Metodo ClrScr
        private static void ClrScr() {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
