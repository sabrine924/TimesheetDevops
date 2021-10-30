node{
   stage('clonning from GIT'){
git  'https://github.com/sabrine924/ProjetDevOps.git'
     }

stage('SonarQube Analysis') {
    def scannerHome = tool 'SonarQube'
      withSonarQubeEnv('SonarQube') {
      sh """/var/lib/jenkins/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarQube/bin/sonar-scanner \
     -D sonar.projectVersion=1.0  \
       -D sonar.login=admin \
      -D sonar.password=Sonaresprit2021 \
      -D sonar.projectBaseDir=C:\Windows\System32\config\systemprofile\AppData\Local\Jenkins\.jenkins\workspace\TimesheetDevops@script  \
        -D sonar.projectKey=ProjetDevOps \
        -D sonar.sourceEncoding=UTF-8 \
        -D sonar.language=java \
        -D sonar.sources=src\main\java\tn\esprit\spring \
        -D sonar.tests=src\test\java\tn\esprit\spring\test \
        -D sonar.host.url= http://localhost:9000/"""
        }
}      

}
