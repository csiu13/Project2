pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                dir('./Project2') {
                    sh 'mvn clean'
                    sh 'mvn install'
                }
            }
        }
        stage('Test') {
            steps {
                dir('./Project2') {
                    sh 'mvn test'
                }
            }
        }
        stage('Deliver') {
            steps {
                dir('./TestApp') {
                    sh 'ng build'
                    sh 'cat ./dist/TestApp/index.html | sed \'s|<base href=\"/\">|<base href=\"/TestApp/\">|g\' > ./dist/TestApp/index.html'
                    sh 'cp -r ../target/surefire-reports/index.html ./dist/TestApp/testResults.html'
                }
                dir('./Project2') {
                    sh 'echo %CATALINA_HOME%'
                    sh 'cp -r target %CATALINA_HOME%/webapps *.war'
                    sh 'cp -r target/Project2 %CATALINA_HOME%/webapps/'
                }
                dir('./TestApp') {
                    sh 'npm start'
                }
            }
        }
    }
}