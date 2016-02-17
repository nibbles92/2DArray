package array.view;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import array.controller.ArrayController;

public class ArrayPanel extends JPanel
	{
		private SpringLayout baseLayout;
		
		private JButton addButton;
		private JButton removeButton;
		private JTextArea showInfo;
		private JTextArea guide;
		private JTextField userX;
		private JTextField userY;
		private JTextField userContent;
		
		private ArrayController baseController;
		
		public ArrayPanel(ArrayController baseController)
		{
			baseLayout = new SpringLayout();
			
			addButton = new JButton("Add");
			removeButton = new JButton("Remove with X and Y");
			showInfo = new JTextArea();
			showInfo.setText("BackPack can hold 0-4.\n");
			showInfo.setEditable(false);
			userX = new JTextField();
			userY = new JTextField();
			userContent = new JTextField();
			guide = new JTextArea("X POS       Y POS\n\n\n\n\nENTER ITEM");
			guide.setOpaque(false);
			guide.setEditable(false);
			
			this.baseController = baseController;
			
			setupPanel();
			setupPlacements();
			setupListeners();
		}
		
		private void setupPanel()
		{
			setLayout(baseLayout);
			
			add(addButton);
			add(removeButton);
			add(showInfo);
			add(userX);
			add(userY);
			add(userContent);
			add(guide);
		}
		
		private void setupPlacements()
		{
			baseLayout.putConstraint(SpringLayout.NORTH, removeButton, -37, SpringLayout.SOUTH, guide);
			baseLayout.putConstraint(SpringLayout.SOUTH, removeButton, 0, SpringLayout.SOUTH, guide);
			baseLayout.putConstraint(SpringLayout.WEST, removeButton, 0, SpringLayout.WEST, addButton);
			baseLayout.putConstraint(SpringLayout.EAST, removeButton, -10, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, addButton, 47, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, removeButton, 0, SpringLayout.WEST, addButton);
			baseLayout.putConstraint(SpringLayout.EAST, removeButton, -10, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.WEST, userX, 0, SpringLayout.WEST, showInfo);
			baseLayout.putConstraint(SpringLayout.EAST, userX, -313, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.WEST, userY, 6, SpringLayout.EAST, userX);
			baseLayout.putConstraint(SpringLayout.EAST, userY, -13, SpringLayout.WEST, removeButton);
			baseLayout.putConstraint(SpringLayout.SOUTH, userY, -6, SpringLayout.NORTH, userContent);
			baseLayout.putConstraint(SpringLayout.SOUTH, userX, -6, SpringLayout.NORTH, userContent);
			baseLayout.putConstraint(SpringLayout.EAST, userContent, -223, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.WEST, userContent, 10, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, userContent, -179, SpringLayout.SOUTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, showInfo, 10, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.EAST, showInfo, -10, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, addButton, 10, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, addButton, 183, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.EAST, addButton, -10, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, showInfo, 127, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, showInfo, -10, SpringLayout.SOUTH, this);
			baseLayout.putConstraint(SpringLayout.NORTH, removeButton, -43, SpringLayout.NORTH, showInfo);
			baseLayout.putConstraint(SpringLayout.SOUTH, removeButton, -6, SpringLayout.NORTH, showInfo);
			baseLayout.putConstraint(SpringLayout.NORTH, guide, 9, SpringLayout.NORTH, addButton);
			baseLayout.putConstraint(SpringLayout.WEST, guide, 20, SpringLayout.WEST, this);
		}
		
		private void setupListeners()
		{
			addButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent clicked)
					{
						int xPos = Integer.parseInt(userX.getText());
						int yPos = Integer.parseInt(userY.getText());
						
						baseController.setPos(xPos, yPos, userContent.getText());
						String printContents = baseController.getBackPack().getContents();
						showInfo.setText("BackPack can hold 0-4.\nRow: " + xPos + " Column: " + yPos + " = " + printContents);
					}
				});
			
			removeButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent clicked)
					{
						int xPos = Integer.parseInt(userX.getText());
						int yPos = Integer.parseInt(userY.getText());
						
						baseController.removeContent(xPos, yPos);
						String printContents = baseController.getBackPack().getContents();
						showInfo.setText("BackPack can hold 0-4.\nRow: " + xPos + " Column: " + yPos + " = " + printContents);
					}
				});
		}
	}