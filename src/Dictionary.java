import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public String ShowDefinationBySlangWord(String word) {		
		
		return dic.get(word.toUpperCase());
	}
	public void ShowSlangWordByDefination(String def) {
//		 for (Entry<String, String> entry : dic.entrySet()) {
//	            if (entry.getValue().equals("c")) {
//	                System.out.println(entry.getKey());
//	            }
//	        }
		List<String> sl = new ArrayList<>();
		dic.entrySet().forEach(entry -> {
		    if(entry.getValue().toLowerCase().equals(def.toLowerCase())) {
		    	sl.add(entry.getKey());
		    }
		});
		System.out.print("Slang word: ")
		for(int i=0; i<sl.size();i++) {
			System.out.print(sl.get(i) + " - ");
		}
		
	}
}
