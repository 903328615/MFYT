package com.mf.dao;

import java.util.List;

import com.mf.entity.Picture;

public interface PictureDao extends BaseDao<Picture>{
	
	//����������������������ͼƬ
	//According to the type of search qualified pictures
	List<Picture> SearchPicturesTypeByLike(String type);
	//ģ����ѯ��������������ͼƬ��
	//Fuzzy query name qualified group of pictures
	List<Picture> fuzzyQueryPictures(String nameLike);
	//��ȡ����ͼƬ
	//Get all the pictures
	List<Picture> AllPicture();
}
