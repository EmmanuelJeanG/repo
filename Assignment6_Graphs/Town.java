package application;

public class Town implements Comparable<Town>{
	private String name;

    public Town(String name) {
        this.name = name;
    }

    public Town(Town templateTown) {
        this.name = templateTown.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Town)) {
            return false;
        }
        Town other = (Town) obj;
        return name.equalsIgnoreCase(other.name) ? true : false;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public int compareTo(Town o) {
    	if (name.equalsIgnoreCase(o.name)) {
            return 0;
        }
        return name.compareToIgnoreCase(o.name) > 0 ? 1 : -1;
    }

}
