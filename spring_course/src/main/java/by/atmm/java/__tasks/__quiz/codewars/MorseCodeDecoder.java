package by.atmm.java.__tasks.__quiz.codewars;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded
        // Morse code table through MorseCode.get(code)
        StringBuilder code = new StringBuilder(morseCode.trim());
        StringBuilder letter = new StringBuilder();
        StringBuilder word = new StringBuilder();
        StringBuilder sentense = new StringBuilder();
        for (int i = 0; i < morseCode.length(); i++) {
            if (Character.isWhitespace(code.charAt(i))) {
                if (i > 0 && Character.isWhitespace(code.charAt(i - 1))) {
                    continue;
                }
                if (Character.isWhitespace(code.charAt(i + 1))) {
                    word.append(get(letter));
                    letter = new StringBuilder();
                    sentense.append(word).append(' ');
                    word = new StringBuilder();
                } else {
                    word.append(get(letter));
                    letter = new StringBuilder();
                }
            } else {
                letter.append(code.charAt(i));
            }
        }
        word.append(get(letter));
        sentense.append(word);
        return sentense.toString();
    }

    private static char[] get(StringBuilder subSequence) {
        return "A".toCharArray();
    }

}