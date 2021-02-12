package chatlogfiles;

/*
*
* @author Mikael Leuf
* @date 2021-02-12
* @course DT007G
* @Lab 1
 */
public class ChatLogFiles {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		String nickname, currentUser;
		FriendReader friends = new FriendReader("friends");

		if (args.length > 0 && args.length <= 2 && args[0].startsWith("-")) {
			switch (args[0]) {
				case "-pf":
					if (args.length < 2) {
						System.out.println("print Friends");
						friends.reader();
						friends.displayNicks();
					} else {
						System.out.println("Too many args");
					}
					break;

				case "-qf":
					if (args.length == 2) {
						nickname = args[1];

						friends.reader();
						friends.displayFriend(nickname);
					} else {
						System.out.println("Need nickname arg or too manny");
					}

					break;

				case "-ql":
					if (args.length == 2) {
						System.out.println("***************Private chatlog***************");

						nickname = args[1];
						ChatReader privateChat = new ChatReader(nickname);
						privateChat.reader();
						privateChat.printer();
					} else {
						System.out.println("Need nickname arg or too manny");
					}
					break;

				case "-qpl":
					if (args.length < 2) {
						System.out.println("***************Public chatlog***************");

						currentUser = "Eurakarte";
						ChatReader publicChat = new ChatReader(currentUser);
						publicChat.reader();
						publicChat.printer();
					} else {
						System.out.println("Too many args");
					}
					break;

				default:
					System.out.println("error wrong arg");
					help();
			}
		} else {
			help();
		}

	}

	static void help() {
		System.out.println("-pf: Prints a list of the friends nicknames and real names ordered by nicknames.\n"
				+ "-qf nickname: Prints all the information related to the given nickname. If nickname not found the text \"Not found.\" is given.\n"
				+ "-ql nickname: Displays the private chat log related to the given nickname. If nickname not found the text \"Not found.\" is given.\n"
				+ "-qpl: Displays the public chat log. If not found the text \"Not found\" is given.");
	}
}
