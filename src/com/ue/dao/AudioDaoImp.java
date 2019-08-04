package com.ue.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.domain.Event;


public class AudioDaoImp implements AudioDao {

	
	JdbcTemplate template;
	/* (non-Javadoc)
	 * @see com.ue.dao.AudioDao#getTemplate()
	 */
	@Override
	public JdbcTemplate getTemplate() {
		return template;
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.AudioDao#setTemplate(org.springframework.jdbc.core.JdbcTemplate)
	 */
	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/* (non-Javadoc)
	 * @see com.ue.dao.AudioDao#getAllAudio()
	 */
	@Override

	public List<Event> getAllAudio() {
		return (List<Event>) template.query(GETALL, new BeanPropertyRowMapper<Event>(Event.class));
	}

}
