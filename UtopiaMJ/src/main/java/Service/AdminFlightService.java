package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.*;
import dao.*;
import jdbcconnection.JDBCConnection;

public class AdminFlightService {

	public static void ReadFlight(Scanner sc) {
		Connection conn = null;
		conn = JDBCConnection.getConnection();

		FlightDAO fdao = new FlightDAO(conn);
		List<Flight> flightsToManage = new ArrayList<Flight>();

		try {
			flightsToManage = fdao.readAllFlight();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Flight f : flightsToManage)
			System.out.println(f.toString());
	}

	public static void ReadRoutes(Scanner sc) {
		Connection conn = null;
		conn = JDBCConnection.getConnection();

		RouteDAO rdao = new RouteDAO(conn);
		List<Route> routes = new ArrayList<Route>();

		try {
			routes = rdao.readAllRoute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Route r : routes)
			System.out.println(r.toString());
	}

	public static void ReadAirports(Scanner sc) {
		Connection conn = null;
		conn = JDBCConnection.getConnection();

		AirportDAO adao = new AirportDAO(conn);
		List<Airport> airports = new ArrayList<Airport>();

		try {
			airports = adao.readAllAirport();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Airport a : airports)
			System.out.println(a.toString());

	}

	public static void CreateFlight(Scanner sc) {
		int id;
		int route_id;
		int airplane_id;
		Date departure_time;
		int reserved_seat;
		float seatprice;
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		FlightDAO fdao = new FlightDAO(conn);
		
		System.out.println("Flight Route ID: ");
		route_id = sc.nextInt();
		System.out.println("Airplane ID: ");
		airplane_id = sc.nextInt();
		System.out.println("Departure time");
		sc.next();
		departure_time = Date.valueOf("2015-01-24");
		System.out.println("Flight Seats Presold: ");
		reserved_seat = sc.nextInt();
		System.out.println("Seat Price: ");
		seatprice = sc.nextFloat();
		
		Flight newFlight = new Flight(0, route_id, airplane_id, departure_time, reserved_seat, seatprice);
		try {
			fdao.addFlight(newFlight);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("flight added");

	}

	public static void CreateRoutes(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
}
