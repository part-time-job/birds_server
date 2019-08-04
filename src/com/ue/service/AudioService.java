package com.ue.service;

import java.util.List;

import com.ue.dao.AudioDao;
import com.ue.domain.Event;

public interface AudioService {

	void setAudioDao(AudioDao audioDao);

	List<Event> getAllAudio();

}