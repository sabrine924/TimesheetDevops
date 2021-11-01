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
        
        post {
           post {  
         always {  
             echo 'This will always run'  
         }  
         success {  
             echo 'This will run only if successful'  
         }  
         failure {  
             mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "foo@foomail.com";  
         }  
         unstable {  
             echo 'This will run only if the run was marked as unstable'  
         }  
         changed {  
             echo 'This will run only if the state of the Pipeline has changed'  
             echo 'For example, if the Pipeline was previously failing but is now successful'  
         }  
     }  
 
    }
}
