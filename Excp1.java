import java.util.*;

class Excp1 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any number");
		int n=sc.nextInt();
		try
		{
			   if(n%2!=0)
			      throw new IllegalArgumentException(n+"is odd");
			   else
				   System.out.print(n+"is even");
		 }
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
	}
}
