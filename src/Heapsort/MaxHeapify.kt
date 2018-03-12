package Heapsort

import kotlin.test.todo

/**
 * @author Kostiantyn Prysiazhnyi
 * @created on 3/12/2018
 * Task 6.2-5
 */

//todo update what class T need to inherit
/**
 * implementation of max-heapify alg with using loop iterations instead of recursive.
 */
fun <T : Int> efectifyMaxHeapify(data: ArrayList<T>, index: Int): ArrayList<T> {
    var leftLeaf = getLeftLeaf(data, index)
    var rightLeaf = getRightLeaf(data, index)
    TODO(" book max-heapify works correctly becasuse recursively fun sends index of largest leaf!!!! not after replacing root with largest and getting index from largest")
}

private fun <T> getLeftLeaf(data: ArrayList<T>, root: Int): Int {
    TODO("implement this method")
}

private fun <T> getRightLeaf(data: ArrayList<T>, root: Int): Int {
    TODO("implement this method")
}


fun main(args: Array<String>) {

}