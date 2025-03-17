job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL')
    scm {
        git('https://github.com/GUILLEVIER/SIMPLE-NODE-APP.git', 'master') { node ->
            node / gitConfigName('guillevier')
            node / gitConfigEmail('guillermo.morales.e@usach.cl')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
    publishers {
	slackNotifier {
            notifyAborted(true)
            notifyEveryFailure(true)
            notifyNotBuilt(false)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage(null)
            sendAs(null)
            commitInfoChoice('NONE')
            teamDomain(null)
            authToken(null)
        }
    }
}
