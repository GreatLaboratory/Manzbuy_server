package tk.manzbuy.admin.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import tk.manzbuy.admin.dto.AdminInfo;
import static tk.manzbuy.admin.dao.AdminInfoDaoSqls.*;

@Repository
public class AdminInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<AdminInfo> rowMapper = BeanPropertyRowMapper.newInstance(AdminInfo.class);

	public AdminInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public List<AdminInfo> selectAll() {
		return jdbc.query(SELECT_ALL, rowMapper);
	}
	
}
