import org.junit.Assert;
import org.junit.Test;

public class SalaryServiceTest {

    @Test
    public void testShouldCalculateSalaryWhenUnderLimit() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(50_000);
        int expected = 2500;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSalaryOverLimit() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(3_000_000);
        int expected = 50_000;

        Assert.assertEquals(expected, actual);
    }
} 