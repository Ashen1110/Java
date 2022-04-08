# 大數運算

## 功能：
* class name: HugeInteger
* 無限制最多幾位數
* 可以接受正數或是負數的大數運算
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
        - 因為是四個位數一組，因此相加時要不要進位就要判斷相加之後的結果有沒有 > 9999
        - 如果有，就令 carry = a_digit+b_digit + carry_last - 10000
        - 如果有溢位，首先判斷是否為負數，如果首數是負數，做加法溢位就是 0；反之則 result.add(1)
        - 並自動增加 8 個 0 補位
        - 如果沒有溢位，那就判斷首數的正負，正數補 0； 負數補 9999
        - 其中當正數 + 負數時，會將後者轉為正數之後 return 兩正數想減 （因為保證 |s1| > |s2| 因此換成兩數相減不需要轉補數）
        
  + 減法:
    - 通式： a_digit - b_digit - borrow，其中 carry 表示為上一位相減的借位
    - 因為是四個數字一組，因此借位時一借就會是 10000 （borrow+=10000）
    - 如果有借位，先判斷首數的正負，如果首數是正數，借位就要補 0；如果首數是負數，借位就要補 9998
    - 並自動增加 8 個 9999 補位
    - 如果沒有借位，那就判斷首數的正負，正數補 0 ； 負數補 9999
    - 特別注意有沒有換過數字（如上述「輸入數字的處理」），如果有交換過數字的話，其結果應該要轉補數（負 --> 正；正 --> 負）
    - 其中當負數 - 正數時，將其首數轉成正數並紀錄 subtract_flag = 1 後，return 兩正數相加之後再轉補數
        
        
   
* 函式:
  + public HugeInteger(String num):
        - 大數的 Constructor 
  + private HugeInteger(List<Integer>bignum)
  + public HugeInteger addition(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public HugeInteger subtract(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + private static boolean abs_compare(String integer1, String integer2)
  + public String toString()
  + private static List<Integer> toComplement(List<Integer> num)
  + private static List<Integer> copy(List<Integer> num, int newLength)
  + public boolean isEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public boolean isNotEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public boolean isGreaterThan(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public boolean isLessThan(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public boolean isGreaterThanOrEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public boolean isLessThanOrEqualTo(HugeInteger that, boolean s2_abs_s1, boolean subtract_flag)
  + public static boolean isZero(List<Integer> list)
  + private static boolean isNegative(List<Integer> list)
  + private static boolean isPositive(List<Integer> list)
  
