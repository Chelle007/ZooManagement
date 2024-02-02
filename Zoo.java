import java.util.ArrayList;

public class Zoo implements HelperMethods.ZooContainer {
    private String name;
    private String description;
    private ArrayList<Enclosure> enclosures;

    // Constructor
    public Zoo (String name, String description, ArrayList<Enclosure> enclosures) {
        this.name = name;
        this.description = description;
        this.enclosures = enclosures;
    }

    // Getters
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ArrayList<Enclosure> getEnclosures() {
        return enclosures;
    }
    
    // Setters
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public void setEnclosures(ArrayList<Enclosure> enclosures) {
    	this.enclosures = enclosures;
    }
    
    // Methods
    public int getTotalEnclosureArea() {
        int totalEnclosureArea = 0;
        for (int i = 0; i < enclosures.size(); i++) {
            totalEnclosureArea += enclosures.get(i).getArea();
        }
        return totalEnclosureArea;
    }

    public int countEnclosures() {
        return enclosures.size();
    }
}
