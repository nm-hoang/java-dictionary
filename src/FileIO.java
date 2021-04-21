import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FileIO {
	private String path = "slang.txt";

	public String GetLastKey(Map<String, String> englSpan) {
		String lastKey = new String();
//		 for (Map.Entry<String, String> entry : englSpan.entrySet()) {
////			 	System.out.print(entry.getKey());
//			
//	            lastKey = entry.getKey();
//        }
		final Set<Entry<String, String>> mapValues = englSpan.entrySet();
        final int maplength = mapValues.size();
        final Entry<Integer,String>[] test = new Entry[maplength];
        mapValues.toArray(test);

        System.out.print("First Key:"+test[0].getKey());
        System.out.println(" First Value:"+test[0].getValue());

        System.out.print("Last Key:"+test[maplength-1].getKey());
        System.out.println(" Last Value:"+test[maplength-1].getValue());
//		 englSpan.entrySet().forEach(entry -> {
//			    lastKey = entry.getKey() ;
//			});
		return lastKey;
	}
	public Map<String, String> ReadFile() {
		Map <String, String> englSpan = new HashMap<String, String>();
		Dictionary dic = new Dictionary();
		try {
		      File myObj = new File(path);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.contains("`")) {
		        	String[] parts = data.split("`");
		        	englSpan.put(parts[0], parts[1]);		        			        	
		        }

		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	
		return englSpan;
	}
	
}
