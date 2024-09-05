import java.util.*;
import java.lang.*;
import java.io.*;
class Xyz 
{
	public static void main(String[] args) 
	{
		int a[]=new int[6];
		int i;
		Scanner sc=new Scanner(System.in);
		for(i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		System.out.println("enter a number");
		int n=sc.nextInt();
		HashSet<Integer> res=new HashSet<Integer>();
		for(i=n;i<a.length;i++)
			res.add(a[i]);
		Iterator<Integer> se=res.iterator();
		while(se.hasNext())
		{
			System.out.println(se.next());
		}
	}
}
