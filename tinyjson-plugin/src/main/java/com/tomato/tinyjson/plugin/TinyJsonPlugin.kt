package com.tomato.tinyjson.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class TinyJsonPlugin :  Plugin<Project> {

    override fun apply(project: Project) {

        println("project name is ${project.name}")
    }
}