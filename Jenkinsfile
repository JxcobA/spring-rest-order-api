pipeline {

  agent any
  
  tools {
    maven 'Maven 3.9.15'
    jdk 'JDK 17'
  }

  stages {

    stage('Verify versions') {
      steps {
        sh 'echo $JAVA_HOME'
        sh 'which java'
        sh 'java -version'
        sh 'mvn -v'
      }
    }
    
    stage('Build') {
      steps {
        sh 'echo "========Building Java Application============"'
        sh 'mvn clean compile'
        sh 'echo "======Building Java Application Completed====="'
      }
    }

    stage('Test') {
      steps {
        sh 'echo "========Testing Java Application============"'
        sh 'mvn test'
        sh 'echo "======Testing Java Application Completed====="'
      }
    }

    stage('Package') {
      steps {
        sh 'echo "========Packaging Java Application============"'
        sh 'mvn clean package'
        sh 'echo "======Packaging Java Application Completed====="'
      }
    }

    stage('Create') {
      steps {
        sh 'echo "========Creating Docker Image============"'
        sh 'echo "======Creating Docker Image Completed====="'
      }
    }

  }
}
