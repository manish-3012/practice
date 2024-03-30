import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeDataSorter {
    private static class Employee {
        private String firstName;
        private String lastName;
        private String department;
        private String email;
        private double salary;

        public Employee(String firstName, String lastName, String department, String email, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            this.email = email;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        String inputFile = "Employees.csv";
        String outputFile = "SortedEmployees.csv";

        List<Employee> employees = readEmployeesFromFile(inputFile);
        sortEmployees(employees);
        writeEmployeesToFile(employees, outputFile);
    }

    private static List<Employee> readEmployeesFromFile(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length != 5) {
                    System.err.println("Invalid line in CSV file: " + line);
                    continue;
                }
                String firstName = fields[0];
                String lastName = fields[1];
                String department = fields[2];
                String email = fields[3];
                double salary = 0.0; // initialize with a default value
                try {
                    salary = Double.parseDouble(fields[4].replaceAll("[^0-9.-]", "")); // remove non-numeric characters
                } catch (NumberFormatException e) {
                    System.err.println("Invalid salary value in CSV file: " + fields[4]);
                }
                employees.add(new Employee(firstName, lastName, department, email, salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private static void sortEmployees(List<Employee> employees) {
        Collections.sort(employees, Comparator
                .comparing(Employee::getDepartment)
                .thenComparingDouble(Employee::getSalary));
    }

    private static void writeEmployeesToFile(List<Employee> employees, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("first_name,last_name,department,email,salary");
            bw.newLine();
            for (Employee employee : employees) {
                bw.write(String.format("%s,%s,%s,%s,%.2f", employee.firstName, employee.lastName, employee.department,
                        employee.email, employee.salary));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}