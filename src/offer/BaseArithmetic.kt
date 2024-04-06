package offer

/**
 * 一些基本算法，比如二分查找、排序等
 */

fun main() {
    val a = intArrayOf(4, 5, 3, 0, 1, 7, 2)
    println("origin array: " + a.contentToString())
    val a1 = a.copyOf()
    bubbleSort(a1)
    println("search 4, index=" + binarySearch(a1, 4))
    insertSort(a.copyOf())
    chooseSort(a.copyOf())
    mergeSort(a.copyOf())
    quickSort(a.copyOf())
    heapSort(a.copyOf(), true)
    heapSort(a.copyOf(), false)

}

/**
 * 排序数组 二分查找
 */
fun binarySearch(a: IntArray?, key: Int): Int {
    if (a == null) {
        return -1
    }
    var low = 0
    var high = a.size
    while (low <= high) {
        val mid = (low + high) shr 1
        if (a[mid] == key) {
            return mid
        } else if (a[mid] > key) {
            high = mid - 1
        } else if (a[mid] < key) {
            low = mid + 1
        }
    }
    return -1
}

/**
 * O(n^2)
 * 冒泡排序
 */
fun bubbleSort(a: IntArray?) {
    if (a == null || a.isEmpty()) {
        return
    }
    var temp = -1
    for (i in a.indices) {
        for (j in i + 1 until a.size) {
            if (a[j] <= a[i]) {
                temp = a[i]
                a[i] = a[j]
                a[j] = temp
            }
        }
    }
    println("bubbleSort: " + a.contentToString())
}

/**
 * O(n)
 * 插入排序
 */
fun insertSort(a: IntArray?) {
    if (a == null || a.isEmpty()) {
        return
    }
    var temp = -1
    var i = 1
    var j = 0
    while (i < a.size) {
        temp = a[i]
        j = i - 1
        while (j >= 0 && a[j] > temp) {
            a[j + 1] = a[j]
            j--
        }
        i++
        a[j + 1] = temp
    }
    println("insertSort: " + a.contentToString())
}

/**
 * O(n)
 * 选择排序
 */
fun chooseSort(a: IntArray?) {
    if (a == null || a.isEmpty()) {
        return
    }
    var temp = -1
    var minIndex = 0
    for (i in a.indices) {
        minIndex = i
        for (j in i + 1 until a.size) {
            if (a[minIndex] > a[j]) {
                minIndex = j
            }
        }
        temp = a[i]
        a[i] = a[minIndex]
        a[minIndex] = temp
    }
    println("chooseSort: " + a.contentToString())
}

/**
 * 合并排序
 */
fun mergeSort(a: IntArray?) {
    if (a == null || a.isEmpty()) {
        return
    }
    mergeSort(a, 0, a.size - 1)
    println("mergeSort: " + a.contentToString())
}

fun mergeSort(a: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val mid = start + ((end - start) shr 1)
    mergeSort(a, start, mid)
    mergeSort(a, mid + 1, end)
    mergeArray(a, start, mid, end)
}

fun mergeArray(a: IntArray, start: Int, mid: Int, end: Int) {
    val len1 = mid - start + 1
    val len2 = end - mid
    val temp1 = IntArray(len1 + 1)
    val temp2 = IntArray(len2 + 1)
    for (i in 0 until len1) {
        temp1[i] = a[start + i]
    }
    for (i in 0 until len2) {
        temp2[i] = a[mid + 1 + i]
    }

    var i = 0
    var j = 0
    temp1[len1] = Int.MAX_VALUE
    temp2[len2] = Int.MAX_VALUE
    for (k in start..end) {
        if (temp1[i] <= temp2[j]) {
            a[k] = temp1[i]
            i++
        } else {
            a[k] = temp2[j]
            j++
        }
    }
}

/**
 * O(log n)
 * 快排
 */
fun quickSort(a: IntArray?) {
    if (a == null || a.isEmpty()) {
        return
    }
    quickSort(a, random(0, a.size - 1), 0, a.size - 1)
    println("quickSort: " + a.contentToString())
}

