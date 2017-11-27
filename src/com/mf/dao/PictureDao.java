package com.mf.dao;

import java.util.List;

import com.mf.entity.Picture;

public interface PictureDao extends BaseDao<Picture>{
	
	//返回同类型图片组
	List<Picture> SearchPicturesTypeByLike(String type);
	//通过关键字模糊查询返回图片集合
	List<Picture> fuzzyQueryPictures(String nameLike);
	//返回所有图片
	List<Picture> AllPicture();
}
