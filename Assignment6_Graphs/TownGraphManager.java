package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph;  

    /**
     * Constructs a TownGraphManager with an empty Graph.
     */
    public TownGraphManager() {
        graph = new Graph();
    }

    /**
     * Adds a road between two towns.
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @param weight the distance of the road
     * @param roadName the name of the road
     * @return true if the road was successfully added
     */
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town t1 = new Town(town1);
        Town t2 = new Town(town2);
        graph.addVertex(t1);
        graph.addVertex(t2);
        return graph.addEdge(t1, t2, weight, roadName) != null;
    }

    /**
     * Gets the name of the road that connects two towns.
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @return the road name, or null if no connection exists
     */
    @Override
    public String getRoad(String town1, String town2) {
        Road road = graph.getEdge(new Town(town1), new Town(town2));
        return (road != null) ? road.getName() : null;
    }

    /**
     * Adds a town to the graph.
     * @param v the name of the town
     * @return true if the town was successfully added
     */
    @Override
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    /**
     * Retrieves the Town object with the given name.
     * @param name the name of the town
     * @return the corresponding Town object, or null if not found
     */
    @Override
    public Town getTown(String name) {
        for (Town town : graph.vertexSet()) {
            if (town.getName().equalsIgnoreCase(name))
                return town;
        }
        return null;
    }

    /**
     * Checks if a town exists in the graph.
     * @param v the name of the town
     * @return true if the town exists, false otherwise
     */
    @Override
    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    /**
     * Checks if a road connection exists between two towns.
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @return true if a road connects them, false otherwise
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    /**
     * Gets all road names in the graph, sorted alphabetically.
     * @return a sorted ArrayList of road names
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> roads = new ArrayList<>();
        for (Road road : graph.edgeSet()) {
            roads.add(road.getName());
        }
        Collections.sort(roads);
        return roads;
    }

    /**
     * Deletes a road connection between two towns.
     * @param town1 the name of the first town
     * @param town2 the name of the second town
     * @param road the name of the road
     * @return true if the road was successfully deleted
     */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Road target = graph.getEdge(new Town(town1), new Town(town2));
        if (target != null && target.getName().equalsIgnoreCase(road)) {
            return graph.removeEdge(new Town(town1), new Town(town2), target.getWeight(), target.getName()) != null;
        }
        return false;
    }

    /**
     * Deletes a town from the graph.
     * @param v the name of the town
     * @return true if the town was successfully deleted
     */
    @Override
    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    /**
     * Gets all town names in the graph, sorted alphabetically.
     * @return a sorted ArrayList of town names
     */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> towns = new ArrayList<>();
        for (Town town : graph.vertexSet()) {
            towns.add(town.getName());
        }
        Collections.sort(towns);
        return towns;
    }

    /**
     * Gets the shortest path between two towns.
     * @param town1 the name of the starting town
     * @param town2 the name of the destination town
     * @return an ArrayList of step strings representing the shortest path
     */
    @Override
    public ArrayList<String> getPath(String town1, String town2) {
    	ArrayList<String> path = graph.shortestPath(new Town(town1), new Town(town2));
        return path;
    }

    /**
     * Populates the graph from a text file where each line has format: roadName,distance;town1;town2
     * @param file the File object containing the graph data
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if an I/O error occurs
     */
    public void populateTownGraph(File file) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("[,;]");
            if (parts.length != 4) continue;

            String roadName = parts[0];
            int distance = Integer.parseInt(parts[1]);
            String town1 = parts[2];
            String town2 = parts[3];

            addTown(town1);
            addTown(town2);
            addRoad(town1, town2, distance, roadName);
        }
        scanner.close();
    }
}

