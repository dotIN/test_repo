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
                sh 'git rev-parse HEAD > commit_id'
                get_commit_id()
                echo "Deploying...." 
                tryHTTP()
            }
        }
    }

}

def get_commit_id() {
  def commit = readFile('commit_id').trim() 
  println(commit);
}

def  tryHTTP() {
   def get = new URL("https://httpbin.org/get").openConnection();
   def getRC = get.getResponseCode();
   println(getRC);
   if(getRC.equals(200)) {
     println(get.getInputStream().getText());
   }
}
