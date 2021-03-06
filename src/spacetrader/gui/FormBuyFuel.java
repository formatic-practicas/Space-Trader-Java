/*******************************************************************************
 *
 * Space Trader for Windows 2.00
 *
 * Copyright (C) 2005 Jay French, All Rights Reserved
 *
 * Additional coding by David Pierron
 * Original coding by Pieter Spronck, Sam Anderson, Samuel Goldstein, Matt Lee
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * If you'd like a copy of the GNU General Public License, go to
 * http://www.gnu.org/copyleft/gpl.html.
 *
 * You can contact the author at spacetrader@frenchfryz.com
 *
 ******************************************************************************/
//using System;
//using System.Drawing;
//using System.Collections;
//using System.ComponentModel;
//using System.Windows.Forms;
package spacetrader.gui;

import java.util.Arrays;

import jwinforms.*;

import spacetrader.Commander;
import spacetrader.Game;

public class FormBuyFuel extends SpaceTraderForm
{
	// #region Control Declarations

	private jwinforms.Button btnOk;
	private jwinforms.Label lblQuestion;
	private jwinforms.Button btnMax;
	private jwinforms.Button btnNothing;
	private jwinforms.NumericUpDown numAmount;

	// #endregion

	// #region Member Declarations

	private Game game = Game.CurrentGame();

	// #endregion

	// #region Methods

	public FormBuyFuel()
	{
		InitializeComponent();

		Commander cmdr = game.Commander();
		numAmount.setMaximum(Math.min(cmdr.getCash(), (cmdr.getShip().FuelTanks() - cmdr.getShip().getFuel())
				* cmdr.getShip().getFuelCost()));
		numAmount.setValue(numAmount.getMaximum());
	}

	// #region Windows Form Designer generated code
	// / <summary>
	// / Required method for Designer support - do not modify
	// / the contents of this method with the code editor.
	// / </summary>
	private void InitializeComponent()
	{
		this.lblQuestion = new jwinforms.Label();
		this.numAmount = new jwinforms.NumericUpDown();
		this.btnOk = new jwinforms.Button();
		this.btnMax = new jwinforms.Button();
		this.btnNothing = new jwinforms.Button();
		((ISupportInitialize)(this.numAmount)).BeginInit();
		this.SuspendLayout();
		//
		// lblQuestion
		//
		this.lblQuestion.setAutoSize(true);
		this.lblQuestion.setLocation(new java.awt.Point(8, 8));
		this.lblQuestion.setName("lblQuestion");
		this.lblQuestion.setSize(new jwinforms.Size(211, 13));
		this.lblQuestion.setTabIndex(3);
		this.lblQuestion.setText("How much do you want to spend on fuel?");
		//
		// numAmount
		//
		this.numAmount.setLocation(new java.awt.Point(216, 6));
		this.numAmount.setMaximum(999);
		this.numAmount.setMinimum(1);
		this.numAmount.setName("numAmount");
		this.numAmount.setSize(new jwinforms.Size(44, 20));
		this.numAmount.setTabIndex(1);
		this.numAmount.setValue(888);
		//
		// btnOk
		//
		this.btnOk.setDialogResult(DialogResult.OK);
		this.btnOk.setFlatStyle(jwinforms.FlatStyle.Flat);
		this.btnOk.setLocation(new java.awt.Point(61, 32));
		this.btnOk.setName("btnOk");
		this.btnOk.setSize(new jwinforms.Size(41, 22));
		this.btnOk.setTabIndex(2);
		this.btnOk.setText("Ok");
		//
		// btnMax
		//
		this.btnMax.setDialogResult(DialogResult.OK);
		this.btnMax.setFlatStyle(jwinforms.FlatStyle.Flat);
		this.btnMax.setLocation(new java.awt.Point(109, 32));
		this.btnMax.setName("btnMax");
		this.btnMax.setSize(new jwinforms.Size(41, 22));
		this.btnMax.setTabIndex(3);
		this.btnMax.setText("Max");
		this.btnMax.setClick(new EventHandler<Object, EventArgs>()
		{
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				btnMax_Click(sender, e);
			}
		});
		//
		// btnNothing
		//
		this.btnNothing.setDialogResult(DialogResult.Cancel);
		this.btnNothing.setFlatStyle(jwinforms.FlatStyle.Flat);
		this.btnNothing.setLocation(new java.awt.Point(157, 32));
		this.btnNothing.setName("btnNothing");
		this.btnNothing.setSize(new jwinforms.Size(53, 22));
		this.btnNothing.setTabIndex(4);
		this.btnNothing.setText("Nothing");
		//
		// FormBuyFuel
		//
		this.setAcceptButton(this.btnOk);
		this.setAutoScaleBaseSize(new jwinforms.Size(5, 13));
		this.setCancelButton(this.btnNothing);
		this.setClientSize(new jwinforms.Size(270, 63));
		this.setControlBox(false);
		this.Controls.addAll(Arrays.asList(this.btnNothing, this.btnMax, this.btnOk, this.numAmount, this.lblQuestion));
		this.setFormBorderStyle(jwinforms.FormBorderStyle.FixedDialog);
		this.setName("FormBuyFuel");
		this.setShowInTaskbar(false);
		this.setStartPosition(FormStartPosition.CenterParent);
		this.setText("Buy Fuel");
		((ISupportInitialize)(this.numAmount)).EndInit();
	}

	// #endregion

	// #endregion

	// #region Event Handlers

	private void btnMax_Click(Object sender, EventArgs e)
	{
		numAmount.setValue(numAmount.getMaximum());
	}

	// #endregion

	// #region Properties

	public int Amount()
	{
		return numAmount.getValue();
	}
}
