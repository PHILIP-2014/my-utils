	
	//第一次（获取）：
		//假设：folder.size = 6 & doc.size = 6  
		//limit = 5;
		//因此第一次取出的全为 folder  totals = 5
		
	//第二次（加载）：
		//limit = 5
		//这时folder totals = 1 ; docLimit = 5-1 = 4 ; docStart = 0 ; docTotals = 4
		
	//第三次（加载）：
		//limit = 5
		//docLimit = 5-0 = 5 ; docStart = 10-6 = 4
		
		//start&limit 取出folderlist 计算:docStart:0,docLimit=0
		
