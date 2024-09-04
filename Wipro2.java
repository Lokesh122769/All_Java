import java.util.*;

class Wipro2 
{
	public static void main(String[] args) 
	{
		
       

		 char c[]=new char[input1.length];
         List<Integer> l=new ArrayList<>();
		for(int i=0;i<input1.length;i++)
		{
			l.add(input1[i]);
		}

		Arrays.sort(input1);

		char ch='a';
		for(int i=0;i<input1.length;i++)
		{
			int in=l.indexOf(input1[i]);

			c[in]=ch++;
		}

        

		return ch;

	
	}
}
