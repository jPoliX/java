import static Tools.Utility.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       String[]opzioni={"LA LIBRERIA","1-Inserimento","2-Ricerca","3-Visualizza","4-Elimina","5-Fine"};
       Scanner tastiera=new Scanner(System.in);
       boolean uscita=false;
       final int maxLibri=5;
       Libri[]zaino=new Libri[maxLibri];
       int contaLibri=0;
       do{
           switch (menu(opzioni,tastiera)){
               case 1:
                   if(contaLibri<maxLibri){
                       Libri nuovoLibro=LeggiLibro(tastiera,true);
                       if(!Presente(zaino,contaLibri,nuovoLibro)){
                           zaino[contaLibri]=nuovoLibro;
                           contaLibri++;
                       }else System.out.println("il libro è già presente nello zaino");
                   }
                   break;
               case 2:
                   if(contaLibri>0){
                       Libri trovato=LeggiLibro(tastiera,false);
                       if(Presente(zaino,contaLibri,trovato)){
                           System.out.println("il libro è presente");
                       }else System.out.println("il libro non è presente");
                   }
                   break;
               case 3:
                   if(contaLibri>0){
                       Visualizza(zaino,contaLibri);
                   }else System.out.println("non ci sono libri da visualizzare");
                   break;
               case 4:
                   if(contaLibri>0){
                       Libri trovato=LeggiLibro(tastiera,false);
                       int posizione=PosizioneLibro(trovato, zaino, contaLibri);
                       if(posizione!=-1){
                           contaLibri=CancellaLibro(posizione,zaino,contaLibri);
                           System.out.println("Libro eliminato");
                       }else System.out.println("nessun libro da eliminare");
                   }
                   break;
               case 5:uscita=true;
               break;
           }
       }while(!uscita);
        System.out.println("Fine programma");
    }
    public static Libri LeggiLibro(Scanner tastiera,boolean si){
        Libri descrizione=new Libri();
        System.out.println("inserisci il titolo del libro");
        descrizione.titolo=tastiera.nextLine();
        if(si) {
            System.out.println("inserisci l'autore del libro");
            descrizione.autore = tastiera.nextLine();
            System.out.println("inserisci la materia del libro");
            descrizione.materia = tastiera.nextLine();
            System.out.println("inserisci il numero di pagine");
            descrizione.nPagine = tastiera.nextLine();
        }
        return descrizione;
    }
    public static void Visualizza(Libri[]zaino,int contaLibri){
        for(int i=0;i< contaLibri;i++){
            System.out.println(zaino[i].visualizza());
        }
    }
    public static boolean Presente(Libri[]zaino,int contaLibri, Libri nuovoLibro){
        for(int i=0;i<contaLibri;i++){
            if(zaino[i].titolo.equals(nuovoLibro.titolo)){
                return true;
            }
        }
        return false;
    }
    public static int PosizioneLibro(Libri nuovoLibro,Libri[]zaino,int contaLibri){
        for(int i=0;i<contaLibri;i++){
            if(zaino[i].titolo.equals(nuovoLibro.titolo)){
                return i;
            }
        }
        return -1;
    }
    public static int CancellaLibro(int posizione,Libri[]zaino,int contaLibri){
        if(posizione!= zaino.length){
            for(int i=posizione;i<contaLibri-1;i++){
                zaino[i]=zaino[i+1];
            }
        }
        return --contaLibri;
    }
}



CLASSE LIBRI
public class Libri {
    public String titolo;
    public String autore;
    public String nPagine;
    public String materia;
    public String visualizza(){
        return String.format("Titolo: %s Autore: %s Materia: %s Numero di pagine: %s",titolo,autore,materia,nPagine);
    }
}

