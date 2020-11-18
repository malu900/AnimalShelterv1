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
                sh 'mvn -Dmaven.test.failure.ignore clean install'
            }
        }
    }
}
