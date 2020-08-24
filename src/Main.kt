package phonebook

import java.io.File

fun main() {


    val namesFileName = "C:\\Users\\Dima\\IdeaProjects\\find.txt"
    val phonesFileName = "C:\\Users\\Dima\\IdeaProjects\\directory.txt"
    val names = File(namesFileName).readLines()
    val phones = File(phonesFileName).readLines()
    println("Start searching...")
    val startTime = System.currentTimeMillis()
    var count = 0

    for (line in phones) {
        val data = line.split(' ')
        var fname = ""

        if (data.size == 2) {
            fname = data[1]
        } else {
            fname = "${data[1]} ${data[2]}"
        }

        for (name in names) {
            if (fname == name) {
                count++
                break
            }
        }
    }

    val stopTime = System.currentTimeMillis()
    val total = stopTime - startTime
    var sec = (total) / 1000
    val ms = total - sec * 1000
    val min = sec / 60
    sec -= min * 60
    println("Found $count / ${names.size} entries. Time taken: $min min. $sec sec. $ms ms.")
}