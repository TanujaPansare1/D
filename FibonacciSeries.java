import java.util.Scanner;
public class FibonacciSeries {
	static int i=0;
	public static int fibonacciseries(int n1,int n2)
	{		
		if(i>5)
		{
			return 0;
		}
		i++;
		int n3=n1+n2;
		System.out.println(n3);
		fibonacciseries(n2,n3);
		return 0;
	}
	public static void main(String args[])
	{
		System.out.println(  "With recursion");
		int n1=0;
		int n2=1;
		System.out.println(n1);
		System.out.println(n2);
		fibonacciseries(n1,n2);
		System.out.println("Without recursion");
		System.out.println(n1);
		System.out.println(n2);
		for(int i=2;i<7;i++)
		{
			
			int n3=n1+n2;
		    n1=n2;
		    n2=n3;
		    System.out.println(n3);
		}
	}

}