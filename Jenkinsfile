pipeline {
    agent { docker { image 'maven:3.3.3' } }
    triggers { scm('') }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
