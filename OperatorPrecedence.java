
import java.util.*;

public class OperatorPrecedence
{
   
    public static void main(String[] args)
	{
		String stack="$";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String input = scanner.next();
        input += "$";
        int len = input.length()-1;
        boolean f=false;
        
        List<String> list=Arrays.asList("i","E+E","E*E","(E)");


        System.out.println("\nSTACK\tINPUT\tACTION");

		//stack=stack+input.charAt(0)+"";

        for(int i=0;i<len||stack.length()>2;i++)
		{
			if(i<len)
			{
				stack=stack+input.charAt(i);
				if(stack.length()>=2)
				{
				    System.out.print(stack+"\t");
					System.out.print(input.substring(i+1)+"\t");
					System.out.print("SHIFT");	
				}
				
			}
            String temp="";
            for(String t:list)
			{
				if(stack.contains(t))
				{
                    temp=t;
					f=true;
					break;
				}
			}
			if(f)
			{
				System.out.println();

			
				stack=stack.replace(temp,"E");
				System.out.print(stack+"\t");

				if(i<len)
			    System.out.print(input.substring(i+1)+"\t");
				else
				System.out.print("$"+"\t");
				System.out.print("Reduces "+temp+"->E");

				f=false;
			}
			
			System.out.println();
		}
        
		

	}
     
}
