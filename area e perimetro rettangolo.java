import java.util.Scanner;
public class main {
    //il seguente programa permette di calcolare l'area e il perimetro di un rettangolo
    //input: base ,altezza
    //output : area ,perimetro
    public static void main(String[] args) {
        Scanner keyBoard= new Scanner(System.in);//serve per leggere i dati dalla tastiera
        //dichiarazione variabile
        double basse , altezza , perimetro , area;
        //input dati
        System.out.println("inserire la basse");
        basse=keyBoard.nextDouble();
        if(basse!=0){
            System.out.println("inserisce altezza");
            altezza= keyBoard.nextDouble();
            if (altezza!=0){
                //calcolare il perimetro
                perimetro=(basse+altezza)*2;
                //calcolare area
                area=(basse*altezza);
                //risultato
                System.out.println("basse"+basse+"altezza"+altezza+"area"+area+"perimetro"+perimetro);
            }else{
                System.out.println("errato la valore altezza");
            }
        }else{
            System.out.println("errato la valore basse");
        }
    }
}
