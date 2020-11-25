pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("compile") {
            steps {
                sh "'mvn' -Dmaven.test.failure.ignore -f ./server/pom.xml clean install"
            }
        }
    }
}
