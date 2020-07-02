package comp2011.lab12;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

class Node {
	InetAddress ip;
	Node next;
}

// We use the facilities of handling IP addresses provided by Java.
// this is different from the version I used in the class.
class VisitorMonitor {
	Node[] visitors;

	public VisitorMonitor() {
		visitors = new Node[65536];
	}
	
	// note that the ip address is a[0].a[1].a[2].a[3]
	public static int h(InetAddress ip) {
		byte[] a = ip.getAddress();
		return ( ((a[1]  & 0xff) << 8) + (a[2] & 0xff) ) & 0x7FFFFFFF;
	}
	
	public boolean newVisitor(InetAddress ip) {
		// 
		int address = h(ip);
		
		
		
		return false;
	}

	public void addVisitor(InetAddress ip) {
		//
	}

	public void deleteVisitor(InetAddress ip) {
		//
	}

	// return the length of the longest list
	// it determines the worst-case running time.
	public int longest() {
		//
		return -1;
	}
}

public class VisitorMonitorTester {
	public static InetAddress newIP() {
		SecureRandom random = new SecureRandom();
		byte[] ip = new byte[4];
		for (int i = 0; i < 4; i++) 
			ip[i] = (byte) random.nextInt(256);
		try {
			return InetAddress.getByAddress(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		VisitorMonitor monitor = new VisitorMonitor();	
		int size = 10000;
		for (int i = 0; i < size; i++) {
			InetAddress ip = newIP();
			System.out.println(ip + " is visiting.");
			if (monitor.newVisitor(ip)) {
				monitor.addVisitor(ip);
				System.out.println("a new visitor, added to the system.");
			}
			else
				System.out.println("a returned visitor.");
			// Try the following line (warning: it's very slow!)
			// System.out.println(ip.getHostName());
		}
	}
}
	
