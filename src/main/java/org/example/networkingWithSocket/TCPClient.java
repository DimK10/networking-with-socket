package org.example.networkingWithSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws IOException {

        String sentence;
        String modifiedSentence;

//		Socket clientSocket = new Socket("192.168.91.20", 7878);
        Socket clientSocket = new Socket("127.0.0.1", 6789);

        System.out.println("Please give a word. The connection closes by giving the word bye (not case sensitive).");

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));



        while (true) {


			sentence = inFromUser.readLine();

            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));





			if (sentence.equalsIgnoreCase("bye")) {
				clientSocket.close();
				break;
			}

			outToServer.writeBytes(sentence + '\n');


			modifiedSentence = inFromServer.readLine();

            System.out.println("FROM SERVER: " + modifiedSentence);
			inFromUser = new BufferedReader(new InputStreamReader(System.in));
		}
    }
}
