import java.util.TreeMap;
import java.util.Comparator;

public class Company {
    public static void main(String[] args) {
        int salary = 100000;

        TreeMap <String, Integer> staff = new TreeMap<>(new StaffComparator());

        Manager manager = new Manager();
        TopManager topManager = new TopManager();

        for(int i = 1;i < 81;i++){
            staff.put("manager "+i, manager.getMonthSatary(salary));
        }
        for(int i = 1;i < 11;i++){
            staff.put("TopManager "+i, topManager.getMonthSatary(salary));
        }


    }

    public int salary_withdrawal (TreeMap staff,String V ){
        int salary = (int) staff.get(V);
        return salary;
    }
}

class Manager{

    public int getMonthSatary(int salary) {
        int company_income = (int) (Math.random() * (20  - 5) + 5);

        double income_from_the_manager = Math.random() * (140000  - 115000) + 115000;
        int salaryManager = (int)  (salary + income_from_the_manager * 0.05);
        return salaryManager;

    }
}
class TopManager {

    public int getMonthSatary (int salary) {
        int company_income = (int) (Math.random() * (20  - 5) + 5);

        double salary_bonus;
        if(company_income > 10)
            salary_bonus = salary * 1.5;
        else salary_bonus = 0;
        int salaryTopManager = (int) (salary + salary_bonus);
        return salaryTopManager;
    }
}

class StaffComparator implements Comparator<Company> {

    public int compare(Company o1, Company o2) {
        if(o1.salary_withdrawal()>o2.salary_withdrawal()){
            return 1;
        }
        if(o1.salary_withdrawal()<o2.salary_withdrawal()){
            return -1;
        }
        return 0;
    }
}
