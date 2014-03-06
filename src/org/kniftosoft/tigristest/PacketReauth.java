package org.kniftosoft.tigristest;

import com.google.gson.JsonObject;

public class PacketReauth extends Packet 
{

	@Override
	public void createFromJSON(JsonObject o) 
	{

	}

	@Override
	public JsonObject storeToJSON() 
	{
		JsonObject jo = new JsonObject();
		
		jo.addProperty("sessionID",sessionID);
		
		return jo;
	}

	@Override
	public PacketType getType() 
	{
		return PacketType.REAUTH;
	}

	public void setSessionID(String sessionID)
	{
		this.sessionID = sessionID;
	}
	
	private String sessionID;
	
}
