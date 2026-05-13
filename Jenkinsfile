pipeline{

  agent any
  
  tools {
    // '<name of tool>' given in the manage jenkins > Tools > Maven Installation
    maven 'Maven 3.9'
    jdk 'jdk_17'
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
 
  }
}
