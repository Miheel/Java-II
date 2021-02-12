package chatlogfiles;

/*
*
* @author Mikael Leuf
* @date 2021-02-12
* @course DT007G
* @Lab 1
 */
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;

public class FriendReader {

	private String fileName;
	private TreeMap<String, Friend> friendList = new TreeMap<String, Friend>();

	public FriendReader(String fileName) {
		this.fileName = fileName;
	}

	public void reader() {
		String[] splitLines;
		String nick, key, name, ip, image;

		try {
			File myFile = new File(this.fileName + ".list");
			Scanner input = new Scanner(myFile);

			while (input.hasNextLine()) {
				Friend friend = new Friend();
				nick = input.nextLine();
				splitLines = nick.split(":", 2);
				key = splitLines[1];

				name = input.nextLine();
				ip = input.nextLine();
				image = input.nextLine();

				friend.setNickName(nick);
				friend.setFullName(name);
				friend.setIP(ip);
				friend.setImage(image);

				this.friendList.put(key, friend);
			}
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public void displayNicks() {
		for (String key : this.friendList.keySet()) {
			System.out.println("<" + key + ">" + this.friendList.get(key).getFullName());
		}
	}

	/**
	 * @param nick nickname to didplay information about
	 */
	public void displayFriend(String nick) {
		try {
			System.out.println(friendList.get(nick).toString());
		} catch (Exception e) {
			System.out.println("Not found");
		}
		
	}
}
