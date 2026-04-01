// import java.util.ArrayList;
// import java.util.Collections;
import java.util.Scanner;

interface user {
    
    public boolean login(String s,int ID,String password,database d);
}

class Setuser {
    int ID;
    Setuser getUser(String s){
        if(s.equals("STUDENT")) return new student();
        else if(s.equals("PROFESSOR")) return new professor();
        return new admin();
    }
}
public class assignment1 {
    public static void main(String[] args) {
        //student s = new student();
        int choice;
        System.out.println("Enter operation to perform : ");
        System.out.println("1. Register new user\n2. Login registered user");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        database d = new database();
        if(choice==1){
            System.out.println("Enter type of user :\n1. Admin\n2. Professor\n3. Student");
            int c = sc.nextInt();
            if(c==1){
                // Setuser s = new Setuser().getUser("ADMIN");
                admin a = new admin();
                System.out.print("Enter name of admin : ");
                sc.next();
                a.name = sc.nextLine();
                System.out.println("Enter Admin's password to register:");
                a.register(d,sc.next());
            }
            else if(c==2){
                professor p = new professor();
                //sc.next();
                System.out.println("Enter name of professor : ");
                p.name = sc.next();
                System.out.println("Enter password : ");
                String password = sc.next();
                p.setPassword(password);
                p.register(d);
            }
            else if(c==3){
                student s = new student();
                //sc.next();
                System.out.println("Enter name of student : ");
                s.name = sc.next();
                System.out.println("Enter password : ");
                s.setPassword(sc.next());
                s.register(d);
            }
        }
        else if(choice==2){
            System.out.println("Enter type of user :\n1. Admin\n2. Professor\n3. Student");
            int c3 = sc.nextInt();
            if(c3==1){
                admin a = new admin();
                System.out.println("Enter ID of admin : ");
                int ID = sc.nextInt();
                System.out.println("Enter password to login: ");
                String s = sc.next();
                if(a.login(s,ID,s,d)){
                    System.out.println("Choose Admin Operations: ");
                    System.out.println("--> 1. Add Course\n--> 2. Show Complains of All Students with ID");
                    int c2 = sc.nextInt();
                    if(c2==1){
                        System.out.print("--> Enter Course ID: ");
                        String cid = sc.next();
                        System.out.print("--> Enter Course Name: ");
                        String name = sc.next();
                        System.out.print("--> Enter credits: ");
                        int credit = sc.nextInt();
                        d.addCourse(cid,name,credit);
                    }
                    else if(c2==2){
                        System.out.println("-->All complaints submitted by students are: ");
                        d.showComplaints();
                    }
                }
            }
            else if(c3==2){
                professor p = new professor();
                System.out.println("Enter ID of professor: ");
                int ID = sc.nextInt();
                System.out.println("Enter password to login: ");
                String s = sc.next();
                if(p.login(s, ID, null, d)){
                    System.out.println("Enter opertion to perform: ");
                    System.out.println("1. Show Syllabus\n2. Update Syllabus");
                    int c2 = sc.nextInt();

                    if(c2==1){
                        d.showSyllabus(ID); 
                    }
                    else if(c2==2){
                        
                        System.out.println("Enter Syllabus to update: ");
                        sc.next();
                        String syllabus = sc.nextLine();
                        d.addData(ID, syllabus);
                    }
                }
                else{
                    System.out.println("WRONG LOGIN CREDENTIALS");
                }
            }
            else if(c3==3){
                System.out.print("--> Enter ID of Student to login: ");
                int ID = sc.nextInt();
                System.out.print("--> Enter password: ");
                String s = sc.next();
                student s1 = new student();
                if(s1.login(s, ID, s, d)){
                    System.out.println("Student successfully logged in.");
                    System.out.println("Enter operations to do: \n--> 1. Submit complain\n--> 2. View courses\n--> 3. Register courses");
                    int c2 = sc.nextInt();
                    if(c2==1){
                        System.out.println("Enter your complain: ");
                        sc.next();
                        String complain = sc.next();
                        d.addComplain(complain,ID);
                    }
                    else if(c2==2){
                        System.out.println("Available Courses are: ");
                        
                        d.displayCourses();
                    }
                    else if(c2==3){
                        System.out.println("Enter course ID to register: ");
                        String cid = sc.next();
                        d.registerCourse(cid,ID);
                    }
                    else{
                        System.out.println("WRONG LOGIN CREDENTIALS.");
                    }
                }
            }
        }
        sc.close();
        // d.adduser("students", 1, "Atharva", "ekdoteen");
        // d.adduser("admins",1,"raju","paswrd");
    }
}
