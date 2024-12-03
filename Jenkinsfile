pipeline {
    agent any

    environment {
        // Define o ambiente ativo para o Spring Boot
        SPRING_PROFILE = 'test'  // Para usar o application-test.properties
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Compila o projeto (pode ser Maven ou Gradle)
                    echo 'Building the application...'
                    // Se for Maven:
                    sh 'mvn clean install -DskipTests'
                    // Se for Gradle:
                    // sh './gradlew build -x test'
                }
            }
        }

        stage('Test') {
            environment {
                // Define o perfil de teste (H2)
                SPRING_PROFILES_ACTIVE = 'test'
            }
            steps {
                script {
                    // Executa os testes com o perfil "test", que usará H2 em memória
                    echo 'Running tests...'
                    // Se for Maven:
                    sh 'mvn test'
                    // Se for Gradle:
                    // sh './gradlew test'
                }
            }
        }

        stage('Deploy to Staging') {
            environment {
                // Define o perfil para o ambiente de staging (PostgreSQL)
                SPRING_PROFILES_ACTIVE = 'staging'
            }
            steps {
                script {
                    // Aqui você pode fazer o deploy em um ambiente de staging
                    echo 'Deploying to staging environment...'
                    // Se for Maven:
                    // sh 'mvn deploy -DskipTests'
                    // Se for Gradle:
                    // sh './gradlew deploy -x test'
                }
            }
        }

        stage('Deploy to Production') {
            environment {
                // Define o perfil para o ambiente de produção (PostgreSQL)
                SPRING_PROFILES_ACTIVE = 'prod'
            }
            steps {
                script {
                    // Aqui você pode fazer o deploy em produção
                    echo 'Deploying to production environment...'
                    // Se for Maven:
                    // sh 'mvn deploy -DskipTests'
                    // Se for Gradle:
                    // sh './gradlew deploy -x test'
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up resources...'
            // Limpeza após a execução do pipeline, se necessário
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
