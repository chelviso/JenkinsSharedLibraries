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
       deploy adapters: [tomcat9(credentialsId: 'tomcatcred', path: '', url: 'http://18.207.212.227:8080/')], contextPath: null, war: 'target/*war'
     }
}
