pipeline {
    agent { docker { image 'maven:3.3.3' } }
     options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
     }
    triggers {
        githubPush()
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'printenv'
            }
        }
    }

    stages {
        stage('compile') {
            steps {
                sh 'mvn compile'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
    }
}
