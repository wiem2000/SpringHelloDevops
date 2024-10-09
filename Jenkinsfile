pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    git 'https://github.com/wiem2000/SpringHelloDevops.git' // Modifiez avec votre URL de dépôt
                }
                // Commande Maven pour construire le projet
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Commande Maven pour exécuter les tests
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                // Construire l'image Docker
                bat 'docker build -t wiembenmlouka/docker-spring-demo-test-sq .'
            }
        }

        stage('Docker Push') {
            steps {
                // Pousser l'image vers Docker Hub
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    bat "echo %DOCKERHUB_PASSWORD% | docker login -u %DOCKERHUB_USERNAME% --password-stdin"
                    bat "docker push wiembenmlouka/docker-spring-demo-test-sq"
                }
            }
        }
    }
}
