pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                //sh "rake "
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                tryHTTP()
            }
        }
    }

}

   def  tryHTTP() {
   def get = new URL("https://httpbin.org/get").openConnection();
   def getRC = get.getResponseCode();
   println(getRC);
   if(getRC.equals(200)) {
       println(get.getInputStream().getText());
   }
  }
