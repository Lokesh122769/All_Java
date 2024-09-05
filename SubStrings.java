import java.util.*;
class SubStrings 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		for(int i=1;i<str.length();i++)
		{
			for(int j=0;j<str.length();j++)
			{
				System.out.println(str.substring(j,i+j));
			}
		}
	}
}

Input: abcd
output :
a b c d ab bc cd ac bd