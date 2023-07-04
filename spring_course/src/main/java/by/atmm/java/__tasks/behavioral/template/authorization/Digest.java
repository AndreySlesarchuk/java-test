package by.atmm.java.__tasks.behavioral.template.authorization;

/**
 * Created by Andrey Slesarchuk on 06/20/2020.
 */
public class Digest {
  private String digest;

  private int salt;

  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  public int getSalt() {
    return salt;
  }

  public void setSalt(int salt) {
    this.salt = salt;
  }
}
