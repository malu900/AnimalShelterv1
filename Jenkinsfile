pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("clean install skip tests") {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore  clean install  -Dmaven.compiler.source=1.6 -Dmaven.compiler.target=1.6'
            }
        }
        stage("tests") {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore  test'
            }
        }
    }
}
