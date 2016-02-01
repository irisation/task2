package pack;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Iryna_Busel on 1/29/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<String>();
        words.add("I");
        words.add("am");
        words.add("your");
        words.add("father");
        words.add(",");
        words.add("Luke");
        words.add("!");

        Parser parser = new Parser();
        parser.parse();
        System.out.println(parser.sentences);

        Sentence sentence = new Sentence(words);
        System.out.println(sentence.text);
    }
}
