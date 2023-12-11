import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner tastiera=new Scanner(System.in);
        int prosecco, lugana, merlot, nBottiglioni,prezzoMerlot=1 ,prezzoLugana=2;
        double capacita = 1.5;
        double costoLitro = 1;
        double iva;
        double prezzoBottiglione, prezzoBarbera=1.5;
        double prezzoTotale;
        double totaleIva;
        String tipo;
        System.out.println("che tipo di vino vuole acquistare?\n");
        System.out.println("1=barbera\n");
        System.out.println("2=merlot\n");
        System.out.println("3=lugana\n");
        tipo=tastiera.next();
        if (tipo.equals("1")){
            System.out.println("inserisci numero bottiglioni");
            nBottiglioni = tastiera.nextInt();
            prezzoBottiglione = capacita * costoLitro;
            prezzoBarbera=prezzoBarbera*nBottiglioni;
            prezzoTotale =prezzoBarbera;
            iva = prezzoTotale * 0.21;
            totaleIva = prezzoTotale + iva;
            System.out.println("il numero di bottiglioni acquistati è" + nBottiglioni + "\n");
            System.out.println("il prezzo totale di vendita è" + prezzoTotale + "\n");
            System.out.println("il prezzo totale con iva è" + totaleIva);
        }else{
            if (tipo.equals("2")){
                System.out.println("inserisci numero bottiglioni");
                nBottiglioni = tastiera.nextInt();
                prezzoBottiglione = capacita * costoLitro;
                prezzoMerlot=prezzoMerlot*nBottiglioni;
                prezzoTotale = prezzoMerlot;
                iva = prezzoTotale * 0.21;
                totaleIva = prezzoTotale + iva;
                System.out.println("il numero di bottiglioni acquistati è" + nBottiglioni + "\n");
                System.out.println("il prezzo totale di vendita è" + prezzoTotale + "\n");
                System.out.println("il prezzo totale con iva è" + totaleIva);
            }else {
                if (tipo.equals("3")){
                    System.out.println("inserisci numero bottiglioni");
                    nBottiglioni = tastiera.nextInt();
                    prezzoBottiglione = capacita * costoLitro;
                    prezzoLugana=prezzoLugana*nBottiglioni;
                    prezzoTotale = prezzoLugana;
                    iva = prezzoTotale * 0.21;
                    totaleIva = prezzoTotale + iva;
                    System.out.println("il numero di bottiglioni acquistati è" + nBottiglioni + "\n");
                    System.out.println("il prezzo totale di vendita è" + prezzoTotale + "\n");
                    System.out.println("il prezzo totale con iva è" + totaleIva);
                }
            }
        }
    }
}
