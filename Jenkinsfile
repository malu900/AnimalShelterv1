node {
    def mvnHome
    stage('Initialize') {
        mvnHome = tool 'maven-3.6.3'
    }
    stage("compile") {
        steps {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -f ./server/pom.xml clean install"
        }
    }
}
