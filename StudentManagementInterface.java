/*  |------Code by Joseph Vusumzi Duda------|
    |---------dudajoseph@gmail.com----------|
    |-----Task 5 for CodSoft Internship-----|
                                                   Student Management System
###################################################################################################################################
1. Create a Student class to represent individual students. Include attributes such as name, roll
   number, grade, and any other relevant details.
2. Implement a StudentManagementSystem class to manage the collection of students. Include
   methods to add a student, remove a student, search for a student, and display all students.
3. Design the user interface for the Student Management System. This can be a console-based
   interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.
4. Implement methods to read and write student data to a storage medium, such as a file or a
   database.
5. Allow users to interact with the Student Management System by providing options such as
   adding a new student, editing an existing student's information, searching for a student, displaying all
   students, and exiting the application.
6. Implement input validation to ensure that required fields are not left empty and that the student
   data is in the correct format
###################################################################################################################################
*/
import java.util.*;
import java.io.*;

public class StudentManagementInterface{
   public static void main(String[] args){
      StudentManagementSystem Studentlist = new StudentManagementSystem();
      Scanner input = new Scanner(System.in); // create a scanner object       
         while(true){ 
            // Print the menu of the Student Management System
            System.out.println("|#####################################################|");
            System.out.println("|-------------Student Management System---------------|");
            System.out.println("|#####################################################|");
            System.out.println("|     *Enter a number for choosing an option*         |");
            System.out.println("| 1.Add Student                                       |");
            System.out.println("| 2.Edit Student                                      |");
            System.out.println("| 3.Search Student                                    |");
            System.out.println("| 4.Display Students                                  |");
            System.out.println("| 5.Exit                                              |");
            System.out.println("|                                  jvd.systems@codsoft|");
            System.out.println("|#####################################################|");
            try{
               // Tell user to enter a correct integer if they entered a number out of range
               System.out.print(">>");
               int choice_1 = input.nextInt();
               input.nextLine();
               System.out.println();
               if (!(choice_1==1||choice_1==2||choice_1==3||choice_1==4||choice_1==5)){
                  System.out.println("[Number out of range.]");
                  System.out.println("[Choose number between 1,2,3,4 & 5.]");
                  System.out.println(); 
                  continue;               
               } 
               // ADD STUDENT
               else if (choice_1==1){
                  // 1. Name
                  System.out.println("[Enter Name.]");
                  System.out.print("~");
                  String name =input.nextLine(); 
                  System.out.println();
                  // 2. Name
                  System.out.println("[Enter Surname.]");
                  System.out.print("~");
                  String surname =input.nextLine(); 
                  System.out.println();
                  //4.Gender
                  System.out.println("[Enter Gender.]");
                  System.out.print("~");
                  String gender =input.nextLine(); 
                  System.out.println();
                  // 5. NameofInstitution
                  System.out.println("[Enter nameOfInstitution.]");
                  System.out.print("~");
                  String nameOfInstitution =input.nextLine(); 
                  System.out.println();
                  //6.ProgramOfStudy
                  System.out.println("[Enter programOfStudy.]");
                  System.out.print("~");
                  String programOfStudy =input.nextLine(); 
                  System.out.println();               
                  //3. Age
                  int age;      
                  while(true){
                      System.out.println("[Enter Age.]");
                      try{ 
                         System.out.print(">>");
                         age= input.nextInt();
                         break;
                      }
                      catch(InputMismatchException e){
                          System.out.println("[Enter an integer.]");  
                          System.out.println();    
                          input.nextLine();
                          continue;
                       }         
                  }  
                  //7.Year of Study
                  int yearOfStudy;
                  while(true){
                      System.out.println("[Enter yearOfStudy.]");
                      try{ 
                         System.out.print(">>");
                         yearOfStudy= input.nextInt();
                         break;
                      }
                      catch(InputMismatchException e){
                          System.out.println("[Enter an integer.]");  
                          System.out.println();    
                          input.nextLine();
                          continue;
                       }         
                  }
                  Student student=new Student(name,surname,age,gender,nameOfInstitution,programOfStudy,yearOfStudy);
                  Studentlist.AddStudent(student);
                  System.out.println("[Student Successfully Added, StudentNumber: "+student.getStudentNumber()+"]");
                  System.out.println();
               } 
               // EDIT STUDENT
               else if (choice_1==2){
                  System.out.println("[Enter StudentNumber for student to be edited: ]");
                  System.out.print("~");
                  String studentname =input.nextLine();
                  if (Studentlist.Contains(studentname)){
                     System.out.println();
                     System.out.println("[System allows you to change the program of study only.]");
                     System.out.println("[Enter programOfStudy.]");
                     System.out.print("~");
                     String programOfStudy =input.nextLine(); 
                     Student original= Studentlist.getStudent(studentname);
                     original.setProgramOfStudy(programOfStudy);
                     System.out.println("[Program of study edited.]");
                     System.out.println();
                  }
                  else{
                      System.out.println("[Student Not in System]");
                  }
                  continue;
               }
               // SEARCH STUDENT
               else if (choice_1==3){
                  System.out.println("[Enter StudentNumber to Search: ]");
                  System.out.print("~");
                  String studentname =input.nextLine();
                  Student original= Studentlist.getStudent(studentname);
                  if (Studentlist.Contains(studentname)){
                     System.out.println();
                     System.out.println("[Student found.]");
                     System.out.println("[Write student data to a storage medium?]");
                     System.out.println("[Enter: Yes/No.]");
                     String choice =input.nextLine();
                     if (choice.equalsIgnoreCase("Yes")){
                         // try to write to the storage medium
                         try {
                            // Create a BufferedWriter object
                            BufferedWriter pen = new BufferedWriter(new FileWriter("StudentStorage.txt"));

                            // Write content to the file
                            pen.write(original.toString());
                            System.out.println("Data wtitten to storage medium.");
                            pen.newLine(); // Add a new line
                            pen.close(); // close
                         } 
                         // handle exception
                         catch (IOException e) {
                             System.out.println("Data cannot be written to storage medium.");                         
                         }
                     }
                     else{System.out.println("Thank you bye.");}
                  }
                  else{
                      System.out.println("[Student Not in System]");
                  }
                  continue;
               }
               // DSPLAY STUDENT
               else if (choice_1==4){
                  if (Studentlist.GetNumberOfStudents()>0){ Studentlist.Display();}
                  else{ System.out.println("[No Students to display.]");System.out.println();}
                  continue;
               }
               // EXIT
               else if (choice_1==5){
                  System.out.println("[Exited.]");
                  System.exit(0);
               }
           }           
           // Tell user to enter an integer if they enter a string
           catch(InputMismatchException e){
              System.out.println("[Enter an integer.]");  
              System.out.println();    
              input.nextLine();
              continue;
          }
       }
   }
}

