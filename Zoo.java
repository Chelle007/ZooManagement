import java.util.ArrayList;

public class Zoo {
    private String name;
    private String description;
    private ArrayList<Enclosure> enclosures;

    // constructor
    public Zoo (String name, String description, ArrayList<Enclosure> enclosures)
    {
        this.name = name;
        this.description = description;
        this.enclosures = enclosures;
    }

    // setters and getters
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setDescription(String description)
    {
    	this.description = description;
    }
    public String getDescription()
    {
        return description;
    }
    
    public ArrayList<Enclosure> getEnclosures()
    {
        return enclosures;
    }
    
    // methods
    public int getTotalEnclosureArea() {
    	return 0;
    }
    
    public int countEnclosures() {
    	return 0;
    }
}
