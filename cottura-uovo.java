public class Main {
    public static void main(String[] args) {
        System.out.println("partenza"); //inizia il programma
        for(int i=1;i<=10;i++){ //usiamo il for per definire un numero preciso di casi
            attesa(); //usiamo il metodo creato sotto
            switch (i){ //facciamo uno switch case in cui abbiamo le 3 fasi di cottura dell'uovo
                case 1:System.out.println("uovo dopo 20 secondi: ");break; //primo caso
                case 2:System.out.println("uovo dopo 40 secondi: ");break; //secondo caso
                case 3:System.out.println("uovo dopo 1 minuto: ");break; //terzo caso
                default:System.out.println("tempo non valido"); 
            }
        }
    }
    public static void attesa(){ //creaiamo il metodo "attesa" 
        try {
            Thread.sleep( 20000); //quantità di tempo che deve passare in ogni fase
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