// Create student class
class Student{
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String nameOfInstitution;
    private String programOfStudy;
    private int yearOfStudy;
    private  String studentNumber;
    
  //  CONSTRUCTORS:
    public Student(String name,String surname, int age, String gender, String nameOfInstitution, String programOfStudy, int yearOfStudy){
       this.name=name;
       this.surname=surname;
       this.age=age;
       this.gender=gender;
       this.nameOfInstitution=nameOfInstitution;
       this.programOfStudy=programOfStudy;
       this.yearOfStudy=yearOfStudy;
       this.studentNumber = name.substring(0, 1) + surname.substring(0, 1) + (int) (Math.random() * 1000)+ 'A' + age +'G'+ gender.substring(0, 1)+programOfStudy.substring(0, 1);
       
       
    }
    // Copy Constructors
    public Student(Student original){
       name=original.getName();
       surname=original.getSurname();
       age=original.getAge();
       gender=original.getGender();
       nameOfInstitution=original.getNameOfInstitution();
       programOfStudy=original.getProgramOfStudy();
       yearOfStudy=original.getYearOfStudy();
       
    }
    //ACCESSOR METHODS:
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getStudentNumber(){return studentNumber;}
    public int getAge(){return age;}
    public String getGender(){return gender;}
    public int getYearOfStudy(){return yearOfStudy;}   
    public String getNameOfInstitution(){return nameOfInstitution;}
    public String getProgramOfStudy(){return programOfStudy;}
    
    //MUTATOR METHODS:
    public void setName(String name){this.name=name;}
    public void setSurname(String surname){this.surname=surname;}
    public void setAge(int age){this.age=age;}
    public void setGender(String gender){this.gender=gender;}    
    public void setNameOfInstitution(String nameOfInstitution){this.nameOfInstitution=nameOfInstitution;}
    public void setProgramOfStudy(String programOfStudy){this.programOfStudy=programOfStudy;}
    public void setYearOfStudy(int yearOfStudy){this.yearOfStudy=yearOfStudy;}
    
    // Equals Method
    public boolean equals (Object o){
       if(o==null){return false;}
       else if (!(o instanceof Student)){ return false;}
       else{
          Student other = (Student)o;
          return(this.name.equals(other.getName())&&this.surname.equals(other.getSurname())&&this.age==other.getAge()&&this.gender.equals(other.getGender())&&this.yearOfStudy==other.getYearOfStudy()&&this.nameOfInstitution.equals(other.getNameOfInstitution())&&this.programOfStudy.equals(other.getProgramOfStudy()));  
       }
    }
    // Equals method for studentNumber
   public boolean StudentNoEquals(String s){
      return (studentNumber.equals(s));
   }
    // To String Method
    public String toString(){
       return "[Name: "+getName()+", "+"Surname: "+getSurname()+", "+"StudentNumber: "+getStudentNumber()+", "+"Age: "+getAge()+", "+"Gender: "+getGender()+", "+"YearOfStudy: "+getYearOfStudy()+", "+"Institution: "+getNameOfInstitution()+", "+"Program: "+getProgramOfStudy()+".]";
    }
}

//Create a class to manage a collection of Students
class StudentManagementSystem implements Iterable<Student>{
// display all students
   private ArrayList<Student> StudentList; 
   private int number_of_students;
   // Create No argument Constructor
   public StudentManagementSystem(){
      this.StudentList=new ArrayList<Student>();
      this.number_of_students=0;
   }
   
   //Add Student method
   public void AddStudent(Student student){
      StudentList.add(student);
      number_of_students++;
   }
   
   // Contains Method, Search Method
   public boolean Contains(String student_no){
      for(Student s: StudentList){
        if ((s.getStudentNumber()).equals(student_no)){return true;}
      }
      return false;
   }
   
   
   //Remove a student
   public void RemoveStudent(String student_no){
      for(Student s: StudentList){
        if (s.getStudentNumber().equals(student_no)){StudentList.remove(s);number_of_students--;}
      }
   }
   public Student getStudent(String student_no){
      for(Student s: StudentList){
        if (s.getStudentNumber().equals(student_no)){return s;}
      }return null;
   }
   //Display Students
   public void Display(){
      for(Student s: StudentList){
         System.out.println(s);
      }
   }
   // Get number of Students in collection of Students
   public int GetNumberOfStudents(){return number_of_students;}
   
   
   // Obtain an iterator that can be used to view the observations one-by-one.
   public Iterator<Student> iterator() {
       return new ArrayList<Student>(StudentList).iterator();
   }

}