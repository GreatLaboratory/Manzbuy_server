package tk.manzbuy.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.manzbuy.admin.dao.ImageInfoDao;
import tk.manzbuy.admin.dto.ImageInfo;
import tk.manzbuy.admin.service.ImageInfoService;


// 여기서 service어노테이션없으면 아래와 같은 에러 뿜어낸다.
//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'fileController': 
//Unsatisfied dependency expressed through field 'imageInfoService'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
//No qualifying bean of type 'tk.manzbuy.admin.service.ImageInfoService' available: expected at least 1 bean which qualifies as autowire candidate. 
//Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)

@Service
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
