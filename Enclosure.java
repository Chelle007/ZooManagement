import java.util.ArrayList;

public class Enclosure {
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
    public String getName(){
        return name;
    }

    public int getArea(){
        return area;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    
    // Methods
    public int countAnimal(){
        return animals.size();
    }
    
    public int getUtilisedArea(){
        int utilisedArea = 0;
        for(Animal animal : animals){
            utilisedArea = utilisedArea + animal.getAreaNeeded();
        }
        return utilisedArea;
    }
    
    public double getUtilisedAreaPercentage(){
        return (double)getUtilisedArea()/getArea()*100;
    }
    
    public int countSpecies(String type){
        int speciesCount = 0;
        for (Animal animal : animals) {
            if (type.equals(animal.getSpecies())) {
                speciesCount++;
            }
        }
        return speciesCount;
    }
    
    public boolean addAnimal(Animal animal){
        if ((getUtilisedArea() + animal.getAreaNeeded()) <= getArea()) {
            animals.add(animal);
            return true;
        }
        else {
            return false;
        }
    }
    
}
