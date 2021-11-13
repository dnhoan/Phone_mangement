/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Services;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
<<<<<<< HEAD
=======
import java.awt.*;
import java.awt.event.*;
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 *
 * @author DUCNAM
 */
<<<<<<< HEAD
public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {

    private JTable table;
    private Action action;
    private int mnemonic;
    private Border originalBorder;
    private Border focusBorder;

    private JButton renderButton;
    private JButton editButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;

    public ButtonColumn(JTable table, Action action, int column) {
        this.table = table;
        this.action = action;

        renderButton = new JButton();
        editButton = new JButton();
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);
        originalBorder = editButton.getBorder();

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
        table.addMouseListener(this);
    }

    public Border getFocusBorder() {
        return focusBorder;
    }

    public void setFocusBorder(Border focusBorder) {
        this.focusBorder = focusBorder;
        editButton.setBorder(focusBorder);
    }

    public int getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(int mnemonic) {
        this.mnemonic = mnemonic;
        renderButton.setMnemonic(mnemonic);
        editButton.setMnemonic(mnemonic);
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
=======
public class ButtonColumn  extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener
{
private JTable table;
	private Action action;
	private int mnemonic;
	private Border originalBorder;
	private Border focusBorder;

	private JButton renderButton;
	private JButton editButton;
	private Object editorValue;
	private boolean isButtonColumnEditor;
        
        
        public ButtonColumn(JTable table, Action action, int column)
	{
		this.table = table;
		this.action = action;

		renderButton = new JButton();
		editButton = new JButton();
		editButton.setFocusPainted( false );
		editButton.addActionListener( this );
		originalBorder = editButton.getBorder();
		

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer( this );
		columnModel.getColumn(column).setCellEditor( this );
		table.addMouseListener( this );
	}
        public Border getFocusBorder()
	{
		return focusBorder;
	}
        public void setFocusBorder(Border focusBorder)
	{
		this.focusBorder = focusBorder;
		editButton.setBorder( focusBorder );
	}
        public int getMnemonic()
	{
		return mnemonic;
	}
        public void setMnemonic(int mnemonic)
	{
		this.mnemonic = mnemonic;
		renderButton.setMnemonic(mnemonic);
		editButton.setMnemonic(mnemonic);
	}
    @Override
    public Object getCellEditorValue() {
            return editorValue;
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
<<<<<<< HEAD
        if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        if (hasFocus) {
            renderButton.setBorder(focusBorder);
        } else {
            renderButton.setBorder(originalBorder);
        }
        if (value == null) {
            renderButton.setText("");
            renderButton.setIcon(null);
        } else if (value instanceof Icon) {
            renderButton.setText("");
            renderButton.setIcon((Icon) value);
        } else {
            renderButton.setText(value.toString());
            renderButton.setIcon(null);
        }

        return renderButton;
=======
           if (isSelected)
		{
			renderButton.setForeground(table.getSelectionForeground());
	 		renderButton.setBackground(table.getSelectionBackground());
		}
		else
		{
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}

		if (hasFocus)
		{
			renderButton.setBorder( focusBorder );
		}
		else
		{
			renderButton.setBorder( originalBorder );
		}
                if (value == null)
		{
			renderButton.setText( "" );
			renderButton.setIcon( null );
		}
		else if (value instanceof Icon)
		{
			renderButton.setText( "" );
			renderButton.setIcon( (Icon)value );
		}
		else
		{
			renderButton.setText( value.toString() );
			renderButton.setIcon( null );
		}

		return renderButton;
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
<<<<<<< HEAD
        if (value == null) {
            editButton.setText("");
            editButton.setIcon(null);
        } else if (value instanceof Icon) {
            editButton.setText("");
            editButton.setIcon((Icon) value);
        } else {
            editButton.setText(value.toString());
            editButton.setIcon(null);
        }

        this.editorValue = value;
        return editButton;
=======
             if (value == null)
		{
			editButton.setText( "" );
			editButton.setIcon( null );
		}
		else if (value instanceof Icon)
		{
			editButton.setText( "" );
			editButton.setIcon( (Icon)value );
		}
		else
		{
			editButton.setText( value.toString() );
			editButton.setIcon( null );
		}

		this.editorValue = value;
		return editButton;
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
<<<<<<< HEAD
        int row = table.convertRowIndexToModel(table.getEditingRow());
        fireEditingStopped();

        //  Invoke the Action
        ActionEvent event = new ActionEvent(
                table,
                ActionEvent.ACTION_PERFORMED,
                "" + row);
        action.actionPerformed(event);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (table.isEditing()
                && table.getCellEditor() == this) {
            isButtonColumnEditor = true;
        }
=======
        int row = table.convertRowIndexToModel( table.getEditingRow() );
		fireEditingStopped();

		//  Invoke the Action

		ActionEvent event = new ActionEvent(
			table,
			ActionEvent.ACTION_PERFORMED,
			"" + row);
		action.actionPerformed(event);
    }

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {
       if (table.isEditing()
		&&  table.getCellEditor() == this)
			isButtonColumnEditor = true;
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
    }

    @Override
    public void mouseReleased(MouseEvent me) {
<<<<<<< HEAD
        if (isButtonColumnEditor
                && table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }

        isButtonColumnEditor = false;
=======
       if (isButtonColumnEditor
    	&&  table.isEditing())
    		table.getCellEditor().stopCellEditing();

		isButtonColumnEditor = false;
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
    }

    @Override
    public void mouseEntered(MouseEvent me) {
<<<<<<< HEAD

=======
        
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
    }

    @Override
    public void mouseExited(MouseEvent me) {
<<<<<<< HEAD

=======
    
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
    }

    private void setFocusBorder(LineBorder lineBorder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
<<<<<<< HEAD

=======
    
    
>>>>>>> dcf56e49b873e78311f0963f608687e169ad61a4
}
