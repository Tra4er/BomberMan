package com.bomberman.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.bomberman.model.Bomberman;

public class FileWorker {
	private static File file;

	public static void write(String fileName, String name, int bestScore, String bestTime) {

		file = new File(fileName);

		try {
			if (!file.exists()) {
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
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void read(String fileName, Bomberman bomberman) throws FileNotFoundException {

		file = new File(fileName);
		
		if (file.exists()) {

			try {
				BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
				try {
					bomberman.setName(in.readLine());
					bomberman.setBestScore(Integer.parseInt(in.readLine()));
					bomberman.setBestTime(in.readLine());
				} finally {
					in.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
