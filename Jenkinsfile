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
        stage('Deliver') {
            steps {
                dir('./Project2') {
                    sh 'echo $CATALINA_HOME'
                    sh 'cp target/*.war $CATALINA_HOME/webapps/'
                    sh 'cp -r target/Project2 $CATALINA_HOME/webapps/'
                }
            }
        }
    }
}