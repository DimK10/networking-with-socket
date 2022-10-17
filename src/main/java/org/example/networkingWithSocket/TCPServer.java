package org.example.networkingWithSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789);

		System.out.println("------------------------------------");
		System.out.println("Created server on port 6789");
		System.out.println("------------------------------------");
		Socket connectionSocket = welcomeSocket.accept();

        while(true) {



            BufferedReader inFromClient =
                    new BufferedReader(new
                            InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();

			System.out.println("Client sentence received: " + clientSentence);

            if (clientSentence == null || clientSentence.equalsIgnoreCase("bye")) {
				System.out.println("------------------------------------");
				System.out.println("User gave word bye - closing...");
				System.out.println("------------------------------------");
                connectionSocket.close();
                break;
            }

            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            outToClient.writeBytes(capitalizedSentence);
			inFromClient =
					new BufferedReader(new
							InputStreamReader(connectionSocket.getInputStream()));
        }
    }
}
