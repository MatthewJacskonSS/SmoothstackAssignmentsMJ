package view;

import java.util.Scanner;
import Service.EmployeeFlightService;
import Service.TravlerService;
import Service.AdminFlightService;

public class Menues {

	public static void start(Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Utopia Airline Mangement System ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ Enter user type                 ║");
			System.out.println("║ 1: Employee/Agent               ║");
			System.out.println("║ 2: Administrator                ║");
			System.out.println("║ 3: Travler                      ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				eMenue(sc);
				break;
			case 2:
				aMenue(sc);
				break;
			case 3:
				tMenue(sc);
				break;
			case 0:
				return;
			}

		} while (true);
	}

	public static void eMenue(Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Utopia Airline Mangement System ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: Flight Management            ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				EmployeeFlightService.EMP3(EmployeeFlightService.fmMenue(sc), sc);
				break;
			case 0:			
				return;
			}

		} while (true);
		
	}
	
	public static void aMenue(Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Utopia Airline Mangement System ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: CRUD FLIGHTS                 ║");
			System.out.println("║ 2: CRUD SEATS                   ║");
			System.out.println("║ 3: CRUD TICKETS AND PASSANGERS  ║");
			System.out.println("║ 4: CRUD AIRPORTS                ║");
			System.out.println("║ 5: CRUD TRAVLERS                ║");
			System.out.println("║ 6: CRUD EMPLOYEES               ║");
			System.out.println("║ 7: Over-ride Cancellations      ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				crudFlightMenue(sc);
				break;
			case 0:
				return;
			}

		} while (true);
		
	}
	
	public static void tMenue(Scanner sc) {
		if (TravlerService.validTravler(sc) ==  false)
			return;
		
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Utopia Airline Mangement System ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: Book a Ticket                ║");
			System.out.println("║ 2: Cancel an Upcoming Trip      ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				TravlerService.chooseSeat(TravlerService.Booking(sc), sc);
				break;
			case 2:
				TravlerService.cancleTrip(sc);
				break;
			case 0:
				
				return;
			}

		} while (true);
		
	}
	
	public static void crudFlightMenue(Scanner sc) {
	do {
		System.out.println("╔═════════════════════════════════╗");
		System.out.println("║ CRUD FLIGHTS                    ║");
		System.out.println("╟─────────────────────────────────╢");
		System.out.println("║ 1: Create Flights               ║");
		System.out.println("║ 2: Read Flights                 ║");
		System.out.println("║ 3: Update Flights               ║");
		System.out.println("║ 4: Delete Flights               ║");
		System.out.println("║ 0: Exit                         ║");
		System.out.println("╚═════════════════════════════════╝");

		int i = sc.nextInt();
		switch (i) {
		case 1:
			caFlightMenue(sc);
			break;
		case 2:
			raFlightMenue(sc);
			break;
		case 0:
			
			return;
		}

	} while (true);
	
}
	
	public static void caFlightMenue(Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Create Flights                  ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: Create Flights               ║");
			System.out.println("║ 2: Create Routes                ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				AdminFlightService.CreateFlight(sc);
				break;
			case 2:	
				AdminFlightService.CreateRoutes(sc);
				break;
			case 0:				
				return;
			}

		} while (true);
		
	}
	
	public static void raFlightMenue(Scanner sc) {
		do {
			System.out.println("╔═════════════════════════════════╗");
			System.out.println("║ Read Flights                    ║");
			System.out.println("╟─────────────────────────────────╢");
			System.out.println("║ 1: Read Flights                 ║");
			System.out.println("║ 2: Read Routes                  ║");
			System.out.println("║ 0: Exit                         ║");
			System.out.println("╚═════════════════════════════════╝");

			int i = sc.nextInt();
			switch (i) {
			case 1:
				AdminFlightService.ReadFlight(sc);
				break;
			case 2:	
				AdminFlightService.ReadRoutes(sc);
				break;
			case 0:		
				return;
			}

		} while (true);
		
	}
		
	}
