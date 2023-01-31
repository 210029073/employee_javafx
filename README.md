# employee_javafx
An Employee GUI app created using JavaFX with search capabilities, and is able to retrieve employee details from the database.

## Requirements 
- Java JDK 17 or later.
- Eclipse IDE (Though it is recommeneded to use IntelliJ)
- MySQL version 8.0.28 or later.

## Setup
For setting up the database, please make sure that your database configuration and credentials matches <code>EmployeeDatabaseCollection.java</code> by making changes to the <code>EmployeeDatabaseCollection.java</code> class from <code>src/java/main/com/first/employee</code>.

On MySQL simply type:
<code>
CREATE DATABASE Employee;
CREATE TABLE employee(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  role TEXT,
  join_date DATE,
  date_of_birth DATE
) 
</code>

For Microsoft Windows users it should just work without any errors when running javafx:run when running it via the Plugins section from Maven tab in IntelliJ.

Or javafx:run in run configurations for running Maven script via Eclipse.

## Important Note for macOS/Linux Users
- May not work correctly in Linux/macOS when running the project in Eclipse or IntelliJ
- May involve you to install Maven from your dependency repository manager.
- For Debian/Ubuntu Linux users simply run <code>sudo apt install maven</code> on your terminal.
- **PLEASE NOTE THAT THIS HAS BEEN TRIED ON Ubuntu 22.04 LTS**
- Then browse to the project directory and run <code>mvn javafx:run</code>
