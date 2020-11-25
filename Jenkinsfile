pipeline {
    agent any
    tools {
        maven 'mvn'
    }

    stages {
        stage("project") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("compile") {
            steps {
                sh 'java -version'
                sh 'javac -version'
                sh "'mvn' -Dmaven.test.failure.ignore -f ./server/pom.xml clean install"
            }
        }
    }
}