fun quickSort(a: IntArray, randIndex: Int, low: Int, high: Int) {
    if (low >= high) {
        return
    }
    var lowIndex = low
    var highIndex = high
    val temp = a[randIndex]
    a[randIndex] = a[lowIndex]
    while (lowIndex < highIndex) {
        while (lowIndex < highIndex && a[highIndex] > temp) {
            highIndex--
        }
        if (lowIndex < highIndex) {
            a[lowIndex] = a[highIndex]
        }
        while (lowIndex < highIndex && a[lowIndex] < temp) {
            lowIndex++
        }
        if (lowIndex < highIndex) {
            a[highIndex] = a[lowIndex]
        }
    }
    a[lowIndex] = temp
    quickSort(a, random(low, lowIndex - 1), low, lowIndex - 1)
    quickSort(a, random(lowIndex + 1, high), lowIndex + 1, high)
}

fun random(low: Int, high: Int): Int = (low + Math.random() * (high - low + 1)).toInt()

/**
 * 堆排序
 */
fun heapSort(a: IntArray?, useMax: Boolean = true) {
    if (a == null || a.isEmpty()) {
        return
    }
    // 将数组看为一棵完全二叉树，依次就对应着数组
    // 构建最大heap，从数组中点也就是堆的中间开始调整，这样可以使该结点的孩子的下标是在最后
    val maxIndex = a.size - 1
    for (i in a.size / 2 - 1 downTo 0) {
        if (useMax) {
            maxHeapAdjust(a, i, maxIndex)
        } else {
            minHeapAdjust(a, i, maxIndex)
        }
        // println(a.contentToString())
    }
    // 经过调整后，最大值始终是根结点，也就是第一个位置
    var temp = -1
    for (i in maxIndex downTo 1) {
        temp = a[0]
        a[0] = a[i]
        a[i] = temp
        if (useMax) {
            // 最大堆 升序
            maxHeapAdjust(a, 0, i - 1)
        } else {
            // 最小堆降序
            minHeapAdjust(a, 0, i - 1)
        }
    }
    if (!useMax) {
        for (i in 0..maxIndex / 2) {
            temp = a[i]
            a[i] = a[maxIndex - i]
            a[maxIndex - i] = temp
        }
    }
    println("useMax=$useMax heapSort: " + a.contentToString())
}

fun maxHeapAdjust(a: IntArray, rootIndex: Int, maxIndex: Int) {
    val parent = a[rootIndex]
    // 左孩子的下标是2*p+1，右孩子下标2*p+2
    var lChild = 2 * rootIndex + 1
    var parentIndex = rootIndex
    while (lChild <= maxIndex) {
        // 如果左孩子小于右孩子
        if (lChild < maxIndex && a[lChild] < a[lChild + 1]) {
            // 变成右孩子下标
            lChild++
        }
        // 如果父结点本身大于孩子结点，就不用调整 此时的lChild可能是左孩子可能是右孩子
        if (parent > a[lChild]) {
            break
        }
        // 父结点跟最大的孩子结点交换
        a[parentIndex] = a[lChild]
        // 转为之前最大孩子结点，遍历它的子树进行调整
        parentIndex = lChild
        lChild = 2 * lChild + 1
    }
    a[parentIndex] = parent
}

fun minHeapAdjust(a: IntArray, rootIndex: Int, maxIndex: Int) {
    val parent = a[rootIndex]
    // 左孩子的下标是2*p+1，右孩子下标2*p+2
    var lChild = 2 * rootIndex + 1
    var parentIndex = rootIndex
    while (lChild <= maxIndex) {
        // 如果左孩子小于右孩子
        if (lChild < maxIndex && a[lChild] > a[lChild + 1]) {
            // 变成右孩子下标
            lChild++
        }
        // 如果父结点本身大于孩子结点，就不用调整 此时的lChild可能是左孩子可能是右孩子
        if (parent < a[lChild]) {
            break
        }
        // 父结点跟最大的孩子结点交换
        a[parentIndex] = a[lChild]
        // 转为之前最大孩子结点，遍历它的子树进行调整
        parentIndex = lChild;
        lChild = 2 * lChild + 1
    }
    a[parentIndex] = parent
}