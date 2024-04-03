import java.util.Scanner;
import static Tools.Utility.*;
public class Main {
    public static void main(String[] args) {
        final int nContratti=3;
        int contaContatti=0;
        boolean uscita=false;
        Scanner tastiera=new Scanner(System.in);
        Persona[]gestore=new Persona[nContratti];
        String[]opzioni={"Gestore telefonico","1-Inserimento","2-Visualizzazione","3-Fine"};

        do{
            switch (menu(opzioni,tastiera)){
                case 1:
                    if(contaContatti<nContratti){
                        gestore[contaContatti]=LeggiContatti(tastiera);
                        contaContatti++;
                    }else System.out.println("non ci sono più contratti da vendere");
                    break;
                case 2:
                    if(contaContatti>0){
                        Visualizza(gestore,contaContatti);
                    }else System.out.println("Non ci sono contratti da visualizzare");

                    break;
                case 3:
                  uscita=true;
                    break;
            }
        }while (!uscita);
        System.out.println("Fine programma");
    }
    public static Persona LeggiContatti(Scanner tastiera){
        Persona contatto=new Persona();
        boolean controllo=false;
        String[]opzioni={"Tipo di abbonamento","1-Cellulare","2-Abitazione","3-Azienda"};
        System.out.println("Inserisci il nome");
        contatto.nome=tastiera.nextLine();
        System.out.println("Inserisci il cognome");
        contatto.cognome=tastiera.nextLine();
        System.out.println("Inserisci il numero di telefono");
        contatto.numDiTelefono=tastiera.nextLine();
        int scelta;
        do {
            scelta=menu(opzioni,tastiera);
            switch (scelta) {
                case 1 -> contatto.tipo = Tipologia.cellulare;
                case 2 -> contatto.tipo = Tipologia.abitazione;
                case 3 -> contatto.tipo = Tipologia.azienda;
            }
        }while (scelta>3 || scelta<1);
        return contatto;
    }
    public static void Visualizza(Persona gestore[],int contaContatti){
        for(int i=0;i< contaContatti;i++){
            System.out.println(gestore[i].anagrafica());
        }
    }
}



CLASSE PERSONA
enum Tipologia{
    cellulare,abitazione,azienda;
}
public class Persona {
    public String nome;
    public String cognome;
    public String numDiTelefono;
    public Tipologia tipo;
    public String anagrafica(){
        return String.format("Nome: %s Cognome: %s Telefono: %s Tipo: %s",nome,cognome,numDiTelefono,tipo);
    }
}
