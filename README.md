# Student Management CLI — Code Review

## Overview

Three files reviewed: `Main.java`, `Student.java`, `StudentManager.java`

Overall the code is well-structured and follows a clean MVC pattern. Found **2 bugs** and **1 minor issue**.

---

## 🔴 Bug 1 — Wrong setter called in `updateStudentCourse()`

**File:** `StudentManager.java` — Line 38

```java
// WRONG
public boolean updateStudentCourse(int id, String course){
    Student s = findById(id);
    if(s != null){
        s.setName(course);   // ❌ setName() called instead of setCourse()
        return true;
    }else{
        return false;
    }
}
```

```java
// CORRECT
public boolean updateStudentCourse(int id, String course){
    Student s = findById(id);
    if(s != null){
        s.setCourse(course);   // ✅
        return true;
    }else{
        return false;
    }
}
```

**Impact:** Updating a student's course would silently overwrite their name instead. The bug would be hard to notice since the method returns `true` (success) either way.

---

## 🔴 Bug 2 — Missing prompt in `getStudent()`

**File:** `Main.java`

```java
// WRONG — no prompt before reading input
static void getStudent(){
    int id = sc.nextInt();   // ❌ user doesn't know what to type
    sc.nextLine();
    ...
}
```

```java
// CORRECT
static void getStudent(){
    System.out.println("Enter the ID of the student you wish to fetch");   // ✅
    int id = sc.nextInt();
    sc.nextLine();
    ...
}
```

**Impact:** The program just freezes waiting for input with no message on screen. Bad user experience.

---

## 🟡 Minor — Missing `sc.nextLine()` after menu choice read

**File:** `Main.java` — inside `main()`

```java
// Current
int option = sc.nextInt();   // leftover \n stays in buffer

// Better
int option = sc.nextInt();
sc.nextLine();               // consume leftover newline
```

**Impact:** Low risk here since the next reads are also `nextInt()`, but it's a good habit to always flush the buffer after every `nextInt()` call.

---

## ✅ What's Correct

| File | Status |
|---|---|
| `Student.java` — fields, constructor, all getters & setters | ✅ Correct |
| `StudentManager.java` — `addNewStudent()` with duplicate ID check | ✅ Correct |
| `StudentManager.java` — `removeStudentById()` | ✅ Correct |
| `StudentManager.java` — `updateStudentName()` | ✅ Correct |
| `StudentManager.java` — `getStudentInfo()` | ✅ Correct |
| `StudentManager.java` — `getAllStudentInfo()` with empty check | ✅ Correct |
| `StudentManager.java` — `findById()` helper | ✅ Correct |
| `Main.java` — `addStudent()` with `sc.nextLine()` after `nextInt()` | ✅ Correct |
| `Main.java` — `removeStudent()` | ✅ Correct |
| `Main.java` — `updateStudent()` with sub-menu | ✅ Correct |
| `Main.java` — `getAllStudent()` | ✅ Correct |
| `Main.java` — Exit with break | ✅ Correct |

---
