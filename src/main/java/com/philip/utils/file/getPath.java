/*
	public List<PanFolder> getPath(Long id, List<PanFolder> path, Long uid){

		if(path == null){
			path = new ArrayList<PanFolder>();
		}
		if(id == null || id.longValue() == 0){
			return path;
		}

		boolean cycle = false;
		for(PanFolder pf : path){
			if(pf.getId() == id){
				cycle = true;
				break;
			}
		}
		if(cycle) {
			LOG.warn("[PAROX]文件夹目录出现死循环，需要立即处理，folderId:"+id+", userId:"+uid+"  "+DateUtil.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			return path;
		}

		PanFolder panFolder = panFolderDao.queryOne(id);
		if(panFolder == null){
			return path;
		}
		path.add(panFolder);
		Long parentId = panFolder.getParentId();
		parentId = parentId==null?panFolder.getParentId():parentId;
		return getPath(parentId, path, uid);

	}*/