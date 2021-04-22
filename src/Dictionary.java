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
	
	//Question 1
	public String ShowDefinationBySlangWord(String word) {		
		String result = null;
		result = dic.get(word.toUpperCase());
		if(result != null) {
			//Save to history
			List<String> slang = new ArrayList<>();
			slang.add(word.toUpperCase());
			FileIO file = new FileIO();
			file.WriteFileHistory(slang,  result);
			return result;
		}
		return result="Not found !!!";
	}
	//Question 2
	public void printListSlangWord(List<String> slangword) {
		System.out.print("Slang word: ");
		if(slangword.size()>0) {
			for(int i=0; i<slangword.size(); i++) {
				System.out.print(slangword.get(i)+ ", ");
			}			
		}
		else {
			System.out.println("Not found!!!");
		}
	}
	

	
	
	public void InitialDictionary() {
		FileIO file = new FileIO();
		dic = file.ReadFileSlang();
	}
	public void PrintDictionary() {
		dic.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
	
	public List<String> ShowSlangWordByDefination(String def) {
		List<String> sl = new ArrayList<>();
		dic.entrySet().forEach(entry -> {
		    if(entry.getValue().toLowerCase().contains(def.toLowerCase())) {
		    	sl.add(entry.getKey());
		    }
		});
		//save to history
		if(sl.size()>0) {
			for(int i=0;i<sl.size(); i++) {
				
			}
			FileIO file = new FileIO();
			file.WriteFileHistory(sl, def);
		}
		
		return sl;
	}
	
	
}
