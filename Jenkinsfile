pipeline{

  agent any
  
  tools {
    // '<name of tool>' given in the manage jenkins > Tools > Maven Installation
    maven 'Maven 3.9.15'
    jdk 'JDK 17'
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

         stage('testing the application'){
          steps{
            sh 'echo "========Testing Java Application============"'
            sh '''
                 mvn test
              '''
            sh 'echo "======Testing Java Application completed====="'
        
         }

        stage('packaging the application'){
          steps{
            sh 'echo "========Packaging Java Application============"'
            sh '''
                 mvn clean package
              '''
            sh 'echo "======Packaging Java Application completed====="'
        
         }
      }

        stage('creating the application'){
          steps{
            sh 'echo "========Creating Java Application============"'
            // sh '''
            //      mvn clean package
            //   '''
            sh 'echo "======Creating Java Application completed====="'
        
         }
 
  }
}
