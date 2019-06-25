package com.codeprep.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			outputStream.write(input.getBytes());
			
			byte [] response = new byte[1024];
			inputStream.read(response);
			
			System.out.println("Recieved from server - "+ new String(response).trim());
			
			scanner.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
