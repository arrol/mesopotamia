package org.kniftosoft.util.packet;

import java.util.Iterator;

import javax.persistence.EntityManager;

import org.kniftosoft.entity.Subscribe;
import org.kniftosoft.util.Constants;

import com.google.gson.JsonObject;

//TODO check class funktion
/**
 * @author julian
 * 
 */
public class UNSUBSCRIBE extends Packet {
	private int category;
	private String id;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.kniftosoft.util.packet.Packet#createFromJSON(com.google.gson.JsonObject)
	 */
	@Override
	public void createFromJSON(JsonObject o) {
		category = o.get("category").getAsInt();
		id = o.get("id").getAsString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.kniftosoft.util.packet.Packet#executerequest()
	 */
	@Override
	public void executerequest() {
		boolean found = false;
		// check for wildcard
		if (id == "*") {
			for (final Iterator<Subscribe> iterator = peer.getUser()
					.getSubscribes().iterator(); iterator.hasNext()
					|| found == false;) {
				final Subscribe sub = iterator.next();
				// delete all subscribes for the user with this category
				if (sub.getAppBean().getIdapp() == category) {
					found = true;
					final EntityManager em = Constants.factory
							.createEntityManager();
					em.remove(sub);
					em.close();
				}
			}
		} else {
			for (final Iterator<Subscribe> iterator = peer.getUser()
					.getSubscribes().iterator(); iterator.hasNext()
					|| found == false;) {
				final Subscribe sub = iterator.next();
				// delete all subscribes for the user with this category and
				// objekt
				if (sub.getObjektID() == Integer.parseInt(id)
						&& sub.getAppBean().getIdapp() == category) {
					found = true;
					final EntityManager em = Constants.factory
							.createEntityManager();
					em.remove(sub);
					em.close();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.kniftosoft.util.packet.Packet#getType()
	 */
	@Override
	public PacketType getType() {
		return PacketType.UNSUBSCRIBE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.kniftosoft.util.packet.Packet#storeData()
	 */
	@Override
	public JsonObject storeData() {
		final JsonObject data = new JsonObject();
		data.addProperty("category", category);
		data.addProperty("id", id);
		return data;
	}

}
