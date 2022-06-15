fun main(args: Array<String>) {
  if (args.size < 2) return println("Missing items")
  val compiled = args[0]
  val key = args[1]
  if (compiled.length != 64 || key.length != 64) return println("you must put 64bit plain and key.")
  
  var pc1List = arrayOf<String>()
  var transPlain = ""
  initArray.forEach {
    transPlain += compiled[it - 1]
  }
  println(transPlain)
  
  
}