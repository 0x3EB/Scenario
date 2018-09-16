# EDC SCENARIOS 

EDC SCENARIO est une suite de test permettant d'effectuer des actions Web.

### Requirements
* Windows - MacOs X - Linux

### Installation

Before using the EDC SCENARIOS you need to install APACHE MAVEN in <mark>command line</mark>. 
The version of maven is the 3.5.3 and the jdk1.8.0_171 but you can have a different ones 

* Check your java version before everything

```bash
java -version
```

* Check if your JAVA_HOME is set and points to your JDK, To check if your envirnment variable is correct :

```bash
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_171
set PATH=%PATH%;%JAVA_HOME%\bin
```

```bash
echo %JAVA_HOME% 
C:\Program Files\Java\jdk1.8.0_171
```

* Then download on the website the maven zip or tar.gz(linux) you can download [here](http://maven.apache.org/download.html)

* Extract in any directory

```bash
unzip apache-maven-3.5.3-bin.zip # For windows or any zip files

#or if you get the tar.gz

tar xzvf apache-maven-3.5.3-bin.tar.gz
```

* to set the environment variables for Maven

```bash
set M2_HOME=c:\Program Files\apache-maven-3.5.3
set PATH=%PATH%;%M2_HOME%\bin
```

* Then just add the BIN directory of the exacted folder to the path envirnonment variable (JAVA_HOME)

* To conclude, you can check if the installation is correctly done by typing in the cmd (Winkey + R) or console :

```bash
mvn -v #Getting the version of the current maven

```

Next you have to download differents WebDrivers to run all the scenarios

* First is Chrome Webdriver
you can download it [here](http://chromedriver.chromium.org/downloads). You have to put to this path :

```bash
C:\chromedriver_win32\chroemdriver.exe

```

* Second is FirefoxDriver known as geckodriver
you can download it [here](https://github.com/mozilla/geckodriver/releases). You have to put to this path :

```bash
C:\geckodriver.exe

```

* Finally is the Edge WebDriver
you can download it [here](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/). You have to put to this path :

```bash
C:\MicrosoftWebDriver.exe

```

* Finally is the safari WebDriver
you can download it [here](https://www.seleniumhq.org/download/). You have to run the file and follow the steps. Check 'Enable WebDriver'.


### Usage
* Go to your folder where you have download the EDC SCENARIOS 

```bash
cd #acces to the folder
cd.. #return of the previous folder
ls #display all the content of the current folder (Linux / UNIX )
dir #Same as ls for Windows
mvn #command to execute the maven test

```

* Exceute the script using mavin, but with eclipse with varible Browser

```bash
Run -> Run configurations -> Maven Build -> New_Configuration 
Select the path of your project 

and Then go to environment and add a Variable called 'BROWSER' and set the value of the browser

eg: BROWSER      firefox

```


* Execute the script using maven (cmd) with the variable BROWSER

```bash
mvn test #The default browser is GOOGLE CHROME
mvn test -DBROWSER=firefox #launch with firefox
mvn test -DBROWSER=chrome #launch with chrome
mvn test -DBROWSER=ie #launch with internet explorer
mvn test -DBROWSER=safari #launch with safari ONLY MAC
mvn test -DBROWSER=opera #launch opera

````
