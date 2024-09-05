import java.util.*;
class VowelsCount 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuffer sb = new StringBuffer();
		char pre=' ';
        
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			int index=0;
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
			{
				if(sb.length()==0)
				{
					sb.append(c);
				}
				else
				{
						for(int j=0;j<sb.length();j++)
		        		{
		        			index = sb.indexOf(Character.toString(c));
		        			if(index==-1)
		        			{
		        				break;
		        			}
		        		}
		        		if(index==-1)
		        		{
		        			sb.append(c);
		        		}
		        		else
						{
		        			if(pre==c)
		        			{
		        				sb.append(c);
		        			}
		        		}
		        }
			}
			pre=sb.charAt(sb.length()-1);
		}
		System.out.println(sb);
		System.out.println(sb.length());
	}
}
