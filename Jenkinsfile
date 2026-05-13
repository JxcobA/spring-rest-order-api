pipeline{
 
  agent any
  tools {
    // '<name of tool>' given in the manage jenkins > Tools > Maven Installation
    maven 'Maven 3.9'
    jdk 'jdk_17'
}
 
  environment {
   IMAGE_NAME = 'priya123456/order-api'
  }  
 
  stages{
      stage ('Verify versions'){
        steps {
          sh 'echo $JAVA_HOME'
          sh 'which java'
          sh 'java -version'
          sh 'mvn -v'
        }
      }
      stage('building the application'){
        steps{
            sh 'echo "========Building Java Application============"'
            sh '''
                 mvn clean compile
              '''
            sh 'echo "======Building Java Application completed====="'
        }
      }
 
 
    stage('Testing the application'){
        steps{
            sh 'echo "========Testing Java Application============"'
            sh '''
                 mvn test
              '''
            sh 'echo "======Testing Java Application completed====="'
        }
      }
 
    stage('packinging the application'){
        steps{
            sh 'echo "========Packaging Java Application============"'
            sh '''
                 mvn clean package
              '''
            sh 'echo "======Packaging Java Application completed====="'
          }
      }
 
     stage('Creating Docker Image'){
        steps{
            sh 'echo "========Creating Docker Image ==========="'
              sh """
                     echo "IMAGE Name is - ${IMAGE_NAME}"
                     docker build -t $IMAGE_NAME:"${env.BUILD_NUMBER}" .
                 """      
             sh 'echo "======Completing Image Creation ====="'
          }
      }

  }
}
