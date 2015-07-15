/*
 * PopoutDocEvent.java
 *
 * Copyright (C) 2009-15 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.workbench.views.source.events;

import org.rstudio.core.client.Point;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class PopoutDocEvent extends GwtEvent<PopoutDocEvent.Handler>
{
   public interface Handler extends EventHandler
   {
      void onPopoutDoc(PopoutDocEvent e);
   }
   
   public PopoutDocEvent(String docId, Point position)
   {
      docId_ = docId;
      position_ = position;
   }

   public String getDocId()
   {
      return docId_;
   }
   
   public Point getPosition()
   {
      return position_;
   }
  
   @Override
   public Type<Handler> getAssociatedType()
   {
      return TYPE;
   }

   @Override
   protected void dispatch(Handler handler)
   {
      handler.onPopoutDoc(this);
   }

   private final String docId_;
   private final Point position_;
   
   public static final Type<Handler> TYPE = new Type<Handler>();
}