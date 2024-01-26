import java.util.ArrayList;

public class Zoo {
    private String name;
    private String description;
    private ArrayList<Enclosure> enclosures;

    // Constructor
    public Zoo (String name, String description, ArrayList<Enclosure> enclosures)
    {
        this.name = name;
        this.description = description;
        this.enclosures = enclosures;
    }

    // Getters
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public ArrayList<Enclosure> getEnclosures()
    {
        return enclosures;
    }
    
    // Methods
    public int getTotalEnclosureArea() {
    	return 0;
    }
    
    public int countEnclosures() {
    	return 0;
    }
}
