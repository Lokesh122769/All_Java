import java.util.*;
class ThreeSeries 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr[] = new String[n];

		for(int i=0;i<n;i++)
		{
			arr[i] = sc.next();
		}
		int count=0;
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
			    {
			    	System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					count++;
			    }
			}
		}
		System.out.println(count);
	}
}

/*Apple
  Banana
  Grapes
  Strawberries
  Guava
  */