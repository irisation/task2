package pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Iryna_Busel on 1/29/2016.
 */
public class Parser {
	ArrayList<Sentence> sentences;
	String text;
	public final static String DELIMITERS = "\u2026.!?";

	public void parse() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("D:\\pdp\\task2\\src\\main\\resources\\inputt.txt"));
		String sentence = "";
		String[] sentences;
		this.sentences = new ArrayList<Sentence>();
		String line = in.readLine();
		String readLine = line;

		while (readLine != null) {

			if (readLine.equals("")) {
				readLine = in.readLine();
				line += readLine;
				continue;
			}

			int i;
			int index = 0;
			String c = "";

			if (DELIMITERS.indexOf(line.charAt(line.length() - 1)) > -1) {
				c += line.charAt(line.length() - 1);
			}
			sentences = line.split("[.?\u2026]+");

			for (i = 0; i < sentences.length - 1; i++) {
				sentence = sentences[i] + line.charAt(sentences[i].length() + index);
				index += sentence.length();
				this.sentences.add(new Sentence(sentence));
			}
			sentence = sentences[i] + c;
			if (!c.equals("")) {
				this.sentences.add(new Sentence(sentence));
				sentence = "";
			}
			readLine = in.readLine();
			line = sentence + " " + readLine;
		}
	}

	// Найти наибольшее количество предложений текста, в которых есть одинаковые
	//
	// слова.
	public int countWordsInSentencesTask1() {
		int count = 0;
        for (Sentence sentence : sentences) {
            Set<Word> tempSet = new HashSet<Word>(sentence.words);
            if(tempSet.size() < sentence.words.size()) {
                count++;
            }
        }
        return count;
	}

//    Вывести все предложения заданного текста в порядке возрастания
//
//    количества слов в каждом из них.
    public ArrayList<Sentence> getSentencesIncreasingCountOfWordsTask2(){
        ArrayList<Sentence> sentences = new ArrayList<Sentence>(this.sentences);
		sentences.sort(Comparator.<Sentence> naturalOrder());
		return sentences;
    }
}
