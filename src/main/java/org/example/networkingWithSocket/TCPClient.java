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

        Socket clientSocket = new Socket("127.0.0.1", 6789);

        System.out.println("Please gve a word. the socket closes by gining the word exit.");

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        sentence = inFromUser.readLine();

        while (true) {


            if (sentence.equalsIgnoreCase("exit")) {
                clientSocket.close();
                break;
            }

            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));


            outToServer.writeBytes(sentence + '\n');

            modifiedSentence = inFromServer.readLine();

            System.out.println("FROM SERVER: " + modifiedSentence);
        }
    }
}
