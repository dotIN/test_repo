def call() {
    // now build, based on the configuration provided
    node {
            echo "Entering buildReports Global Lib"
            echo "junit '**/build/reports/*.xml'"
            // Compress and store reports
            // Sync logs
            echo "emailext attachmentsPattern: '**/cucumber-results-feature-overview.pdf', body: 'Attached report for ${BUILD_URL} [${JOB_NAME}] [${BUILD_NUMBER}]', subject: '${JOB_NAME} [${BUILD_NUMBER}]', to: 'test@email.com'" 
	    echo "${BUILD_URL}"
            echo "Entering buildReports Global Lib"
    }
}
