node{
   stage('clonning from GIT'){
git 'https://github.com/sabrine924/ProjetDevOps.git'
     }
stage('SonarQube Analysis') {
    def scannerHome = tool 'SonarQube'
      withSonarQubeEnv('SonarQube') {
      sh "${scannerHome}/bin/sonar-scanner" \
      }
    

}


}
