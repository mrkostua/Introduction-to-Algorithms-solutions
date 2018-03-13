package Heapsort

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 3/12/2018
 * Task 6.2-5
 */

//todo update what class T need to inherit
/**
 * implementation of max-heapify alg with using loop iterations instead of recursive.
 */
fun <T : Int> efectifyMaxHeapify(array: ArrayList<T>, subRoot: Int): ArrayList<T> {
    var leftLeaf: Int = getLeftLeaf(array, subRoot)
    var rightLeaf: Int = getRightLeaf(array, subRoot)
    var index = subRoot
    var indexOfLargestElement: Int
    var resultArray = array
    while (true) {
        indexOfLargestElement = if (leftLeaf <= array.size && array[leftLeaf] > array[subRoot]) {
            leftLeaf

        } else {
            subRoot

        }
        if (rightLeaf <= array.size && array[rightLeaf] > array[indexOfLargestElement]) {
            indexOfLargestElement = rightLeaf

        }
        if (index != indexOfLargestElement) {
            resultArray = changeElementIndexes(array, index, indexOfLargestElement)
            index = indexOfLargestElement
            leftLeaf = getLeftLeaf(array, index)
            rightLeaf = getRightLeaf(array, index)
        } else {
            break

        }
    }

    return resultArray
}

private fun <T> getLeftLeaf(array: ArrayList<T>, root: Int): Int {
    TODO("implement this method")
}

private fun <T> getRightLeaf(array: ArrayList<T>, root: Int): Int {
    TODO("implement this method")
}

private fun <T> changeElementIndexes(array: ArrayList<T>, firstIndex: Int, indexToChangeWith: Int): ArrayList<T> {
    val temporaryElement = array[firstIndex]
    array[firstIndex] = array[indexToChangeWith]
    array[indexToChangeWith] = temporaryElement
    return array
}


fun main(args: Array<String>) {
    val heapArray = arrayListOf(16, 4, 10, 14, 7, 9, 3, 2, 8, 1)
    var power = 0.0

    for (element in heapArray) {
        /*    println("power is : " + power)
            println("math.pow(2,power) : " + Math.pow(2.0, power))*/

        if (heapArray.indexOf(element) != 0) {
            print("     " + element.toString() + "(" + heapArray.indexOf(element) + ")      ")

            if (heapArray.indexOf(element) == Math.pow(2.0, power).toInt()) {
                println("\n\n")

            }
            if (heapArray.indexOf(element) + 1 > Math.pow(2.0, power).toInt()) {
                power++
            }


        } else {
            print("     " + element.toString() + "(" + heapArray.indexOf(element) + ")      ")
            println("\n\n")
            power++
        }
    }


}