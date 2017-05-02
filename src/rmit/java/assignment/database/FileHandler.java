package rmit.java.assignment.database;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
	// File name
	private String participantList = "participants.txt";
	private ArrayList<String> participants = new ArrayList<String>();
	

	public FileHandler()  {
		
	}

	public void getParticipantList() {
		 try {

	            File f = new File(participantList);
	          

	            BufferedReader b = new BufferedReader(new FileReader(f.getAbsolutePath()));

	            String readLine = "";

	        
	            while ((readLine = b.readLine()) != null) {
	                participants.add(readLine);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}
	
	public ArrayList getParticipants() {
		return this.participants;
	}
}
