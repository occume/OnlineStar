package org.d3.wx.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.os.util.NamedThreadFactory;

public class Async{
	
	private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
	
	private static final ExecutorService executor = 
			Executors.newFixedThreadPool(THREAD_COUNT, new NamedThreadFactory("Async-executor"));

	public static void execute(Runnable task){
		executor.execute(task);
	}
}
