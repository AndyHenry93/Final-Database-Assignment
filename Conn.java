import java.sql.*;  
import java.util.Scanner;
class Conn{  
	public static void main(String args[]) throws Exception{  
		
		int q,z = 0;
		
		// Do-While Loop for the menu.
		  do
		  {
		  System.out.println("");
		  System.out.println("");
		  System.out.println("Please choose what you want to do from below (1 - 2 - 3 - 4).");
		  System.out.println("1- Create the Tables.");
		  System.out.println("2- Insert Data into the Tables");
		  System.out.println("3- Search the Tables Data");
		  System.out.println("4- Enter (000) to Exit");
		  Scanner sc = new Scanner(System.in);
		  q = sc.nextInt();
		  
		  // The first Choice.
		  if (q == 1)
		  {
			  create();
		  }
		  
		  // Second Coice.
		  else if (q == 2)
		  {
			  do
			  {
			  System.out.println("");
			  System.out.println("");
			  System.out.println("Please choose which Table you want to insert into (1 - 2 - 3 - 4 - 5 - 6 - 7 - 8).");
			  System.out.println("1- Courses.");
			  System.out.println("2- Courserequisits.");
			  System.out.println("3- Courseofferings");
			  System.out.println("4- Courseofferingtimings.");
			  System.out.println("5- Instructors.");
			  System.out.println("6- Students.");
			  System.out.println("7- Studentgrade.");
			  System.out.println("8- StudentenrollmentCourses.");
			  System.out.println("9- Go Back...");
			  z = sc.nextInt();
			  if (z == 1)
			  {
				  insertCourses();
			  }
			  else if (z == 2)
			  {
				  insertCourserequisits();
			  }
			  else if (z == 3)
			  {
				  insertCourseofferings();
			  }
			  else if (z == 4)
			  {
				  insertCourseofferingtimings();
				
			  }
			  else if (z == 5)
			  {
				  insertInstructors();
			  }
			  else if (z == 6)
			  {
				  insertStudent();
			  }
			  else if (z == 7)
			  {
				  insertStudentGrade();
			  }
			  else if (z == 8)
			  {
				  insertStudentEnrollmentCourses();
			  }
			  else if (z == 9)
			  {
				  break;
				  }} while (z != 0); 
			  }
		  //Third Choice.
		  else if (q == 3)
		  {
				
			  do
			  {
			  System.out.println("");
			  System.out.println("");
			  System.out.println("Please choose which Table you want to insert into (1 - 2 - 3 - 4 - 5 - 6 - 7 - 8).");
			  System.out.println("1- Courses.");
			  System.out.println("2- Courserequisits.");
			  System.out.println("3- Courseofferings");
			  System.out.println("4- Courseofferingtimings.");
			  System.out.println("5- Instructors.");
			  System.out.println("6- Students.");
			  System.out.println("7- Studentgrade.");
			  System.out.println("8- StudentenrollmentCourses.");
			  System.out.println("9- Go Back...");
			  z = sc.nextInt();
			  if (z == 1)
			  {
				  searchCourses();;
			  }
			  else if (z == 2)
			  {
				  searchCourserequisits();
			  }
			  else if (z == 3)
			  {
				  searchCourseOfferings();
			  }
			  else if (z == 4)
			  {
				  searchCourseOfferingTimings();
				
			  }
			  else if (z == 5)
			  {
				  searchInstructors();
			  }
			  else if (z == 6)
			  {
				  searchStudent();
			  }	
			  else if (z == 7)
			  {
				  searchStudentGrade();
			  }
			  else if (z == 8)
			  {
				  searchStudentEnrollmentCourses();
			  }
			  else if (z == 9)
			  {
				  break;
				  }} while (z != 0); 
		  }
		  else if (q == 000 || q == 4)
		  {
			  break;
			  }} while (q != 000);  
		 	
	}
 
 
// Method to Create The Tables. 
 
static void create() throws Exception
 {
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object //
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  
   
	   // Creating Tables //
	   
	   System.out.println("Creating Tables");
	   // Creating Courses Table.
	   stmt.execute("CREATE TABLE Courses(" +
			   "Coursenumber NUMBER(6) NOT NULL PRIMARY KEY, " + 
			   "Coursename VARCHAR2(20) NOT NULL, " +
			   "coursetitle VARCHAR2(12) NOT NULL," +
			   "coursecredits NUMBER(2) NOT NULL)");
	   			System.out.print(".");
	   
	   // Creating Course Requisits Table.
	   stmt.execute("CREATE TABLE Courserequisits(" +
               "Courserequisitnumber NUMBER(6) NOT NULL PRIMARY KEY, " + 
               "Coursereqname VARCHAR2(20) NOT NULL, " +
               "coursenumber NUMBER(6) NOT NULL, " +
               "FOREIGN KEY (coursenumber) REFERENCES Courses(Coursenumber))");
	   			System.out.print(".");
	   
	   // Creating Course Offering Table.
	   stmt.execute("CREATE TABLE Courseofferings(" +
               "Courseofferingnumber NUMBER(6) NOT NULL PRIMARY KEY, " + 
               "offeringyear NUMBER(4) NOT NULL, " +
               "semester VARCHAR2(12) NOT NULL," +
               "sectionnumber VARCHAR2(5) NOT NULL," +
               "classroom VARCHAR2(10) NOT NULL)");
	   			System.out.print(".");
	   
	   // Creating Course Offering Timing Table.
	   stmt.execute("CREATE TABLE Courseofferingtimings(" +
               "Courseofferingtimingnumber NUMBER(6) NOT NULL PRIMARY KEY, " + 
               "Courseofferingnumber NUMBER(6) NOT NULL, " +
               "coursetiming VARCHAR2(10) NOT NULL, " +
               "FOREIGN KEY (Courseofferingnumber) REFERENCES Courseofferings(Courseofferingnumber))");
	   			System.out.print(".");
	   
	   // Creating Instructors Table.
	   stmt.execute("CREATE TABLE Instructors(" +
               "Instructornumber NUMBER(6) NOT NULL PRIMARY KEY, " + 
               "Courseofferingnumber NUMBER(6) NOT NULL, " +
               "departmentname VARCHAR2(20) NOT NULL, " +
               "instructortitle VARCHAR2(12) NOT NULL, " +
               "Instructorname VARCHAR2(20) NOT NULL, " +
               "FOREIGN KEY (Courseofferingnumber) REFERENCES Courseofferings(Courseofferingnumber))");
	   			System.out.print(".");
	   
	   // Creating Students Table.
	   stmt.execute("CREATE TABLE Student(" +
               "Studentid NUMBER(6) NOT NULL PRIMARY KEY, " + 
               "studentname VARCHAR2(20) NOT NULL, " +
               "program VARCHAR2(12) NOT NULL)");
               	System.out.print(".");
	   
       // Creating Students Grade Table.
       stmt.execute("CREATE TABLE Studentgrade(" +
    		   "Studentgradeid NUMBER(6) NOT NULL PRIMARY KEY, " + 
    		   "coursenumber NUMBER(6) NOT NULL, " +
    		   "coursegrade VARCHAR2(2) NOT NULL, " +
    		   "studentid NUMBER(6) NOT NULL, " +
    		   "FOREIGN KEY (studentid) REFERENCES Student(Studentid))");
        	   	System.out.print(".");
        	   
      // Creating Student Enrollments Courses Table.
       stmt.execute("CREATE TABLE StudentenrollmentCourses(" +
    		   "Enrolled NUMBER(6) NOT NULL PRIMARY KEY, " + 
    		   "studentid NUMBER(6) NOT NULL, " +
    		   "enrolledcourses NUMBER(6) NOT NULL)");
      		   	System.out.println(".");
	   
	   // Close the resources.
	   
	   stmt.close();     
	   conn.close();
	   System.out.println("Tables Created!!");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


// Method to insert Data into Courses Table.

static void insertCourses() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  
  
	   // Inserting Data into Courses Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Courses.");
	   System.out.println("Please enter the course number.");
	   int cNumber  = sc.nextInt();
	   Scanner sc2 = new Scanner(System.in);     
	   System.out.println("Please enter the course name.");
	   String cName  = sc2.nextLine();
	   System.out.println("Please enter the course title.");
	   String cTitle  = sc.next();
	   System.out.println("Please enter the course credits.");
	   int cCredit  = sc.nextInt();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into Courses" +
	   "(Coursenumber, Coursename, coursetitle, coursecredits) " +
                      "VALUES (" +
                      cNumber +
                      ", '" +
                      cName +
                      "', " +
                      "'" +
                      cTitle +
                      "', " +
                      cCredit +
                      ")");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into Courserequisits Table.

static void insertCourserequisits() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  
  
