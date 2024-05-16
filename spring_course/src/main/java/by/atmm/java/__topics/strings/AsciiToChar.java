package by.atmm.java.__topics.strings;

import by.atmm.java.__topics.utils.MyLog;

public class AsciiToChar {

  public static void main(String[] args) {
    char asciiCharacter = (char) 65; // ASCII-code 65 — is 'A'
    MyLog.log(String.valueOf(asciiCharacter)); // A

    int asciiCode = 67; // C
    if (asciiCode >= 0 && asciiCode <= 255) {
      char character = (char) asciiCode;
      MyLog.log(String.valueOf(character));
    }

    String characterStr = Character.toString((char) asciiCode);
    MyLog.log(characterStr);
    characterStr = "" + (char) asciiCode;
    MyLog.log(characterStr);
  }

}
