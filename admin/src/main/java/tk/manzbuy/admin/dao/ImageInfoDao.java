package tk.manzbuy.admin.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import tk.manzbuy.admin.dto.ImageInfo;

@Repository
public class ImageInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ImageInfo> rowMapper = BeanPropertyRowMapper.newInstance(ImageInfo.class);
	
	public ImageInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("imageinfo").usingGeneratedKeyColumns("id");
		//자동으로 insert할 때에는 id값으로 auto_increment
	}
	
	public Long insert(ImageInfo imageInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(imageInfo);
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
