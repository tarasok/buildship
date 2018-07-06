package Buildship.Check.BasicIntegrationTests.IntegrationTests_Linux.buildTypes

import Buildship.EclipseBuildTemplate
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.FailureAction

object IntegrationTests_Linux_Eclipse46Build : BuildType({
    templates(EclipseBuildTemplate)
    name = "Complete Build (Linux, Eclipse 4.6, Java 8)"
    description = "Basic integration testing of the plugin for Eclipse 4.6"

    params {
        param("eclipse.version", "46")
        param("compiler.location", "%linux.java8.oracle.64bit%/bin/javac")
        param("eclipse.test.java.home", "%linux.java8.oracle.64bit%")
        param("env.JAVA_HOME", "%linux.java8.oracle.64bit%")
    }

    dependencies {
        snapshot(Buildship.Check.Checkpoints.buildTypes.BasicTestCoverage) {
            onDependencyFailure = FailureAction.CANCEL
            onDependencyCancel = FailureAction.CANCEL
        }
    }

    requirements {
        contains("teamcity.agent.jvm.os.name", "Linux", "RQ_650")
        doesNotEqual("system.agent.name", "ubuntu6-agent1", "RQ_651")
    }
})
