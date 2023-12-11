
import java.util.Map;
import java.util.Scanner;
public class Byte {
    public static void main(String[] args) {
        int n,num,resto,i=0,cont=0;
        double y=0,deci,somma=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci un byte ");
        n = scanner.nextInt();
        num=n;
        do{
            resto=n%10;
            n=n/10;
            cont=cont+n;
            if (resto!=1 && resto!=0){
                System.out.println("il numero inserito non è un byte");
            }
            i=i+1;
        }while(n>0);
        if(i!=8){
            System.out.println("il numero inserito non è un byte");
        }
        else {
            System.out.println("il numero inserito è un Byte");
            do{
                resto=num%10;
                num=num/10;
                deci = resto * Math.pow(2, y);
                somma = somma+deci;
                y=y+1;
            }while(num>0);
            System.out.println("il numero in decimale è "+somma);
        }
    }
}
