def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
            echo "Entering runTests Global Lib"
            // @args : service and trype of test --tags @Basic for smoke and only service tag for full test
            sh "echo starting test for ${config.api} ${config.test_type} "
            echo "Entering buildReports Global Lib"
    }
}
