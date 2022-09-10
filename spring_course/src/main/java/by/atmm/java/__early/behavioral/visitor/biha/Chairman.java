package by.atmm.java.__early.behavioral.visitor.biha;

/**
 * Created by Slesarchuk on 05/25/2020.
 */
public class Chairman extends Head {
  private int optionBonus;

  public int getOptionBonus() {
    return optionBonus;
  }

  public void setOptionBonus(int optionBonus) {
    this.optionBonus = optionBonus;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.action(this);
    acceptEmployees(visitor);
  }
}
