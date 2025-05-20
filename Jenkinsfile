pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
        jdk 'JDK 21'
    }

    environment {
        PATH = "/usr/bin:$PATH"  // Make sure chromedriver is in path
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your/repo.git' // replace with actual repo
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
