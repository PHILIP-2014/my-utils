	/*
	//取如teamName维度的组
	public Map<String, List<PanDocument>> queryAllByType(PanFolderCond cond) {
		cond.setSort("gmt_created");
		String[] teamName = {"today","yesterday","inWeek","weekAgo","inMonth","monthAgo"};
		Date today = new Date();
		List<PanDocument> panDocs = panDocumentDao.queryAllByType(cond);
		Map<String, List<PanDocument>> result = Maps.newHashMap();
		for(PanDocument panDoc : panDocs){
			Long createTime = panDoc.getGmtCreated().getTime();
			if(DateUtil.isToday(DateUtil.date2secondInt(panDoc.getGmtCreated()))){
				buildGroup(result, teamName[0], panDoc);
			}
			else if(DateUtil.isTheSameDay(DateUtil.getDateAfterDay(today, -1).getTime(), createTime)){
				buildGroup(result, teamName[1], panDoc);
			}
			else if(createTime >= DateUtil.getDateAfterDay(today, -7).getTime()
					&& createTime < DateUtil.getDateAfterDay(today, -2).getTime()){
				buildGroup(result, teamName[2], panDoc);
			}
			else if(createTime >= DateUtil.getDateAfterDay(today, -14).getTime()
					&& createTime < DateUtil.getDateAfterDay(today, -7).getTime()){
				buildGroup(result, teamName[3], panDoc);
			}
			else if(createTime >= DateUtil.getDateAfterMonth(today, -1).getTime()
					&& createTime < DateUtil.getDateAfterDay(today, -14).getTime()){
				buildGroup(result, teamName[4], panDoc);
			}
			else if(createTime < DateUtil.getDateAfterMonth(today, -1).getTime()){
				buildGroup(result, teamName[5], panDoc);
			}
			else {
				buildGroup(result, "others", panDoc);
			}
		}
		return result;
	}

	private Map<String, List<PanDocument>> buildGroup(Map<String, List<PanDocument>> map, String teamName, PanDocument panDocument){
		List<PanDocument> list = map.get(teamName);
		if(list == null || list.isEmpty()){
			list = Lists.newArrayList();
		}
		list.add(panDocument);
		map.put(teamName, list);
		return map;
	}
*/