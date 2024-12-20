pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    git 'https://github.com/wiem2000/SpringHelloDevops.git' 
                }
                
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
               
                bat 'mvn clean verify'
            }
        }
        
       
        stage('SonarQube Analysis') {
           
            steps {
               
                bat """
                mvn sonar:sonar \
                -Dsonar.projectKey=spring-hello-devops \
                -Dsonar.projectName='spring-hello-devops' \
                -Dsonar.host.url=http://localhost:9000 \
                -Dsonar.token=sqp_e179ba50cc940dcc7bae10e95bce0b0c4d403bbd \
                -Dsonar.jacoco.reportPaths=target\\jacoco.exec
                """
            }
        }

        stage('Docker Build') {
            steps {
              
                bat 'docker build -t wiembenmlouka/docker-spring-demo-test-sq .'
            }
        }
        
       stage('Snyk Vulnerability Scan') {
          steps {
        
        bat '''
            docker run --rm \
            -e SNYK_TOKEN=40a4a1d0-f1ad-4226-ac09-919ed4f30c1e \
            -v /var/run/docker.sock:/var/run/docker.sock \
            snyk/snyk:docker snyk test --docker wiembenmlouka/docker-spring-demo-test-sq --severity-threshold=critical
        '''
              }
          }   
          
          stage('Docker Push') {
            steps {
                
                  bat 'docker login -u wiembenmlouka -p Wiwi@2000'

                   bat "docker push wiembenmlouka/docker-spring-demo-test-sq"
                
            }
        }
          
        
         stage('Docker Run') {
            steps {
              
                bat 'docker run -d -p 8081:8080 wiembenmlouka/docker-spring-demo-test-sq'
            }
        }

    
    }
}
