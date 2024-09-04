import java.util.*;
class Uni 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of array");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("enter array elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		Arrays.sort(a);
		int count=0;
		int i,j;
		System.out.println("unique elements are");
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(a[i]==a[j])
					count++;
				else
					break;
			}
			if(count==0)
				System.out.print(a[i]+"\t");
			else
			    i=j-1;
			count=0;
		}
	}
}
