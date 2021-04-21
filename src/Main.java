import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dic = new Dictionary();
		dic.InitialDictionary();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1: Chức năng tìm kiếm theo slang word");
			System.out.println("2: Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.");
			System.out.println("3: Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.");
			System.out.println("4: Chức năng add 1 slang words mới. Nếu slang words trùng thì thông báo cho người\r\n"
					+ "dùng, confirm có overwrite hay duplicate ra 1 slang word mới");
			System.out.println("5: Chức năng edit 1 slang word");
			System.out.println("6: Chức năng delete 1 slang word. Confirm trước khi xoá.");
			System.out.println("7: Chức năng reset danh sách slang words gốc");
			System.out.println("8: Chức năng random 1 slang word (On this day slang word)." );
			System.out.println("9: Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho\r\n"
					+ "người dùng chọn");
			System.out.println("10: Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho\r\n"
					+ "người dùng chọn");
			System.out.print("Choose: ");
			String line = scanner.nextLine();
			switch(line) {
				case "1":{
					System.out.print("Nhập từ tìm kiếm");
					dic.FindWord(line)
					break;
				}
			}
		}
	}

}
