pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build Appliation'
            }
        }
    
        stage('Test') {
            steps {
                echo 'Test application'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploy application'
            }        
        }
    }
    post {
         success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}

