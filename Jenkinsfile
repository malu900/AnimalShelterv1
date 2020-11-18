pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("compile") {
            steps {
                echo 'mvn life cycle'
                sh 'mvn -Dmaven.test.failure.ignore  clean install'
            }
        }
    }
}
