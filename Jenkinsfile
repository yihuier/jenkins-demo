#!groovy

apps = ['jenkins-demo-project']

pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                 sh './mvnw clean package'
                 sh "mv ./package/*.jar ./docker/"
            }
        }
        stage('build-image') {
            steps {
                 sh "docker build -t jenkins-demo-project:latest ./docker"
            }
        }
        stage('deploy') {
            steps {
                 sh "docker run -p 9000:9000 -d jenkins-demo-project:latest"
            }
        }
    }
}