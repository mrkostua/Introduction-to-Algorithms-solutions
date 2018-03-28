package heapsort

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 3/28/2018
 */

fun <T : Comparable<T>> heapSort(array: ArrayList<T>): ArrayList<T> {
    var resultArray = buildMaxHeap(array)
    heapSize = resultArray.size
    for (i in resultArray.size downTo 2) {
        resultArray = changeElementIndexes(resultArray, 0, i)
        heapSize--
        effectiveMaxHeapify(resultArray, 0)
    }
    return resultArray
    
}
//TODO here we need to control the size of the heap decrease it without deleting any element from the heap for this we need
// to create custom ArrayList or just one class with some @heapSize variable and move maxHeapify fun there so it also can use this variable during calculating


private fun <T : Comparable<T>> buildMaxHeap(array: ArrayList<T>): ArrayList<T> {
    TODO("implement this fun more info in book")
}

fun main(args: Array<String>) {

}