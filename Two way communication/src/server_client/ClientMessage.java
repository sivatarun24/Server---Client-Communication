package server_client;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientMessage {

	@SuppressWarnings("resource")
	public static void main(String[] args)  {
		try {
		Socket s = new Socket("localhost", 7785);
		System.out.println("Connection done ..");
		System.out.println("|---------------------------------------------------|");
		System.out.println("|   Note: Only type an message when you see 'You'   | ");
		System.out.println("|---------------------------------------------------|");
		boolean flagc = true;
		while(flagc) {
			PrintStream psc = new PrintStream(s.getOutputStream());
		BufferedReader brtc = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader brsc = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String ansc = brsc.readLine();
			if(ansc != null) {
				System.out.println("Server: " +ansc);
			}
			System.out.print("You: ");
			String strc = brtc.readLine();
			if(strc != null && !strc.equals("exit")){
				psc.println(strc);
			}
			if(strc.equals("exit")) {
				flagc = false;
				System.exit(0);
			}
		}
	}catch(Exception e) {
		System.out.println("----Disconnected----");
	}
	}

}