	   // Inserting Data into Courserequisits Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Courserequisits.");
	   System.out.println("Please enter the course requisit number.");
	   int cRequisitNumber  = sc.nextInt();
	   System.out.println("Please enter the course requisit name.");
	   String cRequisitName  = sc.next();
	   System.out.println("Please enter the course number.");
	   int cNumber  = sc.nextInt();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into Courserequisits" +
	   "(Courserequisitnumber, Coursereqname, coursenumber) " +
                      "VALUES (" +
                      cRequisitNumber +
                      ", '" +
                      cRequisitName +
                      "', " +
                      cNumber +
                      ")");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into Courseofferings Table.

static void insertCourseofferings() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  
  
	   // Inserting Data into Courseofferings Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Courseofferings Table.");
	   System.out.println("Please enter the Course Offering Number.");
	   int cOfferingNumber  = sc.nextInt();
	   System.out.println("Please enter the Course Offering Year. EX:(2018),(2019)");
	   int cOfferingYear  = sc.nextInt();
	   System.out.println("Please enter the Semester. EX:(Spring), (Fall)");
	   String semester  = sc.next();
	   System.out.println("Please enter the Section Number. EX: (EM630)");
	   String section  = sc.next();
	   System.out.println("Please enter the Classroom. EX:(ENGL-2003)");
	   String classroom  = sc.next();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into Courseofferings" +
	   "(Courseofferingnumber, offeringyear, semester, sectionnumber, classroom) " +
                      "VALUES (" +
                      cOfferingNumber +
                      ", " +
                      cOfferingYear +
                      ", '" +
                      semester +
                      "' ,'" +
                      section +
                      "' ,'" +
                      classroom +
                      "')");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into Courseofferingtimings Table.

