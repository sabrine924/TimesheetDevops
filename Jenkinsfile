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
     //  stage('Build'){
     //       steps{
      //          sh 'mvn clean package'
         //   }
      //   }
     //   stage('SonarQube analysis') {
  //  def scannerHome = tool 'SonarQube';
   //     steps{
   //     withSonarQubeEnv('SonarQube') { 
        // If you have configured more than one global server connection, you can specify its name
   //   sh "${scannerHome}/bin/sonar-scanner"
 //       sh "mvn sonar:sonar"
 //   }
  //      }
   //     }
 
    }
}
