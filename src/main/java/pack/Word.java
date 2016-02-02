package pack;

/**
 * Created by Iryna_Busel on 1/29/2016.
 */
public class Word implements TextItem {
    public String text;
    boolean isPunctuationMark;

    Word(String text){
        this.text = text;
        if(text.matches("([\u2026.,!?;:()])")){
            isPunctuationMark = true;
        }
        else
            isPunctuationMark = false;
        System.out.print(this.text + " ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return text.equalsIgnoreCase(word.text);

    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
