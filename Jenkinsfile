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
        stage("test") {
            steps{
                sh "mvn -Dmaven.test.failure.ignore -f ./server/pom.xml test"
            }
        }
        stage('Results') {
//             archiveArtifacts './server/target/*.jar'
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml'
        }
    }
}
