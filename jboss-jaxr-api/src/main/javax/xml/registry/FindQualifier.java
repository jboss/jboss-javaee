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
package javax.xml.registry;

/** FindQualifier provides various constants that identify options that effect
 * find method behavior. A JAXR provider may silently ignore any qualifiers
 * marked as optional. A JAXR provider must support qualifiers not marked
 * optional.
 *  
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface FindQualifier
{
   public static final String AND_ALL_KEYS="andAllKeys";
   public static final String CASE_SENSITIVE_MATCH="caseSensitiveMatch";
   public static final String COMBINE_CLASSIFICATIONS="combineClassifications";
   public static final String EXACT_NAME_MATCH="exactNameMatch";
   public static final String OR_ALL_KEYS="orAllKeys";
   public static final String OR_LIKE_KEYS="orLikeKeys";
   public static final String SERVICE_SUBSET="serviceSubset";
   public static final String SORT_BY_DATE_ASC="sortByDateAsc";
   public static final String SORT_BY_DATE_DESC="sortByDateDesc";
   public static final String SORT_BY_NAME_ASC="sortByNameAsc";
   public static final String SORT_BY_NAME_DESC="sortByNameDesc";
   public static final String SOUNDEX="soundex";

}
