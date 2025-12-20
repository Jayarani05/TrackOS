package com.TrackOSProject.TrackOS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackOsApplication {
	public static void main(String[] args) {
		System.out.println("Starting TrackOS Application...");
		SpringApplication.run(TrackOsApplication.class, args);
	}

}
