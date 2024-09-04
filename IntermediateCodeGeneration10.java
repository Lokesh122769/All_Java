import java.util.Scanner;

public class IntermediateCodeGeneration10
{

    public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tIntermediate Code Generation");
        System.out.print("Enter the expression: ");
        String e= scanner.nextLine();
        System.out.println("Intermediate code:"+"\t"+"expression");
		char ch='A';
		for(int i=0;e.length()>1;i++)
		{
			if(e.contains("/"))
			{
				int in=e.indexOf("/");
				String sub=e.substring(in-1,in+2);
				System.out.print(ch+":="+sub);
				e=e.replace(sub,ch+++"");
			}
			else if(e.contains("*"))
			{
				int in=e.indexOf("*");
				String sub=e.substring(in-1,in+2);
				
				System.out.print(ch+":="+sub);
				e=e.replace(sub,ch+++"");
			}
			else if(e.contains("+"))
			{
				int in=e.indexOf("+");
				String sub=e.substring(in-1,in+2);
				
				System.out.print(ch+":="+sub);
				e=e.replace(sub,ch+++"");
			}
			else 
			{
				int in=e.indexOf("-");
				String sub=e.substring(in-1,in+2);
				
				System.out.print(ch+":="+sub);
				e=e.replace(sub,ch+++"");
			}
			System.out.print("\t\t"+e);
			System.out.println();
		}
    }
}
