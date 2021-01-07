package server_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMessage {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		ServerSocket ss = new ServerSocket(7785);
		System.out.println("Waiting for client....................");
		System.out.println("|---------------------------------------------------|");
		System.out.println("|   Note: Only type an message when you see 'You'   | ");
		System.out.println("|---------------------------------------------------|");
		Socket s = ss.accept();
		System.out.println("Connection Established .. ");
		boolean flag = true;
		while(flag) {
		PrintStream pss = new PrintStream(s.getOutputStream());
		BufferedReader brts = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader brcs = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.print("You: ");
		String str = brts.readLine();
			if(str != null && !str.equals("exit")) {
				pss.println(str);
			}
			if(str.equals("exit")) {
				flag = false;
				System.exit(0);
			}
			String ans = brcs.readLine();
			if(ans != null) {
				System.out.println("Client: "+ans);
			}
		}
		}catch(Exception e) {
			System.out.println("----Disconnected----");
		}
	}

}

