import java.util.ArrayList;
import java.util.Scanner;

public class HelperMethods {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Zoo> zoos = ZooManagement.getZoos();

	
	// ADDITIONAL METHODS

	// Method to show zoo list and return the choice in integer
	public static int selectZoo() {
		
		printColor("\nZoo list:", "blue");
		for (int i = 0; i<zoos.size(); i++) {
			printColor(String.format("%d. %s", i+1, zoos.get(i).getName()), "blue");
		}
		printColor("0. Go back", "blue");

		int zooChoice = checkInt("Enter your choice: ", 0, zoos.size());
		
		return zooChoice;
		
	}
	
	// Method to show enclosure list and return the choice in integer
	public static int selectEnclosure(Zoo choosenZoo) {
		
		printColor("\nEnclosure list:", "blue");
		for (int i = 0; i<choosenZoo.getEnclosures().size(); i++) {
			printColor(String.format("%d. %s", i+1, choosenZoo.getEnclosures().get(i).getName()), "blue");
		}
		printColor("0. Go back", "blue");
		
		int enclosureChoice = checkInt("Enter your choice: ", 0, choosenZoo.getEnclosures().size());
		
		return enclosureChoice;
		
	}
	
	// Method to ask for details (name, description, area, etc) and return the answers
	public static String[] enterDetails(String type) {
		// Opening
		System.out.printf("%nEnter %s details: (Enter 0 to go back)%n", type);
		String first = "Name";
		String second = "Area Needed";
		String[] answers = new String[2];
		
		// Set question
		if (type.equals("Zoo")) second = "Description";
		else if (type.equals("Enclosure")) second = "Area";
		else if (type.equals("Animal")) first = "Species";
		
		// First question
		System.out.printf("%s: ", first);
		answers[0] = input.nextLine();
		if (answers[0].equals("0")) return answers;
		
		// Second question
		if (type.equals("Enclosure") || type.equals("Animal")) {
			answers[1] = "" + checkInt(String.format("%s: ", second));
		}
		else {
			System.out.printf("%s: ", second);
			answers[1] = input.nextLine();
		}
		
		return answers;
	}
	
	
	// CONSOLE INTERFACE METHODS
	
	public static void printColor(String output, String color) {
		String ansi_color = "\u001B[0m";
		String ansi_reset = "\u001B[0m";
		
		switch (color) {
			case "red": ansi_color = "\u001B[31m"; break;
			case "yellow": ansi_color = "\u001B[33m"; break;
			case "green": ansi_color = "\u001B[32m"; break;
			case "blue": ansi_color = "\u001B[34m"; break;
		}
		
		System.out.println(ansi_color + output + ansi_reset);
	}
	
	
	// ERROR HANDLING METHODS
	
	// Method to check whether the input is integer
	public static int checkInt(String question) {
		return checkInt(question, 0, Integer.MAX_VALUE);
	}
	
	// Method to check whether the input is integer and is between the minimum and maximum choice
	public static int checkInt(String question, int start, int end) {
		while (true) {
			System.out.print(question);
			
			try {
				int answer = input.nextInt();
				input.nextLine();
				
				if (answer < start || answer > end) {
					if (end == Integer.MAX_VALUE) printColor("Error. Please input number correctly.", "red");
					else printColor(String.format("Error. Please input number between %s and %s.", start, end), "red");
				}
				
				else return answer;
			}
			catch (Exception e) {
				printColor("Error. Please input number correctly.", "red");
				input.reset();
				input.nextLine();
			}
		}
	}
}
