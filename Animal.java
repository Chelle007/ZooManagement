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
    public String getSpecies() {
        return species;
    }

    public int getAreaNeeded() {
        return areaNeeded;
    }
    
    public Enclosure getEnclosure() {
        return enclosure;
    }
    
    // Setters
    public void setSpecies(String species) {
    	this.species = species.toLowerCase();
    }
    
    public void setAreaNeeded(int areaNeeded) {
    	this.areaNeeded = areaNeeded;
    }
    
    public void setEnclosure(Enclosure enclosure) {
    	this.enclosure = enclosure;
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
