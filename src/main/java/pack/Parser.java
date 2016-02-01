package pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Iryna_Busel on 1/29/2016.
 */
public class Parser {
    ArrayList<Sentence> sentences;
    String text;

    public void parse() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("D:\\pdp\\task2\\src\\main\\resources\\input.txt"));
        String line = in.readLine();
        String[] sentences;
        this.sentences = new ArrayList<Sentence>();
        while (line != null) {
            sentences = line.split("[.?!]+");
            for (int i = 0; i < sentences.length; i++) {
                if (sentences[i] != "" && sentences.length > 1) {
                    String sentence = sentences[i] + line.charAt(sentences[i].length());
                    this.sentences.add(new Sentence(sentence));
                }
            }
            line = in.readLine();
        }
    }
}
