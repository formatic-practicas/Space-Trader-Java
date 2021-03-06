/*******************************************************************************
 *
 * Space Trader for Windows 2.00
 *
 * Copyright (C) 2005 Jay French, All Rights Reserved
 *
 * Additional coding by David Pierron Original coding by Pieter Spronck, Sam Anderson, Samuel Goldstein, Matt Lee
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * If you'd like a copy of the GNU General Public License, go to http://www.gnu.org/copyleft/gpl.html.
 *
 * You can contact the author at spacetrader@frenchfryz.com
 *
 ******************************************************************************/

package spacetrader.gui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.UIManager;

import jwinforms.*;
import spacetrader.Commander;
import spacetrader.Consts;
import spacetrader.Functions;
import spacetrader.Game;
import spacetrader.GameController;
import spacetrader.enums.AlertType;
import spacetrader.enums.GameEndType;
import spacetrader.enums.ShipType;
import spacetrader.guifacade.GuiFacade;
import spacetrader.guifacade.GuiEngine;
import spacetrader.guifacade.MainWindow;
import spacetrader.stub.Directory;
import spacetrader.stub.RegistryKey;

public class SpaceTrader extends jwinforms.WinformWindow implements MainWindow
{
	// #region Control Declarations

	private DockBox dockBox;
	private CargoBox cargoBox;
	private TargetSystemBox targetSystemBox;
	private GalacticChart galacticChart;
	private ShortRangeChart shortRangeChart;
	private SystemBox system;
	private ShipyardBox shipyard;
	private SpaceTraderStatusBar statusBar;

	private jwinforms.ImageList ilChartImages;
	private jwinforms.ImageList ilDirectionImages;
	private jwinforms.ImageList ilEquipmentImages;
	private jwinforms.ImageList ilShipImages;
	private jwinforms.MainMenu mnuMain;
	private jwinforms.SubMenu mnuGame;
	private jwinforms.MenuItem mnuGameExit;
	private jwinforms.MenuItem mnuGameLine1;
	private jwinforms.MenuItem mnuGameLine2;
	private jwinforms.MenuItem mnuGameLoad;
	private jwinforms.MenuItem mnuGameNew;
	private jwinforms.MenuItem mnuGameSave;
	private jwinforms.MenuItem mnuGameSaveAs;
	private jwinforms.SubMenu mnuHelp;
	private jwinforms.MenuItem mnuHelpAbout;
	private jwinforms.MenuItem mnuHighScores;
	private jwinforms.MenuItem mnuOptions;
	private jwinforms.MenuItem mnuRetire;
	private jwinforms.SubMenu mnuView;
	private jwinforms.MenuItem mnuViewBank;
	private jwinforms.MenuItem mnuViewCommander;
	private jwinforms.MenuItem mnuViewLine1;
	private jwinforms.MenuItem mnuViewLine2;
	private jwinforms.MenuItem mnuViewPersonnel;
	private jwinforms.MenuItem mnuViewQuests;
	private jwinforms.MenuItem mnuViewShip;
	private jwinforms.OpenFileDialog dlgOpen;
	private jwinforms.PictureBox picLine;
	private jwinforms.SaveFileDialog dlgSave;

	private jwinforms.IContainer components;

	private Game game;
	private GameController controller;
	private Commander commander;

	public SpaceTrader(String loadFileName)
	{
		InitializeComponent();

		InitFileStructure();

		if (loadFileName != null)
			controller.LoadGame(loadFileName);

		UpdateAll();
	}

