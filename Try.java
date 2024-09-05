import java.io.*;
class Try
{
	public static void main(String[] args) throws Exception
	{
		 try {
        // Code that might throw a FileNotFoundException
        FileInputStream fileInputStream = new FileInputStream(filePath);
        // Read data from the file
    } 
    // FileNotFoundException will propagate to the caller without being caught here
	}
}
