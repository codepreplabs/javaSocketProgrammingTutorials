package com.codeprep.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		try (DatagramSocket datagramSocket = new DatagramSocket()) {

			String message = "Hello from UDP protocol!";

			byte[] data = message.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8989);
			datagramSocket.send(packet);

		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

}
