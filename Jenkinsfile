pipeline {
    agent any
    tools {
        maven 'mvn'
    }

    stages {
        stage("project") {
            steps {
                echo "------------------------------------- MVN FULL PROJECT-------------------------------------"
                sh "mvn clean install"
                echo "------------------------------------- END FULL PROJECT-------------------------------------"
            }
        }
        stage("compile") {
            steps {
                echo "------------------------------------- SERVER MODULE -------------------------------------"
                sh 'java -version'
                sh 'javac -version'
                sh "'mvn' -Dmaven.test.failure.ignore -Dmaven.test.skip=true  -f ./server/pom.xml clean install"
                echo "------------------------------------- END SERVER MODULE -------------------------------------"
            }
        }
        stage("test") {
            steps{
                echo "------------------------------------- TESTS -------------------------------------"
                sh "mvn -Dmaven.test.failure.ignore -f ./server/pom.xml test"
                echo "------------------------------------- END TESTS -------------------------------------"
            }
        }
    }
    post {
        always {
            archiveArtifacts "**/target/**/*"
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
        }
    }
}