static void insertCourseofferingtimings() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Inserting Data into Courses Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Courseofferingtimings Table.");
	   System.out.println("Please enter the Course Offering Timing Number.");
	   int cOfferingTimingNumber  = sc.nextInt();
	   System.out.println("Please enter the Course Offering Number.");
	   int cOfferingNumber  = sc.nextInt();
	   System.out.println("Please enter the Course Timing. EX:(Mon,Wed - 6:30)");
	   String courseTiming  = sc.next();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into courseofferingtimings" +
	   "(courseofferingtimingnumber, courseofferingnumber, coursetiming) " +
                    "VALUES (" +
                    cOfferingTimingNumber +
                    ", " +
                    cOfferingNumber +
                    ", '" +
                    courseTiming +
                    "')");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into Instructors Table.

static void insertInstructors() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Inserting Data into Instructor Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Instructrs Table.");
	   System.out.println("Please enter the Instructor Number.");
	   int instructorNumber  = sc.nextInt();
	   System.out.println("Please enter the Course Offering Number.");
	   int cOfferingNumber  = sc.nextInt();
	   System.out.println("Please enter the Department Name.");
	   String departmentName  = sc.next();
	   System.out.println("Please enter the Instructor Title");
	   String instructorTitle  = sc.next();
	   System.out.println("Please enter the Instructor Name.");
	   String instructorName  = sc.next();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into Instructors" +
	   "(Instructornumber, Courseofferingnumber, departmentname, instructortitle, instructorname) " +
                    "VALUES (" +
                    instructorNumber +
                    ", " +
                    cOfferingNumber +
                    ", '" +
                    departmentName +
                    "' ,'" +
                    instructorTitle +
                    "' ,'" +
                    instructorName +
                    "')");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into Student Table.

