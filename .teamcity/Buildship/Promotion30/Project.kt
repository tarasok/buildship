package Buildship.Promotion30

import Buildship.Promotion30.buildTypes.Milestone
import Buildship.Promotion30.buildTypes.Release
import Buildship.Promotion30.buildTypes.Snapshot
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Promotion30")
    name = "Promotion30"
    description = "Promotes Buildship releases"

    template(Promotion30Template)

    buildType(Snapshot)
    buildType(Release)
    buildType(Milestone)

    buildTypesOrder = arrayListOf(Release, Milestone, Snapshot)
})