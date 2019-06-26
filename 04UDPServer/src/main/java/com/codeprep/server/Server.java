package com.codeprep.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		
		try (DatagramSocket datagramSocket = new DatagramSocket(8989)){
			
			DatagramPacket packet = new DatagramPacket(new byte[1000], 1000);
			datagramSocket.receive(packet);
			System.out.println(new String(packet.getData()));
			System.out.println("Obtained from IP: "+packet.getAddress());
			System.out.println("Obtained from Port: "+packet.getPort());
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
