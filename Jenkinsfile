node{
   stage('clonning from GIT'){
git 'https://github.com/sabrine924/ProjetDevOps.git'
     }
stage('SonarQube Analysis') {
    def scannerHome = tool 'SonarQube'
      withSonarQubeEnv('SonarQube') {
      bat "${scannerHome}/bin/sonar-scanner" \
     -D sonar.projectVersion=1.0 \
       -D sonar.login=admin \
      -D sonar.password=Sonaresprit2021 \
      -D sonar.projectBaseDir=C:/Windows/system32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/TimesheetDevops@script/ \
        -D sonar.projectKey=ProjetDevOps \
        -D sonar.sourceEncoding=UTF-8 \
        -D sonar.language=java \
        -D sonar.sources=ProjetDevOps/src/test/java\tn/esprit/spring/test \
        -D sonar.tests=ProjetDevOps/src/main/java/tn/esprit/springt \
        -D sonar.host.url=http://localhost:9000/"""
        }
}

}
