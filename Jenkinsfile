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
  
 
           stage('SonarQube analysis') {
       steps{
        withSonarQubeEnv('SonarQube') { 
       bat "mvn sonar:sonar"
    }
      }
   }
                 stage('Build Maven') {
            steps{
              git branch: 'main', credentialsId: 'token_nexus', url: 'https://github.com/sabrine924/ProjetDevOps.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
                
            }
            post {
            success {
          
               jacoco classPattern: "**/classes", sourcePattern: "**/src/main/java"
               

            }
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

                            repository: 'DevOpsProject',

                            credentialsId: 'token_nexus',

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

        
      stage('Build Docker Image') {

			steps {
				bat 'docker build -t softwaredeveloper98/timesheet-spring-boot-core-data-jpa-mvc-rest-1:latest .'
			}
		}

		stage('Push') {

			steps {
			    bat'docker login -u "softwaredeveloper98" -p "sabrine" docker.io '
			    bat 'docker push softwaredeveloper98/timesheet-spring-boot-core-data-jpa-mvc-rest-1:latest'
			}
			
		}
		stage('Cleaning up'){
			steps{
				bat "docker rmi softwaredeveloper98/timesheet-spring-boot-core-data-jpa-mvc-rest-1:latest" 
			}
		}
     
     
 
 
    }
    post {
          failure {  
             mail  bcc: '', body: "Result : ${currentBuild.currentResult}<br> JOB : ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL} <br> ", cc: '', charset: 'UTF-8', from: 'Jenkins@gmail.com', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}  ", 
             to: "hmidisabrine228@gmail.com" 
         }
          success {
          mail   bcc: '', body: "Result : ${currentBuild.currentResult}<br> JOB : ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL} <br> ", cc: '', charset: 'UTF-8', from: 'Jenkins@gmail.com', mimeType: 'text/html', replyTo: '', subject: "SUCCES CI: Project name -> ${env.JOB_NAME}  ", 
             to: "hmidisabrine228@gmail.com" 
         }
      
     }
     

     
     
}
