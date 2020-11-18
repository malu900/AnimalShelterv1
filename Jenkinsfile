pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage('maven') {
            echo 'mvn -v'
        }
        stage("compile") {
            steps {
                sh 'mvn clean verify'
            }
        }
    }
}
