package beans;

import java.sql.Date;

public class Flight {
	private int id;
	private int route_id;
	private int airplane_id;
	private Date departure_time;
	private int reserved_seat;

	public Flight(int id, int route_id, int airplane_id, Date departure_time, int reserved_seat,
			float seat_price) {
		super();
		this.id = id;
		this.route_id = route_id;
		this.airplane_id = airplane_id;
		this.departure_time = departure_time;
		this.reserved_seat = reserved_seat;
		this.seat_price = seat_price;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", route_id=" + route_id + ", airplane_id=" + airplane_id + ", departure_time="
				+ departure_time + ", reserved_seat=" + reserved_seat + ", seat_price=" + seat_price + "]";
	}

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public int getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}

	public Date getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Date date) {
		this.departure_time = date;
	}

	public int getReserved_seat() {
		return reserved_seat;
	}

	public void setReserved_seat(int reserved_seat) {
		this.reserved_seat = reserved_seat;
	}

	public float getSeat_price() {
		return seat_price;
	}

	public void setSeat_price(float seat_price) {
		this.seat_price = seat_price;
	}

	private float seat_price;
}
