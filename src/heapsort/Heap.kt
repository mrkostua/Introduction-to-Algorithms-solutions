package heapsort

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 3/28/2018
 */


class Heap<T : Comparable<T>>(data: ArrayList<T>) {
    /**
     * implementation of max-heapify alg with using loop iterations instead of recursive.
     */
    var heapSize: Int = data.size
    var resultArray = data

    fun heapSort(): ArrayList<T> {
        buildMaxHeap()
       /* for (i in resultArray.size - 1 downTo 1) {
            println("       LOG------------------------- heapSort loop index : " + i)
            changeElementIndexes(resultArray, 0, i)
            heapSize--
            effectiveMaxHeapify(resultArray, 0)
        }*/
        return resultArray
    }

    private fun buildMaxHeap() {
        println("   buildMaxHeap()")
        for (i in resultArray.size / 2 downTo 0) {
            println("       LOG------------------------- buildMaxHeap loop index : " + i)
            effectiveMaxHeapify(resultArray, i)

        }
    }


    private fun effectiveMaxHeapify(array: ArrayList<T>, subRoot: Int): ArrayList<T> {
        if (subRoot > heapSize - 1) {
            throw IndexOutOfBoundsException("There is no element in array under this index")

        }
        var leftLeaf: Int = getLeftLeaf(array, subRoot)
        var rightLeaf: Int = getRightLeaf(array, subRoot)
        var index = subRoot
        var indexOfLargestElement: Int
        var resultArray = array

        while (true) {
            indexOfLargestElement = if (leftLeaf <= heapSize && array[leftLeaf] > array[subRoot]) {
                leftLeaf
            } else {
                index
            }

            if (rightLeaf <= heapSize && array[rightLeaf] > array[indexOfLargestElement]) {
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
            print("resultArray : ")
            resultArray.forEach({ i -> print(i.toString() + " ") })
            println("\n")

        }

        return resultArray
    }

    /**
     * if it is max heapify and there is no left leaf for given root return -1 in case of min-heapify return max Integer value.
     */
    //TODO update getRightLeaf and getLeftLeaf fun's (problem with returning 0 in case if there no leaf for given root)
    private fun getLeftLeaf(array: ArrayList<T>, root: Int): Int =
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
    private fun getRightLeaf(array: ArrayList<T>, root: Int): Int =
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

    private fun changeElementIndexes(array: ArrayList<T>, firstIndex: Int, indexToChangeWith: Int): ArrayList<T> {
        val temporaryElement = array[firstIndex]
        array[firstIndex] = array[indexToChangeWith]
        array[indexToChangeWith] = temporaryElement
        return array
    }


    private fun generateStringWithSpaces(amountOfSpaces: Int, spaceLength: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until amountOfSpaces * spaceLength) {
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

    fun printHeap(elementLength: Int) {
        var jumpNumber = 0
        var jumpPower = 1.0
        var maxAmountOfSpaces = (Math.pow(2.0, (countHeapHeight(heapSize) - 1).toDouble())).toInt() * elementLength
        maxAmountOfSpaces += (maxAmountOfSpaces - 1)
        var leafAmountOfSpace = maxAmountOfSpaces
        var spaceIncrementer = 0

        var sElemnent: String
        for ((index, element) in resultArray.withIndex()) {
            sElemnent = if (element.toString().length < 2) element.toString() + " "
            else element.toString()
            if (index == 0) {
                //space after root element
                print(generateStringWithSpaces((maxAmountOfSpaces - elementLength) / 2, 1) + sElemnent)

            } else {
                print(generateStringWithSpaces(leafAmountOfSpace, 1) + sElemnent)

            }
            if (index == jumpNumber) {
                leafAmountOfSpace = (maxAmountOfSpaces - Math.pow(2.0, jumpPower - 1).toInt() * elementLength) / (jumpPower + 1).toInt()
                println()
                for (i in 0 until Math.pow(2.0, jumpPower - 1).toInt()) {
                    print(generateStringWithSpaces(leafAmountOfSpace, 1))
                    print("/\\")
                }
                println()
                jumpNumber += Math.pow(2.0, jumpPower).toInt()
                jumpPower++
                leafAmountOfSpace = (maxAmountOfSpaces - Math.pow(2.0, jumpPower - 1).toInt() * elementLength) / (jumpPower + 1).toInt()
                spaceIncrementer++
            }

        }
    }

}

fun main(args: Array<String>) {
    println("Initial data : \n")
    var array = ArrayList<Int>()
    for (i in 1..5) {
        array.add(i)

    }
    val heap = Heap(array)
    with(heap) {
        printHeap(2)
        println("\n heapSort algorithm : ")
        array = heapSort()
        printHeap(2)
        println("\n")
        array.forEach { print(" " + it) }
    }


}