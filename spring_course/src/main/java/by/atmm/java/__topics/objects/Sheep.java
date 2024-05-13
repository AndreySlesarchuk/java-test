package by.atmm.java.__topics.objects;

import lombok.Data;

@Data
public class Sheep implements Cloneable {
  private String name;

  public Sheep(String name) {
    this.name = name;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
