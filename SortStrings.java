import java.util.*;
import java.math.BigInteger;
class SortStrings 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		String str[] = new String[n];
		for(int i=0;i<n;i++)
		{
			str[i] = s.next();
		}
		int length = str.length;
		BigInteger arr[] = new BigInteger[length];

		try
		{
			for(int i=0;i<length;i++)
		    {
		    	arr[i] = new BigInteger(str[i]);
		    }  
       
		    for(int i=0;i<length;i++)
		    {
		    	System.out.print(arr[i]+" ");
		    }

			Arrays.sort(arr);
		    System.out.println();
		    for(int i=0;i<length;i++)
		    {
		    	System.out.print(arr[i]+" ");
		    }
		    System.out.println();
		}
		catch (NumberFormatException ne)
		{
			System.out.println("Error");
		}
		
		
	}
}
