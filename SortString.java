import java.util.*;
class SortString 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.next();
		char small=' ';
		StringBuffer sb=new StringBuffer(str);
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				char c1=sb.charAt(i);
			    char c2=sb.charAt(j);
			    int ascii1=(int)c1;
			    int ascii2=(int)c2;

			    if(ascii1>ascii2)
				{
					sb.setCharAt(i,c2);
					sb.setCharAt(j,c1);
				}
			}
			System.out.println(sb);
		}
		System.out.println("sb "+sb);
	}
}
