pipeline {
    agent any

    environment {
        IMAGE_NAME = "vruttipatel13/hello-devops-project"
        CONTAINER_NAME = "hello-devops-container"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/yourusername/hello-devops-project.git'
            }
        }

        stage('Build (Maven)') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }

        stage('Docker Tag') {
            steps {
                sh 'docker tag hello-devops-project $IMAGE_NAME:latest'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push $IMAGE_NAME:latest'
                }
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                docker run -d -p 8080:8080 --name $CONTAINER_NAME $IMAGE_NAME:latest
                '''
            }
        }
    }
}
