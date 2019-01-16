pipeline {
    agent { docker { image 'maven:3.3.3' } }
     options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
     }
    triggers {
        pollSCM('')
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'printenv'
            }
        }
    }
}
