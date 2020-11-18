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
                echo 'mvn life cycle'
                sh 'mvn clean verify'
            }
        }
    }
}
