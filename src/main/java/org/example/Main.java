package org.example;


import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.example.WordCounter.calculatedWord;

public class Main {

    public static LinkedList<Employee> findDuplicates(List<Employee> linkedList) {
       LinkedList<Employee> duplicates = new LinkedList<>() {
       };
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) == null) {
                continue;
            }
            for (int j = i + 1; j < linkedList.size(); j++) {
                if (linkedList.get(j) == null) {
                    continue;
                }
                if (linkedList.get(i).getId() == linkedList.get(j).getId()) {
                    duplicates.add(linkedList.get(i));
                }
            }
        }
        return duplicates;
    }

    public static HashMap<Integer,Employee> findUniques(List<Employee> linkedList) {
        HashMap<Integer,Employee> uniques = new HashMap<>();
        for (Employee employee : linkedList) {
            if (employee != null && !uniques.containsKey(employee.getId())) {
                uniques.put(employee.getId(),employee);
            }
        }
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> linkedList) {
        int i = 0;
        while (i < linkedList.size()) {
            if (linkedList.get(i) == null) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < linkedList.size()) {
                if (linkedList.get(j) == null) {
                    j++;
                    continue;
                }
                if (linkedList.get(i).getId() == linkedList.get(j).getId()) {
                    linkedList.remove(j);
                    linkedList.remove(i);
                } else {
                    j++;
                }
            }
            i++;
        }
        System.out.println(linkedList);
        return linkedList;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Employee employee = new Employee(1, "John", "Doe");
        Employee employee2 = new Employee(2, "Jane", "Doe");
        Employee employee3 = new Employee(3, "John", "Smith");
        Employee employee4 = new Employee(4, "Jane", "Smith");

        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.add(employee);
        linkedList.add(employee2);
        linkedList.add(employee3);
        linkedList.add(employee4);
        linkedList.add(employee);

        calculatedWord();

    }
}