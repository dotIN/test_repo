pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                echo "Fix 01 "
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
                script {
                  env.COMMIT = readFile 'commit_id'
                }
                echo "Deploying.... ${env.COMMIT}" 
                tryHTTP()
            }
        }
    }
   post { 
        always { 
            echo 'I will always execute ' 
            echo 'I will always execute, am I first !! ' 
        }
    }
}

def get_commit_id() {
  def commit = readFile('commit_id').trim();
  println(commit);
  return this
}

def  tryHTTP() {
   def get = new URL("https://httpbin.org/get").openConnection();
   def getRC = get.getResponseCode();
   println(getRC);
   if(getRC.equals(200)) {
     println(get.getInputStream().getText());
   }
}
