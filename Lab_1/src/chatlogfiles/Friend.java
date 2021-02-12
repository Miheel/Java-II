package chatlogfiles;

/*
*
* @author Mikael Leuf
* @date 2021-02-12
* @course DT007G
* @Lab 1
 */
public class Friend {

	private String nickName;
	private String fullName;
	private String IP;
	private String image;

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIP() {
		return this.IP;
	}

	public void setIP(String IP) {
		this.IP = IP;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "<" + this.nickName + ">\n" + this.fullName + "\n" + this.IP + "\n" + this.image + "\n";
	}
}
