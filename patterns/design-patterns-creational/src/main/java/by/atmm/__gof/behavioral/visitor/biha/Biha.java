package by.atmm.__gof.behavioral.visitor.biha;

/**
 * Created by Slesarchuk on 05/26/2020.
 */
public class Biha {
    private Chairman chairman;

    public void initialize() {
        chairman = createChairman();
        Head head1 = createHead("Head1", 700, 1100);
        Head head2 = createHead("Head2", 500, 1000);
        Employee employee1 = createEmployee("Employee1", 330, 100);
        Employee employee2 = createEmployee("Employee2", 220, 50);
        Employee employee3 = createEmployee("Employee3", 100, 25);
        Employee employee4 = createEmployee("Employee4", 50, 10);
        chairman.addEmployee(head1);
        chairman.addEmployee(head2);
        head1.addEmployee(employee1);
        head1.addEmployee(employee2);
        head2.addEmployee(employee3);
        head2.addEmployee(employee4);
        head1.getEmployees();
    }

    private Chairman createChairman() {
        Chairman chairman = new Chairman();
        chairman.setName("Chairman");
        chairman.setSalary(1000);
        chairman.setAnnualBonus(2000);
        chairman.setOptionBonus(10000);
        return chairman;
    }

    private Head createHead(String name, int salary, int annualBonus) {
        Head chairman = new Head();
        chairman.setName(name);
        chairman.setSalary(salary);
        chairman.setAnnualBonus(annualBonus);
        return chairman;
    }

    private Employee createEmployee(String name, int salary, int incentiveBonus) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setIncentiveBonus(incentiveBonus);
        return employee;
    }

    public static void main(String[] args) {
        Biha biha = new Biha();
        biha.initialize();

        IncomeVisitor incomeVisitor = new IncomeVisitor();
        biha.chairman.accept(incomeVisitor);
        System.out.println("chairman income = " + incomeVisitor.getChairmanIncome());
        System.out.println("heads income = " + incomeVisitor.getHeadIncome());
        System.out.println("employees income = " + incomeVisitor.getEmployeeIncome());
        System.out.println("total income = " + incomeVisitor.getTotalIncome());

        PersonnelVisitor personnelVisitor = new PersonnelVisitor();
        biha.chairman.accept(personnelVisitor);
        System.out.println("chairman amount : " + personnelVisitor.getChairmanAmount());
        System.out.println("heads amount : " + personnelVisitor.getHeadAmount());
        System.out.println("employees amount : " + personnelVisitor.getEmployeeAmount());
        System.out.println("total personnel amount : " + personnelVisitor.getPersonnelAmount());
        System.out.println("personnel " + personnelVisitor.getPersonnel());
    }

}
