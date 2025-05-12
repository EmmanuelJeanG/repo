package application;

import java.util.*;

public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns;
    private Set<Road> roads;
    private Map<Town, Integer> distances;
    private Map<Town, Town> predecessors;

    /**
     * Constructs an empty graph.
     */
    public Graph() {
        towns = new HashSet<>();
        roads = new HashSet<>();
    }

    /**
     * Gets the road that connects two towns.
     * @param source the source town
     * @param destination the destination town
     * @return the connecting road if it exists, otherwise null
     */
    @Override
    public Road getEdge(Town source, Town destination) {
        for (Road road : roads) {
            if (road.contains(source) && road.contains(destination)) {
                return road;
            }
        }
        return null;
    }

    /**
     * Adds a road between two existing towns.
     * @param source the source town
     * @param destination the destination town
     * @param weight the distance of the road
     * @param description the name of the road
     * @return the added Road object
     */
    @Override
    public Road addEdge(Town source, Town destination, int weight, String description) {
        if (!towns.contains(source) || !towns.contains(destination))
            throw new IllegalArgumentException();
        Road road = new Road(source, destination, weight, description);
        roads.add(road);
        return road;
    }

    /**
     * Adds a town to the graph.
     * @param town the town to add
     * @return true if added successfully, false if it already exists
     */
    @Override
    public boolean addVertex(Town town) {
        if (town == null) throw new NullPointerException();
        return towns.add(town);
    }

    /**
     * Checks if the edge exists between two towns.
     * @param source the source town
     * @param destination the destination town
     * @return true if the edge exists, false otherwise
     */
    @Override
    public boolean containsEdge(Town source, Town destination) {
        return getEdge(source, destination) != null;
    }

    /**
     * Checks if a town is in the graph.
     * @param town the town to check
     * @return true if the town exists in the graph
     */
    @Override
    public boolean containsVertex(Town town) {
        return towns.contains(town);
    }

    /**
     * Gets all roads in the graph.
     * @return a set of all roads
     */
    @Override
    public Set<Road> edgeSet() {
        return roads;
    }

    /**
     * Gets all roads connected to a town.
     * @param town the town to check
     * @return a set of roads connected to the town
     */
    @Override
    public Set<Road> edgesOf(Town town) {
        if (!towns.contains(town)) throw new IllegalArgumentException();
        Set<Road> connected = new HashSet<>();
        for (Road road : roads) {
            if (road.contains(town)) {
                connected.add(road);
            }
        }
        return connected;
    }

    /**
     * Removes a road from the graph.
     * @param source the source town
     * @param destination the destination town
     * @param weight the weight of the road
     * @param description the name of the road
     * @return the removed road if found, otherwise null
     */
    @Override
    public Road removeEdge(Town source, Town destination, int weight, String description) {
        Road toRemove = null;
        for (Road road : roads) {
            if (road.contains(source) && road.contains(destination)
                    && road.getWeight() == weight && road.getName().equals(description)) {
                toRemove = road;
                break;
            }
        }
        if (toRemove != null) {
            roads.remove(toRemove);
        }
        return toRemove;
    }

    /**
     * Removes a town and all its connected roads.
     * @param town the town to remove
     * @return true if the town was removed
     */
    @Override
    public boolean removeVertex(Town town) {
        if (!towns.contains(town)) return false;
        towns.remove(town);
        roads.removeIf(road -> road.contains(town));
        return true;
    }

    /**
     * Gets all towns in the graph.
     * @return a set of all towns
     */
    @Override
    public Set<Town> vertexSet() {
        return towns;
    }

    /**
     * Runs Dijkstra's algorithm from the given source town.
     * @param source the starting town
     */
    @Override
    public void dijkstraShortestPath(Town source) {
        distances = new HashMap<>();
        predecessors = new HashMap<>();
        Set<Town> visited = new HashSet<>();
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Town town : towns) {
            distances.put(town, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            visited.add(current);

            for (Road road : edgesOf(current)) {
                Town neighbor = road.getDestination().equals(current) ? road.getSource() : road.getDestination();
                if (visited.contains(neighbor)) continue;

                int newDist = distances.get(current) + road.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    predecessors.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    /**
     * Returns the shortest path from source to destination as a list of descriptions.
     * @param source the starting town
     * @param destination the destination town
     * @return a list of strings representing the shortest path, or an empty list if none exists
     */
    @Override
    public ArrayList<String> shortestPath(Town source, Town destination) {
        dijkstraShortestPath(source);
        ArrayList<String> path = new ArrayList<>();
        if (!predecessors.containsKey(destination)) return path;

        Town current = destination;
        while (!current.equals(source)) {
            Town prev = predecessors.get(current);
            Road road = getEdge(current, prev);
            path.add(0, prev + " via " + road.getName() + " to " + current + " " + road.getWeight() + " mi");
            current = prev;
        }
        return path;
    }
}

