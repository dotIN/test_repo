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
                sh "rake "
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
