pipeline {
    agent any
    tools {
        maven 'mvn'
    }
    stages {
        stage("compile") {
            steps {
                sh 'mvn -U clean compile -Dmaven.compiler.source=11 -Dmaven.compiler.target=11'                
            } 
        }
        stage("tests") {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore  test'
            }
        }
    }
}
