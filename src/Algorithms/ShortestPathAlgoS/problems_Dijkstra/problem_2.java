package Algorithms.ShortestPathAlgoS.problems_Dijkstra;
// Question: You are developing a flight route planning system. Given a list of airports and the flights between them, each with a specific duration, write a Java program to find the shortest route between two airports.
// Implement Dijkstra's algorithm to find the shortest route from the source airport to the destination airport, considering the flight durations as weights. Assume that the flights are represented as a graph with airports as nodes and flights as edges, and each edge has a weight representing the duration of the flight.
// Implement the 'shortestRoute' function to calculate the shortest route from the source airport to the destination airport and return the route as a list of airports.

import java.util.*;

public class problem_2 {
    public static class Airport {
        private String name;
        private int id;

        public Airport(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    public static class Flight {
        private Airport source;
        private Airport destination;
        private int duration;

        public Flight(Airport source, Airport destination, int duration) {
            this.source = source;
            this.destination = destination;
            this.duration = duration;
        }

        public Airport getSource() {
            return source;
        }

        public Airport getDestination() {
            return destination;
        }

        public int getDuration() {
            return duration;
        }
    }

    public static List<Airport> shortestRoute(List<Airport> airports, List<Flight> flights, Airport source, Airport destination) {
        Map<Airport, Integer> distanceTable = new HashMap<>();
        Map<Airport, Airport> previousTable = new HashMap<>();
        Set<Airport> visited = new HashSet<>();

        // Initialize distances to infinity
        for (Airport airport : airports) {
            distanceTable.put(airport, Integer.MAX_VALUE);
        }

        // Set distance of source airport to 0
        distanceTable.put(source, 0);

        // Main loop
        while (!visited.contains(destination)) {
            Airport currentAirport = getMinDistanceAirport(distanceTable, visited);

            if (currentAirport == null) {
                break; // No more reachable airports
            }

            visited.add(currentAirport);

            for (Flight flight : flights) {
                if (flight.getSource().equals(currentAirport)) {
                    int duration = distanceTable.get(currentAirport) + flight.getDuration();
                    if (duration < distanceTable.get(flight.getDestination())) {
                        distanceTable.put(flight.getDestination(), duration);
                        previousTable.put(flight.getDestination(), currentAirport);
                    }
                }
            }
        }

        return reconstructRoute(previousTable, source, destination);
    }

    private static Airport getMinDistanceAirport(Map<Airport, Integer> distanceTable, Set<Airport> visited) {
        int minDistance = Integer.MAX_VALUE;
        Airport minAirport = null;
        for (Map.Entry<Airport, Integer> entry : distanceTable.entrySet()) {
            Airport airport = entry.getKey();
            int distance = entry.getValue();
            if (distance < minDistance && !visited.contains(airport)) {
                minDistance = distance;
                minAirport = airport;
            }
        }
        return minAirport;
    }

    private static List<Airport> reconstructRoute(Map<Airport, Airport> previousTable, Airport source, Airport destination) {
        List<Airport> route = new ArrayList<>();
        Airport currentAirport = destination;
        while (currentAirport != null && !currentAirport.equals(source)) {
            route.add(currentAirport);
            currentAirport = previousTable.get(currentAirport);
        }
        if (currentAirport != null && currentAirport.equals(source)) {
            route.add(source);
            Collections.reverse(route);
        } else {
            route.clear(); // No route found
        }
        return route;
    }

    public static void main(String[] args) {
        // Define airports
        Airport airportA = new Airport("Airport A", 1);
        Airport airportB = new Airport("Airport B", 2);
        Airport airportC = new Airport("Airport C", 3);
        Airport airportD = new Airport("Airport D", 4);
        Airport airportE = new Airport("Airport E", 5);

        // Define flights
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(airportA, airportB, 2));
        flights.add(new Flight(airportA, airportC, 4));
        flights.add(new Flight(airportB, airportC, 1));
        flights.add(new Flight(airportB, airportD, 7));
        flights.add(new Flight(airportC, airportE, 3));
        flights.add(new Flight(airportD, airportE, 1));
        flights.add(new Flight(airportD, airportA, 5));

        // Find the shortest route
        List<Airport> shortestRoute = shortestRoute(Arrays.asList(airportA, airportB, airportC, airportD, airportE), flights, airportA, airportE);

        if (shortestRoute.isEmpty()) {
            System.out.println("No route found.");
        } else {
            System.out.println("Shortest route:");
            for (Airport airport : shortestRoute) {
                System.out.println(airport.getName());
            }
        }
    }
}
