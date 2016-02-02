package pack;

import java.util.ArrayList;

/**
 * Created by Iryna_Busel on 1/29/2016.
 */
public class Sentence implements TextItem {
	ArrayList<Word> sentence;
	public String text;
	public final static String DELIMITERS = "\u2026.!?,;:)}";

	public Sentence(ArrayList<String> words) {
		sentence = new ArrayList<Word>();
		for (int i = 0; i < words.size(); i++) {
			sentence.add(new Word(words.get(i)));
		}
		setText();
	}

	public Sentence(String sentence) {
		this.text = sentence;
		this.sentence = new ArrayList<Word>();
		String[] words = sentence.split("[ ]+");

		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals("")) {
				if (DELIMITERS.indexOf(words[i].charAt(words[i].length() - 1)) > -1) {
					this.sentence.add(new Word(words[i].substring(0, words[i].length() - 1)));
					this.sentence.add(new Word("" + words[i].charAt(words[i].length() - 1)));
				} else {
					this.sentence.add(new Word(words[i]));
				}

			}
		}
		System.out.println("\n");
	}

	private void setText() {
		StringBuffer curr = new StringBuffer();
		for (int i = 0; i < sentence.size(); i++) {
			if (i != 0 && sentence.get(i).isPunctuationMark == false) {
				curr.append(" ");
			}
			curr.append(sentence.get(i).text);
		}
		this.text = curr.toString();
	}

	@Override
	public String toString() {
		return text.toString();
	}
}
