package beans;

public class Booking {
	@Override
	public String toString() {
		return "Booking [id=" + id + ", is_active=" + is_active + ", confirmation_code=" + confirmation_code + "]";
	}

	private int id;
	private boolean is_active;
	private String confirmation_code;

	public Booking(int id, boolean is_active, String confirmation_code) {
		super();
		this.id = id;
		this.is_active = is_active;
		this.confirmation_code = confirmation_code;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getConfirmation_code() {
		return confirmation_code;
	}

	public void setConfirmation_code(String confirmation_code) {
		this.confirmation_code = confirmation_code;
	}

}
