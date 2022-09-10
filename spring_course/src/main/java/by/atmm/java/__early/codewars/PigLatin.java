package by.atmm.java.__early.codewars;

import java.util.regex.Pattern;

public class PigLatin {

    public static String pigIt(String str) {
        String[] startWords = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < startWords.length; i++) {
            StringBuilder word = new StringBuilder(startWords[i]);
            if (word.length() == 1 && Pattern.matches("\\p{Punct}", String.valueOf(word.charAt(0)))) {
                result.append(word);
            }
            else {
                if (!Pattern.matches("\\p{Punct}", String.valueOf(word.charAt(word.length() - 1)))) {
                    result.append(word.append(word.charAt(0) + "ay").deleteCharAt(0));
                }
                else {
                    StringBuilder newWord = new StringBuilder();
                    for (int j = 0; j < word.length(); j++) {
                        if (Pattern.matches("\\p{Punct}", String.valueOf(word.charAt(j)))) {
                            result.append(newWord.append(newWord.charAt(0) + "ay").deleteCharAt(0)).append(word.substring(j, word.length()));
                            break;
                        }
                        else {
                            newWord.append(word.charAt(j));
                        }
                    }
                }
            }
            if (!(i == startWords.length - 1)) {
                result.append(" ");
            }
        }
        return result.toString();
    }

//    public class PigLatin {
//        public static String pigIt(String str) {
//            return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
//        }
//    }

}
