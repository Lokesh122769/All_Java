import java.util.*;
class SubList 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for(int i=0;i<n;i++)
		{
			al.add(s.nextInt());
		}
		
		List<Integer> list = al.subList(5,9+1);

		Iterator et = list.iterator();

		while(et.hasNext())
		{
			int h = (Integer)et.next();
			if(h==7)
			{
		       System.out.println("Matched");
			}
			System.out.println(h);
		}

	}
}
