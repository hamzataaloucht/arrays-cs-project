package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students == null || students.length == 0) return null;
        Student oldest = students[0];
        // compare each student age with the oldest
        for (Student s : students) {
            if (s.getAge() > oldest.getAge()) {
                oldest = s;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s.isAdult()) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) return Double.NaN;
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equals(name)) return s;
        }
        return null; // not found
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparingInt(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) System.out.println(s);
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true; // updated
            }
        }
        return false; // id not found
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        // compare every student with the ones after him
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equals(students[j].getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        // copy old array into a bigger one
        Student[] newArr = Arrays.copyOf(students, students.length + 1);
        newArr[newArr.length - 1] = newStudent; // add at the end
        return newArr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Ali", 20, 14),
                new Student(2, "Sara", 17, 18),
                new Student(3, "Omar", 22, 11),
                new Student(4, "Dina", 19, 16),
                new Student(5, "Youssef", 16, 9)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("\nOldest: " + findOldest(arr));

        // 3) Count adults
        System.out.println("Adults: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("Find Sara: " + findStudentByName(arr, "Sara"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 19);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("\nHas duplicate names? " + hasDuplicateNames(arr));

        // 10) Append new student
        arr = appendStudent(arr, new Student(6, "Hamza", 21, 17));
        System.out.println("\n== After append ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());
    }
}