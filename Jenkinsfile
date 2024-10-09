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
        
       stage('Snyk Vulnerability Scan') {
          steps {
        // Scanner les vulnérabilités avec Snyk
        bat '''
            docker run --rm \
            -e SNYK_TOKEN=40a4a1d0-f1ad-4226-ac09-919ed4f30c1e \
            -v /var/run/docker.sock:/var/run/docker.sock \
            snyk/snyk:docker snyk test --docker wiembenmlouka/docker-spring-demo-test-sq --severity-threshold=critical
        '''
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
