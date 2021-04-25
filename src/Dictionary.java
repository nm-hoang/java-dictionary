import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;


public class Dictionary {
	private Map<String, String> dic;
	private static String pathSlangOriginal = "slang-origin.txt";
	private static String pathSlangUsed = "slang-used.txt";
	private static String pathHistory = "history.txt";
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
			file.WriteFile(slang,  pathHistory);
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
		dic = file.ReadFileSlang(pathSlangUsed);
	}
	public void PrintDictionary() {
		dic.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
	
	public List<String> ShowSlangWordByDefination(String def) {
		List<String> sl = new ArrayList<>();
		for (Map.Entry<String, String> entry : dic.entrySet()) {
			if(entry.getValue().toLowerCase().contains(def.toLowerCase())) {
				sl.add(entry.getKey());
			}
		}
		//save to history
		if(sl.size()>0) {
			FileIO file = new FileIO();
			file.WriteFile(sl, pathHistory);
			System.out.print(sl);
		}
		return sl;
	}
	
	public void AddSlangWord(){
		FileIO file = new FileIO();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a slang word: ");
		List<String> sl = new ArrayList<>();
		sl.add(scanner.nextLine().toUpperCase());
		String result = dic.get(sl.get(0));
		if(result != null) {
			System.out.print("Slang word is already exist! \n Do you want to override(o), duplicate(d) or cancel(c): ");
			String choose = scanner.nextLine();
			switch(choose) {
				case "o":{
					file.RemoveSlangWord(pathSlangUsed, sl.get(0));
					System.out.print("defination: ");
					String def = scanner.nextLine();
					file.WriteDuplicateInFile(sl, pathSlangUsed, def);
					break;
				}
				case "d":{
					file.RemoveSlangWord("test.txt", sl.get(0));
					System.out.print("defination: ");
					String def = scanner.nextLine();
					String duplicate = result + " | " + def;
					file.WriteDuplicateInFile(sl, pathSlangUsed, duplicate);
					break;
				}
				case "c":{
					break;
				}
			}
		}
		else {
			System.out.print("defination: ");
			String def = scanner.nextLine();
			file.WriteDuplicateInFile(sl,pathSlangUsed , def);
		}
	}
	public void EditSlangWord() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter slangword: ");
		String sl = scanner.nextLine().toUpperCase();
		if(dic.get(sl.toUpperCase()) != null) {
			System.out.print("Defination: ");
			String def = scanner.nextLine();
			dic.put(sl, def);
			FileIO file = new FileIO();
			file.printToFile(pathSlangUsed, ConvertToList(this));
		}
		else {
			System.out.print("Slang word not found !");
		}
		
	}
	public List<String> ConvertToList(Dictionary dic){
		List<String> listDic = new ArrayList<>();
		dic.getDic().entrySet().forEach(entry -> {
			listDic.add(entry.getKey()+"`"+entry.getValue());
		});
		return listDic;
	}
	public void DeleteSlangWord() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a slang word you want to delete: ");
		String sl = scanner.nextLine().toUpperCase();
		if(dic.get(sl) != null) {
			dic.remove(sl);
			FileIO file = new FileIO();
			file.printToFile(pathSlangUsed, ConvertToList(this));
			System.out.print("Delete done!");
		}
		else{
			System.out.print("Slang word is not exist");
		}
	}
	public void ResetOgSlangWord() {
		FileIO file = new FileIO();
		dic = file.ReadFileSlang(pathSlangOriginal);
		file.printToFile(pathSlangUsed, ConvertToList(this));
		System.out.print("done");
	}
	public String RandomSlangWord() {
		String[] sl = new String[2];
		Random generator = new Random();
		Object[] values = dic.keySet().toArray();
		Object randomValue = values[generator.nextInt(values.length)];
		return randomValue.toString();
	}
	public void ShowRandomSlangWord() {
		String random = this.RandomSlangWord();
		System.out.println("Random: " + random + "\nDefination: " + dic.get(random));
	}
	public void ChooseRightDef() {
		String randowSl = this.RandomSlangWord();
		String rightAnswer = dic.get(randowSl);
		ArrayList<String> def = new ArrayList<>();
		while(def.size() < 4){
			
		}
	}
}
