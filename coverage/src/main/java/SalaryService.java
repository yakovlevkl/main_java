class SalaryService {

    int calculateSalary(int sales) {
        int percent = 5;
        int salary = sales * percent / 100;
        int salaryLimit = 50000;
        if (salary > salaryLimit) {
            salary = salaryLimit;
        }
        return salary;
    }
}
