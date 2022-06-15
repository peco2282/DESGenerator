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
    val f = functionF(transKeep[1], pc2, false)
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