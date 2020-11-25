pipeline {
    agent any
    def mvnHome
    tools {
        mvnHome = tool 'maven-3.6.3'
        maven 'mvn'
    }
    stages {
        stage("compile") {
            steps {
                sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -f ./server/pom.xml clean install"
            } 
        }
//         stage("tests") {
//             steps {
//                 sh 'mvn -Dmaven.test.failure.ignore  test'
//             }
//         }
    }
}
