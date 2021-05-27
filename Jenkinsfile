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
    }
}
