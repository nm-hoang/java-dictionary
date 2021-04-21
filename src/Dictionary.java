import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	private Map<String, String> dic;
	public Dictionary(){
		this.dic = new HashMap<String, String>();
	}
	public void InitialDictionary() {
		FileIO file = new FileIO();
		dic = file.ReadFile();
	}
	public void PrintDictionary() {
		dic.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
	public String FindWord(String word) {
		return dic.get(word);
	}
}
