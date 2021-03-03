# Sales Assist
### Sales-Force-Automation (Oracle-ADF)

Sales Assist is a miniaturized Sales Force application created using Oracle ADF and JDev. 

#### Requirements
- Oracle JDeveloper [Link here](https://www.oracle.com/in/tools/downloads/jdeveloper-12c-downloads.html)
- Oracle SQLDeveloper [Link here](https://www.oracle.com/tools/downloads/sqldev-downloads.html)
- VirtualBox [Link here](https://www.virtualbox.org/wiki/Downloads)
- JDK 1.8.+ [Link here](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
- Oracle DB VM [Link here](https://www.oracle.com/database/technologies/databaseappdev-vm.html)

#### Setting up Database and running
* Inside the opening terminal of Oracle DB VM, enter the following 

```SQL
SQLPLUS
--Username - SYSTEM
--Password - oracle

ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER hyzam IDENTIFIED BY hyzam;
GRANT ALL PRIVILEGES TO hyzam;
```

- Now back inside your machine, open SQLDeveloper and create a new connection with the following properties
  - username - hyzam
  - password - hyzam
  - port - 1521
  - service name - ORCL
  
- Inside SQLDeveloper run [this](https://github.com/HyzamAli/Sales-Force-Automation---Oracle-ADF/blob/master/SFA_DB.sql) script for the newly created connection
- Now open Jdev and clone the repository from Tools > Git > Clone
- To run the application : ViewController > Web Content > login.jsf - Right click and click run
  - To run as administrator
    - username: admin
    - password: admin1234
  - To run as Sales Representative
    - username: user
    - password: user1234
    

***Contributers Guidelines***
- Create an issue describing the bug/enhancement
- Open a pull request with the branch containing the fix/enhancement and the issue number associated

***Current Contributers***
- [Shweta V A](https://github.com/shweta98va)
- [Hyzam Ali](https://github.com/HyzamAli)
