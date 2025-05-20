pipeline {
    agent any

    tools {
        jdk 'JDK 21'              // Match the name set in Jenkins > Global Tool Configuration
        maven 'Maven 3.9.9'       // Match the name set in Jenkins > Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sardaraz/Jenkins-Selenium.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
