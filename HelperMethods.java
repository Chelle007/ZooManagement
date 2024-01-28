import java.util.ArrayList;
import java.util.Scanner;

public class HelperMethods {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Zoo> zoos = ZooManagement.getZoos();

	// ADDITIONAL METHODS

	// Method to show zoo list and return the choice in integer
	public static int selectZoo() {
		
		System.out.println("\nZoo list:");
		for (int i = 0; i<zoos.size(); i++) {
			System.out.printf("%d. %s%n", i+1, zoos.get(i).getName());
		}
		System.out.println("0. Go back");

		int zooChoice = checkInt("Enter your choice: ", 0, zoos.size());
		
		return zooChoice;
		
	}
	
	// Method to show enclosure list and return the choice in integer
	public static int selectEnclosure(Zoo choosenZoo) {
		
		System.out.println("\nEnclosure list:");
		for (int i = 0; i<choosenZoo.getEnclosures().size(); i++) {
			System.out.printf("%d. %s%n", i+1, choosenZoo.getEnclosures().get(i).getName());
		}
		System.out.println("0. Go back");
		
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
					if (end == Integer.MAX_VALUE) System.out.println("Error. Please input number correctly.");
					else System.out.printf("Error. Please input number between %s and %s.%n", start, end);
				}
				
				else return answer;
			}
			catch (Exception e) {
				System.out.println("Error. Please input number correctly.");
				input.reset();
				input.nextLine();
			}
		}
	}	
}
