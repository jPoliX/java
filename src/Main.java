import java.util.Scanner;
import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        int contacontatti = 0, contaNascosti=0;

        final int nContratti = 3;
        boolean uscita = false;
        Scanner tastiera = new Scanner(System.in);
        Persona[] gestore = new Persona[nContratti];
        Persona []nascosti=new Persona[nContratti];
        String[] opzioni = {"Gestore telefonico", "1-Inserimento","2-Visualizza","3-Visualizza nascosti","4-Elimina","5-Fine"};
        do {
            switch (menu(opzioni, tastiera)) {
                case 1:
                    if (contacontatti < nContratti) {
                        Persona NuovoContatto = LeggiContatto(true, tastiera,nascosti,true,contaNascosti);
                        if (!Presente(gestore, NuovoContatto, contacontatti)) {
                            gestore[contacontatti] = NuovoContatto;
                            contacontatti++;
                            
                            if (NuovoContatto.password != null) {
                                nascosti[contaNascosti] = NuovoContatto;
                                contaNascosti++;
                            }

                        } else {
                            System.out.println("Il contatto è già presente nella collezione.");
                        }
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    ;
                    break;
                case 2:
                    if (contacontatti > 0) {
                        Visualizza(gestore, contacontatti);
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare.");
                    }
                    break;
                case 3:
                    if (contaNascosti > 0) {
                        Persona supporto = LeggiContatto(false, tastiera, nascosti, false, contaNascosti);
                        int posizione = posNumero(gestore, supporto, contacontatti);
                        if (PresenteNascosti(supporto, contaNascosti, nascosti)) {
                            System.out.println("Inserisci la password:");
                            String passwordInserita = tastiera.nextLine();
                            if (verificaPassword(nascosti, passwordInserita)) {
                                VisualizzaNascosti(nascosti, contaNascosti, posizione);
                            } else {
                                System.out.println("Password errata.");
                            }
                        } else {
                            System.out.println("Contatto non presente.");
                        }
                    } else {
                        System.out.println("Non ci sono contatti nascosti.");
                    }
                    break;

                case 4:
                    if (contacontatti > 0) {

                        Persona Supporto = LeggiContatto(false, tastiera,nascosti,false,contaNascosti);
                        int posizione = posNumero(gestore, Supporto,contacontatti);
                        if(posizione != -1){
                            contacontatti = cancellaContatto(gestore,posizione,contacontatti);
                        }else{
                            System.out.println("Non è presente");
                        }
                    } else {
                        System.out.println("Non ci sono contatti da visualizzare");
                    }
                    ;
                    break;

                case 5:
                    uscita = true;

                    break;

            }

        } while (!uscita);
        System.out.println("Fine programma");
    }

    public static Persona LeggiContatto(boolean telSi, Scanner tastiera, Persona[]nascosti,boolean pass,int contaNascosti) {
        Persona contatto = new Persona();
        String risposta;
        System.out.println("Inserici il nome");
        contatto.nome = tastiera.nextLine();
        System.out.println("Inserici il cognome");
        contatto.cognome = tastiera.nextLine();
        if(pass){
        System.out.println("Vuoi crearlo nascosto? Si/No");
        risposta=tastiera.nextLine();
        if(risposta.equals("Si")) {
            System.out.println("Inserisci la password");
            contatto.password = tastiera.nextLine();
            ++contaNascosti;
        }
        }
        if (telSi) {
            System.out.println("Inserici il numero di telefono");
            contatto.numDiTelefono = tastiera.nextLine();
            String[] opzioni = {"TipoAbbonamento", "1-cellulare", "2-abitazione", "3-azienda"};
            int scelta;
            do {
                scelta = menu(opzioni, tastiera);
                switch (scelta) {
                    case 1 -> contatto.tipo = Tipologia.cellulare;
                    case 2 -> contatto.tipo = Tipologia.abitazione;
                    case 3 -> contatto.tipo = Tipologia.azienda;
                }

            } while (scelta > 3 || scelta < 1);
        }
        return contatto;
    }
    public static int cancellaContatto(Persona[] gestore,int posizione,int contacontatti){

        if(posizione != gestore.length) {
            for (int i = posizione; i < contacontatti - 1; i++)
                gestore[i] = gestore[i + 1];
        }
        return --contacontatti;
    }
    public static boolean verificaPassword(Persona[] nascosti, String password) {
        for (int i = 0; i < nascosti.length; i++) {
            if (nascosti[i] != null && nascosti[i].password != null && nascosti[i].password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static void Visualizza(Persona gestore[], int contacontatti) {
        for (int i = 0; i < contacontatti; i++) {
            System.out.println(gestore[i].anagrafica());
        }
    }

    public static void VisualizzaNascosti(Persona[] nascosti, int contacontatti, int posizione) {
        if (posizione >= 0 && posizione < contacontatti) {
            System.out.println(nascosti[posizione].visNascosti());
        }
    }

    public static boolean Presente(Persona[] gestore, Persona NuovoContatto, int contacontatti) {

        for (int i = 0; i < contacontatti; i++) {
            if ((gestore[i].nome.equals(NuovoContatto.nome)) && (gestore[i].cognome.equals(NuovoContatto.cognome))) {
                return true;
            }
        }
        return false;
    }
    public static boolean PresenteNascosti( Persona NuovoContatto, int contaNascosti, Persona[]nascosti) {

        for (int i = 0; i < contaNascosti; i++) {
            if ((nascosti[i].nome.equals(NuovoContatto.nome)) && (nascosti[i].cognome.equals(NuovoContatto.cognome))) {
                return true;
            }
        }
        return false;
    }

    public static int CercaContatto(Persona[] gestore, Persona NuovoContatto, int contacontatti) {
        for (int i = 0; i < contacontatti; i++) {
            if ((gestore[i].nome.equals(NuovoContatto.nome)) && (gestore[i].cognome.equals(NuovoContatto.cognome))) {
                return i;
            }
        }
        return -1;
    }

    public static int posNumero(Persona[] gestore, Persona NuovoContatto, int contacontatti) {
        for (int i = 0; i < contacontatti; i++) {
            if ((gestore[i].nome.equals(NuovoContatto.nome)) && (gestore[i].cognome.equals(NuovoContatto.cognome))) {
                return i;
            }
        }
        return -1;
    }
}


