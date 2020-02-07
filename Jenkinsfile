pipeline {
	agent any

	stages {
	    wrappers {
                preBuildCleanup { // Clean before build
                    includePattern('**/target/**')
                    deleteDirectories()
                    cleanupParameter('CLEANUP')
                }
            }
		stage('Clone') {
			steps {
				git 'https://github.com/pavangaddam4/test.git'
				sh "pwd"
				sh "echo 'Current user: ' $USER"
			}

		}
		stage('Build') {
			steps {
				sh "mvn -Dmaven.test.failure.ignore=true clean package"
			}
		}
		stage('Docker') {
			steps {
				sh "docker build -t 230429497234.dkr.ecr.us-east-1.amazonaws.com/cs-portal-l1:latest ."
				//sh "docker tag pgaddam/demo:latest 598860148757.dkr.ecr.us-east-2.amazonaws.com/claims:latest"
				sh "aws ecr get-login --no-include-email --region us-east-1 | bash"
				sh "sleep 5"
				sh "docker push 230429497234.dkr.ecr.us-east-1.amazonaws.com/cs-portal-l1:latest"
				sh "sleep 7"
				sh "aws ecs update-service --cluster cs-portal-l1 --service cs-portal-l1 --force-new-deployment"
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