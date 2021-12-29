#!groovy

apps = ['jenkins-demo-project']

pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                 sh 'mvn clean package'
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
                 sh 'docker ps -f name=jenkins-demo-project -q | xargs --no-run-if-empty docker container stop'
                 sh 'docker container ls -a -fname=jenkins-demo-project -q | xargs -r docker container rm'
                 sh "docker run --name jenkins-demo-project -p 9000:9000 -d jenkins-demo-project:latest"
            }
        }
    }
}