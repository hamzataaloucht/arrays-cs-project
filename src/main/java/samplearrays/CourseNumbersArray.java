package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        // print all courses
        System.out.println("Registered courses:");
        for (int i = 0; i < registeredCourses.length; i++) {
            System.out.println(registeredCourses[i]);
        }

        // print number of courses
        System.out.println("Number of courses: " + registeredCourses.length);

        // search for a course
        int search = 2140;
        boolean found = false;
        for (int course : registeredCourses) {
            if (course == search) {
                found = true;
                break;
            }
        }
        System.out.println("Course " + search + " found? " + found);
    }
}