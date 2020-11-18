pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("compile") {
            steps {
                sh 'mvn clean verify'
            }
        }
    }
}
