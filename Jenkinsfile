pipeline {
    agent any

    environment {
        IMAGE_NAME = "vruttipatel13/hello-devops-project"
        CONTAINER_NAME = "hello-devops-container"
    }

    stages {

        stage('Checkout Code') {
    steps {
        git branch: 'main', url: 'https://github.com/menduvada/hello-devops-project.git'
    }
}

        stage('Build (Maven)') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }

        stage('Docker Build') {
    steps {
        sh '/usr/local/bin/docker build -t hello-devops-project .'
    }
}

        stage('Docker Tag') {
    steps {
        sh '/usr/local/bin/docker tag hello-devops-project vruttipatel13/hello-devops-project:latest'
    }
}

        stage('Docker Push') {
    steps {
        sh '/usr/local/bin/docker push vruttipatel13/hello-devops-project:latest'
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
