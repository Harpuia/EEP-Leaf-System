# Chaos Monkeys (Data61) code for Architecture assignment A3

## Introduction

This archive includes both the sources and the executables for this assignment.

The prerequisite to compiling is having the following software installed:

* JDK 1.8
* Netbeans 8.2

The prerequisite to executing the code is having the following installed:

* JRE 1.8
* MySQL 5.7.17
* J Connector 5.1.41 

## Installation
Before compiling or running the project, please follow the installation instructions of *A3_Installation.pdf*. After finishing the preliminary installataions, here are some extra steps required to run our new system:

* Open the terminal / CMD.
* Make sure the MySQL server has started. If the server is not on, please follow the instruction below.

For UNIX-based system, type the following commands in the terminal: 

```
$ mysql.server start
```

For Windows users, type the following commands in CMD:

```
C:\ start mysqlId -u root
```

* Run the command line MySQL interface to connect to the MySQL server

**Windows**

```
C:\ mysql --user=root
```

**UNIX**

```
$ mysql -u root
```

* In order to support the user management functionalities, you need to create a database by

```
mysql> create database administration;
```

* At this point exit from MySQL by typing `exit` at the MySQL prompt. In your OS shell (**not the MySQL command line window**), navigate to folder `MySQLData` and import the sample data by typing the following commands (*root pwd* is the password you set for the MySQL root administrator):

**Windows**

```
cd EEPs\MySQLData
mysql -u root -p[root pwd] -D administration < administration.sql 
```
**UNIX**

```
cd EEPs/MySQLData
mysql -u root -p[root pwd] -D administration < administration.sql
```

### To compile the code:

* Open NetBeans 8.2 and open **all 7 projects in the folder**.
* Resolve any project problems prompted by NetBeans.
* Select all the project and then click the build icon.

### To run with NetBeans IDE:

* Simply select one of the Java applications (`Inventory`, `OrderApp` or `ShippingApp`) and click the run icon. 
* **Note that there are 7 NetBeans project in total, but also 3 of them are Java applications that will be run. The other 4 projects are libraries we built.**

### To run without NetBeans IDE:

* Open the terminal or command line window, and navigate to the distribution directory. For example, to run the `OrderApp` application, type the following commands:

**Windows**

```
cd EEPs\OrderApp\dist
java -jar OrderApp.jar
```

**UNIX**

```
cd EEPs/OrderApp/dist
java -jar OrderApp.jar
```


