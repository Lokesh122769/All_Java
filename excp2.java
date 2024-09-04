import java.util.*;
class Excp2 
{
	static int check(int i,int n,int a[])
    {
		int j;
		for(j=i+1;j<n;j++)
		{
			if(a[i]==a[j])
				break;
		}
			return j;
    }
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of list");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("enter list elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		try
		{
			int i,j;
			for(i=0;i<n-1;i++)
			{
				j=check(i,n,a);
				if(j!=n)
					throw new ArithmeticException("EXCEPTION--->list contains duplicates"+"\t"+a[i]);
			}
			if(i==n-1)
				System.out.println("list contains no duplicates");
		}
		catch (ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}

	}
}
