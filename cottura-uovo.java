import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String risposta;
        System.out.println("partenza");
        for(int i=1;i<=11;i++){
            attesa();
            switch (i){
                case 1:System.out.println("uovo iniziale: ");break;
                case 2:System.out.println("uovo a metà: ");break;
                case 3:System.out.println("uovo finale: ");break;
                default:System.out.println("tempo non valido");
            }
             System.out.println("hai ancora fame?");
             risposta=scanner.next();
        if(risposta.equals("si")){
            switch (i){
                case 1:System.out.println("uovo iniziale: ");break;
                case 2:System.out.println("uovo a metà: ");break;
                case 3:System.out.println("uovo finale: ");break;
                default:System.out.println("tempo non valido");
            }
        }
        }
    }
    public static void attesa(){
        try {
            Thread.sleep( 5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
