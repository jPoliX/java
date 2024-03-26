import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nome1,nome2;
        int fiammiferi=21,quanti=0;
        System.out.println("inserisci il nome del primo giocatore");
        nome1=sc.nextLine();
        System.out.println("inserisci il nome del secondo giocatore");
        nome2=sc.nextLine();
        while(fiammiferi>0){
            System.out.println("E' il turno di: "+nome1);
            System.out.println("Quanti fiammiferi vuoi prelevare? MAX 3");
            if (fiammiferi <= 0) {
                System.out.println(nome1 + " ha vinto!");
                break;
            }
            do {
                quanti = sc.nextInt();
            }while(quanti<1||quanti>3);

            fiammiferi=fiammiferi-quanti;
            System.out.println("E' il turno di: "+nome2);
            System.out.println("Quanti fiammiferi vuoi prelevare? MAX 3");
            if (fiammiferi <= 0) {
                System.out.println(nome2 + " ha vinto!");
                break;
            }
            do {
                quanti = sc.nextInt();
            }while(quanti<1||quanti>3);
            fiammiferi=fiammiferi-quanti;
        }
    }
}
