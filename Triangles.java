import java.util.*;
class Anagrams2 
{
	public static void main(String[] args) 
	{
		String s1 = "post";
		String s2 = "stop";
		boolean result = true;
		int count1=1,count2=0;
		for(int i=0;i<s1.length() && result==true;i++)
		{
			char a =  s1.charAt(i);
			for(int k=0;k<s1.length();k++)
			{
				char b = s1.charAt(k);
				if(a==b)
				{
					count1++;
				}
			}

			for(int j=0;j<s2.length();j++)
			{
				char c = s2.charAt(j);
				if(a==c)
				{
					count2++;
				}
			}
			if(count1!=count2)
			{
				result=false;
			}
			count1=1;
			count2=0;
		}
      
	}
}
