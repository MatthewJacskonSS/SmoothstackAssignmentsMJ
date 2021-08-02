package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import beans.Airport;
import beans.Flight;
import beans.Passenger;
import beans.Route;
import beans.User;
import beans.Booking;
import beans.FlightBookings;
import beans.BookingPayment;
import beans.BookingUser;
import dao.AirplaneDAO;
import dao.AirplaneTypeDAO;
import dao.AirportDAO;
import dao.BookingDAO;
import dao.BookingPaymentDAO;
import dao.BookingUserDAO;
import dao.FlightBookingsDAO;
import dao.FlightDAO;
import dao.PassengerDAO;
import dao.RouteDAO;
import dao.UserDAO;
import jdbcconnection.JDBCConnection;

public class TravlerService {
	public static int userId = 0;

	public static boolean validTravler(Scanner sc) {
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		System.out.println("Enter the your Membership Number: ");
		int i = sc.nextInt();
		UserDAO udao = new UserDAO(conn);
		try {
			User u = udao.readUserByID(i);
			if (u == null)
				return false;
			else if (u.getRole_id() != 2)
				return false;
			else
				userId = u.getId();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static Flight Booking(Scanner sc) {
		System.out.println("Pick the Flight you want to book a ticket for:");

		Connection conn = null;
		conn = JDBCConnection.getConnection();
		List<Flight> flightsToBook = new ArrayList<Flight>();
		Route route = new Route();
		Airport airportO = new Airport();
		Airport airportD = new Airport();
		try {
			FlightDAO fdao = new FlightDAO(conn);
			flightsToBook = fdao.readAllFlight();
			RouteDAO rdao = new RouteDAO(conn);
			AirportDAO adao = new AirportDAO(conn);
			for (Flight f : flightsToBook) {
				route = rdao.readRouteByID(f.getRoute_id());
				airportO = (Airport) adao.readAirportsByID(route.getOrigin_id()).get(0);
				airportD = (Airport) adao.readAirportsByID(route.getDestination_id()).get(0);
				System.out.println((flightsToBook.indexOf(f)) + 1 + "): " + airportO.getIata_id() + ", "
						+ airportO.getCity() + " -> " + airportD.getIata_id() + ", " + airportD.getCity());
			}
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = sc.nextInt();

		return flightsToBook.get(i - 1);
	}

	public static void chooseSeat(Flight f, Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Flight information              ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: View More Details            ║");
			System.out.println("║ 2: First                        ║");
			System.out.println("║ 3: Business                     ║");
			System.out.println("║ 4: Economy                      ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				viewFlightDetails(f, sc);
				break;
			case 2:
				System.out.println("0 seats available");
				break;
			case 3:
				System.out.println("0 seats available");
				break;
			case 4:
				if (viewSeatCount(f, sc))
					book(f, sc);
				break;
			case 0:
				return;
			}

		} while (true);
	}

	private static void book(Flight f, Scanner sc) {
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		do {
			System.out.println("Seat Available, do you want to book? Y/N");
			String s = sc.next();
			if (s.equals("y") || s.equals("Y"))
				break;
			else if (s.equals("n") || s.equals("N"))
				return;
		} while (true);

		String givenName, familyName, gender, address;
		int d, m, y;
		Date dob;
		System.out.println("Enter Passenger information:");
		System.out.println("Enter First Name: ");
		givenName = sc.next();
		System.out.println("Enter Last Name ");
		familyName = sc.next();
		System.out.println("Enter gender: ");
		gender = sc.next();
		System.out.println("Enter address: ");
		address = sc.next();
		System.out.println("Enter Birth year: ");
		y = sc.nextInt();
		System.out.println("Enter Birth month: ");
		m = sc.nextInt();
		System.out.println("Enter Birth Day: ");
		d = sc.nextInt();
		dob = java.sql.Date.valueOf(LocalDate.of(y, m, d));

		BookingDAO bdao = new BookingDAO(conn);
		Booking book = new Booking();
		book.setIs_active(true);
		book.setConfirmation_code("");
		PassengerDAO pdao = new PassengerDAO(conn);
		FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
		BookingPaymentDAO bpdao = new BookingPaymentDAO(conn);
		BookingUserDAO budao = new BookingUserDAO(conn);
		FlightDAO fdao = new FlightDAO(conn);

		try {
			int bookingId = bdao.addBooking(book);
			Passenger p = new Passenger(bookingId, givenName, familyName, dob, gender, address);
			pdao.addPassenger(p);
			FlightBookings fb = new FlightBookings(f.getId(), bookingId);
			fbdao.addFlightBookings(fb);
			BookingPayment bp = new BookingPayment(bookingId, "what is this", false);
			bpdao.addBookingPayment(bp);
			BookingUser bu = new BookingUser(bookingId, userId);
			budao.addBookingUser(bu);
			int i = f.getReserved_seat() + 1;
			f.setReserved_seat(i);
			fdao.updateFlight(f);

			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private static void viewFlightDetails(Flight f, Scanner sc) {
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
			maxSeat = atdao.readAirplaneTypesById(adao.readAirplaneByID(f.getAirplane_id()).get(0).getId()).get(0)
					.getMax_capacity();
			aSeat = maxSeat - f.getReserved_seat();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		String s = String.format(
				"You have chosen to view the Flight with Flight Id: %d and Departure Airport: %s and Arrival Airport: %s. ",
				f.getAirplane_id(), route.getOrigin_id(), route.getDestination_id());
		System.out.println(s);
		System.out.println("");
		s = String.format("Departure Airport: %s | Arrival Airport: %s |", route.getOrigin_id(),
				route.getDestination_id());
		System.out.println(s);
		System.out.println("Departe Date: " + f.getDeparture_time().toString());
		System.out.println("Available seats: " + aSeat);

		System.out.println("any to go back");
		sc.next();
		return;
	}

	private static boolean viewSeatCount(Flight f, Scanner sc) {
		int maxSeat = 0;
		int aSeat = 0;
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		float price = 0;
		try {
			AirplaneDAO adao = new AirplaneDAO(conn);
			AirplaneTypeDAO atdao = new AirplaneTypeDAO(conn);
			maxSeat = atdao.readAirplaneTypesById(adao.readAirplaneByID(f.getAirplane_id()).get(0).getId()).get(0)
					.getMax_capacity();
			aSeat = maxSeat - f.getReserved_seat();
			price = f.getSeat_price();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Existing number of seats:" + aSeat + " at price: " + price);
		if (aSeat != 0) {
			return true;
		}
		return false;
	}

	public static void cancleTrip(Scanner sc) {
		Connection conn = null;
		conn = JDBCConnection.getConnection();
		BookingDAO bdao = new BookingDAO(conn);
		BookingUserDAO budao = new BookingUserDAO(conn);
		List<Flight> flightinfo = new ArrayList<Flight>();
		FlightDAO fdao = new FlightDAO(conn);
		FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
		Route route = new Route();
		Airport airportO = new Airport();
		Airport airportD = new Airport();
		RouteDAO rdao = new RouteDAO(conn);
		AirportDAO adao = new AirportDAO(conn);
		
		List<BookingUser> bookedflights = new ArrayList<BookingUser>();
		try {
			bookedflights = budao.readBookingUserByUserID(userId);
			for (BookingUser bu : bookedflights) {
				flightinfo.add(fdao.readFlightByID(fbdao.readFlightBookingsByTypeBookingID(bdao.readBookingByID(bu.getBooking_id()).get(0).getId()).get(0).getFlight_id()).get(0));
				route = rdao.readRouteByID(flightinfo.get(bookedflights.indexOf(bu)).getRoute_id());
				airportO = (Airport) adao.readAirportsByID(route.getOrigin_id()).get(0);
				airportD = (Airport) adao.readAirportsByID(route.getDestination_id()).get(0);
				System.out.println(bookedflights.indexOf(bu) + 1 + "): " +  airportO.getIata_id() + ", "
						+ airportO.getCity() + " -> " + airportD.getIata_id() + ", " + airportD.getCity());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		
	}
}
