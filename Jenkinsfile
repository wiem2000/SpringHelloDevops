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
        
         stage('Vulnerability Scan') {
            steps {
                script {
                    // Scanner l'image Docker avec Trivy en utilisant l'image Docker de Trivy
                    def scanResult = bat(script: 'docker run --rm --net=host aquasec/trivy:latest image --exit-code 1 --severity HIGH,CRITICAL wiembenmlouka/docker-spring-demo-test-sq', returnStatus: true)

                    if (scanResult != 0) {
                        error "Vulnerabilities detected! Please check the scan report."
                    } else {
                        echo "No critical vulnerabilities found."
                    }
                }
            }
        }
        
         stage('Docker Run') {
            steps {
                // Exécuter le conteneur sur le port 8081
                bat 'docker run -d -p 8081:8080 wiembenmlouka/docker-spring-demo-test-sq'
            }
        }


       // stage('Docker Push') {
            //steps {
                
                  // bat 'docker login -u wiembenmlouka -p Wiwi@2000'

                   // bat "docker push wiembenmlouka/docker-spring-demo-test-sq"
                
            //}
       // }
    }
}
