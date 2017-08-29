package org.d3.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import net.schmizz.sshj.xfer.scp.SCPFileTransfer;

import com.xqbase.util.ByteArrayQueue;
import com.xqbase.util.Streams;

public class Redeploy {
	
	protected static class Node{
		public String host;
		public int port;
		public String username;
		public String password;
		public Node(String host, int port, String username, String password) {
			this.host = host;
			this.port = port;
			this.username = username;
			this.password = password;
		}
	}
	
	protected static class KEYS{
		public static final String PORTAL_FAT = "porta_fat";
		public static final String PORTAL_UAT = "porta_uat";
		public static final String PORTAL_PROD = "porta_prod";
		
		public static final String PORTAL_PROD_NEW = "porta_prod";
		public static final String MYCITY = "mycity";
		
		public static final String SERVER178 = "server178";
		public static final String SERVER179 = "server179";
	}
	
	protected static Map<String, Node> nodes = new HashMap<String, Redeploy.Node>();
	
	static{
//		nodeList.add(new Node("10.8.90.86", 1022, 	"deploy", 	"654321WY_654321wy"));
//		nodeList.add(new Node("10.8.90.87", 1022, 	"deploy", 	"654321WY_654321wy"));
//		nodeList.add(new Node("10.8.74.8", 	1022,  	"op1",    	"1qaz2wsx#EDC$RFV"));
//		nodeList.add(new Node("10.8.74.7", 	1022,  	"op1",    	"1qaz2wsx#EDC$RFV"));
//		nodes.put(KEYS.PORTAL_FAT,  new Node("10.2.5.82", 	 22,  	"fxUser",   ")OKM9ijn"));
		nodes.put(KEYS.PORTAL_FAT,  new Node("10.2.6.15", 	 22,  "op1",   "QATE@qa.nt.ctripcorp.com"));
		nodes.put(KEYS.PORTAL_UAT,  new Node("10.2.26.90", 1022,  "sbuvadm",    "cVmyjcmnk8Df2fjj^"));
//		nodes.put(KEYS.PORTAL_UAT,  new Node("10.2.254.205", 1022,  "op1",    	"Ctrip777"));
		nodes.put(KEYS.PORTAL_PROD, new Node("10.8.74.7", 	 1022,  "op1",    	"1qaz2wsx#EDC$RFV"));
		nodes.put(KEYS.PORTAL_PROD_NEW, new Node("10.8.92.9",1022,  "op1",    	"superoctopus1124"));
		nodes.put(KEYS.MYCITY, new Node("112.124.115.136",		22,  "root",    	"Ggshop05221066"));
		
		nodes.put(KEYS.SERVER178, new Node("116.62.159.178",	22,  "root",    	"Hrz5651403"));
		
		nodes.put(KEYS.SERVER179, new Node("10.8.2.179",1022,  "op1",    	"s6zdzKuv,qMrobxt8"));
	}
	
	public static Node getNode(String key){
		return nodes.get(key);
	}
	
	protected static void upload(SSHClient ssh, String local, String remote) throws IOException {
		SCPFileTransfer scp = ssh.newSCPFileTransfer();
		scp.upload(local, remote);
	}
	
	public static SSHClient getClient(Node node) throws IOException{
		
		SSHClient client = new SSHClient();
		client.loadKnownHosts();
		client.addHostKeyVerifier(new PromiscuousVerifier());

		client.connect(node.host, node.port);
		client.authPassword(node.username, node.password);

		return client;
	};
	
	public static void exec(SSHClient client, String cmd) throws IOException {
		ByteArrayQueue baq = new ByteArrayQueue();
		exec0(client, cmd,baq);
		try (
			BufferedReader in = new BufferedReader(new
					InputStreamReader(baq.getInputStream()));
		) {
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		}
		finally{
//			client.disconnect();
		}
	}
	
	public static void exec0(SSHClient ssh, String command, ByteArrayQueue baq) throws IOException {
		try (
			Session session = ssh.startSession();
			Command command_ = session.exec(command);
		) {
			Streams.copy(command_.getErrorStream(), System.err);
			if (baq == null) {
				Streams.copy(command_.getInputStream(), new ByteArrayOutputStream());
			} else {
				Streams.copy(command_.getInputStream(), baq.getOutputStream());
			}
			session.close();
		}
		
	}
}
