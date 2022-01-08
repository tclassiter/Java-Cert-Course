import java.io.*;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Hello, and welcome to the prototype for your project LockProject. I'm Tom, the lead developer. My email address is: email@email.com\n");
		
		
		int choice = -1;
		
		do {
			System.out.println("Please pick one option from below: \n");
			System.out.println("1. Display all files\n");
			System.out.println("2. Create a new file\n");
			System.out.println("3. Delete a file \n");
			System.out.println("4. Search for a file \n");
			System.out.println("5. Exit the application \n");
			System.out.println("0. Return to the root menu \n");
			choice = sc1.nextInt();
		
	
			switch(choice) {
			
			case 1: {
		
					System.out.println("Here are the files:\n ");		
					
					//For this prototype:
					System.out.println("File 1\n" + "File 2\n" + "File 3\n" + "File 4\n" + "File 5\n");
				
					//For the real world application in the final product:
					//File file = new File ("C:\\Users\\Tom\\Documents\\Java");
					//String[] fileList = file.list();
					
					//for (String str : file List() {
						//System.out.println(str);
					}
					break;
					
					
					
			case 2: {
	
					System.out.println("What is the name of the file you want to create? ");
					Scanner sc2 = new Scanner (System.in);
					String newFile = sc2.nextLine();
					
					File File1 = new File ("C:\\document\\mystuff" + newFile);
					
					System.out.println("Your new file has beeen created at:\n C:\\document\\mystuff\\" + File1);
					}
					break;
					
			
			
			case 3: {
					
					System.out.println("What is the name of the file you want to delete? ");
					Scanner sc3 = new Scanner(System.in);
					String deleteFile = sc3.nextLine();
				
					File fileName = new File("filename.txt"); 
				 
					if (fileName.delete()) { 
				      System.out.println("Deleted the file: " + fileName.getName());  
						} else {
							System.out.println("Failed to delete the file.");
				 			}
					}
					break;   
				 		
					
			
			case 4: {
				
					System.out.println("What is the name of the file you want to find? ");
					Scanner sc4 = new Scanner (System.in);
					String search = sc4.nextLine();
					
					File dir = new File("C:\\Files");
					File[] newSearch = dir.listFiles((dir1, name) -> name.startsWith(search));
					
					System.out.println("The file" + newSearch + "has been located");
					}
					break;
		
					
					
			case 5: {
				
					System.out.println("Are you sure you want to exit the application? ");
					Scanner sc5 = new Scanner (System.in);
					String exit = sc5.nextLine();
					
					if (exit.equalsIgnoreCase("yes")) {
					
						System.exit(1);
					}
					}
			
		default:
	
		}
		}
	while (choice !=-1);
	}
}




