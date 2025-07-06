# 🎓 Academic System with Java and MongoDB

> A desktop application for Student Management (CRUD) built with Java Swing and integrated with a NoSQL MongoDB database.

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

---

## 🏗️ Project Structure

```
📦 sistema-academico-mongodb
├── 📄 pom.xml                      # Project dependencies and build configuration
└── 📁 src/
    └── 📁 main/
        └── 📁 java/
            ├── 📁 dao/
            │   └── 📄 AlunoDAO.java        # Data Access Object for student operations
            ├── 📁 model/
            │   └── 📄 Aluno.java           # Student data model
            ├── 📁 util/
            │   └── 📄 ConnectionMongo.java # MongoDB connection utility
            └── 📁 view/
                └── 📄 Tela.java            # Main application interface (JFrame)
```

---

## ✨ Features

- **📝 Register Students:** Add new students to the database
- **✏️ Update Students:** Modify information of existing students
- **❌ Delete Students:** Remove a student from the system by their ID (RA)
- **🔍 Query Students:** Search for a specific student by their ID (RA) and display their data
- **📋 List All:** Display a list of all registered students in the system

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java** | Main programming language |
| **Java Swing** | Library for creating the graphical user interface (GUI) |
| **MongoDB** | NoSQL database for storing student data |
| **MongoDB Java Driver** | Driver to connect and interact with the MongoDB database |
| **Maven** | Tool for dependency management and project build |

---

## 🚀 Getting Started

### 📋 Prerequisites

- **Java Development Kit (JDK) 11** or later
- **Apache Maven 3.6+**
- **MongoDB** (local instance running on the default port `27017`)

### 🖥️ Setup and Execution

1. **Clone the repository**
   ```bash
   git clone https://github.com/kevinfjq/sistema-academico-mongodb.git
   cd sistema-academico-mongodb
   ```

2. **Make sure MongoDB is running**
   - The application will try to connect to `mongodb://localhost:27017`
   - The `sistema_academico` database and the `alunos` collection will be created automatically on the first connection

3. **Compile and run the project with Maven**
   ```bash
   # Clean and compile the project
   mvn clean compile
   
   # Run the application (Method 1 - Recommended)
   mvn exec:java -Dexec.mainClass="view.Tela"
   
   # OR (Method 2 - Using configured plugin)
   mvn exec:java
   ```

4. **Alternative: Create and run executable JAR**
   ```bash
   # Create executable JAR with dependencies
   mvn clean package
   
   # Run the JAR file
   java -jar target/SistemaAcademicoMongo-0.0.1-SNAPSHOT-jar-with-dependencies.jar
   ```

5. **Running from an IDE**
   - Import the project as an "Existing Maven Project" in your IDE (Eclipse, IntelliJ, etc.)
   - Run the `main` method in the `view.Tela.java` class

---

##  How to Use

1. **➕ Novo (New):** Clears all fields for entering a new student
2. **💾 Salvar (Save):** Saves the new student's data filled in the fields
3. **🔄 Atualizar (Update):** Modifies an existing student's data. First, use the `RA` field and the `Consultar` (Query) button to load the data, change what is necessary, and click `Atualizar` (Update)
4. **❌ Excluir (Delete):** Deletes a student. Fill in the `RA` field of the student you want to remove and click `Excluir` (Delete)
5. **🔍 Consultar (Query):** Searches for a student by their `RA` and fills the fields with their information
6. **📋 Listar (List):** Displays all registered students in the text area at the bottom of the screen

---


### Database Structure

The application automatically creates:
- **Database:** `sistema_academico`
- **Collection:** `alunos`
- **Index:** Unique index on `ra` field

---

## 📝 Student Data Model

```json
{
  "ra": "123456",
  "nome": "João Silva",
  "email": "joao@email.com",
  "data_nascimento": "15/03/1995",
  "endereco": "Rua ABC, 123",
  "periodo": "Manhã"
}
```
