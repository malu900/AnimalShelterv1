pipeline {
    agent any
    tools {
        maven 'mvn'
    }

    stages {
        stage("initialize") {
            steps {
                echo "------------------------------------- INITIALIZE -------------------------------------"
                sh 'java -version'
                sh 'javac -version'
                echo "------------------------------------- END INITIALIZE -------------------------------------"
            }
        }
        stage("project") {
            steps {
                echo "------------------------------------- MVN FULL PROJECT-------------------------------------"
                sh "mvn  -Dmaven.test.failure.ignore -Dmaven.test.skip=true clean install"
                echo "------------------------------------- END FULL PROJECT-------------------------------------"
            }
        }
        stage("test") {
            steps{
                echo "------------------------------------- TESTS -------------------------------------"
                sh "mvn clean test"
                echo "------------------------------------- END TESTS -------------------------------------"
            }
        }
    }
    post {
        always {
            archiveArtifacts "**/target/**/*"
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml'
        }
    }
}
