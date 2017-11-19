package khayrul;

public class ThreadExample {
	
	public static void main(String[] args)
	{
		A oba = new A();
		B obb = new B();
		oba.start();
		obb.start();
		Thread t = new Thread(new Runnable()
		{

			public void run() {
				for(int i=0; i<5; i++)
				{
					System.out.println("nothing");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		t.start();
	}

}

class A extends Thread
{
	public void show() throws InterruptedException
	{
		for(int i=0; i<5; i++)
		{
			System.out.println("hi");
			Thread.sleep(200);
		}
	}
	
	public void run()
	{
		try {
			show();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}

class B extends Thread
{
	public void show() throws InterruptedException
	{
		for(int i=0; i<10; i++)
		{
			System.out.println("hello");
			Thread.sleep(100);
		}
	}
	public void run()
	{
		try {
			show();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}