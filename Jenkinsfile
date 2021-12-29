#!groovy

apps = ['jenkins-demo-project']

pipeline {
    agent any

    stages {
        stage('build') {
            steps {
            echo 'hello jenkins'
//                 sh 'mvn clean package'
//                 sh "mv ./target/*.jar ./docker/"
            }
        }
        stage('build-image') {
            steps {
//                 sh "docker build -t linas-jenkins-demo-project:latest ./docker"
            }
        }
        stage('deploy') {
            steps {
//                 sh "docker run -p 8081:8081 -d linas-jenkins-demo-project:latest"
            }
        }
    }
}