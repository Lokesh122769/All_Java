import java.util.*;
public class  SortingStrings
{   
	public static boolean isPrime(int n)
	{
		int count=0;

		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				count++;
			}
		}

		if(count==2)
		{
			return true;
		}

		return false;
	}


	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String str = sc.next();
		StringBuffer bf=new StringBuffer(str);

		for(int i=0;i<bf.length();i++)
		{
            for(int j=i+1;j<bf.length();j++)
			{
                int ascii1 = (int)bf.charAt(i);
                int ascii2 = (int)bf.charAt(j);
				boolean isAscii1 = isPrime(ascii1);
				boolean isAscii2 = isPrime(ascii2);

				if(isAscii2==true && isAscii1==false)
				{
					bf.setCharAt(i,(char)ascii2);
					bf.setCharAt(j,(char)ascii1);
				}
				else if(isAscii1==true && isAscii2==true)
				{
					if(ascii2<ascii1)
					{
						bf.setCharAt(i,(char)ascii2);
					    bf.setCharAt(j,(char)ascii1);
					}
				}
				else if(isAscii1==false && isAscii2==false)
				{
					if(ascii2<ascii1)
					{
						bf.setCharAt(i,(char)ascii2);
					    bf.setCharAt(j,(char)ascii1);
					}
				}
			}
		}
		System.out.println(bf);
	}
}
