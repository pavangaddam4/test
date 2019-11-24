pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/pavangaddam4/test.git'
                sh "pwd"
                sh "who am i"
            }

        }
        stage('Build') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Docker') {
            steps {
                sh "docker build -t pgaddam/demo:latest ."
                sh "docker tag pgaddam/demo:latest 598860148757.dkr.ecr.us-east-2.amazonaws.com/claims:latest"
                sh "aws ecr get-login --no-include-email --region us-east-2 | bash"
                sh "sleep 5"
                sh "docker push 598860148757.dkr.ecr.us-east-2.amazonaws.com/claims:latest"
                sh "sleep 7"
                sh "aws ecs update-service --cluster claims-fargate-cluster --service claims-service --force-new-deployment"
                sh "sleep 40"
            }
            post {
                success {
                    echo "Successfully completed...."
                }
            }
        }
    }
}