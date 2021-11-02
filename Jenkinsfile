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
   stage('Email Notification ') {
     steps{
          emailext(
                    to: 'hmidisabrine228@gmail.com' ,
                   subject: 'This is the TimesheetProjet email ',
                   body: readFile("target/surfire-reports/emailable-report.html"),
                   mimeType: 'test/html' ;
                
                
                  )
         }
}     
    
 
    }
}
