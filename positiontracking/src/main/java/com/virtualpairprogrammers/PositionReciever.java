package com.virtualpairprogrammers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PositionReciever {

	@Autowired
	private Data data;
	
	@JmsListener(destination="positionQueue")
	public void recieve(Map<String, String> position){
		
		data.updatePosition(position);
	}
	
}
