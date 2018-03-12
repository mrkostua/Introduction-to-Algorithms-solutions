package addingBinaryNumbers

import java.util.*

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 2/24/2018
 */

class AddingBinaryNumbersAlgorithm(private var firstArray: Array<Boolean>, private var secondArray: Array<Boolean>) {
    private val resultArray = Array(firstArray.size + 1, { defaultValue -> 0 })
    private var additionalNumber = false
    private var aArray: Array<Int>
    private var bArray: Array<Int>

    init {
        checkInitialData()

        aArray = Array(firstArray.size, { defaultValue -> 0 })
        bArray = Array(secondArray.size, { defaultValue -> 0 })
        convertBooleanArrayToIntArray()
    }

    fun binaryAdd(): Array<Int> {
        for (bit in 0 until aArray.size) {
            println("iteration : " + bit)
            when {
                aArray[bit] + bArray[bit] == 2 -> positivePlusPositive(bit)
                aArray[bit] + bArray[bit] == 1 -> positivePlusNegative(bit)
                aArray[bit] + bArray[bit] == 0 -> negativePlusNegative(bit)
            }
        }
        setLastBit()
        println("setLastBit partial additionalNumber : " + additionalNumber)

        return resultArray
    }

    private fun positivePlusPositive(bit: Int) {
        println("positivePlusPositive")
        if (additionalNumber) {
            resultArray[bit] = 1
        } else {
            resultArray[bit] = 0
        }
        additionalNumber = true
        println("partial result array : " + Arrays.toString(resultArray))
        println("partial additionalNumber : " + additionalNumber)
    }

    private fun positivePlusNegative(bit: Int) {
        println("positivePlusNegative")
        if (additionalNumber) {
            resultArray[bit] = 0
            additionalNumber = true
        } else {
            resultArray[bit] = 1
            additionalNumber = false
        }
        println("partial result array : " + Arrays.toString(resultArray))
        println("partial additionalNumber : " + additionalNumber)
    }

    private fun negativePlusNegative(bit: Int) {
        println("negativePlusNegative")
        if (additionalNumber) {
            resultArray[bit] = 1
            additionalNumber = false
        } else {
            resultArray[bit] = 0
            additionalNumber = false
        }
        println("partial result array : " + Arrays.toString(resultArray))
        println("partial additionalNumber : " + additionalNumber)
    }

    private fun setLastBit() {
        if (additionalNumber) {
            resultArray[resultArray.size - 1] = 1
        } else {
            resultArray[resultArray.size - 1] = 0
        }
    }


    private fun checkInitialData() {
        if (firstArray.isEmpty() || secondArray.isEmpty()) {
            throw NotImplementedError("array can't be empty.")
        }
        checkIfSizeEqual(firstArray, secondArray)

    }

    private fun convertBooleanArrayToIntArray() {
        for (bit in 0 until firstArray.size) {
            if (firstArray[bit]) {
                aArray[bit] = 1
            } else {
                aArray[bit] = 0
            }
            if (secondArray[bit]) {
                bArray[bit] = 1
            } else {
                bArray[bit] = 0
            }
        }
    }

    private fun checkIfSizeEqual(a: Array<Boolean>, b: Array<Boolean>) {
        if (a.size > b.size) {
            secondArray = increaseSizeOfArray(b, a)
        } else if (b.size > a.size) {
            firstArray = increaseSizeOfArray(a, b)
        }
    }

    private fun increaseSizeOfArray(smallerArray: Array<Boolean>, biggerArray: Array<Boolean>): Array<Boolean> {
        val initialSmallerArraySize = smallerArray.size
        val resultArray = Arrays.copyOf(smallerArray, smallerArray.size + (biggerArray.size - smallerArray.size))
        for (bit in (initialSmallerArraySize - 1) until biggerArray.size) {
            resultArray[bit] = false

        }
        return resultArray
    }

}