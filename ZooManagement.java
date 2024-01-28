import java.util.ArrayList;
import java.util.Scanner;

public class ZooManagement {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Zoo> zoos = new ArrayList<Zoo>();
	
	// Getter to connect the ArrayList to HelperMethods class
	public static ArrayList<Zoo> getZoos() {
		return zoos;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Zoo Management System!");
		
		mainMenu(true);
	}
	
	public static void mainMenu(boolean firstTime) {
		if (!firstTime) System.out.println("\n======================================================");
		System.out.println("\nZoo Management System");
		System.out.println("1. Manage Zoos");
		System.out.println("2. Manage Enclosures");
		System.out.println("3. Manage Animals");
		System.out.println("4. Exit");

		int choice = HelperMethods.checkInt("Enter your choice: ", 1, 4);
		
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

		int choice = HelperMethods.checkInt("Enter your choice: ", 1, 5);
		
		if (choice == 1) {
			String[] answers = HelperMethods.enterDetails("Zoo");
			
			if (answers[0].equals("0") || answers[1].equals("0")) System.out.println("Going back...");
			
			else {
				Zoo newZoo = new Zoo(answers[0], answers[1], new ArrayList<Enclosure>());
				zoos.add(newZoo);
				System.out.println("\nZoo created successfully!");
			}
		}
		
		else if (choice == 2) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				zoos.remove(zooChoice);
				System.out.println("\nZoo deleted successfully!");
			}
		}
		
		else if (choice == 3) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				int totalArea = zoos.get(zooChoice).getTotalEnclosureArea();
				System.out.printf("\nTotal area of all enclosures in the zoo: %d square units%n", totalArea);
			}
		}
		
		else if (choice == 4) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
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

		int choice = HelperMethods.checkInt("Enter your choice: ", 1, 6);
		
		if (choice == 1) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				String[] answers = HelperMethods.enterDetails("Enclosure");
				
				if (answers[0].equals("0") || answers[1].equals("0")) System.out.println("Going back...");
				
				else {
					Enclosure newEnclosure = new Enclosure(answers[0], Integer.parseInt(answers[1]), new ArrayList<Animal>());
					
					ArrayList<Enclosure> Enclosures = choosenZoo.getEnclosures();
					
					Enclosures.add(newEnclosure);
					System.out.println("\nEnclosure added successfully!");
				}
			}
			
		}
		
		else if (choice == 2) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					ArrayList<Enclosure> Enclosures = choosenZoo.getEnclosures();
					
					Enclosures.remove(enclosureChoice);
					System.out.println("\nEnclosure deleted successfully!");
				}
			}
		}
		
		else if (choice == 3) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					
					System.out.printf("%nUtilised area: %d%n", choosenEnclosure.getUtilisedArea());
				}
			}
		}
		
		else if (choice == 4) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					
					System.out.printf("%nPercentage of utilised area: %.2f%n", choosenEnclosure.getUtilisedAreaPercentage());
				}
			}
		}
		
		else if (choice == 5) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					
					while (true) {
						System.out.print("\nEnter animal species (Enter 0 to go back): ");
						String animalSpecies = input.nextLine();
						
						if (animalSpecies.equals("0")) {
							System.out.println("Going back...");
							break;
						}
						
						else if (choosenEnclosure.countSpecies(animalSpecies) == 0) System.out.println("\nSpecies not found.");
						
						else {
							for (Animal animal : choosenEnclosure.getAnimals()) {
								if (animal.getSpecies().equals(animalSpecies)) {
									System.out.printf("%nNumber of species: %d%n", choosenEnclosure.countSpecies(animalSpecies));
									break;
								}
							}
							break;
						}
					}
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
	
		int choice = HelperMethods.checkInt("Enter your choice: ", 1, 4);
		
		if (choice == 1) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
				
				while (true) {
					String[] answers = HelperMethods.enterDetails("Animal");
					
					if (answers[0].equals("0") || answers[1].equals("0")) {
						System.out.println("Going back...");
						break;
					}
					
					else {
						Animal newAnimal = new Animal(answers[0], choosenEnclosure, Integer.parseInt(answers[1]));
						if (choosenEnclosure.addAnimal(newAnimal)) {
							System.out.println("\nAnimal added successfully!");
							break;
						}
						else System.out.println("The needed area exceeds area in enclosure.");
					}
				}
			}
		}
		
		else if (choice == 2) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					
					ArrayList<Animal> animals = choosenEnclosure.getAnimals();
					
					animals.clear();
					System.out.println("\nAnimals removed successfully!");
				}
			}
		}
		
		else if (choice == 3) {
			int zooChoice = HelperMethods.selectZoo()-1;
			
			if (zooChoice != -1) {
				Zoo choosenZoo = zoos.get(zooChoice);
				
				int enclosureChoice = HelperMethods.selectEnclosure(choosenZoo)-1;
				
				if (enclosureChoice != -1) {
					Enclosure choosenEnclosure = choosenZoo.getEnclosures().get(enclosureChoice);
					while (true) {
						System.out.print("\nEnter animal species (Enter 0 to go back): ");
						String animalSpecies = input.nextLine();
						
						if (animalSpecies.equals("0")) {
							System.out.println("Going back...");
							break;
						}
						
						else if (choosenEnclosure.countSpecies(animalSpecies) == 0) System.out.println("\nSpecies not found.");
						
						else {
							for (Animal animal : choosenEnclosure.getAnimals()) {
								if (animal.getSpecies().equals(animalSpecies)) {
									if (animal.hasCompanion()) System.out.println("\nThis animal has companion.");
									else System.out.println("\nThis animal does not have companion.");
									
									break;
								}
							}
							break;
						}
					}
				}
			}
		}
		
		if (choice == 4) mainMenu(false);
		else manageAnimals();
	}
	
}
