package beans;

public class Airplane {
	private Integer id;
	private Integer type_id;

	public Airplane(int id, int type_id) {
		super();
		this.id = id;
		this.type_id = type_id;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", type_id=" + type_id + "]";
	}

	public Airplane() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
}
