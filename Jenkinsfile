pipeline {
    agent any
    tools {
        maven 'maven-3.6.3'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build stage') {
            steps {
                sh 'cd backend && start mvn spring-boot:run -DskipTests'
            }
            post {
                success {
                    sh '''
                        echo "FINISH"
                    '''
                }
             }
        }
    }
}