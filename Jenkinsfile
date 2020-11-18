pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("clean install skip tests") {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore  clean install'
            }
        }
        stage("tests") {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore  test'
            }
        }
    }
}
