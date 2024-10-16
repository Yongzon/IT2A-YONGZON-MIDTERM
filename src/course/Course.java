package course;

import java.util.Scanner;

public class Course {
    public void addCourse(){
    Scanner sc = new Scanner(System.in);
    config conf = new config();
    System.out.print("Course Name: ");
    String cname = sc.next();
    System.out.print("Corse Code: ");
    String ccode = sc.next();
    System.out.print("Credits: ");
    int credits = sc.nextInt();
    System.out.print("Semester: ");
    String sem = sc.next();
    System.out.print("Year: ");
    int yr = sc.nextInt();

    String sql = "INSERT INTO course (course_name, course_code, credits, semester, year) VALUES (?, ?, ?, ?, ?)";

    conf.addRecord(sql, cname, ccode, credits, sem, yr);
}
    private void viewCourse() {
        String courseQuery = "SELECT * FROM course";
        String[] courseHeaders = {"Course ID", "Course Name", "Course Code", "Credits", "Semester", "Year"};
        String[] courseColumns = {"course_id", "course_name", "course_code", "credits", "semester", "year"};
        
        config conf = new config();
        conf.viewRecords(courseQuery, courseHeaders, courseColumns);
    }
    
     public void updateCourse(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter Course ID: ");
         int id = sc.nextInt();
         
         System.out.print("Enter new Semester: ");
         String sem = sc.next();
         System.out.print("Enter new Year: ");
         String yr = sc.next();
         
        String sql = "UPDATE course SET semester = ?, year = ? WHERE course_id = ?";
        
        config conf = new config();
        conf.updateRecord(sql, sem, yr, id);
    }
     
    public void deleteCourse(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter Course ID to Delete: ");
         int id = sc.nextInt();
         
         String sql = "DELETE FROM course WHERE course_id = ?";
        
        config conf = new config();
        conf.updateRecord(sql, id);
    }
    
    public static void main(String[] args) {
        Course crs = new Course();
        config conf = new config();
        Scanner sc = new Scanner (System.in);
        
        int chose;
    do{
        System.out.println("--------Course--------");
        System.out.println("1. Add Course");
        System.out.println("2. View Course");
        System.out.println("3. Update Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Exit");
        System.out.print("Enter Action: ");
        int act = sc.nextInt();
    
        switch(act){
            case 1:
                crs.addCourse();
                break;
                
            case 2:
                crs.viewCourse();
                break;
                
            case 3:
                System.out.println("-----Course Record---------");
                crs.viewCourse();
                crs.updateCourse();
                break;
                
            case 4:
                System.out.println("-----Course Record---------");
                crs.viewCourse();
                crs.deleteCourse();
                break;
                
            case 5:
                System.out.println("Exiting.....");
                break;
                
            default:
                System.out.println("Action Error!");
        }
        System.out.print("Enter Again (1/0)?: ");
        chose = sc.nextInt();
    
    }while(chose != 0);
        System.out.println("Thank You!");
        
    }
}
