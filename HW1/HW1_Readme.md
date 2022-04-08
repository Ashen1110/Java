# 大數運算

* class name: HugeInteger
* 最多到 40 位數 (建 int array [40])
* 要求函式:
  + parse: 接收字串，可以利用 "charAt" 內建函式將每一位數取出並放入陣列中
  + toString: 將 integer 陣列轉成字串
  + add: 大數加法
  + subtract: 大數減法
  + 比較大小的函式，return true or false
    - isEqualTo: ==
    - isNotEqualTo: !=
    - isGreaterThan: >
    - isLessThan: <
    - isGreaterThanOrEqualTo: >=
    - isLessThanOrEqualTo: <=
  + isZero

* Bonus:
  + multiply: 大數乘法
  + divide: 大數除法
  + remainder: 大數取餘
  

# Tic-Tac-Toe

* class name: TicTacToe
* private enum A[3][3]; --> constants: X, O, EMPTY
* constructor: initialize array into EMPTY
* two people, first: X; second: O
* Bonus:
  + 跟電腦對戰
  + 讓玩家選擇要先還是後
  
* Bonus+Bonus:
  + 3D array A[4][4][4]
