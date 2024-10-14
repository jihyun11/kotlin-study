package org.example

import java.io.FileWriter

fun main() {
    FileWriter("text").use {
        it.write("Hello, World!")
    }
}