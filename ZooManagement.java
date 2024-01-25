import java.util.ArrayList;
import java.util.Scanner;

/* Some part that can be improved:
 * - simplify check name availability
 * - simplify checkInt (maybe can combine with checkChoice)
 * - simplify selectList methods (? idk whether this can/not be simplified)
 * - simplify selectList in main too (?) for example choice 2 -> 3,4,5 & choice 3 -> 1 they're repetitive
 * - improve interface
 */

public class ZooManagement {
	private static ArrayList<Zoo> zoos = new ArrayList<Zoo>();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Zoo Management System!");
		
		mainMenu(true);
	}
	
	public static void mainMenu(boolean firstTime) {
		if (!firstTime) {
			System.out.println("\n======================================================");
		}
		System.out.println("\nZoo Management System");
		System.out.println("1. Manage Zoos");
		System.out.println("2. Manage Enclosures");
		System.out.println("3. Manage Animals");
		System.out.println("4. Exit");

		int choice = checkChoice(1, 4);
		
		switch (choice) {
			case 1: manageZoos(); break;
			case 2: manageEnclosures(); break;
			case 3: manageAnimals(); break;
			case 4: System.out.println("\nExiting Zoo Management System. Goodbye!"); break;
		}
	}
	
	public static void manageZoos() {
		System.out.println("\n======================================================\n\nZoo Management - Manage Zoos");
		System.out.println("1. Create new Zoo");
		System.out.println("2. Delete existing Zoo");
		System.out.println("3. Calculate total area of all enclosures in the zoo");
		System.out.println("4. Count total number of enclosures");
		System.out.println("5. Back to main menu");

		int choice = checkChoice(1, 5);
		
		if (choice == 1) {
			
			while (true) {
				System.out.println("\nEnter Zoo details: (Enter 0 to go back)");
				
				System.out.print("Name: ");
				String zooName = input.next();
				
				if (zooName.equals("0")) {
					System.out.println("Going back...");
					break;
				}
				
				System.out.print("Description: ");
				String zooDesc = input.next();
				
				if (zooDesc.equals("0")) {
					System.out.println("Going back...");
					break;
				}
					
				Zoo newZoo = new Zoo(zooName, zooDesc, new ArrayList<Enclosure>());
				zoos.add(newZoo);
				System.out.println("\nZoo created successfully!");
				break;
			}
			
		}
		
		if (choice == 2) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				zoos.remove(zooChoice);
				System.out.println("\nZoo deleted successfully!");
			}
		}
		
		if (choice == 3) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				int totalArea = zoos.get(zooChoice).getTotalEnclosureArea();
				System.out.printf("\nTotal area of all enclosures in the zoo: %d square units%n", totalArea);
			}
		}
		
		if (choice == 4) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				int totalEnclosure = zoos.get(zooChoice).countEnclosures();
				System.out.printf("\nTotal number of enclosures in the zoo: %d%n", totalEnclosure);
			}
		}
		
		if (choice == 5) mainMenu(false);
		else manageZoos();
	}
	
	public static void manageEnclosures() {
		System.out.println("\n======================================================\n\nZoo Management - Manage Enclosures");
		System.out.println("1. Add an Enclosure to a Zoo");
		System.out.println("2. Delete an existing Enclosure from a Zoo");
		System.out.println("3. Get utilised area in a given enclosure");
		System.out.println("4. Get percentage of utilised area in a given enclosure");
		System.out.println("5. Count number of species in an enclosure");
		System.out.println("6. Back to main menu");

		int choice = checkChoice(1, 6);
		
		if (choice == 1) {
			int zooChoice = selectZoo()-1;
			
			if (zooChoice != -1) {
				
				while (true) {
					Zoo choosenZoo = zoos.get(zooChoice);
					System.out.println("\nEnter Enclosure details: (Enter 0 to go back)");
					
					System.out.print("Name: ");
					String enclosureName = input.next();
					
					if (enclosureName.equals("0")) {
						System.out.println("Going back...");
						break;
					}
					
					int area = checkInt("Area: ");
					
					if (area == 0) {
						System.out.println("Going back...");
						break;
					}
				
					Enclosure newEnclosure = new Enclosure(enclosureName, area, new ArrayList<Animal>());
					ArrayList<Enclosure> Enclosures = choosenZoo.getEnclosures();
					Enclosures.add(newEnclosure);
					System.out.println("\nEnclosure added successfully!");
					break;
				}
				
			}
		}
		
		if (choice == 2) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					ArrayList<Enclosure> Enclosures = choosenZoo.getEnclosures();
					Enclosures.remove(enclosureChoice);
					System.out.println("\nEnclosure deleted successfully!");
				}
			}
		}
		
		if (choice == 3) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					System.out.printf("Utilised area: %d%n", choosenEnclosure.getUtilisedArea());
				}
			}
		}
		
		if (choice == 4) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					System.out.printf("Percentage of utilised area: %.2f%%n", choosenEnclosure.getUtilisedAreaPercentage());
				}
			}
		}
		
		if (choice == 5) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					System.out.printf("Number of species: %.2f%%n", choosenEnclosure.countAnimal()); // still not sure about this method
				}
			}
		}
		
		if (choice == 6) mainMenu(false);
		else manageEnclosures();
	}
	
	public static void manageAnimals() {
		System.out.println("\n======================================================\n\nZoo Management - Manage Animals");
		System.out.println("1. Add animals to an Enclosure");
		System.out.println("2. Remove animals from an Enclosure");
		System.out.println("3. Check if an animal has a companion in its enclosure");
		System.out.println("4. Back to main menu");
	
		int choice = checkChoice(1, 4);
		
		if (choice == 1) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					boolean err = true;

					while (err) {
						Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
						System.out.println("\nEnter animal details: (Enter 0 to go back)");
						
						System.out.print("Species: ");
						String animalSpecies = input.next();
						
						if (animalSpecies.equals("0")) {
							System.out.println("Going back...");
							break;
						}
						
						int areaNeeded = checkInt("Area needed: ");
					
						if (areaNeeded == 0) {
							System.out.println("Going back...");
							break;
						}
						
						Animal newAnimal = new Animal(animalSpecies, choosenEnclosure, areaNeeded);
						
						if (choosenEnclosure.addAnimal(newAnimal)) {
							System.out.println("\nAnimal added successfully!");
							break;
						}
						
						else {
							System.out.println("The needed area exceeds area in enclosure.");
							err = true;
						}
					}
					
				}
			}
		}
		
		if (choice == 2) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					ArrayList<Animal> animals = choosenEnclosure.getAnimals();
					animals.clear();
					
					System.out.println("\nAnimals removed successfully!");
				}
			}
		}
		
		if (choice == 3) {
			int zooChoice = selectZoo()-1;
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				int enclosureChoice = selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					boolean found = false;
					
					while (true) {
						Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
						System.out.print("\nEnter animal species (Enter 0 to go back): ");
						String animalSpecies = input.next();
						
						if (animalSpecies.equals("0")) {
							System.out.println("Going back...");
							break;
						}
						
						for (Animal animal : choosenEnclosure.getAnimals()) {
							if (animal.getSpecies().equals(animalSpecies)) {
								if (animal.hasCompanion()) {
									System.out.println("\nThis animal has companion.");
								}
								else {
									System.out.println("\nThis animal does not have companion.");
								}
								found = true;
								break;
							}
						}
						
						if (!found) {
							System.out.println("\nAnimal not found.");
						}
						else {
							break;
						}
					}
				}
			}
		}
		
		if (choice == 4) mainMenu(false);
		else manageAnimals();
	}
	
	// ADDITIONAL METHODS
	public static int selectZoo() {
		System.out.println("\nZoo list:");
		for (int i = 0; i<zoos.size(); i++) {
			System.out.printf("%d. %s%n", i+1, zoos.get(i).getName());
		}
		System.out.println("0. Go back");
		int zooChoice = checkChoice(0, zoos.size());
		return zooChoice;
	}
	
	public static int selectEnclosure(Zoo choosenZoo) {
		System.out.println("\nEnclosure list:");
		for (int i = 0; i<choosenZoo.getEnclosures().size(); i++) {
			System.out.printf("%d. %s%n", i+1, choosenZoo.getEnclosures().get(i).getName());
		}
		System.out.println("0. Go back");
		int enclosureChoice = checkChoice(0, choosenZoo.getEnclosures().size());
		return enclosureChoice;
	}
	
	// ERROR HANDLING METHODS
	public static int checkChoice(int start, int end) {
		while (true) {
			System.out.print("Enter your choice: ");
			try {
				int choice = input.nextInt();
				if (choice < start || choice > end) {
					System.out.println("Error. Please input correct choice.");
				}
				else {
					return choice;
				}
			}
			catch (Exception e) {
				System.out.println("Error. Please input correct choice.");
				input.reset();
				input.next();
			}
		}
	}
	
	public static int checkInt(String question) {
		while (true) {
			System.out.print(question);
			try {
				int answer = input.nextInt();
				if (answer < 0) {
					System.out.println("Error. Please input positive integer.");
				}
				else {
					return answer;
				}
			}
			catch (Exception e) {
				System.out.println("Error. Please input integer.");
				input.reset();
				input.next();
			}
		}
	}
	
}
