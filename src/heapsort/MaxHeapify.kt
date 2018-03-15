package heapsort

import kotlin.collections.ArrayList

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 3/12/2018
 * Task 6.2-5
 */
//todo update what class T need to inherit
//todo update getRightLeaf and getLeftLeaf fun's (problem with returning 0 in case if there no leaf for given root)

/**
 * implementation of max-heapify alg with using loop iterations instead of recursive.
 */
fun <T : Int> effectiveMaxHeapify(array: ArrayList<T>, subRoot: Int): ArrayList<T> {
    var leftLeaf: Int = getLeftLeaf(array, subRoot)
    var rightLeaf: Int = getRightLeaf(array, subRoot)
    var index = subRoot
    var indexOfLargestElement: Int
    var resultArray = array

    while (true) {
        indexOfLargestElement = if (leftLeaf <= array.size && array[leftLeaf] > array[subRoot]) {
            leftLeaf
        } else {
            index
        }

        if (rightLeaf <= array.size && array[rightLeaf] > array[indexOfLargestElement]) {
            indexOfLargestElement = rightLeaf

        }
        println("index : " + index)
        println("index of large element : " + indexOfLargestElement)
        println("right leaf : " + rightLeaf)
        println("left leaf : " + leftLeaf)

        if (index != indexOfLargestElement) {
            resultArray = changeElementIndexes(array, index, indexOfLargestElement)
            index = indexOfLargestElement
            leftLeaf = getLeftLeaf(array, index)
            rightLeaf = getRightLeaf(array, index)

            println("after moving index of large element : " + indexOfLargestElement)
            println("after moving right leaf : " + rightLeaf)
            println("after moving left leaf : " + leftLeaf)
        } else {
            break

        }
        println("resultArray : forEach : " + resultArray.forEach({ i -> print(i.toString() + " ") }))

    }

    return resultArray
}

/**
 * if it is max heapify and there is no left leaf for given root return -1 in case of min-heapify return max Integer value.
 */
private fun <T> getLeftLeaf(array: ArrayList<T>, root: Int): Int =
        if (array.lastIndex <= root) {
            Int.MAX_VALUE
        } else {
            val leftLeafIndex = root * 2 + 1
            if (array.lastIndex >= leftLeafIndex) {
                leftLeafIndex
            } else {
                Int.MAX_VALUE

            }

        }

/**
 * if it is max heapify and there is no right leaf for given root return 0 in case of min-heapify return max Integer value.
 */
private fun <T> getRightLeaf(array: ArrayList<T>, root: Int): Int =
        if (array.lastIndex <= root) {
            Int.MAX_VALUE

        } else {
            val leftLeafIndex = root * 2 + 2
            if (array.lastIndex >= leftLeafIndex) {
                leftLeafIndex
            } else {
                Int.MAX_VALUE

            }

        }

private fun <T> changeElementIndexes(array: ArrayList<T>, firstIndex: Int, indexToChangeWith: Int): ArrayList<T> {
    val temporaryElement = array[firstIndex]
    array[firstIndex] = array[indexToChangeWith]
    array[indexToChangeWith] = temporaryElement
    return array
}


private fun <T> printHeap(heapArray: ArrayList<T>) {
    var jumpNumber = 0
    var jumpPower = 1.0
    var amountOfSpaces = (Math.pow(2.0, (countHeapHeight(heapArray.size) - 1).toDouble()) / 2).toInt()
    var spaceIncrementer = 0
    for ((index, element) in heapArray.withIndex()) {
        if (index == 0) {
            //space after root element
            print(generateStringWithSpaces(amountOfSpaces, 5) + element.toString() + "(" + index + ")" + generateStringWithSpaces(amountOfSpaces, 5))

        } else {
            print(generateStringWithSpaces(amountOfSpaces, 1) + element.toString() + "(" + index + ")" + generateStringWithSpaces(amountOfSpaces, 1))

        }

        if (index == jumpNumber) {
            println("\n\n")
            jumpNumber = (jumpNumber + Math.pow(2.0, jumpPower)).toInt()
            jumpPower++
            amountOfSpaces--
            // print(generateStringWithSpaces(amountOfSpaces, 5))
            spaceIncrementer++
        }

    }
}

private fun generateStringWithSpaces(amountOfSpaces: Int, spaceLegth: Int): String {

    val stringBuilder = StringBuilder()
    for (i in 0 until amountOfSpaces * spaceLegth) {
        stringBuilder.append(" ")
    }
    return stringBuilder.toString()
}

private fun countHeapHeight(heapSize: Int): Int {
    if (heapSize < 1) {
        return 0

    }
    var power = 1.0
    while (true) {
        if (heapSize.toDouble() > Math.pow(2.0, power)) {
            power++

        } else {
            return power.toInt()

        }
    }

}

fun main(args: Array<String>) {
    var heapArray = arrayListOf(16, 4, 10, 14, 7, 9, 3, 2, 8, 1)
    println("initial Heap : \n")
    printHeap(heapArray)
    println("\n\n after using max-Heapify() : \n")
    printHeap(effectiveMaxHeapify(heapArray, 1))

}