package by.atmm.gof.behavioral.visitor.biha;

/**
 * Created by Slesarchuk on 05/25/2020.
 */
public class Employee {

    private String name;

    private int salary;

    private int incentiveBonus;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getIncentiveBonus() {
        return incentiveBonus;
    }

    public void setIncentiveBonus(int incentiveBonus) {
        this.incentiveBonus = incentiveBonus;
    }

    public void accept(Visitor visitor) {
        visitor.action(this);
    }

}
