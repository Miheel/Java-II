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

public class ChatReader {

	private String fileName;
	private ArrayList<String[]> chatList = new ArrayList<>();

	public ChatReader(String fileName) {
		this.fileName = fileName;
	}

	public void reader() {
		String line;

		try {
			File myFile = new File("logs/" + fileName + ".log");
			Scanner reader = new Scanner(myFile);

			while (reader.hasNextLine()) {
				line = reader.nextLine();
				chatList.add(line.split(":", 2));
			}
		} catch (Exception e) {
			System.out.println("Not found");
		}
	}

	public void printer() {
		String nick, msg;

		for (int i = 0; i < chatList.size(); i++) {
			nick = chatList.get(i)[0];
			msg = chatList.get(i)[1];
			System.out.println("<" + nick + ">" + msg);
		}
	}
}