static void insertStudent() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Inserting Data into Student Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Student Table.");
	   System.out.println("Please enter the Student ID.");
	   int studentId  = sc.nextInt();
	   System.out.println("Please enter the Student Name.");
	   Scanner sc2 = new Scanner(System.in);     
	   String studentName  = sc2.nextLine();
	   System.out.println("Please enter the Program.");
	   String program  = sc2.nextLine();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into Student" +
	   "(Studentid, studentname , program) " +
                  "VALUES (" +
                  studentId +
                  ", '" +
                  studentName +
                  "', '" +
                  program +
                  "')");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into Studentgrade Table.

static void insertStudentGrade() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Inserting Data into Studentgrade Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into Studentgrade Table.");
	   System.out.println("Please enter the Student Grade ID.");
	   int studentGradeId  = sc.nextInt();
	   System.out.println("Please enter the Course Number.");
	   int courseNumber  = sc.nextInt();
	   System.out.println("Please enter the Course Grade.");    
	   String courseGrade  = sc.next();
	   System.out.println("Please enter the Student ID.");
	   String studentId  = sc.next();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into Studentgrade" +
	   "(Studentgradeid, coursenumber , coursegrade, studentid) " +
                "VALUES (" +
                studentGradeId +
                ", " +
                courseNumber +
                ", '" +
                courseGrade +
                "', " +
                studentId +
                ")");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to insert Data into StudentenrollmentCourses Table.

static void insertStudentEnrollmentCourses() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Inserting Data into StudentenrollmentCourses Table from console.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("insert data into StudentenrollmentCourses Table.");
	   System.out.println("Please enter the Enrolled Number.");
	   int enrolledNumber  = sc.nextInt();
	   System.out.println("Please enter the Student ID.");
	   int studentId  = sc.nextInt();
	   System.out.println("Please enter the Enrolled Courses.");
	   Scanner sc2 = new Scanner(System.in);     
	   String enrolledCourses  = sc2.nextLine();
	   // SQL Statement to insert into the table.
	   stmt.executeUpdate("insert into studentenrollmentCourses" +
	   "(Enrolled, studentid , enrolledcourses) " +
              "VALUES (" +
              enrolledNumber +
              ", " +
              studentId +
              ", '" +
              enrolledCourses +
              "')");

	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	   System.out.println("Data Added.");
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}



//Method to Search the Courses Table.

