def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        junit '**/build/reports/*.xml'
            step([$class: 'CucumberReportPublisher', failedFeaturesNumber: 0, failedScenariosNumber: 0, failedStepsNumber: 0, fileExcludePattern: '', fileIncludePattern: '**/testresult.json', jsonReportDirectory: '', pendingStepsNumber: 0, skippedStepsNumber: 0, undefinedStepsNumber: 0])
            //step([$class: 'InfluxDbPublisher',customData: null,customDataMap: null,customPrefix: null,target: 'dpp reporting'])
            // Compress and store reports
            // Sync logs
            emailext attachmentsPattern: '**/cucumber-results-feature-overview.pdf', body: "Attached report for ${BUILD_URL} [${JOB_NAME}] [${BUILD_NUMBER}]", subject: "Job '${JOB_NAME} [${BUILD_NUMBER}]'", to: 'test@email.com' 
    }
}
