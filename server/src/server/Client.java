package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

	/**
	 * @param args
	 * @throws  
	 * @throws UnknownHostException 
	 */
	static Socket soc;
	public static void main(String[] args) throws Exception {
		
		//Scanner in = new Scanner(System.in);
		soc  = new Socket("192.168.0.116", 8888);
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				BufferedReader buf;
				try {
					buf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					while(true)
					{
						String str = "";
						str = buf.readLine();
						System.out.println(str);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				try
				{
					OutputStreamWriter outstream = new OutputStreamWriter(soc.getOutputStream());
					PrintWriter out = new PrintWriter(outstream);
					Scanner in = new Scanner(System.in);
					while(true)
					{
	
						String ss;
						//System.out.println("Client::");
						ss = in.nextLine();
						out.println("Client: " + ss);
						out.flush();
					}
				}catch(Exception e)
				{
					
				}
			}
		});
		t2.start();
	}

}