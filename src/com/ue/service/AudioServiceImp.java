package com.ue.service;

import java.util.List;

import com.ue.dao.AudioDao;
import com.ue.domain.Event;
import com.ue.utils.BeanUtils;

public class AudioServiceImp implements AudioService {
	AudioDao audioDao;
	
	/* (non-Javadoc)
	 * @see com.ue.service.AudioService#setAudioDao(com.ue.dao.AudioDao)
	 */
	@Override
	public void setAudioDao(AudioDao audioDao){
		this.audioDao = audioDao;
	}
	
	public AudioServiceImp(){
		audioDao = (AudioDao) BeanUtils.getBean("audioDao");
	}
	
	/* (non-Javadoc)
	 * @see com.ue.service.AudioService#getAllAudio()
	 */
	@Override
	public List<Event> getAllAudio(){
		return audioDao.getAllAudio();
	}
}
