import java.util.Scanner;
public class KnapsackDynamic {
	public static int knapsackdyanamic(int capacity,int[] weights,int[] profits,int n)
	{
		int[][] dp=new int[n+1][capacity+1];
		for(int i=0;i<=n;i++)
		{
			for(int w=0;w<=capacity;w++)
			{
				if(i==0 || w==0)
				{
					dp[i][w]=0;
				}
				else if(weights[i-1]<=w)
				{
					dp[i][w]=Math.max(profits[i-1]+dp[i-1][w-weights[i-1]],dp[i-1][w]);
				}
				else
				{
					dp[i][w]=dp[i-1][w];
				}
			}
		}
		return dp[n][capacity];
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the number of items");
		int n=sc.nextInt();
		int[] profits=new int[n];
		int[] weights=new int[n];
		System.out.println("\nEnter the profits of items:");
		for(int i=0;i<n;i++)
		{
			profits[i]=sc.nextInt();
		}
		System.out.println("\nEnter the weight of the items");
		for(int i=0;i<n;i++)
		{
			weights[i]=sc.nextInt();
		}
		System.out.println("\nEnter the capacity of items");
		int capacity=sc.nextInt();
		int result=knapsackdyanamic(capacity,weights,profits,n);
		System.out.println(result);
		
		
	}

}