import java.util.*;
class Viva 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>(n);

		for(int i=0;i<n;i++)
		{
			al.add(i,sc.nextInt());
		}
        int count=1;
		while(count>=1)
		{
			count=0;
			for(int i=0;i<al.size()-1;i++)
			{
				if(al.get(i+1)>al.get(i))
				{
					System.out.println(al.get(i)+" is removed:");
					al.remove(i+1);
					count++;
				}
				System.out.println("count is "+count);
			}
		}
		System.out.println(al.size());
	}
}
