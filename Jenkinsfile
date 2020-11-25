pipeline {
    agent any
    tools {
        maven 'mvn'
    }
     stage("jdk11") {
        environment {
            JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
        }
        steps {
            sh "java -version"
            sh "mvn --version"
        }
    }
    stages {
        stage("compile") {
            steps {
                sh 'java -version'
                sh 'javac -version'
                sh "'mvn' -Dmaven.test.failure.ignore -f ./server/pom.xml clean install -X"
            }
        }
    }
}
