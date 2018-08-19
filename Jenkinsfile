pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                dir('./Project2') {
                    bat 'mvn clean'
                    bat 'mvn install'
                }
            }
        }
        stage('Test') {
            steps {
                dir('./Project2') {
                    bat 'mvn test'
                }
            }
        }
        stage('Deliver') {
            steps {
                dir('./TestApp') {
                    bat 'ng build'
                    bat 'cat ./dist/TestApp/index.html | sed \'s|<base href=\"/\">|<base href=\"/TestApp/\">|g\' > ./dist/TestApp/index.html'
                    bat 'npm start'
                    bat 'robocopy ../target/surefire-reports/index.html ./dist/TestApp/testResults.html & EXIT /B 0'
                }
                dir('./Project2') {
                    bat 'echo %CATALINA_HOME%'
                    bat 'robocopy target %CATALINA_HOME%/webapps *.war & EXIT /B 0'
                    bat 'robocopy target/Project2 %CATALINA_HOME%/webapps/ /s & EXIT /B 0'
                    
                }
            }
        }
    }
}