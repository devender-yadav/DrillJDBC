# DrillJDBC

 A simple project showing - "How to use Drill JDBC". 

Drill JDBC 1.4 is used for this project:

     <dependency>
       	<groupId>org.apache.drill.exec</groupId>
       	<artifactId>drill-jdbc</artifactId>
        <version>1.4.0</version>
     </dependency>

A simple query using CP (class path) plugin (_which is by default enabled in Drill_) is shown: 

    "select employee_id,first_name,last_name from cp.`employee.json` limit 10"
    
**How to Use**:

- Git Clone project using  `git clone https://github.com/devender-yadav/DrillJDBC.git`

- Use `mvn clean install`

- Run `TestJDBC.java` as Java Application
