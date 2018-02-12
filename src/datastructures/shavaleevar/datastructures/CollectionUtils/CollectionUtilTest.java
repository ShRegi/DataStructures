package datastructures.shavaleevar.datastructures.CollectionUtils;

import datastructures.util.Assert;

import static datastructures.shavaleevar.datastructures.CollectionUtils.CollectionUtils.transform;
import static datastructures.shavaleevar.datastructures.CollectionUtils.UnmodifiableCollection.unmodifiableCollection;
import static datastructures.util.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public class CollectionUtilTest {
    private static final Employee EMPLOYEE_1 = new Employee("Ivan", "Ivanov", "Ivanivich", "36 Carnberry St.", 50000);
    private static final Employee EMPLOYEE_2 = new Employee("Ivanna", "Ivanovna", "Ivanovna", "36 Carnberry St.", 38000);
    private static final Employee EMPLOYEE_3 = new Employee("Rachel", "Ivanova", "", "36 Carnberry St.", 65000);
    private static final Employee EMPLOYEE_4 = new Employee("Piter", "Ivanov", "Petrovich", "36 Carnberry St.", 78000);
    private static final Employee EMPLOYEE_5 = new Employee("Petr", "Krug", "Petrovich", "36 Carnberry St.", 41000);
    private static final Employee EMPLOYEE_6 = new Employee("Vasily", "Andreevich", "", "36 Carnberry St.", 54000);
    private static final Employee EMPLOYEE_7 = new Employee("Ivan", "Ivanov", "Ivanivich", "36 Carnberry St.", 38000);
    private static final Employee EMPLOYEE_8 = new Employee("Ivanna", "Ivanovna", "Ivanovna", "36 Carnberry St.", 32000);
    private static final Employee EMPLOYEE_9 = new Employee("Rachel", "Ivanova", "", "36 Carnberry St.", 49000);

    public static void main(String[] args) {
        testFilter();
        testTransformModifies();
        testTransform();
        testForAllDo();
        testUnmodifiableCollection();
        testTransformNotList();
        testTransformModifiesNotList();
    }

    private static void testFilter() {
        Collection<Employee> employees = new ArrayList<>();
        employees.add(EMPLOYEE_1);
        employees.add(EMPLOYEE_2);
        employees.add(EMPLOYEE_3);
        employees.add(EMPLOYEE_4);
        employees.add(EMPLOYEE_5);
        employees.add(EMPLOYEE_6);
        employees.add(EMPLOYEE_7);
        employees.add(EMPLOYEE_8);
        employees.add(EMPLOYEE_9);
        Predicate<Employee> predicate = employee -> employee.getLastName().equals("Ivanov");
        CollectionUtils.filter(employees, predicate);
        Collection<Employee> expected = new ArrayList<>();
        expected.add(EMPLOYEE_1);
        expected.add(EMPLOYEE_4);
        expected.add(EMPLOYEE_7);
        Assert.assertEquals("CollectionUtilTest.testFilter", expected, employees);
    }

    private static void testTransformModifies() {
        Collection<Employee> employees = new ArrayList<>();
        employees.add(EMPLOYEE_1);
        employees.add(EMPLOYEE_2);
        employees.add(EMPLOYEE_3);
        employees.add(EMPLOYEE_4);
        employees.add(EMPLOYEE_5);
        employees.add(EMPLOYEE_6);
        employees.add(EMPLOYEE_7);
        employees.add(EMPLOYEE_8);
        employees.add(EMPLOYEE_9);
        CollectionUtils.transform(employees, value -> value.getLastName());
        Collection<String> expected = new ArrayList<>();
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        expected.add("Ivanov");
        expected.add("Krug");
        expected.add("Andreevich");
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        Assert.assertEquals("CollectionUtilTest.testTransformModifies", expected, employees);
    }

    private static void testTransform() {
        Collection<Employee> employees = new ArrayList<>();
        employees.add(EMPLOYEE_1);
        employees.add(EMPLOYEE_2);
        employees.add(EMPLOYEE_3);
        employees.add(EMPLOYEE_4);
        employees.add(EMPLOYEE_5);
        employees.add(EMPLOYEE_6);
        employees.add(EMPLOYEE_7);
        employees.add(EMPLOYEE_8);
        employees.add(EMPLOYEE_9);
        Collection<String> lastNames = new ArrayList<>();
        CollectionUtils.transform(employees, lastNames, value -> value.getLastName());
        Collection<String> expected = new ArrayList<>();
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        expected.add("Ivanov");
        expected.add("Krug");
        expected.add("Andreevich");
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        Assert.assertEquals("CollectionUtilTest.testTransform", expected, lastNames);
    }

    private static void testForAllDo() {
        Collection<Employee> employees = new ArrayList<>();
        employees.add(EMPLOYEE_1);
        employees.add(EMPLOYEE_2);
        employees.add(EMPLOYEE_3);
        employees.add(EMPLOYEE_4);
        employees.add(EMPLOYEE_5);
        employees.add(EMPLOYEE_6);
        employees.add(EMPLOYEE_7);
        employees.add(EMPLOYEE_8);
        employees.add(EMPLOYEE_9);
        CollectionUtils.forAllDo(employees, employee -> employee.setSalary(employee.getSalary() * 2));
        Collection<Employee> expected = new ArrayList<>();
        expected.add(EMPLOYEE_1);
        expected.add(EMPLOYEE_2);
        expected.add(EMPLOYEE_3);
        expected.add(EMPLOYEE_4);
        expected.add(EMPLOYEE_5);
        expected.add(EMPLOYEE_6);
        expected.add(EMPLOYEE_7);
        expected.add(EMPLOYEE_8);
        expected.add(EMPLOYEE_9);
        Collection<Integer> salary = new ArrayList<>();
        Iterator<Employee> iterator = expected.iterator();
        while (iterator.hasNext()) {
            salary.add(iterator.next().getSalary() * 2);
        }
        iterator = expected.iterator();
        Iterator<Integer> salaryIterator = salary.iterator();
        while (iterator.hasNext()) {
            iterator.next().setSalary(salaryIterator.next());
        }
        Assert.assertEquals("CollectionUtilTest.testForAllDo", expected, employees);
    }

    private static void testUnmodifiableCollection() {
        Collection<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan", "Ivanov", "Ivanivich", "36 Carnberry St.", 50000));
        employees.add(new Employee("Ivanna", "Ivanovna", "Ivanovna", "36 Carnberry St.", 38000));
        employees.add(new Employee("Rachel", "Ivanova", "", "36 Carnberry St.", 65000));
        employees.add(new Employee("Piter", "Ivanov", "Petrovich", "36 Carnberry St.", 78000));
        employees.add(new Employee("Petr", "Krug", "Petrovich", "36 Carnberry St.", 41000));
        employees.add(new Employee("Vasily", "Andreevich", "", "36 Carnberry St.", 54000));
        employees.add(new Employee("Ivan", "Ivanov", "Ivanivich", "36 Carnberry St.", 38000));
        employees.add(new Employee("Ivanna", "Ivanovna", "Ivanovna", "36 Carnberry St.", 32000));
        Collection<Employee> unmodifiableCollection = unmodifiableCollection(employees);
        Assert.assertEquals("CollectionUtilTest.testUnmodifiableCollection", "class UnmodifiableCollection", unmodifiableCollection.getClass().toString());
        try {
            unmodifiableCollection.add(new Employee("Ivan", "Ivanov", "Ivanivich", "36 Carnberry St.", 50000));
        } catch (UnsupportedOperationException e) {
            System.out.println("Collection is unmodifiable");
        }
    }

    private static void testTransformModifiesNotList() {
        Collection<Employee> employees = new ArrayDeque<>();
        employees.add(EMPLOYEE_1);
        employees.add(EMPLOYEE_2);
        employees.add(EMPLOYEE_3);
        employees.add(EMPLOYEE_4);
        employees.add(EMPLOYEE_5);
        employees.add(EMPLOYEE_6);
        employees.add(EMPLOYEE_7);
        employees.add(EMPLOYEE_8);
        employees.add(EMPLOYEE_9);
        CollectionUtils.transform(employees, value -> value.getLastName());
        Collection<String> expected = new ArrayDeque<>();
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        expected.add("Ivanov");
        expected.add("Krug");
        expected.add("Andreevich");
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        Assert.assertEquals("CollectionUtilTest.testTransformModifiesNotList", expected, employees);
    }

    private static void testTransformNotList() {
        Collection<Employee> employees = new ArrayDeque<>();
        employees.add(EMPLOYEE_1);
        employees.add(EMPLOYEE_2);
        employees.add(EMPLOYEE_3);
        employees.add(EMPLOYEE_4);
        employees.add(EMPLOYEE_5);
        employees.add(EMPLOYEE_6);
        employees.add(EMPLOYEE_7);
        employees.add(EMPLOYEE_8);
        employees.add(EMPLOYEE_9);
        Collection<String> lastNames = new ArrayDeque<>();
        CollectionUtils.transform(employees, lastNames, value -> value.getLastName());
        Collection<String> expected = new ArrayDeque<>();
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        expected.add("Ivanov");
        expected.add("Krug");
        expected.add("Andreevich");
        expected.add("Ivanov");
        expected.add("Ivanovna");
        expected.add("Ivanova");
        Assert.assertEquals("CollectionUtilTest.testTransformNotList", expected, lastNames);
    }
}
