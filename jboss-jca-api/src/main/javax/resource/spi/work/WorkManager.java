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
package javax.resource.spi.work;


/**
 * Interface used to associate the resource adapter with objects that implement
 * this interface.
 */
public interface WorkManager
{
   /** Unknown/unspecified start delay */
   static final long UNKNOWN = -1l;
   /** No start delay */
   static final long IMMEDIATE = 0l;
   /** Indefinite start delay */
   static final long INDEFINITE = Long.MAX_VALUE;
   
   /**
    * Executes the work, the call blocks until the work completes
    *
    * @param work the work
    * @throws WorkException a generic error
    * @throws WorkRejectedException if the work is rejected
    * @throws WorkCompletedException if the work completes with an exception 
    */
   void doWork(Work work) throws WorkException;
   
   /**
    * Executes the work, the call blocks until the work completes
    *
    * @param work the work
    * @param startTimeout the wait before execution
    * @param ctx the execution context
    * @param listener the work listener
    * @throws WorkException a generic error
    * @throws WorkRejectedException if the work is rejected
    * @throws WorkCompletedException if the work completes with an exception 
    */
   void doWork(Work work, long startTimeout, ExecutionContext ctx, WorkListener listener) throws WorkException;
   
   /**
    * Executes the work, the call blocks until the work starts
    *
    * @param work the work
    * @return the time elapsed until the work starts
    * @throws WorkException a generic error
    * @throws WorkRejectedException if the work is rejected
    */
   long startWork(Work work) throws WorkException;
   
   
   /**
    * Executes the work, the call blocks until the work starts
    *
    * @param work the work
    * @param startTimeout the wait before execution
    * @param ctx the execution context
    * @param listener the work listener
    * @return the time elapsed until the work starts
    * @throws WorkException a generic error
    * @throws WorkRejectedException if the work is rejected
    */
   long startWork(Work work, long startTimeout, ExecutionContext ctx, WorkListener listener) throws WorkException;
   
   /**
    * Executes the work, the call returns immediatley
    *
    * @param work the work
    * @throws WorkException a generic error
    * @throws WorkRejectedException if the work is rejected
    */
   void scheduleWork(Work work) throws WorkException;
   
   /**
    * Executes the work, the call returns immediately
    *
    * @param work the work
    * @param startTimeout the wait before execution
    * @param ctx the execution context
    * @param listener the work listener
    * @throws WorkException a generic error
    * @throws WorkRejectedException if the work is rejected
    */
   void scheduleWork(Work work, long startTimeout, ExecutionContext ctx, WorkListener listener) throws WorkException;
}