static void searchCourses() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Courserequisits Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Courserequisits Table using Courses");
	   System.out.println("Please enter the Course Number.");
	   int coursetNumber  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from Courses where Coursenumber = " +
          coursetNumber );
		while (Entry.next())
		{	
	       System.out.println("Course Number : " + Entry.getInt(1) + " || " +
	    		   "Course Name : " + Entry.getString(2) + " || " + "Course Title : " +
	    		   Entry.getString(3) + " || " + "Course Credits : " +
	    		   Entry.getInt(4));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to Search the Courserequisits Table.

static void searchCourserequisits() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Courserequisits Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Courserequisits Table using Courserequisitnumber");
	   System.out.println("Please enter the Course Requisit Number.");
	   int courseRequisitNumber  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from COURSEREQUISITS where Courserequisitnumber = " +
            courseRequisitNumber );
		while (Entry.next())
		{	
	       System.out.println("Course Requisit Number : " + Entry.getInt(1) + " || " +
	    		   "Course Requisit Name : " + Entry.getString(2) + " || " + "Course Number : " +
	    		   Entry.getString(3));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to Search the Courseofferings Table.

static void searchCourseOfferings() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Coursesofferings Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Courseofferings Table using Courseofferingnumber");
	   System.out.println("Please enter the Course OFfering Number.");
	   int courseOfferingNumber  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from Courseofferings where Courseofferingnumber = " +
          courseOfferingNumber );
		while (Entry.next())
		{	
	       System.out.println("Course Offering Number : " + Entry.getInt(1) + " || " +
	    		   "Offering Year : " + Entry.getInt(2) + " || " + "Semester : " +
	    		   Entry.getString(3) +  " || " + "Section Number : " + Entry.getString(4) +
	    		   " || " + "Classroom : " + Entry.getString(5));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to Search the Courseofferingtimings Table.

static void searchCourseOfferingTimings() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Coursesofferingtimings Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Courseofferingtimings Table using Courseofferingtimingsnumber");
	   System.out.println("Please enter the Course OFfering Timing Number.");
	   int courseOfferingTimingNumber  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from Courseofferingtimings where Courseofferingtimingnumber = " +
        courseOfferingTimingNumber );
		while (Entry.next())
		{	
	       System.out.println("Course Offering Timing Number : " + Entry.getInt(1) + " || " +
	    		   "Course Offering Number : " + Entry.getInt(2) + " || " + "Course Timing : " +
	    		   Entry.getString(3));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to Search the Instructors Table.

static void searchInstructors() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Instructors Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Instructors Table using Instructornumber");
	   System.out.println("Please enter the Instructor Number.");
	   int instructorNumber  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from Instructors where Instructornumber = " +
      instructorNumber );
		while (Entry.next())
		{	
	       System.out.println("Instructor Number : " + Entry.getInt(1) + " || " +
	    		   "Course Offering Number : " + Entry.getInt(2) + " || " + "Department Name : " +
	    		   Entry.getString(3) + " || " + "Instructor Title : " +
	    		   Entry.getString(4) + " || " + "Instructor Name : " +
	    		   Entry.getString(5));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to Search the Student Table.

static void searchStudent() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Student Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Student Table using Studentid");
	   System.out.println("Please enter the Student ID.");
	   int studentId  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from Student where Studentid = " +
       studentId);
		while (Entry.next())
		{	
	       System.out.println("Student ID : " + Entry.getInt(1) + " || " +
	    		   "Student Name : " + Entry.getString(2) + " || " + 
	    		   "Program : " + Entry.getString(3));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}

//Method to Search the Studentgrade Table.

static void searchStudentGrade() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in Studentgrade Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the Studentgrade Table using Studentgradeid");
	   System.out.println("Please enter the Student Grade ID.");
	   int studentGradeId  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from Studentgrade where Studentgradeid = " +
			   studentGradeId);
		while (Entry.next())
		{	
	       System.out.println("Student Grade ID : " + Entry.getInt(1) + " || " +
	    		   "Course Number : " + Entry.getInt(2) + " || " + 
	    		   "Course Grade : " + Entry.getString(3) + " || " + 
	    		   "Student ID : " + Entry.getInt(4));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}


//Method to Search the StudentenrollmentCourses Table.

static void searchStudentEnrollmentCourses() throws Exception
{
	  try{  
		  
		  // Load Driver //
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   // Create a connection object.
	   
	   Connection conn=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:cisc","system","123456");  
	  
	   
	   // Connection Object //  
	   
	   Statement stmt = conn.createStatement();  

	   // Searching Data in StudentenrollmentCourses Table.
	   Scanner sc = new Scanner(System.in);     
	   System.out.println("Searching the StudentenrollmentCourses Table using Enrolled Number");
	   System.out.println("Please enter the Enrolled Number.");
	   int enrolledNumber  = sc.nextInt();
	   // SQL Statement to search the table.
	   ResultSet Entry = stmt.executeQuery("SELECT * from StudentenrollmentCourses where enrolled = " +
     enrolledNumber);
		while (Entry.next())
		{	
	       System.out.println(" Enrolled : " + Entry.getInt(1) + " || " +
	    		   "Student ID : " + Entry.getInt(2) + " || " + 
	    		   "enrolledcourses : " + Entry.getString(3));
		}
	   // Close the resources.

	   stmt.close();     
	   conn.close();
	   
	  }
	   
	  // Exception Handler //
	   
	  catch(Exception ex)
	  {
	      System.out.println("ERROR: " + ex.getMessage());
	  }}}