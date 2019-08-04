package com.ue.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.domain.Event;

public interface AudioDao {

	String GETALL = "select * from tb_event where eve_audiourl is not null";

	JdbcTemplate getTemplate();

	void setTemplate(JdbcTemplate template);

	List<Event> getAllAudio();

}