package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Airport;
import beans.Flight;
import beans.Route;
import dao.AirplaneDAO;
import dao.AirplaneTypeDAO;
import dao.AirportDAO;
import dao.FlightDAO;
import dao.RouteDAO;
import jdbcconnection.JDBCConnection;

public class EmployeeFlightService {

	public static Flight fmMenue(Scanner sc) {
		System.out.println("Select flight number");

		Connection conn = null;
		conn = JDBCConnection.getConnection();
		List<Flight> flightsToManage = new ArrayList<Flight>();
		Route route = new Route();
		Airport airportO = new Airport();
		Airport airportD = new Airport();
		try {
			FlightDAO fdao = new FlightDAO(conn);
			flightsToManage = fdao.readAllFlight();
			RouteDAO rdao = new RouteDAO(conn);
			AirportDAO adao = new AirportDAO(conn);
			for (Flight f : flightsToManage) {
				route = rdao.readRouteByID(f.getRoute_id());
				airportO = (Airport) adao.readAirportsByID(route.getOrigin_id()).get(0);
				airportD = (Airport) adao.readAirportsByID(route.getDestination_id()).get(0);
				System.out.println((flightsToManage.indexOf(f)) + 1 + "): " + airportO.getIata_id() + ", "
						+ airportO.getCity() + " -> " + airportD.getIata_id() + ", " + airportD.getCity());
			}
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = sc.nextInt();

		System.out.println("Please enter new Arrival Time or enter N/A for no change: ");
		sc.next();
		return flightsToManage.get(i - 1);
	}

	public static void EMP3(Flight fmMenue, Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Flight information              ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: View More Details            ║");
			System.out.println("║ 2: Update Details               ║");
			System.out.println("║ 3: Add Seats                    ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				viewFlightDetails(fmMenue, sc);
				break;
			case 2:
				UpdateFlightDetails(fmMenue, sc);
			case 3:
				seatMenue(fmMenue, sc);
			case 0:				
				return;
			}

		} while (true);

	}

	private static void seatMenue(Flight fmMenue, Scanner sc) {
		do {
		System.out.println("╔═════════════════════════════════╗");
		System.out.println("║ Add Seats                       ║");
		System.out.println("╟─────────────────────────────────╢");
		System.out.println("║ 1: First                        ║");
		System.out.println("║ 2: Business                     ║");
		System.out.println("║ 3: Economy                      ║");
		System.out.println("║ 0: Exit                         ║");
		System.out.println("╚═════════════════════════════════╝");
		
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("Existing number of seats:" + 0);
			break;
		case 2:
			System.out.println("Existing number of seats:" + 0);
			break;
		case 3:
			int maxSeat = 0;
			int aSeat = 0;
			Connection conn = null;
			conn = JDBCConnection.getConnection();
			try {
				AirplaneDAO adao = new AirplaneDAO(conn);
				AirplaneTypeDAO atdao = new AirplaneTypeDAO(conn);
				maxSeat = atdao.readAirplaneTypesById(adao.readAirplaneByID(fmMenue.getAirplane_id()).get(0).getId()).get(0).getMax_capacity();
				aSeat = maxSeat-fmMenue.getReserved_seat();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Existing number of seats:" + aSeat);
			System.out.println("Enter New Number of Seats: " );
			int j = sc.nextInt();
			break;
		case 0:				
			return;
		}

		} while (true);
	}

	public static void viewFlightDetails(Flight f, Scanner sc) {
		
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		Route route = new Route();
		int maxSeat = 0;
		int aSeat = 0;
		
		try {
			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO adao = new AirplaneDAO(conn);
			AirplaneTypeDAO atdao = new AirplaneTypeDAO(conn);
			route = rdao.readRouteByID(f.getRoute_id());
			maxSeat = atdao.readAirplaneTypesById(adao.readAirplaneByID(f.getAirplane_id()).get(0).getId()).get(0).getMax_capacity();
			aSeat = maxSeat-f.getReserved_seat();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String s = String.format("You have chosen to view the Flight with Flight Id: %d and Departure Airport: %s and Arrival Airport: %s. ", f.getAirplane_id(), route.getOrigin_id(), route.getDestination_id());
		System.out.println(s);
		System.out.println("");
		s = String.format("Departure Airport: %s | Arrival Airport: %s |",  route.getOrigin_id(), route.getDestination_id());
		System.out.println(s);
		System.out.println("Departe Date: " + f.getDeparture_time().toString());
		System.out.println("Available seats: " + aSeat);
		
		System.out.println("any to go back");
		sc.next();
		return;
	}
	
	public static void UpdateFlightDetails(Flight f, Scanner sc) {
		//not a working update
	
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		Route route = new Route();
		//Flight uf = new Flight();
		//uf = f;
		
		try {
			RouteDAO rdao = new RouteDAO(conn);
			route = rdao.readRouteByID(f.getRoute_id());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String s = String.format("You have chosen to view the Flight with Flight Id: %d and Departure Airport: %s and Arrival Airport: %s. ", f.getAirplane_id(), route.getOrigin_id(), route.getDestination_id());
		System.out.println(s);
		System.out.println("Enter 'quit' at any prompt to cancel operation.");
		
		System.out.println("");
		System.out.println("Please enter new Origin Airport enter N/A for no change:");
		s = sc.next();
		if (s == "quit")
			return;		
		System.out.println("Please enter new Destination Airport enter N/A for no change:");
		s = sc.next();
		if (s == "quit")
			return;		
		System.out.println("Please enter new Departure Date enter N/A for no change:");
		s = sc.next();
		if (s == "quit")
			return;		
		System.out.println("Please enter new Departure Time or enter N/A for no change:");
		s = sc.next();
		if (s == "quit")
			return;
		System.out.println("Please enter new Arrival Date or enter N/A for no change:");
		s = sc.next();
		if (s == "quit")
			return;
		System.out.println("Please enter new Arrival Time or enter N/A for no change:");
		s = sc.next();
		if (s == "quit")
			return;
		
		return;
	}

}
