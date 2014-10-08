package com.wealth.miniloan.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService<T> {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Object queryForObject(String sql, Class<T> clazz) {
		return jdbcTemplate.queryForObject(sql, clazz);
	}

	public Object queryForProtoType(String sql, Class<?> clazz) {
		return jdbcTemplate.queryForObject(sql, clazz);
	}

	public T queryForObject(String sql, RowMapper<T> rowMapper) {
		return jdbcTemplate.queryForObject(sql, rowMapper);
	}

	public List<Map<String, Object>> queryForList(String sql) {
		return jdbcTemplate.queryForList(sql);
	}

	@Transactional
	public int delete(String sql) throws Exception {
		return jdbcTemplate.update(sql);
	}

	@Transactional
	public void update(String sql) {
		jdbcTemplate.update(sql);
	}

	@Transactional
	public void update(String sql, Object[] o) {
		jdbcTemplate.update(sql, o);
	}

	@Transactional
	public void batchUpdate(String[] sql) {
		jdbcTemplate.batchUpdate(sql);
	}

	@Transactional
	public void batchUpdate(String sql, List<Object[]> l) {
		jdbcTemplate.batchUpdate(sql, l);
	}

	@Transactional
	public void execute(String sql) {
		jdbcTemplate.execute(sql);
	}

}
