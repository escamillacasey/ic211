import java.util.*;
import java.io.*;


public class WordRead{
	public static String[] get(String fname){
		Scanner sc = null;
		try{
			sc = new Scanner(new FileReader(fname));
		}catch(IOException e){
			e.printStackTrace(); System.exit(1);
		}	
		StringNode sn = null;
		String nextWord = "";
		while(sc.hasNext()){
			nextWord = sc.next();
			sn = ListStuff.addToFront(nextWord, sn);
		}
    sn = ListStuff.reverse(sn);
		return ListStuff.listToArray(sn);
	}

	public static void main(String[] args){
		String[] strings = get("nouns.txt");
	for(int i = 0; i<strings.length;i++){
			System.out.println(strings[i]);
		}
	}
}
