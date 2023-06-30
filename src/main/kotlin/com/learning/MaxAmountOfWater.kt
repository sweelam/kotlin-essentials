package com.learning

/**
 *  [1,8,6,2,5,4,8,3,7]
 *  i = 1 ... n
 *  p1(2,8) , p2(9,7)
 *
 *  width = idx2 - idx1 = 9 - 2 = 7
 *  height = min (y1,y2) = min (8,7) = 7
 *  area = width * height = 7 * 7 = 49
 *
 *  first max height , second max height : max(width)
 *
 *  p1(1,1) , p2(9,7)
 *  area = 8 * 1 = 48
 */

fun main() {
    println("result is ${maxArea(arrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7).toIntArray())}")
    println("result is ${maxArea(arrayOf(1, 2, 1).toIntArray())}")
    println("result is ${maxArea(arrayOf(2, 3, 4, 5, 18, 17, 6).toIntArray())}")
}

fun maxArea(height: IntArray): Int {
    var area = 0

    /** O(N^2) solution
    for (idx1 in 0..height.size-1) {
    for (idx2 in 0..height.size-1) {
    val width = (idx2+1) - (idx1+1)
    val heigth = min(height[idx1],height[idx2])
    area = max(area, width * heigth)
    }
    }
     **/
    var leftIdx = 0;
    var rightIdx = height.size - 1
    while (leftIdx != rightIdx) {
        area = Math.max(area, (rightIdx - leftIdx) * Math.min(height[rightIdx], height[leftIdx]))
        if (height[leftIdx] < height[rightIdx]) leftIdx++ else rightIdx--
    }


    return area;
}

// O(N^2) solution
fun maxAreaSlow(height: IntArray): Int {
    var area = 0

    for (idx1 in 0..height.size - 1) {
        for (idx2 in 0..height.size - 1) {
            val width = (idx2 + 1) - (idx1 + 1)
            val heigth = Math.min(height[idx1], height[idx2])
            area = Math.max(area, width * heigth)
        }
    }

    return area;
}









