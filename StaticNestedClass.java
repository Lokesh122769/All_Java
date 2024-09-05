class OuterClass1 {
    int a = 19;

    public void hello() 
    {
        System.out.println("Hello");
    }

    class InnerClass1 
    {
        int b = 10;
        public void hello2() 
        {
            System.out.println(b);
        }

		class ClassThree
		{
			public void hello3()
			{
				System.out.println("Hello3");
			}
		}
    }
}

public class StaticNestedClass {
    public static void main(String args[]) {
        
        OuterClass1 ob = new OuterClass1();
        OuterClass1.InnerClass1 ob2 = ob.new InnerClass1();
        ob2.hello2();
		OuterClass1.InnerClass1.ClassThree ob3 = ob2.new ClassThree();
		ob3.hello3();
    }
}