	public static void main(String[] args) throws Exception
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("swing.boldMetal", Boolean.FALSE);
		} catch (Exception e)
		{
			// TODO: We get here if there's no windows UI; I think no special treatment is needed.
		}
		SpaceTrader spaceTrader = new SpaceTrader(args.length > 0 ? args[0] : null);
		GuiEngine.installImplementation(new OriginalGuiImplementationProvider(spaceTrader));
		spaceTrader.ShowWindow();
	}

	// #region Windows Form Designer generated code
	// / <summary>
	// / Required method for Designer support - do not modify
	// / the contents of this method with the code editor.
	// / </summary>
	private void InitializeComponent()
	{
		components = new jwinforms.Container();
		jwinforms.ResourceManager resources = new jwinforms.ResourceManager(SpaceTrader.class);
		mnuMain = new jwinforms.MainMenu();
		mnuGame = new jwinforms.SubMenu();
		mnuGameNew = new jwinforms.MenuItem();
		mnuGameLoad = new jwinforms.MenuItem();
		mnuGameSave = new jwinforms.MenuItem();
		mnuGameSaveAs = new jwinforms.MenuItem();
		mnuGameLine1 = new jwinforms.MenuItem();
		mnuRetire = new jwinforms.MenuItem();
		mnuGameLine2 = new jwinforms.MenuItem();
		mnuGameExit = new jwinforms.MenuItem();
		mnuView = new jwinforms.SubMenu();
		mnuViewCommander = new jwinforms.MenuItem();
		mnuViewShip = new jwinforms.MenuItem();
		mnuViewPersonnel = new jwinforms.MenuItem();
		mnuViewQuests = new jwinforms.MenuItem();
		mnuViewBank = new jwinforms.MenuItem();
		mnuViewLine1 = new jwinforms.MenuItem();
		mnuHighScores = new jwinforms.MenuItem();
		mnuViewLine2 = new jwinforms.MenuItem();
		mnuOptions = new jwinforms.MenuItem();
		mnuHelp = new jwinforms.SubMenu();
		mnuHelpAbout = new jwinforms.MenuItem();
		statusBar = new SpaceTraderStatusBar(this);
		cargoBox = new CargoBox();
		system = new SystemBox(this);
		shipyard = new ShipyardBox(this);
		dockBox = new DockBox(this);
		picLine = new jwinforms.PictureBox();
		dlgOpen = new jwinforms.OpenFileDialog();
		dlgSave = new jwinforms.SaveFileDialog();
		ilChartImages = new jwinforms.ImageList(components);
		ilShipImages = new jwinforms.ImageList(components);
		ilDirectionImages = new jwinforms.ImageList(components);
		ilEquipmentImages = new jwinforms.ImageList(components);
		statusBar.BeginInit();
		shortRangeChart = new ShortRangeChart(this, ilChartImages);
		galacticChart = new GalacticChart(this, ilChartImages);
		targetSystemBox = new TargetSystemBox(this);

		shortRangeChart.SuspendLayout();
		galacticChart.SuspendLayout();
		targetSystemBox.SuspendLayout();
		cargoBox.SuspendLayout();
		system.SuspendLayout();
		shipyard.SuspendLayout();
		dockBox.SuspendLayout();
		this.SuspendLayout();
		//
		// mnuMain
		//
		mnuMain.addAll(mnuGame, mnuView, mnuHelp);
		//
		// mnuGame
		//
		mnuGame.Index = 0;
		mnuGame.addAll(mnuGameNew, mnuGameLoad, mnuGameSave, mnuGameSaveAs, mnuGameLine1, mnuRetire, mnuGameLine2,
				mnuGameExit);
		mnuGame.setText("&Game");
		//
		// mnuGameNew
		//
		mnuGameNew.Index = 0;
		mnuGameNew.setText("&New...");
		mnuGameNew.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuGameNew_Click(sender, e);
			}
		});
		//
		// mnuGameLoad
		//
		mnuGameLoad.Index = 1;
		mnuGameLoad.Shortcut = jwinforms.Shortcut.CtrlL;
		mnuGameLoad.setText("&Load...");
		mnuGameLoad.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuGameLoad_Click(sender, e);
			}
		});
		//
		// mnuGameSave
		//
		mnuGameSave.setEnabled(false);
		mnuGameSave.Index = 2;
		mnuGameSave.Shortcut = jwinforms.Shortcut.CtrlS;
		mnuGameSave.setText("&Save");
		mnuGameSave.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuGameSave_Click(sender, e);
			}
		});
		//
		// mnuGameSaveAs
		//
		mnuGameSaveAs.setEnabled(false);
		mnuGameSaveAs.Index = 3;
		mnuGameSaveAs.Shortcut = jwinforms.Shortcut.CtrlA;
		mnuGameSaveAs.setText("Save &As...");
		mnuGameSaveAs.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuGameSaveAs_Click(sender, e);
			}
		});
		//
		// mnuGameLine1
		//
		mnuGameLine1.Index = 4;
		mnuGameLine1.setText("-");
		//
		// mnuRetire
		//
		mnuRetire.setEnabled(false);
		mnuRetire.Index = 5;
		mnuRetire.setText("&Retire");
		mnuRetire.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuRetire_Click(sender, e);
			}
		});
		//
		// mnuGameLine2
		//
		mnuGameLine2.Index = 6;
		mnuGameLine2.setText("-");
		//
		// mnuGameExit
		//
		mnuGameExit.Index = 7;
		mnuGameExit.setText("E&xit");
		mnuGameExit.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuGameExit_Click(sender, e);
			}
		});
		//
		// mnuView
		//
		mnuView.Index = 1;
		mnuView.addAll(mnuViewCommander, mnuViewShip, mnuViewPersonnel, mnuViewQuests, mnuViewBank, mnuViewLine1,
				mnuHighScores, mnuViewLine2, mnuOptions);
		mnuView.setText("&View");
		//
		// mnuViewCommander
		//
		mnuViewCommander.setEnabled(false);
		mnuViewCommander.Index = 0;
		mnuViewCommander.Shortcut = jwinforms.Shortcut.CtrlC;
		mnuViewCommander.setText("&Commander Status");
		mnuViewCommander.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuViewCommander_Click(sender, e);
			}
		});
		//
		// mnuViewShip
		//
		mnuViewShip.setEnabled(false);
		mnuViewShip.Index = 1;
		mnuViewShip.Shortcut = jwinforms.Shortcut.CtrlH;
		mnuViewShip.setText("&Ship");
		mnuViewShip.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuViewShip_Click(sender, e);
			}
		});
		//
		// mnuViewPersonnel
		//
		mnuViewPersonnel.setEnabled(false);
		mnuViewPersonnel.Index = 2;
		mnuViewPersonnel.Shortcut = jwinforms.Shortcut.CtrlP;
		mnuViewPersonnel.setText("&Personnel");
		mnuViewPersonnel.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuViewPersonnel_Click(sender, e);
			}
		});
		//
		// mnuViewQuests
		//
		mnuViewQuests.setEnabled(false);
		mnuViewQuests.Index = 3;
		mnuViewQuests.Shortcut = jwinforms.Shortcut.CtrlQ;
		mnuViewQuests.setText("&Quests");
		mnuViewQuests.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuViewQuests_Click(sender, e);
			}
		});
		//
		// mnuViewBank
		//
		mnuViewBank.setEnabled(false);
		mnuViewBank.Index = 4;
		mnuViewBank.Shortcut = jwinforms.Shortcut.CtrlB;
		mnuViewBank.setText("&Bank");
		mnuViewBank.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuViewBank_Click(sender, e);
			}
		});
		//
		// mnuViewLine1
		//
		mnuViewLine1.Index = 5;
		mnuViewLine1.setText("-");
		//
		// mnuHighScores
		//
		mnuHighScores.Index = 6;
		mnuHighScores.setText("&High Scores");
		mnuHighScores.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuHighScores_Click(sender, e);
			}
		});
		//
		// mnuViewLine2
		//
		mnuViewLine2.Index = 7;
		mnuViewLine2.setText("-");
		//
		// mnuOptions
		//
		mnuOptions.Index = 8;
		mnuOptions.setText("Options");
		mnuOptions.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuOptions_Click(sender, e);
			}
		});
		//
		// mnuHelp
		//
		mnuHelp.Index = 2;
		mnuHelp.add(mnuHelpAbout);
		mnuHelp.setText("&Help");
		//
		// mnuHelpAbout
		//
		mnuHelpAbout.Index = 0;
		mnuHelpAbout.setText("&About Space Trader");
		mnuHelpAbout.setClick(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, jwinforms.EventArgs e)
			{
				mnuHelpAbout_Click(sender, e);
			}
		});
		//
		// picGalacticChart
		//
		galacticChart.InitializeComponent();
		galacticChart.setLocation(new Point(180, 306));

		//
		// statusBar
		//
		statusBar.setLocation(new Point(0, 481));
		statusBar.InitializeComponent();

		//
		// boxShortRangeChart
		//
		shortRangeChart.InitializeComponent();
		shortRangeChart.setLocation(new Point(364, 306));

		//
		// boxTargetSystem
		//
		targetSystemBox.InitializeComponent();
		targetSystemBox.setLocation(new Point(548, 306));

		//
		// boxCargo
		//
		cargoBox.InitializeComponent();
		cargoBox.setLocation(new Point(252, 2));

		//
		// boxSystem
		//
		system.InitializeComponent();
		system.setLocation(new Point(4, 2));

		//
		// boxShipYard
		//
		shipyard.InitializeComponent();
		shipyard.setLocation(new Point(4, 306));

		//
		// boxDock
		//
		dockBox.InitializeComponent();
		dockBox.setLocation(new Point(4, 212));

		//
		// picLine
		//
		picLine.setBackColor(Color.darkGray);
		picLine.setLocation(new Point(0, 0));
		picLine.setName("picLine");
		picLine.setSize(new jwinforms.Size(770, 1));
		picLine.setTabIndex(132);
		picLine.setTabStop(false);
		//
		// dlgOpen
		//
		dlgOpen.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
		//
		// dlgSave
		//
		dlgSave.setFileName("SpaceTrader.sav");
		dlgSave.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
		//
		// ilChartImages
		//
		ilChartImages.setImageSize(new jwinforms.Size(7, 7));
		ilChartImages.setImageStream(((jwinforms.ImageListStreamer)(resources.GetObject("ilChartImages.ImageStream"))));
		ilChartImages.setTransparentColor(Color.white);
		//
		// ilShipImages
		//
		ilShipImages.setImageSize(new jwinforms.Size(64, 52));
		ilShipImages.setImageStream(((jwinforms.ImageListStreamer)(resources.GetObject("ilShipImages.ImageStream"))));
		ilShipImages.setTransparentColor(Color.white);
		//
		// ilDirectionImages
		//
		ilDirectionImages.setImageSize(new jwinforms.Size(13, 13));
		ilDirectionImages.setImageStream(((jwinforms.ImageListStreamer)(resources
				.GetObject("ilDirectionImages.ImageStream"))));
		ilDirectionImages.setTransparentColor(Color.white);
		//
		// ilEquipmentImages
		//
		ilEquipmentImages.setImageSize(new jwinforms.Size(64, 52));
		ilEquipmentImages.setImageStream(((jwinforms.ImageListStreamer)(resources
				.GetObject("ilEquipmentImages.ImageStream"))));
		ilEquipmentImages.setTransparentColor(Color.white);

		//
		// SpaceTrader
		//
		this.setAutoScaleBaseSize(new jwinforms.Size(5, 13));
		this.setClientSize(new jwinforms.Size(768, 505));
		Controls.add(picLine);
		Controls.add(dockBox);
		Controls.add(cargoBox);
		Controls.add(targetSystemBox);
		Controls.add(galacticChart);
		Controls.add(shortRangeChart);
		setStatusBar(statusBar);
		Controls.add(system);
		Controls.add(shipyard);
		this.setFormBorderStyle(jwinforms.FormBorderStyle.FixedSingle);
		this.setIcon(((Icon)(resources.GetObject("$this.Icon"))));
		this.setMaximizeBox(false);
		this.setMenu(mnuMain);
		this.setName("SpaceTrader");
		this.setStartPosition(FormStartPosition.Manual);
		this.setText("Space Trader");
		this.setClosing(new jwinforms.EventHandler<Object, CancelEventArgs>()
		{
			@Override
			public void handle(Object sender, CancelEventArgs e)
			{
				SpaceTrader_Closing(sender, e);
			}
		});
		this.setClosed(new jwinforms.EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, EventArgs e)
			{
				SpaceTrader_Closed(sender, e);
			}
		});

		this.setLoad(new EventHandler<Object, EventArgs>()
		{
			@Override
			public void handle(Object sender, EventArgs e)
			{
				SpaceTrader_Load(sender, e);
			}
		});
	}

	// #endregion

	private String GetRegistrySetting(String settingName, String defaultValue)
	{
		String settingValue = defaultValue;

		try
		{
			RegistryKey key = Functions.GetRegistryKey();
			Object ObjectValue = key.GetValue(settingName);
			if (ObjectValue != null)
				settingValue = ObjectValue.toString();
			key.Close();
		} catch (NullPointerException ex)
		{
			GuiFacade.alert(AlertType.RegistryError, ex.getMessage());
		}

		return settingValue;
	}

	// Make sure all directories exists.
	private void InitFileStructure()
	{
		String[] paths = new String[] { Consts.CustomDirectory, Consts.CustomImagesDirectory,
				Consts.CustomTemplatesDirectory, Consts.DataDirectory, Consts.SaveDirectory };

		for (String path : paths)
		{
			if (!Directory.Exists(path))
				Directory.CreateDirectory(path);
		}

		dlgOpen.setInitialDirectory(Consts.SaveDirectory);
		dlgSave.setInitialDirectory(Consts.SaveDirectory);
	}

	public void SetInGameControlsEnabled(boolean enabled)
	{
		mnuGameSave.setEnabled(enabled);
		mnuGameSaveAs.setEnabled(enabled);
		mnuRetire.setEnabled(enabled);
		mnuViewCommander.setEnabled(enabled);
		mnuViewShip.setEnabled(enabled);
		mnuViewPersonnel.setEnabled(enabled);
		mnuViewQuests.setEnabled(enabled);
		mnuViewBank.setEnabled(enabled);
	}

	private void SetRegistrySetting(String settingName, String settingValue)
	{
		try
		{
			RegistryKey key = Functions.GetRegistryKey();
			key.SetValue(settingName, settingValue);
			key.Close();
		} catch (NullPointerException ex)
		{
			GuiFacade.alert(AlertType.RegistryError, ex.getMessage());
		}
	}

	public void UpdateAll()
	{
		dockBox.Update();
		cargoBox.Update();
		shipyard.Update();
		statusBar.Update();
		system.Update();
		targetSystemBox.Update();
		galacticChart.Refresh();
		shortRangeChart.Refresh();
	}

	private void SpaceTrader_Closing(Object sender, jwinforms.CancelEventArgs e)
	{
		if (game == null || commander.getDays() == controller.SaveGameDays
				|| GuiFacade.alert(AlertType.GameAbandonConfirm) == DialogResult.Yes)
		{
			if (WindowState == FormWindowState.Normal)
			{
				SetRegistrySetting("X", Left.toString());
				SetRegistrySetting("Y", Top.toString());
			}
		} else
			e.Cancel = true;
	}

	private void SpaceTrader_Closed(Object sender, jwinforms.EventArgs e)
	{
		FormsOwnerTree.pop(this);
	}

	private void SpaceTrader_Load(Object sender, jwinforms.EventArgs e)
	{
		Left = Integer.parseInt(GetRegistrySetting("X", "0"));
		Top = Integer.parseInt(GetRegistrySetting("Y", "0"));

		FormsOwnerTree.add(this);

		GuiFacade.alert(AlertType.AppStart);
	}

	private void mnuGameExit_Click(Object sender, jwinforms.EventArgs e)
	{
		Close();
	}

	private void mnuGameNew_Click(Object sender, jwinforms.EventArgs e)
	{
		FormNewCommander form = new FormNewCommander();
		if ((game == null || commander.getDays() == controller.SaveGameDays || GuiFacade.alert(AlertType.GameAbandonConfirm) == DialogResult.Yes)
				&& form.ShowDialog(this) == DialogResult.OK)
		{
			setGame(new Game(form.CommanderName(), form.Difficulty(), form.Pilot(), form.Fighter(), form.Trader(), form
					.Engineer(), this));
			controller.SaveGameFile = null;
			controller.SaveGameDays = 0;

			SetInGameControlsEnabled(true);
			UpdateAll();

			if (game.Options().getNewsAutoShow())
				game.ShowNewspaper();
		}
	}

	private void mnuGameLoad_Click(Object sender, jwinforms.EventArgs e)
	{
		if ((game == null || commander.getDays() == controller.SaveGameDays || GuiFacade.alert(AlertType.GameAbandonConfirm) == DialogResult.Yes)
				&& dlgOpen.ShowDialog(this) == DialogResult.OK)
			controller.LoadGame(dlgOpen.getFileName());
	}

	private void mnuGameSave_Click(Object sender, jwinforms.EventArgs e)
	{
		if (Game.CurrentGame() != null)
		{
			if (controller.SaveGameFile != null)
				controller.SaveGame(controller.SaveGameFile, false);
			else
				mnuGameSaveAs_Click(sender, e);
		}
	}

	private void mnuGameSaveAs_Click(Object sender, jwinforms.EventArgs e)
	{
		if (Game.CurrentGame() != null && dlgSave.ShowDialog(this) == DialogResult.OK)
			controller.SaveGame(dlgSave.getFileName(), true);
	}

	private void mnuHelpAbout_Click(Object sender, jwinforms.EventArgs e)
	{
		(new FormAbout()).ShowDialog(this);
	}

	private void mnuHighScores_Click(Object sender, jwinforms.EventArgs e)
	{
		(new FormViewHighScores()).ShowDialog(this);
	}

	private void mnuOptions_Click(Object sender, jwinforms.EventArgs e)
	{
		FormOptions form = new FormOptions();
		if (form.ShowDialog(this) == DialogResult.OK)
		{
			game.Options().CopyValues(form.Options());
			UpdateAll();
		}
	}

	private void mnuRetire_Click(Object sender, jwinforms.EventArgs e)
	{
		if (GuiFacade.alert(AlertType.GameRetire) == DialogResult.Yes)
		{
			game.setEndStatus(GameEndType.Retired);
			controller.GameEnd();
			UpdateAll();
		}
	}

	private void mnuViewBank_Click(Object sender, jwinforms.EventArgs e)
	{
		ShowBank();
	}

	public void ShowBank()
	{
		(new FormViewBank()).ShowDialog(this);
	}

	private void mnuViewCommander_Click(Object sender, jwinforms.EventArgs e)
	{
		(new FormViewCommander()).ShowDialog(this);
	}

	private void mnuViewPersonnel_Click(Object sender, jwinforms.EventArgs e)
	{
		(new FormViewPersonnel()).ShowDialog(this);
	}

	private void mnuViewQuests_Click(Object sender, jwinforms.EventArgs e)
	{
		(new FormViewQuests()).ShowDialog(this);
	}

	private void mnuViewShip_Click(Object sender, jwinforms.EventArgs e)
	{
		(new FormViewShip()).ShowDialog(this);
	}

	// #endregion

	// #region Properties

	public Image[] CustomShipImages()
	{
		Image[] images = new Image[Consts.ImagesPerShip];
		int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
		for (int index = 0; index < Consts.ImagesPerShip; index++)
			images[index] = ilShipImages.getImages()[baseIndex + index];

		return images;
	}

	public void CustomShipImages(Image[] value)
	{
		Image[] images = value;
		int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
		for (int index = 0; index < Consts.ImagesPerShip; index++)
			ilShipImages.getImages()[baseIndex + index] = images[index];
	}

	public ImageList DirectionImages()
	{
		return ilDirectionImages;
	}

	public ImageList EquipmentImages()
	{
		return ilEquipmentImages;
	}

	public ImageList ShipImages()
	{
		return ilShipImages;
	}

	public Image[] getCustomShipImages()
	{
		Image[] images = new Image[Consts.ImagesPerShip];
		int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
		for (int index = 0; index < Consts.ImagesPerShip; index++)
			images[index] = ilShipImages.getImages()[baseIndex + index];

		return images;
	}

	public void setCustomShipImages(Image[] value)
	{
		Image[] images = value;
		int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
		for (int index = 0; index < Consts.ImagesPerShip; index++)
			ilShipImages.getImages()[baseIndex + index] = images[index];
	}

	// #endregion

	public void setGame(Game game)
	{
		this.game = game;
		controller = new GameController(game, this);
		commander = game == null ? null : game.Commander();

		dockBox.setGame(commander);
		cargoBox.setGame(game, controller);
		targetSystemBox.setGame(game, controller, commander);
		galacticChart.setGame(game, controller, commander);
		shortRangeChart.setGame(game, commander);
		system.setGame(game, controller, commander);
		shipyard.setGame(commander);
		statusBar.setGame(commander);
	}

	/**
	 * TODO remove?
	 */
	public void UpdateStatusBar()
	{
		statusBar.Update();
	}
}
