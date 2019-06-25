package com.codeprep.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			outputStream.write("Hello!".getBytes());
			
			byte [] response = new byte[1024];
			inputStream.read(response);
			
			System.out.println("Recieved from server - "+ new String(response).trim());
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
