package tk.manzbuy.admin.dto;

public class AdminInfo {
	private String id;
	private String passwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "AdminInfo [id=" + id + ", passwd=" + passwd + "]";
	}

}
