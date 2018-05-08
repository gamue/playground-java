#!/usr/bin/env groovy

node {
    deleteDir()

    try {
        stage ('Checkout') {
        	checkout scm
        }
        stage ('Build') {
        	withEnv(){
        		sh './gradlew clean build'
        	}
        		
        	currentBuild.result = 'SUCCESS'
        }
    } catch (e) {
        currentBuild.result = 'FAILED'
        throw e
    }
}
