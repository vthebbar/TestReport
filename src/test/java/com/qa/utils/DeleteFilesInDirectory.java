package com.qa.utils;

import java.io.File;

public class DeleteFilesInDirectory {

	
	public static void deleteFiles() {
	String dirPath = System.getProperty("user.dir")+"/test-output/Downloads";
	
	 // Create a File object representing the directory
	File directory = new File(dirPath);
	
	if(directory.exists() && directory.isDirectory()) {
		
		
		File files[] = directory.listFiles();
		
		for(File file : files) {
			
			if(file.isFile()) {
				if(file.delete()) {
					
					System.out.println("File deleted:"+ file.getName());
				}
				else {
					System.out.println("File NOT deleted:"+ file.getName());

				}
			}
		}
		
	}
	
}

}