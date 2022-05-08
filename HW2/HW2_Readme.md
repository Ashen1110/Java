# Carbon Footprint Interface: Polymorphism

* 3 classes
	- class Building
	- class Car
	- class Bicycle

* 建一個 Intereface: CarbonFootprint 裡面要有 getCarbonFootprint() 函式
	
* getCarbonFootprint()
	- 自創函式
	- 目的： 為 class 計算出適當的碳足跡
	- 每一個 class 都要計算 （提示： @Override   感謝興民）
	
* Application: (我是直接寫在 main 裡了)
	- 為 3 個 classes 創造物件 (e.g. new Building())
	- 並將各自的 reference 放入 ArrayList<CarbonFootprint> 中
	- 計算並顯示各自計算後的碳足跡結果
	- 顯示一些提示文字
	
* 至於要如何計算碳足跡，要哪些變數之類的可以自己決定、自己查資料，自己設計 test 的部份之後輸出就行惹，這部份就沒有硬性規定了
