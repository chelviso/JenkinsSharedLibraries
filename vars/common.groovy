def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn deploy"
     }
  else if ("${stageName}" == "Upload Into Tomcat")
     {
     deploy adapters: [tomcat9(credentialsId: 'tomcatdada1', path: '', url: 'http://44.211.42.209:8080/')], contextPath: null, war: 'target/*.war'
     }
  
 else if ("${stageName}" == "Waiting Approval")
     {
       timeout(time:5, unit:'DAYS') {
    input message: 'Application ready for deployment, Please review and approve'
}
}
  else if ("${stageName}" == "Deploy To Production")
     {
      deploy adapters: [tomcat9(credentialsId: 'tomcatdada1', path: '', url: 'http://44.211.42.209:8080/')], contextPath: null, war: 'target/*war'
     }
     
  }
