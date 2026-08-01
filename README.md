# Selenium Demo Framework

**Group Members:**

* Edrian B. Señar
* Arian M. Mance
* Taniah Jane G. Versoza

## Brief Project Description

This project is an automated testing framework built to perform regression testing across web browsers, specifically Google Chrome. The framework automates and validates key user workflows, including user registration, user login (handling both correct and incorrect credentials), and contact us form submissions. Upon execution, the framework automatically generates comprehensive HTML testing reports and captures screenshot images for each test step.

## Technologies Used

* **Java:** The core programming language used for the test scripts.
* **Selenium WebDriver:** Used for automating browser interactions and validating web elements.
* **Maven:** Dependency management and build automation tool.
* **Visual Studio / VS Code:** The integrated development environment (IDE) used to structure, write, and manage the project workspace.

## Instructions on how to set up and run the project

1. Ensure that the Java Development Kit (JDK) and Apache Maven are installed and configured on your local machine.
2. *Note:* If using Visual Studio Code, ensure you have the **Extension Pack for Java** installed for full Maven and testing support.
3. Clone or extract the `seleniumdemoframework` project files to your local directory.
4. Open your Visual Studio IDE and select **Open Folder** (or **File > Open Folder...**), then navigate to and select the extracted `seleniumdemoframework` folder.
5. Allow the IDE a moment to detect the `pom.xml` file, download the necessary Maven dependencies, and build the Java workspace.
6. Open your testing class file and execute the run command (usually via the "Run" button above the `main` method, or using the built-in Test Explorer).
7. Once the execution is complete, navigate to the newly generated `Reports/REGRESSION_CHROME/` folder to view the `REGRESSION_CHROME_TESTING.html` report and the associated test screenshots located in the `img-src` subdirectory.
