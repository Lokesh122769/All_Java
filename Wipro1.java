import java.util.*;

class  Wipro1
{
	public static void main(String[] args) 
	{
		
        String input1="Rajiv",input2="Roy";
		int input3=560037,input4=6;
        String first,last;
	    if(input1.length()==input2.length())
		{
			String a[]=new String[]{input1,input2};
			Arrays.sort(a);
			first=a[1]+"";
			last=a[0]+"";
		}
		else if(input1.length()>input2.length())
		{
			first=input1+"";
			last=input2+"";
		}
		else
		{
			first=input2+"";
			last=input1+"";
		}
        
		String pin=String.valueOf(input3);
        String id=last.charAt(last.length()-1)+""+first+""+pin.charAt(input4-1)+""+pin.charAt(pin.length()-input4);
      //  System.out.println(id);
		String res="";

		for(int i=0;i<id.length();i++)
		{
			if(Character.isAlphabetic(id.charAt(i)))
			{
				res=res+((char) (id.charAt(i)^32));
			}
			else
			{
				res=res+""+id.charAt(i);
			}
		}

		System.out.println( res);


	}
}
