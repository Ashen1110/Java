HW4 Readme

408410042 林靖紳

* 執行：
	1. 請在本目錄的 terminal 上打 make，執行 makefile 檔，此步驟將會編譯並執行程式碼
	2. 如果只想編譯程式碼，可以在 terminal 上打 make main
	3. 如果在確認程式碼編好的情況下，只想要跑執行檔，可以在 terminal 上打 make execute
	4. 將所有的 .class 檔放在 ./classes/ 目錄底下
	
* 程式描述：
	1. 多加了一個可以讓使用者自己定最大球數的互動，可以根據 terminal 上的提示訊息進行輸入
	2. 設計每點一下滑鼠，會根據滑鼠在框框中的位置生成一顆隨機顏色的球以隨機的方向奔跑

* 本程式提供 make clean 功能：
	1. 在本目錄的 terminal 上打 make clean，將會遞迴刪除 ./classes/ 的檔案
