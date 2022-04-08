# 大數運算

## 功能：
* class name: HugeInteger
* 無限制最多幾位數
* 方法描述：
  + 建立一個 HugeInteger constructor:
        - 將接收的字串切成每四個 digits 一組並放入 list<Integer> bignum
        - 將 bignum 用 0 補滿 8 的倍數格
        - e.g. Input: 1234567 ==> bignum = [4567, 123, 0, 0, 0, 0, 0, 0]
        - 負數特別處理成補數
        - e.g. Input: -1234567 ==> bignum = [5433, 9876, 9999, 9999, 9999, 9999, 9999, 9999]
        
   + 輸入數字的處理：
        - 假設輸入的數字是 s1, s2
        - 如果 |s1| < |s2|，就將兩者交換，並利用一個變數來紀錄有沒有交換數字 （這樣方便做減法 e.g. 9 - 10 ==> -(10-9)

   + 加法:
        - 通式： a_digit + b_digit + carry，其中 carry 表示為上一位相加的進位
        
   
* 函式:
  + parse: 接收字串
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
