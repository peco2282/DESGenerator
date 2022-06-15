# DES 生成

[![GitHub](https://img.shields.io/github/license/peco2282/DESGenerator)](https://github.com/peco2282/DESGenerator/blob/main/LICENSE)

64bitの平文、鍵を用いてDESを生成する。

また、暗号化された文と鍵を用いて復号する。

[DESについて](https://atmarkit.itmedia.co.jp/ait/articles/0401/01/news076.html)

# 使い方

```shell
$ git clone https://github.com/peco2282/DESGenerator.git
```
### コマンドプロンプトで動かす

1. kotlinをインストール、pathを通す。[参考](https://shotanukumizu-1000.hatenablog.com/entry/20210909)

暗号化する場合：

:warning: 復号のjarファイルを作る場合、.jarファイルの名前を変えることを推奨します。

2. コマンドプロンプトで `DESGenerator` フォルダに行き、`kotlinc -d DESGenerator.jar -include-runtime src/main/kotlin/Encode.kt` を実行
3. `kotlin -cp DESGenerator.jar EncodeKt 平文(64bit)  鍵(64bit)`
   (例: `kotlin -cp DESGenerator.jar EncodeKt 00111010....(64bit-Plain)  1010010111....(64bit-Key)`)
4.  16段目, 平文暗号が最後に出力されれば成功。

復号する場合：

:warning: 暗号化jarファイルを作る場合、.jarファイルの名前を変えることを推奨します。

2. コマンドプロンプトで `DESGenerator` フォルダに行き、`kotlinc -d DESGenerator.jar -include-runtime src/main/kotlin/Decode.kt` を実行
3. `kotlin -cp DESDenerator.jar DecodeKt 平文(64bit)　鍵(64bit)`
   (例: `kotlin -cp DESGenerator.jar DecodeKt 11101001....(64bit-Compiled)  1010010111....(64bit-Key) `)
4.  16段目, 復号された平文が最後に出力されれば成功。

 16段目, 平文暗号が最後に出力されれば成功。

両方を1つのjarに圧縮する場合。

2. コマンドプロンプトで `DESGenerator` フォルダに行き、`kotlinc -d DESGenerator.jar -include-runtime src/main/kotlin/Encode.kt src/main/kotlin/Decode.kt` を実行
3. `kotlin -cp DESGenerator.jar (EncodeKt 又は DecodeKt) 00110011....(平文または暗号化文-64bit) 11001100....(鍵-64bit)`

ターミナルではなくてファイルとして出力したい場合

`kotlin -cp DESGenerator.jar EncodeKt 平文(64bit)  鍵(64bit) >> encode.txt`

---
### Intellij側から動かす。

1. Injellij-IDEA で `DESGenerator` フォルダを開く。
2. 右上の `実行環境の編集` を開く。 
![実行環境](https://gyazo.com/5d76ddda37e28089946384501f1bea0a.png)
3. プログラム引数に平文64bitと鍵64bitを入力。(例：0010010111.....  1000111100...)
4. `Encode.kt` または `Decode.kt` を開き、`fun main(args: Array<String>) {` の緑の▶印を押す。
![実行](https://gyazo.com/8e5d540b79cc13802780ad04cb562999.png)
5. 下の実行タブが開き、出力が行われる。
