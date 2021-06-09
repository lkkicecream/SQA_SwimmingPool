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
                    classPattern: 'app/build/classes',
                    inclusionPattern: '**/*.class',
                    exclusionPattern: '**/*Test*.class',
                    execPattern: 'app/build/jacoco/**/*.exec'
                )
            }
        }
        stage('sonarqube-analysis') {
            environment {
                SONAR_TOKEN = credentials('wtf')
            }
            steps {
                sh '''./gradlew sonarqube \
  -Dsonar.projectKey=gg \
  -Dsonar.host.url=http://140.134.26.54:10990 \
  -Dsonar.login=SONAR_TOKEN
                '''
            }
        }
    }
}
