package homework_5

fun main(args: Array<String>) {
    println(square(3, 3))
}

fun square(num: Int, degree: Int): Int {
    return if (degree > 1) square(num * num, degree - 1)
    else num
}