import java.util.*;
import java.io.*;
/**
 * This class is MidLibs
 * @author Capt Casey Escamilla
 */
public class MidLibs{
	public static void main(String[] args){
		// check usage
		if(args.length != 1){
			System.out.println("usage: java MidLibs <filename>");
			System.exit(1);
		}

		// read in nouns, verbs, adjectives
		String[] nouns = WordRead.get("nouns.txt");
		String[] verbs = WordRead.get("verbs.txt");
		String[] adjectives = WordRead.get("adjectives.txt");
		
		String[] wordsFromFile = WordRead.get(args[0]);
		Random rand = new Random(890);

		for(int i=0;i<wordsFromFile.length;i++){
			if(wordsFromFile[i].equals("@noun")){
				wordsFromFile[i] = nouns[rand.nextInt(nouns.length)];
			}
			else if(wordsFromFile[i].equals("@verb")){
				wordsFromFile[i] = verbs[rand.nextInt(verbs.length)];
			}
			else if(wordsFromFile[i].equals("@adjective")){
				wordsFromFile[i] = adjectives[rand.nextInt(adjectives.length)];
			}
			else if(wordsFromFile[i].equals("@nounp")){
				wordsFromFile[i] = nouns[rand.nextInt(nouns.length)] + "s";
			}
		}
		String[] finalArray = new String[wordsFromFile.length];
		// reverse array
		for(int i=0; i<wordsFromFile.length;i++){
			finalArray[i] = wordsFromFile[wordsFromFile.length-i-1];
		}

		Formatter.writeInColumns(wordsFromFile, 35);
	}
}
