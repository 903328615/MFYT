package com.mf.dao;

import java.util.List;

import com.mf.entity.Picture;

public interface PictureDao extends BaseDao<Picture>{
	
	//根据类型搜索符合条件的图片
	//According to the type of search qualified pictures
	List<Picture> SearchPicturesTypeByLike(String type);
	//模糊查询符合名称条件的图片组
	//Fuzzy query name qualified group of pictures
	List<Picture> fuzzyQueryPictures(String nameLike);
	//获取所有图片
	//Get all the pictures
	List<Picture> AllPicture();
}
