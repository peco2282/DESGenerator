//fun main(args: Array<String>) {
//  println("Hello World!")
//
//  // Try adding program arguments via Run/Debug configuration.
//  // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//  println("Program arguments: ${args.joinToString()}")
//}

/**
 * an array for creating PC-1
 *
 * 56bit
 */
private val pc1Array: Array<Int> = arrayOf(
  57, 49, 41, 33, 25, 17,  9,
  1, 58, 50, 42, 34, 26, 18,
  10,  2, 59, 51, 43, 35, 27,
  19, 11,  3, 60, 52, 44, 36,
  63, 55, 47, 39, 31, 23, 15,
  7, 62, 54, 46, 38, 30, 22,
  14,  6, 61, 53, 45, 37, 29,
  21, 13,  5, 28, 20, 12,  4
) // 56bit

/**
 * an array for create PC-2
 *
 * 48bit
 */
private val pc2Array: Array<Int> = arrayOf(
  14, 17, 11, 24,  1,  5,
  3, 28, 15,  6, 21, 10,
  23, 19, 12,  4, 26,  8,
  16,  7, 27, 20, 13,  2,
  41, 52, 31, 37, 47, 55,
  30, 40, 51, 45, 33, 48,
  44, 49, 39, 56, 34, 53,
  46, 42, 50, 36, 29, 32
) // 48bit

/**
 * an array for initial translation.
 *
 * 64bit
 */
private val initArray: Array<Int> = arrayOf(
  58, 50, 42, 34, 26, 18, 10, 2,
  60, 52, 44, 36, 28, 20, 12, 4,
  62, 54, 46, 38, 30, 22, 14, 6,
  64, 56, 48, 40, 32, 24, 16, 8,
  57, 49, 41, 33, 25, 17,  9, 1,
  59, 51, 43, 35, 27, 19, 11, 3,
  61, 53, 45, 37, 29, 21, 13, 5,
  63, 55, 47, 39, 31, 23, 15, 7
)

/**
 * an array for extention translate.
 *
 * 48bit
 */
private val transExtArray: Array<Int> = arrayOf(
  32,  1,  2,  3,  4,  5,
  4,  5,  6,  7,  8,  9,
  8,  9, 10, 11, 12, 13,
  12, 13, 14, 15, 16, 17,
  16, 17, 18, 19, 20, 21,
  20, 21, 22, 23, 24, 25,
  24, 25, 26, 27, 28, 29,
  28, 29, 30, 31, 32,  1
) // 48bit


/**
 * arrays for SBOX translation.
 *
 * 64bit * 8
 */
private val sBoxArray: Array<Array<Int>> = arrayOf(
  arrayOf(
    14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7,
    0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8,
    4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0,
    15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13
  ),
  arrayOf(
    15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10,
    3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5,
    0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15,
    13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9
  ),
  arrayOf(
    10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8,
    13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1,
    13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7,
    1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12
  ),
  arrayOf(
    7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15,
    13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9,
    10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4,
    3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14
  ),
  arrayOf(
    2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9,
    14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6,
    4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14,
    11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3
  ),
  arrayOf(
    12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11,
    10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8,
    9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6,
    4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13
  ),
  arrayOf(
    4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1,
    13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6,
    1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2,
    6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12
  ),
  arrayOf(
    13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7,
    1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2,
    7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8,
    2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11
  )
)

/**
 * an array for translate table after SBOX.
 *
 * 32bit
 */
private val pArray: Array<Int> = arrayOf(
  16,  7, 20, 21,
  29, 12, 28, 17,
  1, 15, 23, 26,
  5, 18, 31, 10,
  2,  8, 24, 14,
  32, 27,  3,  9,
  19, 13, 30,  6,
  22, 11,  4, 25
)
private val finalArray: Array<Int> = arrayOf(
  40, 8, 48, 16, 56, 24, 64, 32,
  39, 7, 47, 15, 55, 23, 63, 31,
  38, 6, 46, 14, 54, 22, 62, 30,
  37, 5, 45, 13, 53, 21, 61, 29,
  36, 4, 44, 12, 52, 20, 60, 28,
  35, 3, 43, 11, 51, 19, 59, 27,
  34, 2, 42, 10, 50, 18, 58, 26,
  33, 1, 41,  9, 49, 17, 57, 25
)

/**
 * a list for key shifting the key value.
 */
private val shiftList: List<Int> = listOf(
  1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
)

