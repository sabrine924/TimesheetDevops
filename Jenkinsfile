pipeline{
    agent any
    environment {
        PATH = "$PATH:C:/Users/user/Desktop/apache-maven-3.8.1/bin"
        EMAIL_TO = 'someone@gmail.com'
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
              git branch: 'CodeWithSonarup1', credentialsId: 'NEXUS_CRED', url: 'https://github.com/sabrine924/ProjetDevOps.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
                
            }
        }   
    
    stage("Publish to Nexus Repository Manager") {

            steps {

                script {

                    pom = readMavenPom file: "pom.xml";

                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");

                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"

                    artifactPath = filesByGlob[0].path;

                    artifactExists = fileExists artifactPath;

                    if(artifactExists) {

                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";

                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            
                            protocol: 'http',

                            nexusUrl: 'localhost:8081/',

                            groupId: 'pom.com.tn.esprit.spring',

                            version: 'pom.1.0',

                            repository: 'TimesheetProject',

                            credentialsId: 'NEXUS_CRED',

                            artifacts: [

                                [artifactId: 'pom.Timesheet-spring-boot-core-data-jpa-mvc-REST-1',

                                classifier: '',

                                file: artifactPath,

                                type: pom.packaging],

                                [artifactId: 'pom.Timesheet-spring-boot-core-data-jpa-mvc-REST-1',

                                classifier: '',

                                file: "pom.xml",

                                type: "pom"]

                            ]

                        );

                    } else {

                        error "*** File: ${artifactPath}, could not be found";

                    }

                }

            }

        }
          stage('Email Notification ') {
     steps{
          emailext(
                    to: 'hmidisabrine228@gmail.com' ,
                   subject: 'This is the TimesheetProjet email ',
                   body: 'job failure build '
                
                
                )
        }
              
} 
         post {
            failure {
                emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                        to: EMAIL_TO, 
                        subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
            }
         }
 
    }
}
