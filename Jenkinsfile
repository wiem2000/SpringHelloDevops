pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    git 'https://github.com/wiem2000/SpringHelloDevops.git' // Modifiez avec votre URL de dépôt
                }
                
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
               
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
              
                bat 'docker build -t wiembenmlouka/docker-spring-demo-test-sq .'
            }
        }

        stage('Docker Push') {
            steps {
                
                   bat 'docker login -u wiembenmlouka -p Wiwi@2000'

                    bat "docker push wiembenmlouka/docker-spring-demo-test-sq"
                
            }
        }
    }
}
