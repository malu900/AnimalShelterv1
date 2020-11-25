node {
    def mvnHome
    stages {
        stage('Initialize') {
            mvnHome = tool 'maven-3.6.3'
    //         maven 'mvn'
        }
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
