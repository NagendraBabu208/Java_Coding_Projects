package com.training.quest4;

import java.util.Scanner;

public class MediaPlayerDemo {
	
	public static void main(String[] args) {
		IMediaPlayer mediaPlayer=null;
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter MediaPlayerType vlc/windows");
		String mediaType=scanner.nextLine();
		
		if("VLC".equalsIgnoreCase(mediaType.toUpperCase())) {
			mediaPlayer=new VLCMediaPlayer();
			mediaPlayer.playVideo();
			mediaPlayer.downloadMusic();
			
		}else if("WINDOWS".equalsIgnoreCase(mediaType.toUpperCase())) {
			mediaPlayer=new WindowsMediaPlayer11();
			WindowsMediaPlayer windowsMediaPlayer=(WindowsMediaPlayer) mediaPlayer;
			windowsMediaPlayer.playVideo();
			mediaPlayer.downloadMusic();
		}
		else {
			System.out.println(" Invalid User Input!!!");
		}
		
		if(scanner!=null) {
			scanner.close();
		}
	}

}
