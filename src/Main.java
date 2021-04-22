import java.util.Scanner;

public class Main {
	private static String pathSlangOriginal = "slang.txt";
	private static String pathHistory = "history.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dic = new Dictionary();
		Dictionary history = new Dictionary();
		
		FileIO file = new FileIO();
		dic.InitialDictionary(pathSlangOriginal);
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1: Find word in slang word");
			System.out.println("2: Find slang word by defination, show another slang word that contain keyword.");
			System.out.println("3: Show history, list slang word was searched");
			System.out.println("4: Add a slangword. If a slang word is already exist, notice to user want to confirm or duplicate to a new slangword");
			System.out.println("5: Edit 1 slang word");
			System.out.println("6: Delete 1 slang word. Confirm before delete");
			System.out.println("7: Reset original list slang word");
			System.out.println("8: Random 1 slang word (On this day slang word)." );
			System.out.println("9: Show 1 random slang word. User pick 1 in 4 option");
			System.out.println("10: Show 1 randow defination. User pick 1 in 4 option of slang words");
			System.out.print("Choose: ");
			String line = scanner.nextLine();
			switch(line) {
				case "1":{
					System.out.print("Enter a slang word: ");
					String word = scanner.nextLine();
					System.out.print("Defination: ");
					System.out.println(dic.ShowDefinationBySlangWord(word));
					break;
				}
				case "2": {
					System.out.print("Enter a defination: ");
					String word = scanner.nextLine();
					dic.printListSlangWord(dic.ShowSlangWordByDefination(word));
					break;
				}
				case "3":{
//					file.WriteFile(pathHistory, dic.getDic());
					file.WriteFileHistory(pathHistory, "#1`NumberOne");
					break;
				}
			}
		}
	}

}
