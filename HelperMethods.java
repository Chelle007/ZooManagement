import java.util.ArrayList;
import java.util.Scanner;

public class HelperMethods {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Zoo> zoos = ZooManagement.getZoos();

	
	// ADDITIONAL METHODS

	// Method to show zoo list and return the choice in integer
	public static int selectZoo() {
		
		printlnColor("\nZoo list:", "blue bold");
		for (int i = 0; i<zoos.size(); i++) {
			printlnColor(String.format("%d. %s", i+1, zoos.get(i).getName()), "blue");
		}
		printlnColor("0. Go back", "blue");

		int zooChoice = checkInt("Enter your choice: ", 0, zoos.size());
		
		return zooChoice;
		
	}
	
	// Method to show enclosure list and return the choice in integer
	public static int selectEnclosure(Zoo choosenZoo) {
		
		printlnColor("\nEnclosure list:", "blue bold");
		for (int i = 0; i<choosenZoo.getEnclosures().size(); i++) {
			printlnColor(String.format("%d. %s", i+1, choosenZoo.getEnclosures().get(i).getName()), "blue");
		}
		printlnColor("0. Go back", "blue");
		
		int enclosureChoice = checkInt("Enter your choice: ", 0, choosenZoo.getEnclosures().size());
		
		return enclosureChoice;
		
	}
	
	// Methods to ask for details (name, description, area, etc) and return the answers
	public static String[] enterDetails(String type) {
		return enterDetails(type, null);
	}
	
	public static String[] enterDetails(String type, ArrayList<? extends ZooContainer> enclosures) {
		// Opening
		printColor(String.format("%nEnter %s details:", type), "bold");
		System.out.println(" (Enter 0 to go back)");
		String second = "error";
		String[] answers = new String[2];
		
		// Set question
		if (type.equals("Zoo")) second = "Description";
		else if (type.equals("Enclosure")) second = "Area";
		else if (type.equals("Animal")) second = "Area Needed";
		
		// First question
		if (type.equals("Zoo")) answers[0] = checkName("Name (case sensitive): ", zoos);
		else if (type.equals("Enclosure")) answers[0] = checkName("Name (case sensitive): ", enclosures);
		else {
			System.out.print("Species (case insensitive): ");
			answers[0] = input.nextLine();
		}
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
	
	// Methods to print with color
	public static void printlnColor(String output, String color) {
		printColor(output + "\n", color);
	}
	
	public static void printColor(String output, String color) {
		String ansi_color = "\u001B[0m";
		String ansi_reset = "\u001B[0m";
		
		switch (color) {
			case "red": ansi_color = "\u001B[31m"; break;
			case "yellow": ansi_color = "\u001B[33m"; break;
			case "green": ansi_color = "\u001B[32m"; break;
			case "blue": ansi_color = "\u001B[34m"; break;
			case "bold": ansi_color = "\033[0;1m"; break;
			case "blue bold": ansi_color = "\033[1;34m"; break;
		}
		
		System.out.print(ansi_color + output + ansi_reset);
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
					if (end == Integer.MAX_VALUE) printlnColor("Error. Please input number correctly.", "red");
					else printlnColor(String.format("Error. Please input number between %s and %s.", start, end), "red");
				}
				
				else return answer;
			}
			catch (Exception e) {
				printlnColor("Error. Please input number correctly.", "red");
				input.reset();
				input.nextLine();
			}
		}
	}
	
	// Methods to check whether the name has been used
	public static String checkName(String question, ArrayList<? extends ZooContainer> arrlist) {
		String name = "";
		boolean found = true;
		
		while (found) {
			found = false;
			
			System.out.print(question);
			name = input.nextLine();
			
			for (ZooContainer element : arrlist) {
				if (element.getName().equals(name)) {
					found = true;
					break;
				}
			}
			
			if (found) printlnColor("Name has been taken, please input another name.", "red");
			else break;
		}
		
		return name;
	}
	
	interface ZooContainer {
	    String getName();
	}
}
