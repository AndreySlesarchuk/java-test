package by.atmm.java.__early.behavioral.visitor.biha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slesarchuk on 05/25/2020.
 */
public class Head extends Employee {

  private int annualBonus;

  private List<Employee> employees = new ArrayList<>();

  public int getAnnualBonus() {
    return annualBonus;
  }

  public void setAnnualBonus(int annualBonus) {
    this.annualBonus = annualBonus;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.action(this);
    acceptEmployees(visitor);
  }

  public void acceptEmployees(Visitor visitor) {
    for (Employee employee : employees) {
      employee.accept(visitor);
    }
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }
}
