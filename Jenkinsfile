pipeline {
    agent any
    /* insert Declarative Pipeline here */
    stages {
        stage('run-test') {
            when {
                anyOf {
                    branch 'master'
                    branch 'dev'
            	   }
            }
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
                jacoco(
                    changeBuildStatus: true,
                    classPattern: 'build/classes',
                    exclusionPattern: '**/*Test*.class',
                    execPattern: 'build/jacoco/**.exec',
                    inclusionPattern: '**/*.class'
                )
            }
        }
        stage('sonarqube-analysis') {
            environment {
                SONAR_TOKEN = credentials('{sonarqube-token}')
            }
            steps {
                sh '''./gradlew sonarqube \
                    -Dsonar.projectKey=swimming-pool1 \
                    -Dsonar.host.url=http://140.134.26.54:10990 \
                    -Dsonar.login=8567f70461c246eddd06f1ed715decd22c505706
                '''
            }
        }
    }
}
