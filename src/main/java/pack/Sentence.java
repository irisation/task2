package pack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Iryna_Busel on 1/29/2016.
 */
public class Sentence implements TextItem {
    ArrayList<Word> sentence;
    public String text;

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
            if(words[i].matches("[\\w]+]")) {
                this.sentence.add(new Word(words[i]));
            }
            else {
                StringBuffer current = new StringBuffer();
                for (int j = 0; j < words[i].length(); j++) {
                    if(!",.".contains(String.valueOf(words[i].charAt(j)))) {
                        current.append(words[i].charAt(j));
                    }
                    else {
                        if(!"".equals(current.toString())) {
                            this.sentence.add(new Word(current.toString()));
                        }
                        this.sentence.add(new Word(String.valueOf(words[i].charAt(j))));
                    }
                }

            }
        }
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
