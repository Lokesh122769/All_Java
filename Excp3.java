import java.util.*;
class StringException extends Exception
{
	public StringException(String msg)
	{
		super(msg);
	}
}
class  Excp3
{
	static void check(String str)
	{
		try
		{
			int i;
			for(i=0;i<str.length();i++)
		   {
			  if(checkVowel(str.charAt(i)))
				   break;
		   }
		  if(i==str.length())
			 throw new StringException("EXCEPTION--->string contains no vowels");
		  else
			  System.out.println("String contains vowels");
		}
		catch(StringException e)
		{
			System.out.println(e);
		}
		
	}
	static boolean checkVowel(char c)
	{
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			return true;
		else
			return false;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		check(str);
	}
}
