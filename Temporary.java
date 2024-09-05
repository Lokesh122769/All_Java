import java.util.Scanner;
public class Temporary
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int b=sc.nextInt();
	    int c=sc.nextInt();
	    int arr[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        int x=sc.nextInt();
	        arr[i]=x;
	    }
	    int sum=0;
	    int count=0;
	    for(int i=0;i<n-1;i++)
	    {
	        sum=arr[i];
	        for(int j=i+1;j<n;j++)
	        {
	            sum=sum+arr[j];
	            if(sum>=b && sum<=c)
	            {
	                count++;
	            }
	            else{
	                break;
	            }
	        }
	    }
	    System.out.println(count);
	}
}