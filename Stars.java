public class Stars
{
	public static void main(String args[])
	{
		int n=5,noOfStars=1;
		for(int i=n;i>=1;i--)
		{
			for(int k=1;k<=noOfStars;k++)
			{
                System.out.print("*");
			}
            System.out.println();
			noOfStars++;
		}
	}
}