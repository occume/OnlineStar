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
		public static final String MYCITY = "mycity";
		public static final String SERVER178 = "server178";
	}
	
	private static final String PROJECT_PATH = "/apache-tomcat-8.5.16/webapps/";
	
	protected static Map<String, Node> nodes = new HashMap<String, Redeploy.Node>();
	
	static{
		nodes.put(KEYS.SERVER178, new Node("116.62.159.178",	22,  "root",    	"Hrz5651403"));
	}
	
	public static void main(String...cmd) throws IOException{
		SSHClient client = getClient(getNode(KEYS.SERVER178));
		exec(client, "echo $JAVA_HOME");
		exec(client, "ls");
		upload(client, "D:/Server" + PROJECT_PATH + "OnlineStar.tar.gz", 
						"/home" + PROJECT_PATH + "OnlineStar.tar.gz");
		exec(client, "cd /home/" + PROJECT_PATH + ";"
				+ "rm -rf OnlineStar;"
				+ "tar -zxvf OnlineStar.tar.gz");
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
