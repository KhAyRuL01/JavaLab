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
		soc  = new Socket("localhost", 8888);
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				BufferedReader buf;
				try {
					buf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					OutputStreamWriter outstream = new OutputStreamWriter(soc.getOutputStream());
					Scanner in = new Scanner(System.in);
					PrintWriter out = new PrintWriter(outstream);
					while(true)
					{
						String str = "";
						str = buf.readLine();
						System.out.println(str);
						System.out.print("Client: ");
						String ss;
						ss = in.nextLine();
						out.println(ss);
						out.flush();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();

	}

}
