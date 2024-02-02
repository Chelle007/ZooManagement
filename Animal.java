public class Animal {
	private String species;
    private Enclosure enclosure;
    private int areaNeeded;
    
    // Constructor
    public Animal(String species, Enclosure enclosure, int areaNeeded){
        this.species = species.toLowerCase();
        this.enclosure = enclosure;
        this.areaNeeded = areaNeeded;
    }
    
    // Getters
    public String getSpecies(){
        return species;
    }

    public int getAreaNeeded(){
        return areaNeeded;
    }
    
    public Enclosure getEnclosure() {
        return enclosure;
    }
    
    // Method
    public boolean hasCompanion() {
        for(Animal animal: enclosure.getAnimals()){
            if(animal != this && animal.getSpecies().equals(species))
                return true;
        }
        return false;
    }
    
}
