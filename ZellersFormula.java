import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        boolean mark []=new boolean[26];
        int index=0;
        for(int i=0;i<s.length();i++)
        {
            /*if('A'<=s.charAt(i) && s.charAt(i)<='Z')
            {
                index=s.charAt(i)-'A';
            }*/
            if('a'<=s.charAt(i) && s.charAt(i)<='z')
            {
                index=s.charAt(i)-'a';
            }
            else
            {
                continue;
            }
            mark[index]=true;
        }
        int c=0;
        for(int i=0;i<=25;i++)
        {
            if(mark[i]==true)  
            {
                c=c+1;
            }
        }
        if(c==26)
        {
             System.out.println("Panagram");
        }
        else
        {
        System.out.println("Its not panagram");
        }
    }
}