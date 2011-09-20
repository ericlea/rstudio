/*
 * InputEditorUtil.java
 *
 * Copyright (C) 2009-11 by RStudio, Inc.
 *
 * This program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.workbench.views.console.shell.editor;

public class InputEditorUtil
{
   public static void yankAfterCursor(final InputEditorDisplay editor,
                                      final boolean saveValue)
   {
      InputEditorSelection selection = editor.getSelection() ;
      if (selection != null)
      {
         selection = selection.extendToLineEnd();

         editor.setSelection(selection);

         editor.setFocus(true) ;
         String yanked = editor.replaceSelection("", true);
         if (saveValue)
            lastYanked = yanked;
      }
   }

   public static void yankBeforeCursor(final InputEditorDisplay editor,
                                       final boolean saveValue)
   {
      InputEditorSelection selection = editor.getSelection() ;
      if (selection != null)
      {
         selection = selection.extendToLineStart();

         editor.setSelection(selection);

         editor.setFocus(true) ;
         String yanked = editor.replaceSelection("", true);
         if (saveValue)
            lastYanked = yanked;
      }
   }

   public static void pasteYanked(InputEditorDisplay editor)
   {
      if (lastYanked != null)
      {
         editor.replaceSelection(lastYanked, true);
      }
   }
   
   public static InputEditorLineWithCursorPosition getLineWithCursorPosition(
                                                InputEditorDisplay editor)
   {
      String line;
      int pos;
      if (editor.getSelection().isEmpty())
      {
         line = editor.getText();
         pos = editor.getSelection().getStart().getPosition();
         // Move pos to the right until we get to a break
         for (; pos < line.length() && Character.isLetterOrDigit(line.charAt(pos)); pos++)
         {
         }
      }
      else
      {
         line = editor.getSelectionValue();
         pos = line.length();
      }
      
      return new InputEditorLineWithCursorPosition(line, pos);
   }

   private static String lastYanked;
}
