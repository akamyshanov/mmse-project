/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancecompany;

import insurancecompany.Employee.Department;
import insurancecompany.Employee.Rank;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanyasn
 */
public class EmployeeTest {
    Employee employee;
    
    public EmployeeTest() {
        employee = new Employee(0, "myname", "mysurn", Employee.Department.CarDamage, "123", Employee.Rank.High);
    }
    
    @Test
    public void testGetId() {
        System.out.println("getId test: id set to 0");
        assertEquals(0, employee.getId());
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("myname", employee.getName());
    }

    @Test
    public void testGetSurname() {
        System.out.println("getSurname test");
        assertEquals("mysurn", employee.getSurname());
    }

    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        assertEquals(Department.CarDamage, employee.getDepartment());
    }

    @Test
    public void testGetRank() {
        System.out.println("getRank test");
        assertEquals(Rank.High, employee.getRank());
    }

    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword test");
        assertFalse(employee.checkPassword("rdftgre"));
        assertTrue(employee.checkPassword("123"));
    }
}
