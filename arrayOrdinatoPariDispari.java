import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        int quantiNumeri=0, n=0,contatorePari=0, contatoreDispari=0;
        Scanner sc=new Scanner(System.in);

        System.out.println("inserisci la dimensione del vettore\n");
        quantiNumeri=sc.nextInt();
        int []array=new int[quantiNumeri];

        System.out.println("inserisci i numeri per il vettore\n");
        for(int i=0;i<quantiNumeri;i++){
            do{
                n=sc.nextInt();
            }while(n<0);
            array[i]=n;
        }
        for(int i = 0; i < array.length-1; i++) {
            int minimo = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[minimo]>array[j]) {
                    minimo = j;
                }
            }
            if(minimo!=i) {
                int k = array[minimo];
                array[minimo]= array[i];
                array[i] = k;
            }
        }
        int[] arrayPari = new int[quantiNumeri];
        int[] arrayDispari = new int[quantiNumeri];



        for(int i=0;i<quantiNumeri;i++){
            if(array[i]%2 == 0){
                arrayPari[contatorePari] = array[i];
                contatorePari++;
            } else {
                arrayDispari[contatoreDispari] = array[i];
                contatoreDispari++;
            }
        }

        int[] arrayOrdinato = new int[quantiNumeri];
        int indice = 0;
        for(int i=0;i<contatoreDispari;i++){
            arrayOrdinato[indice] = arrayDispari[i];
            indice++;
        }

        for(int i=0;i<contatorePari;i++){
            arrayOrdinato[indice] = arrayPari[i];
            indice++;
        }

        for(int i=0;i<quantiNumeri;i++)
            System.out.println("Array Ordinato: "+arrayOrdinato[i]);
    }
}
