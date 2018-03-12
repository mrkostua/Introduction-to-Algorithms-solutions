package addingBinaryNumbers

import java.util.*

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 2/24/2018
 */

fun main(args: Array<String>) {
    val aArray = arrayOf(true, true, true, true, true)
    val bArray = arrayOf(true, true, true, false)
    println("Initial data aArray : " + Arrays.toString(aArray))
    println("Initial data bArray : " + Arrays.toString(bArray))

    val resultArray = AddingBinaryNumbersAlgorithm(aArray, bArray).binaryAdd()

    println("\nRESULTS")
    println(Arrays.toString(resultArray))

}