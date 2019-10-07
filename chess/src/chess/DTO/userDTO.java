package chess.DTO;

public class userDTO {
	private int u_idx;
	private String id;
	private String password;
	private String nickname;
	private int mmr;
	public userDTO() {
		
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMmr() {
		return mmr;
	}
	public void setMmr(int mmr) {
		this.mmr = mmr;
	}
	public userDTO(int u_idx, String id, String password, String nickname, int mmr) {
		super();
		this.u_idx = u_idx;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.mmr = mmr;
	}
	@Override
	public String toString() {
		return "userDTO [u_idx=" + u_idx + ", id=" + id + ", password=" + password + ", nickname=" + nickname + ", mmr="
				+ mmr + "]";
	}
	
}
