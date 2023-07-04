package by.atmm.java.__tasks.behavioral.visitor.biha;

/**
 * Created by Slesarchuk on 05/26/2020.
 */
public class IncomeVisitor implements Visitor {
  private int chairmanIncome;

  private int headIncome;

  private int employeeIncome;

  @Override
  public void action(Employee employee) {
    employeeIncome += employee.getSalary() + employee.getIncentiveBonus();
    System.out.println("IncomeVisitor.visit Employee " + employee.getName());
  }

  @Override
  public void action(Head head) {
    headIncome += head.getSalary() + head.getAnnualBonus();
    System.out.println("IncomeVisitor.visit Head " + head.getName());
  }

  @Override
  public void action(Chairman chairman) {
    chairmanIncome += chairman.getSalary() + chairman.getAnnualBonus() + chairman.getOptionBonus();
    System.out.println("IncomeVisitor.visit Chairman " + chairman.getName());
  }

  public int getTotalIncome() {
    return chairmanIncome + headIncome + employeeIncome;
  }

  public int getChairmanIncome() {
    return chairmanIncome;
  }

  public int getHeadIncome() {
    return headIncome;
  }

  public int getEmployeeIncome() {
    return employeeIncome;
  }

}
