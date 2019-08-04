package com.ue.test;

import java.util.List;

import com.ue.domain.Event;
import com.ue.service.EventService;
import com.ue.service.EventServiceImp;

public class EventTest {
	EventService es = new EventServiceImp();
	
	
	public void insertEventTest(int i){
		Event event = new Event();
		event.setUse_id(1);
		event.setEve_count(1);
		event.setEve_datatype(1);
		event.setEve_pictureurl("demo"+i+".jpg");
		System.out.println("new"+event.toString());
		boolean res = es.insertEvent(event);
		System.out.println("新增："+res);
	}

	
	public void deleteEventByEventId(){
		boolean res = es.deleteEventByEventId(2);
		System.out.println("删除："+res);
	}

	
	public void updateEventByEventId(){
		Event event = new Event();
		event.setEve_id(8);
		event.setEve_count(1);
		event.setUse_id(1);
		event.setEve_datatype(1);
		event.setEve_question("这是什么鸟？");
		event.setEve_time("2015-03-21 09:27:27.224");
		event.setEve_pictureurl("demo6.jpg");
		boolean res = es.updateEventByEventId(event);
		System.out.println("更新："+res);
	}

	
	public void searchEventByEventId(){
		Event event = es.searchEventByEventId(1);
		System.out.println(event.toString());
	}
	
	
	public void searchEventByUserId(){
		List<Event> list = es.searchEventByUserId(1);
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
	}
	
	
	public void searchEventPuretextByPage(){
		List<Event> list1 = es.searchEventPuretextByPage(1);
		for(int i = 0;i<list1.size();i++){
			System.out.println(list1.get(i).toString());
		}
		List<Event> list2 = es.searchEventPuretextByPage(1,1);
		for(int i = 0;i<list2.size();i++){
			System.out.println(list2.get(i).toString());
		}
	}
	
	
	
	public void searchEventPictureByPage(){
		List<Event> list1 = es.searchEventPictureByPage(1);
		for(int i = 0;i<list1.size();i++){
			System.out.println(list1.get(i).toString());
		}
		List<Event> list2 = es.searchEventPictureByPage(1,1);
		for(int i = 0;i<list2.size();i++){
			System.out.println(list2.get(i).toString());
		}
	}
	
	
	public void searchEventAudioByPage(){
		List<Event> list1 = es.searchEventAudioByPage(1);
		for(int i = 0;i<list1.size();i++){
			System.out.println(list1.get(i).toString());
		}
		List<Event> list2 = es.searchEventAudioByPage(1,1);
		for(int i = 0;i<list2.size();i++){
			System.out.println(list2.get(i).toString());
		}
	}
	public static void main(String[] args){
		EventTest et = new EventTest();
		//for(int i = 0;i<20;i++)
			//et.insertEventTest(i);
		//et.searchEventByEventId();
		//et.searchEventByUserId();
		//et.searchEventPuretextByPage();
		et.searchEventPictureByPage();
		//et.updateEventByEventId();
	}
}
