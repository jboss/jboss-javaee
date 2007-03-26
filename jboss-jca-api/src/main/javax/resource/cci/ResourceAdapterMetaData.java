/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package javax.resource.cci;

/**
 * The ResourceAdaptetMetaData provides information about the resource adapters
 * implementation.
 * 
 * The resource adapter does not require an active connection to exist in order
 * for the client to retrieve and use this data.
 * @version $Revision$
 */
public interface ResourceAdapterMetaData
{
   /**
	 * Gets the resource adapter's name.
	 * 
	 * @return Resource adapter name.
	 */
   public String getAdapterName();

   /**
	 * Gets the resource adapter's short description.
	 * 
	 * @return Resource adapter short description.
	 */
   public String getAdapterShortDescription();

   /**
	 * Gets the resource adapter vendor's name.
	 * 
	 * @return Resource adapter vendor name.
	 */
   public String getAdapterVendorName();

   /**
	 * Gets the resource adapter version.
	 * 
	 * @return Resource adapter version.
	 */
   public String getAdapterVersion();

   /**
	 * Gets information on the InteractionSpec types supported by this resource
	 * adapter.
	 * 
	 * @return Array of InteractionSpec names supported.
	 */
   public String[] getInteractionSpecsSupported();

   /**
	 * Gets the Connector specification version supported by this adapter.
	 * 
	 * @return Connector specification version.
	 */
   public String getSpecVersion();

   /**
	 * Returns true if the resource adapter Interaction implementation supports
	 * the method boolean execute( InteractionSpec spec, Record input, Record
	 * output ), otherwise returns false
	 */
   public boolean supportsExecuteWithInputAndOutputRecord();

   /**
	 * Returns true if the resource adapter Interaction implementation supports
	 * the method boolean execute( InteractionSpec spec, Record input ),
	 * otherwise returns false
	 */
   public boolean supportsExecuteWithInputRecordOnly();

   /**
	 * Returns true if the resource adapter implementation implements the
	 * LocalTransaction interface and supports local transaction demarcation.
	 */
   public boolean supportsLocalTransactionDemarcation();
}