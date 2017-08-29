package org.d3.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.schmizz.sshj.SSHClient;

public class RedeployFat extends Redeploy {
	
//	private String dasName;
	
	public static RedeployFat newRedeployFat(String dasName, String baseDir, String serverPath){
		return new RedeployFat(dasName, baseDir, serverPath);
	}

	private String delete_pre = "cd #serverPath#;"
			+ "sudo rm -r #dasPackage#;" 
			+ "sudo rm -r #dasPackage#.zip;" ;

	private String 
			localPath = "#baseDir#/#dasPackage#.zip",
			remotePath = "#serverPath#/#dasPackage#.zip";

	private String restart_das = "cd #serverPath#;"
			+ "unzip -o -d #dasPackage# ./#dasPackage#.zip;"
			+ "cd #dasPackage#/;"
			+ "dos2unix *.sh;"
			+ "dos2unix ./scripts/*;"
			+ "./run.sh restart";
	
	private String cmd = "echo $HOSTNAME;pwd;";
	
	public RedeployFat(String dasPackage, String proDir, String serverPath){
//		this.dasName = dasName;
		Path p = Paths.get(proDir);
		
		System.out.println("--- " + proDir);
//		proDir = proDir.replaceAll("\\", "\\\\");
		System.out.println("=== " + p.normalize().toString());
		System.out.println("=== " + p.toUri().toASCIIString());
		proDir = p.toUri().toASCIIString().substring(8);
		delete_pre = delete_pre.replaceAll("#dasPackage#", dasPackage).replaceAll("#serverPath#", serverPath);
		localPath = localPath.replaceAll("#dasPackage#", dasPackage).replaceAll("#baseDir#", proDir);
		remotePath = remotePath.replaceAll("#dasPackage#", dasPackage).replaceAll("#serverPath#", serverPath);
		restart_das = restart_das.replaceAll("#dasPackage#", dasPackage).replaceAll("#serverPath#", serverPath);
	}
	
	public void test(){
		
		Node node = getNode(KEYS.SERVER178);
		
		SSHClient client;
		try {
			client = getClient(node);

			exec	(client, cmd);
//			exec	(client, delete_pre);
//			upload	(client, localPath, remotePath);
//			exec	(client, restart_das);

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void redeploy(String env) {
		
		Node node = null;
		
		if("fat".equals(env))
			node = getNode(KEYS.PORTAL_FAT);
		else if("uat".equals(env))
			node = getNode(KEYS.PORTAL_UAT);
		SSHClient client;
		try {
			client = getClient(node);

			exec	(client, cmd);
			exec	(client, delete_pre);
			upload	(client, localPath, remotePath);
			exec	(client, restart_das);

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String...strings){
		RedeployFat d = RedeployFat.newRedeployFat("das-index1-1.0", "d:/workspace/das/das-index1/target", "");
		d.test();
	}

}
