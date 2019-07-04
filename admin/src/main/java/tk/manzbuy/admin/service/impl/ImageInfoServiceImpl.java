package tk.manzbuy.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tk.manzbuy.admin.dao.ImageInfoDao;
import tk.manzbuy.admin.dto.ImageInfo;
import tk.manzbuy.admin.service.ImageInfoService;

public class ImageInfoServiceImpl implements ImageInfoService {
	@Autowired
	ImageInfoDao imageInfoDao;
	
	
	@Override
	@Transactional(readOnly = false )
	public ImageInfo addImageInfo(ImageInfo imageInfo) {
		Long id = imageInfoDao.insert(imageInfo);
		imageInfo.setId(id);
		return imageInfo;
	}

}
