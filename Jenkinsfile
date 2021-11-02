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
    stage('SonarQube analysis') {
       steps{
        withSonarQubeEnv('SonarQube') { 
       bat "mvn sonar:sonar"
    }
      }
   }
         stage('Build Maven') {
            steps{
             
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
                
            }
        }   
 //  stage('Email Notification ') {
  //   steps{
      //    emailext(
             //       to: 'hmidisabrine228@gmail.com' ,
             //      subject: 'This is the TimesheetProjet email ',
             //      body: 'job failure build '
                
                
          //        )
       //  }
//}     
    
 
    }
}
