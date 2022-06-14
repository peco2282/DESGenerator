# DES 生成

[![GitHub](https://img.shields.io/github/license/peco2282/DESGenerator)](https://github.com/peco2282/DESGenerator/blob/main/LICENSE)

64bitの平文、鍵を用いてDESを生成する。

[DESについて](https://atmarkit.itmedia.co.jp/ait/articles/0401/01/news076.html)

# 使い方

```shell
git clone https://github.com/peco2282/DESGenerator.git
```

1. Injellij-IDEA で `DESGenerator` フォルダを開く。
2. 右上の `実行環境の編集` を開く。 
![実行環境](https://gyazo.com/5d76ddda37e28089946384501f1bea0a.png)
3. プログラム引数に平文64bitと鍵64bitを入力。(例：0010010111.....  1000111100...)
4. `Main.kt` を開き、`fun main(args: Array<String>) {` の緑の▶印を押す。
![実行](https://gyazo.com/8e5d540b79cc13802780ad04cb562999.png)
5. 下の実行タブが開き、出力が行われる。
