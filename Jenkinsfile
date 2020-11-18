pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("clean") {
            steps {
                echo 'mvn life cycle'
                sh 'mvn clean'
            }
        }
        stage("compile") {
            steps {
                echo 'mvn life cycle'
                sh 'mvn compile'
            }
        }
    }
}
