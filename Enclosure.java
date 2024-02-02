import java.util.ArrayList;

public class Enclosure implements HelperMethods.ZooContainer {
    private String name;
    private int area;
    private ArrayList<Animal> animals;

    // Constructor
    public Enclosure(String name, int area, ArrayList<Animal> animals){
        this.name = name;
        this.area = area;
        this.animals = animals;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    // Setters
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setArea(int area) {
    	this.area = area;
    }
    
    public void setAnimals(ArrayList<Animal> animals) {
    	this.animals = animals;
    }
    
    // Methods
    public int countAnimal() {
        return animals.size();
    }
    
    public int getUtilisedArea() {
        int utilisedArea = 0;
        for(Animal animal : animals){
            utilisedArea = utilisedArea + animal.getAreaNeeded();
        }
        return utilisedArea;
    }
    
    public double getUtilisedAreaPercentage() {
        return (double)getUtilisedArea()/getArea();
    }
    
    public int countSpecies() {
        ArrayList<String> uniqueSpecies = new ArrayList<>();
        for (Animal animal : animals){
            if (!uniqueSpecies.contains(animal.getSpecies()))
                uniqueSpecies.add(animal.getSpecies());
        }
        return uniqueSpecies.size();
    }
    
    public boolean addAnimal(Animal animal) {
        if ((getUtilisedArea() + animal.getAreaNeeded()) <= getArea()) {
            animals.add(animal);
            return true;
        }
        else {
            return false;
        }
    }
    
}