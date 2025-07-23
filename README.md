# 💳 FinTeck-Bridge — Intelligent Digital Banking System

**FinTeck-Bridge** is a smart and secure desktop-based digital banking platform developed using **Java, JDBC, Swing, and MySQL**, with intelligent features powered by the **OpenAI API**. It modernizes traditional banking by enabling fast, reliable transactions, secure account handling, and administrative control — all from an intuitive graphical interface.

---

## 🧠 Key Features

- 🔐 Secure User Authentication (Login/Register/Forgot Password)
- 💳 Account Dashboard with Transaction Management
- 🔄 Money Transfer, Deposit & Withdrawal System
- 📊 Transaction History Viewer
- 👨‍💼 Admin Panel for User & System Oversight
- 🤖 OpenAI Integration for Smart Chat or Help Assistant
- 🖥️ Swing-based GUI Desktop Application
- 🗄️ MySQL Database Backend using JDBC

---

## 🧱 Tech Stack

| Layer         | Technology            |
|---------------|------------------------|
| Frontend      | Java Swing (GUI)       |
| Backend       | Java (OOP) + JDBC      |
| Database      | MySQL                  |
| Intelligence  | OpenAI API             |
| Architecture  | MVC Design Pattern     |

---

## 📁 Folder Structure

FinTeck-Bridge/ <br>
│ <br>
├── src/ <br>
│ ├── ui/ # GUI screens using Swing <br>
│ ├── dao/ # JDBC Database Access Objects <br>
│ ├── model/ # Java Beans / Data Models <br>
│ ├── service/ # Business logic and controllers <br>
│ └── utils/ # Helper utilities (e.g., OpenAI integration) <br>
│ <br>
├── lib/ # External JARs (if any) <br>
├── sql/ # MySQL scripts for DB schema <br>
├── README.md <br>
└── LICENSE <br>



---

## ⚙️ Setup Instructions

### ✅ Prerequisites

- Java JDK 8 or higher
- MySQL Server
- IDE (e.g., IntelliJ IDEA, Eclipse)
- OpenAI API Key (for smart assistant feature)

### 🔧 Installation Steps

1. **Clone the Repository**<br>
git clone https://github.com/krpiyush1302/FinTeck-Bridge.git <br>
cd FinTeck-Bridge



3. **Configure the Database**

- Open MySQL and run the script from `/sql/schema.sql` to set up tables.
- Update DB credentials in `DBConnection.java`.

3. **Add Dependencies**

- Add the MySQL JDBC connector JAR in your IDE.
- (Optional) Add OpenAI SDK JAR if using advanced integration.

4. **Run the Application**

- Open and run `Main.java` file.
- GUI will launch and system will be ready to use.

---

## 🧠 OpenAI Smart Assistant

This project includes an optional AI-powered chatbot integrated via the **OpenAI API** to:

- Answer banking FAQs
- Assist with user navigation
- Provide personalized tips

> 💡 Requires an active internet connection and valid OpenAI API Key.

---

## 👨‍💻 Developed By

- **Piyush Raj**
- **Ashwini Kumar**
- **Ashutosh Kumar**
- **Nitish Kumar Pathak**

---

## 📌 Future Enhancements

- Two-factor Authentication (2FA)
- Web-based version using Spring Boot
- Mobile app using Flutter or React Native
- AI-powered budget suggestions
- Role-Based Access Control for advanced admin features

---

🔗 Connect With Me <br>

💼 GitHub: github.com/krpiyush1302 <br>
🔗 LinkedIn: linkedin.com/in/krpiyush1308<br>
📧 Email: pk7049153@gmail.com<br>


## 🙋‍♂️ Feedback or Contributions

Have ideas to improve it? Found a bug?  
Feel free to open an issue or raise a pull request!

> ⭐ If you like this project, give it a star on GitHub!
