pipeline{
    agent any
    environment {
        PATH = "$PATH:C:/Users/user/Desktop/apache-maven-3.8.1/bin"
    }
    stages{
       stage('GetCode'){
            steps{
                git 'https://github.com/sabrine924/ProjetDevOps.git'
            }
         }        
    stage('Checkout') {
        steps{
        checkout scm
        }
    }
 //  stage('Build'){
    //       steps{
    //           bat "mvn clean package"
     //      }
      //   }
    stage('SonarQube analysis') {
       steps{
        withSonarQubeEnv('SonarQube') { 
       bat "mvn sonar:sonar"
    }
      }
   }
        
    
 
    }
}
