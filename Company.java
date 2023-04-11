import java.util.TreeMap;
import java.util.Comparator;

    public class Company {
        static TreeMap <String, Integer> staff = new TreeMap<>(new StaffComparator());
        
    public static void main(String[] args) {
         int salary = 100000;

        Manager manager = new Manager();
        TopManager topManager = new TopManager();

        for(int i = 1;i < 81;i++){
            staff.put("manager "+i, manager.getMonthSatary(salary));
        }
        for(int i = 1;i < 11;i++){
            staff.put("TopManager "+i, topManager.getMonthSatary(salary));
        }

    }

    public int salary_withdrawal (String o1o2){
        int salary = (int) staff.get(o1o2);
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

class StaffComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        Company company = new Company();
        if(company.salary_withdrawal(o1)>company.salary_withdrawal(o2)){
            return 1;
        }
        if(company.salary_withdrawal(o1)<company.salary_withdrawal(o2)){
            return -1;
        }
        return 0;
    }
}
