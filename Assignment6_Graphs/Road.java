package application;

public class Road implements Comparable<Road>{
	private Town source;
    private Town destination;
    private String name;
    private int degrees;

    public Road(Town source, Town destination, int degrees, String name) {
        this.source = source;
        this.destination = destination;
        this.degrees = degrees;
        this.name = name;
    }

    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);
    }
    
    public String getName() {
        return name;
    }

    public int getWeight() {
        return degrees;
    }
    
    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }
    
    public boolean contains(Town town) {
        if (town == null) return false;
        return source.equals(town) || destination.equals(town) ? true : false;
    }
    
    @Override
    public int compareTo(Road o) {
        if (this.name.equalsIgnoreCase(o.name)) {
            return 0;
        }
        return this.name.compareToIgnoreCase(o.name) > 0 ? 1 : -1;
    }
    
    @Override
    public boolean equals(Object r) {
        if (this == r) return true;
        if (!(r instanceof Road)) return false;
        Road road = (Road) r;

        boolean sameTowns = 
            (this.source.equals(road.source) && this.destination.equals(road.destination)) ||
            (this.source.equals(road.destination) && this.destination.equals(road.source));

        return sameTowns && this.name.equalsIgnoreCase(road.name) ? true : false;
    }
    
    @Override
    public String toString() {
        return source + " via " + name + " to " + destination + " " + degrees + " mi";
    }

}
