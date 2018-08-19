pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                dir('./TestApp') {
                    sh 'pm2 stop 0'
                }
                dir('./Project2') {
                    sh 'mvn clean'
                    sh 'mvn install -DskipTests'
                    //sh 'npm install -g protractor'
                }
            }
        }
        stage('Test') {
            steps {
                dir('./Project2') {
                    sh 'mvn test -fn'
                }
                dir('./TestApp') {
                    //sh 'npm install protractor-beautiful-reporter --save-dev'
                    sh 'webdriver-manager update'
                    sh 'webdriver-manager start --detach'
                    sh 'protractor Test/conf.js'
                    sh 'webdriver-manager shutdownc'
                }
            }
        }
        stage('Deliver') {
            steps {
                dir('./TestApp') {
                    sh 'ng build'
                    sh 'cat ./dist/TestApp/index.html | sed \'s|<base href=\"/\">|<base href=\"/TestApp/\">|g\' > ./dist/TestApp/index.html'
                    sh 'cp -r ../Project2/target/surefire-reports/index.html ./dist/TestApp/testResults.html'
                }
                dir('./Project2') {
                    sh 'echo $CATALINA_HOME'
                    sh 'cp -r target/*.war $CATALINA_HOME/webapps'
                    sh 'cp -r target/Project2 $CATALINA_HOME/webapps/'
                }
                dir('./TestApp') {
                    sh 'pm2 start ./server/index.js'
                }
            }
        }
    }
}