pipeline{

  agent any
  
  tools {
    // '<name of tool>' given in the manage jenkins > Tools > Maven Installation
    maven 'Maven 3.9'
 }

  environment {
    JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'   //  force JDK 21 to be used
    PATH = "${JAVA_HOME}/bin:${env.PATH}"
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
            sh 'mvn clean compile'
            sh 'echo "======Building Java Application completed====="'
          
        }
      }
 
  }
}
