package server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ServerSoc {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static Socket soc;
	public static void main(String[] args) throws IOException {
		//System.out.println(InetAddress.getLoopbackAddress());
		ServerSocket serversoc = new ServerSocket(8888);
		System.out.println("Server started");
		soc = serversoc.accept();
		System.out.println("connected");
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				BufferedReader buf;
				try {
					buf = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					Scanner in = new Scanner(System.in);
					OutputStreamWriter outstream = new OutputStreamWriter(soc.getOutputStream());
					PrintWriter out = new PrintWriter(outstream);
					while(true)
					{
						System.out.print("Server: ");
						String ss;
						ss = in.nextLine();
						out.println("Server: " + ss);
						out.flush();
						String str = "";
						str = buf.readLine();
						System.out.println(str);
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		t1.start();
		serversoc.close();
	}

}
