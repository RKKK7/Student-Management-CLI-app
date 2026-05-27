# 📚 Student Management CLI

A simple command-line application built in **Java** to manage student records. Supports adding, removing, updating, searching, and listing students — all from the terminal.

---

## 🗂️ Project Structure

```
StudentManagement/
│
├── Main.java            # Entry point — handles CLI menu and user input
├── Student.java         # Student model — fields, constructor, getters & setters
└── StudentManager.java  # Business logic — all CRUD operations on student list
```

---

## ⚙️ Features

| # | Feature | Description |
|---|---|---|
| 1 | Add Student | Add a new student with ID, age, name, and course |
| 2 | Remove Student | Delete a student by their ID |
| 3 | Update Student | Update a student's name or course by ID |
| 4 | Get Student | Fetch and display details of a single student by ID |
| 5 | Get All Students | Display details of all students |
| 6 | Exit | Quit the application |

---

## 🧱 Class Breakdown

### `Student.java` — Model
Represents a single student object.

- Fields: `id`, `age`, `name`, `course`
- Constructor to initialize all fields
- Getters and setters for all fields

### `StudentManager.java` — Controller
Handles all operations on the student list.

- `addNewStudent()` — adds student, rejects duplicate IDs
- `removeStudentById()` — removes student by ID
- `updateStudentName()` — updates name by ID
- `updateStudentCourse()` — updates course by ID
- `getStudentInfo()` — prints details of one student
- `getAllStudentInfo()` — prints details of all students
- `findById()` — private helper to locate a student by ID

### `Main.java` — View
Handles everything the user sees and interacts with.

- Displays the menu in a loop until Exit is chosen
- Reads user input using `Scanner`
- Calls the appropriate method on `StudentManager`
- Displays success or error messages based on the result

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or above installed
- A terminal / command prompt

### Steps

**1. Clone or download the project**
```bash
git clone https://github.com/RKKK7/student-management-cli
cd student-management-cli
```

**2. Compile all Java files**
```bash
javac *.java
```

**3. Run the application**
```bash
java Main
```

> If using a package (e.g. `org.example` in IntelliJ), compile and run from the project root via your IDE's Run button.

---

## 🖥️ Usage Example

```
           WELCOME STUDENT MANAGEMENT CLI
1. Add a student
2. remove a student
3. Update student details
4. Get a student details
5. Get all student details
6. Exit
```

**Adding a student:**
```
Enter Student Id
101
Enter Student age
20
Enter Student name
Ravi Kumar
Enter Student course
AIML
student added successfully
```

**Fetching a student:**
```
Enter the ID of the student you wish to fetch
101
 student ID: 101
 student Name: Ravi Kumar
 student Age: 20
 student Course: AIML
 student details of iD 101 fetched successfully
```

**Updating a student:**
```
what would you like to update?
1. Name
2. course
1
Enter the id of the student
101
Enter the name
Ravi K
Student with ID 101 updated successfully
```

---

## 🏗️ Design Pattern

This project follows a simplified **MVC (Model-View-Controller)** pattern:

| Class | Role |
|---|---|
| `Student.java` | **Model** — data container |
| `StudentManager.java` | **Controller** — business logic |
| `Main.java` | **View** — user interface |

This separation keeps the code clean and maintainable. If you wanted to swap the CLI for a GUI later, only `Main.java` would need to change.

---

## 📌 Notes

- Data is stored **in memory only** — records are lost when the program exits
- Duplicate student IDs are not allowed
- No external libraries used — pure Java only

---

## 👨‍💻 Author

**Ravi Kumar**
Computer Science Student — AMC Engineering College
USN: 1AM22CS164
GitHub: [@RKKK7](https://github.com/RKKK7)
