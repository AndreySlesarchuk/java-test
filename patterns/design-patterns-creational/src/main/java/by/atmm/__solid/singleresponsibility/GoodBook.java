package by.atmm.__solid.singleresponsibility;

public class GoodBook {

    private String name;
    private String author;
    private String text;

    //constructor, getters and setters

    //methods that directly relate to the book properties
    public String replaceWordInText(String word, String replacementWord) {
        return text.replaceAll(word, replacementWord);
    }

    public boolean isWordInText(String word) {
        return text.contains(word);
    }

}
