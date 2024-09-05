import java.util.*;
class A
{
	int a=10;

	public A()
	{
		this("Sai");
		System.out.println("A Constructor");
		m();
	}
	
	public A(String name)
	{
		System.out.println("Hii : "+name);
	}

	public void m()
	{
		this.a(this);
		System.out.println("M method");	
	}

	public void a(A var)
	{
		System.out.println(var.a);
		System.out.println("A Method");
	}
}

class ThisKeyword
{
	public static void main(String[] args) 
	{
		List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().forEach(name -> System.out.println(name));
	}
}
