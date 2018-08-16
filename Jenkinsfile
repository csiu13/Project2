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
        stage('Deliver') {
            steps {
                dir('./Project2') {
                    bat 'echo %CATALINA_HOME%'
                    bat 'robocopy target %CATALINA_HOME%/webapps *.war & EXIT /B 0'
                    bat 'robocopy target/Project2 %CATALINA_HOME%/webapps/ /s & EXIT /B 0'
                }
            }
        }
    }
}