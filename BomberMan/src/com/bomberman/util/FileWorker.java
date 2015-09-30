package com.bomberman.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWorker {
	private static File file;
	
	public static void write(String fileName, String name, int bestScore, String bestTime) {
		
	    file = new File(fileName);
	 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            out.println(name);
	            out.println(bestScore);
	            out.println(bestTime);
	        } finally {
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
}
