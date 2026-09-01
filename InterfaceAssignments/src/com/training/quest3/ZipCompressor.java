package com.training.quest3;

public class ZipCompressor implements IFileCompressor {

	@Override
	public void compressFile(String... files) {
		
		for(String file:files) {
			System.out.println(file);
		}
		
	}

}
