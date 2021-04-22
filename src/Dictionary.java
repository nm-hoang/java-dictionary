import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dictionary {
	private Map<String, String> dic;
	public Map<String, String> getDic(){
		return this.dic;
	}
	public void setDic(Map<String, String> dic) {
		this.dic = dic;
		
	}
	public Dictionary(){
		this.dic = new HashMap<String, String>();
	}
	public void InitialDictionary(String path) {
		FileIO file = new FileIO();
		dic = file.ReadFile(path);
	}
	public void PrintDictionary() {
		dic.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
	public String ShowDefinationBySlangWord(String word) {		
		return dic.get(word.toUpperCase());
	}
	public List<String> ShowSlangWordByDefination(String def) {
		List<String> sl = new ArrayList<>();
		dic.entrySet().forEach(entry -> {
		    if(entry.getValue().toLowerCase().equals(def.toLowerCase())) {
		    	sl.add(entry.getKey());
		    }
		});
	
		return sl;
	}
	
	public void printListSlangWord(List<String> slangword) {
		System.out.print("Slang word: ");
		for(int i=0; i<slangword.size(); i++) {
			System.out.print(slangword.get(i));
		}
	}
}
