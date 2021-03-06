package org.kniftosoft.util;

import javax.persistence.EntityManagerFactory;

/**
 * Constant Collection for Euphratis
 * @author julian 
 */
public class Constants {
	public static final String Clientversion = "0.4.1";
	public static final String PERSISTENCE_UNIT_NAME = "Euphratis";
	public static final int incoming = 1;
	public static final int bidirectional = 2;
	public static final int outgoing = 3;
	public static EntityManagerFactory factory;
}