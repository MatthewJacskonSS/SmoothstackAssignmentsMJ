package beans;

public class Route {
	@Override
	public String toString() {
		return "Route [id=" + id + ", origin_id=" + origin_id + ", destination_id=" + destination_id + "]";
	}

	private int id;
	private String origin_id;
	private String destination_id;

	public Route(int id, String origin_id, String destination_id) {
		super();
		this.id = id;
		this.origin_id = origin_id;
		this.destination_id = destination_id;
	}

	public Route() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}

	public String getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(String destination_id) {
		this.destination_id = destination_id;
	}
}
