import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner scanner=new Scanner(System.in);
	    double a,f;
	    int c;
	    System.out.println("inserisci la base");
	    a=scanner.nextDouble();
	     System.out.println("inserisci la potenza");
	     c=scanner.nextInt();
	     f=a*a;
	     for(int i=1;i<c-1;i++){
	         f=f*a;
	     }
	      System.out.println(""+f);
	}
}