fun main(args: Array<String>) {
  if (args.size < 2) return println("Missing items")
  val compiled = args[0] // 暗号
  val key = args[1] // 鍵
  if (compiled.length != 64 || key.length != 64) return println("you must put 64bit plain and key.")
  
  println("compiled: $compiled")
  println("key     : $key")
  println()
  var pc2ShiftedList = arrayOf<String>() // 拡大鍵リスト
  var pc1ShiftedList = arrayOf<String>() // 左シフトリスト
  var pc1 = ""
  pc1Array.forEach {
    pc1 += key[it - 1]
  }
  
  var transPlain = ""
  initArray.forEach {
    transPlain += compiled[it - 1]
  }
  val initTrans = transPlain.chunked(32)
  println("初期転置: $transPlain")
  println()
  var tmp = 0
  var pc1Keep = ""
  var pc1After: String
  var transKeep: List<String>
  var leftAns: String
  var ans = ""
  
  shiftList.forEach { // PC1の左シフト
    pc1After = if (tmp == 0) {
      pc1Mover(pc1, it)
    } else {
      pc1Mover(pc1Keep, it)
    }
    val pc2 = pc2Maker(pc1After)
    pc1ShiftedList += pc1After
    pc2ShiftedList += pc2
    tmp++
    pc1Keep = pc1After
//    println("左シフト: $pc1Keep")
//    println("拡大鍵　: $pc2")
  }
  println()
  transKeep = initTrans
  for (i in 0 ..  15) {
    println((i + 1).toString() + " 段目")
    pc1 = pc1ShiftedList[i]
    val pc2 = pc2ShiftedList[15 - i]
    println("左シフト鍵: $pc1")
    println("使用拡大鍵: $pc2")
    val f = functionF(transKeep[1], pc2)
    leftAns  = xOr(transKeep[0], f)
    transKeep = listOf(transKeep[1], leftAns)
    println("暗号文左側: $leftAns")
    val r = transKeep[0]
    println("暗号文右側: $r")
    ans = leftAns + transKeep[0]
    println()
  }
  var finally = ""
  finalArray.forEach {
    finally += ans[it - 1]
  }
  println("\n")
  println("復号化平文: $finally")
}



/**
 * the function for create pc2.
 *
 * 56bit -> 48bit
 *
 * @param pc1After raw string value for create pc2.
 */
private fun pc2Maker(pc1After: String): String {
  var pc2 = ""
  pc2Array.forEach {
    pc2 += pc1After[it - 1]
  }
  return pc2
}


/**
 * the function for shift pc1.
 *
 * 56bit + shiftValue -> 56bit
 *
 * @param param the value of translate.
 * @param shift the value for shift key.
 */
private fun pc1Mover(param: String, shift: Int): String {
  var pc1Shifted = ""
  param.chunked(28).forEach {
    pc1Shifted += (it.takeLast(28 - shift) + it.take(shift))
  }
  return pc1Shifted
}


/**
 * the function F.
 *
 * 32bit + 48bit -> 32bit
 *
 * @param initRight 32bit, right value of initPlain Translated.
 * @param pc2 48bit, the value translated pc2.
 */
private fun functionF(initRight: String ,pc2: String): String { // 32bit, 48bit
  var transExt = "" // 拡大転置
  
  transExtArray.forEach {
    transExt += initRight[it - 1]
  }
  
  
  val rightList = transExt.chunked(6)
  val pc2List = pc2.chunked(6)
  
  var checkBox = ""
  for (i in 0..7) checkBox += sBox(xOr(rightList[i], pc2List[i]), i)
  
  var fin = ""
  pArray.forEach {
    fin += checkBox[it - 1]
  }
  return fin
}


/**
 * the function for SBOX.
 *
 * 6bit + (arrayPos) -> 4bit
 *
 * @param value 6bit, raw value for check SBOX.
 * @param pos position of sBoxArray.
 */
private fun sBox(value: String, pos: Int): String {
  val h = (value.take(1) + value.takeLast(1)).toInt(2)
  val w = (value.substring(1 until 5)).toInt(2)
  var ans = sBoxArray[pos][h * 16 + w].toString(2)
  
  when (ans.length) {
    1 -> {
      ans = "000$ans"
    }
    2 -> {
      ans = "00$ans"
    }
    3 -> {
      ans = "0$ans"
    }
  }
  return ans
}


/**
 * the function of check 2 param XOR.
 *
 * @param x check xor with y
 * @param y check xor with x
 */
private fun xOr(x: String, y: String): String {
  if (x.length != y.length) return "-1"
  var xor = ""
  val time = (x.length - 1)
  for (i in 0..time) {
    xor += if (x[i] == y[i]) {
      "0"
    } else {
      "1"
    }
  }
  return xor
}

