package spacetrader.gui;

import java.awt.Color;
import java.awt.Point;

import jwinforms.*;
import spacetrader.*;
import spacetrader.enums.StarSystemId;

public class ShortRangeChart extends jwinforms.GroupBox
{
	private SystemTracker game = null;
	private Commander commander;

	void setGame(SystemTracker game, Commander commander)
	{
		this.game = game;
		this.commander = commander;
	}

	private final SpaceTrader mainWindow;

	public ShortRangeChart(SpaceTrader mainWindow, jwinforms.ImageList images)
	{
		this.mainWindow = mainWindow;
		ilChartImages = images;
	}

	private jwinforms.PictureBox picShortRangeChart;
	private final jwinforms.ImageList ilChartImages;

	void InitializeComponent()
	{
		picShortRangeChart = new jwinforms.PictureBox();

		//
		// picShortRangeChart
		//

		picShortRangeChart.setBackColor(Color.white);
		picShortRangeChart.setLocation(new Point(8, 16));
		picShortRangeChart.setName("picShortRangeChart");
		picShortRangeChart.setSize(new jwinforms.Size(160, 145));
		picShortRangeChart.setTabIndex(1);
		picShortRangeChart.setTabStop(false);
		picShortRangeChart.setPaint(new jwinforms.EventHandler<Object, PaintEventArgs>()
		{
			@Override
			public void handle(Object sender, PaintEventArgs e)
			{
				picShortRangeChart_Paint(sender, e);
			}
		});
		picShortRangeChart.setMouseDown(new jwinforms.EventHandler<Object, MouseEventArgs>()
		{
			@Override
			public void handle(Object sender, MouseEventArgs e)
			{
				picShortRangeChart_MouseDown(sender, e);
			}
		});

		Anchor = (((jwinforms.AnchorStyles.Top_Right)));
		Controls.add(picShortRangeChart);
		setName("boxShortRangeChart");
		setSize(new jwinforms.Size(176, 168));
		setTabIndex(6);
		setTabStop(false);
		setText("Short-Range Chart");

		fixFonts(super.getFont());
	}

	private final int OFF_X = ChartsGraphicsConsts.OFF_X;
	private final int OFF_Y = ChartsGraphicsConsts.OFF_Y;
	private final int IMG_G_N = ChartsGraphicsConsts.IMG_G_N;
	private final int IMG_G_V = ChartsGraphicsConsts.IMG_G_V;
	private final int IMG_G_W = ChartsGraphicsConsts.IMG_G_W;
	private final Pen DEFAULT_PEN = new Pen(Color.black);
	private final Brush DEFAULT_BRUSH = new SolidBrush(Color.white);

	private void picShortRangeChart_MouseDown(Object sender, jwinforms.MouseEventArgs e)
	{
		if (e.Button == MouseButtons.Left && game != null)
		{
			StarSystem[] universe = game.Universe();
			StarSystem curSys = commander.getCurrentSystem();

			boolean clickedSystem = false;
			int centerX = picShortRangeChart.getWidth() / 2;
			int centerY = picShortRangeChart.getHeight() / 2;
			int delta = picShortRangeChart.getHeight() / (Consts.MaxRange * 2);

			for (int i = 0; i < universe.length && !clickedSystem; i++)
			{
				if ((Math.abs(universe[i].X() - curSys.X()) * delta <= picShortRangeChart.getWidth() / 2 - 10)
						&& (Math.abs(universe[i].Y() - curSys.Y()) * delta <= picShortRangeChart.getHeight() / 2 - 10))
				{
					int x = centerX + (universe[i].X() - curSys.X()) * delta;
					int y = centerY + (universe[i].Y() - curSys.Y()) * delta;

					if (e.X >= x - OFF_X && e.X <= x + OFF_X && e.Y >= y - OFF_Y && e.Y <= y + OFF_Y)
					{
						clickedSystem = true;
						game.SelectedSystemId(StarSystemId.FromInt(i));
					} else if (Functions.WormholeExists(i, -1))
					{
						int xW = x + 9;

						if (e.X >= xW - OFF_X && e.X <= xW + OFF_X && e.Y >= y - OFF_Y && e.Y <= y + OFF_Y)
						{
							clickedSystem = true;
							game.SelectedSystemId((StarSystemId.FromInt(i)));
							game.TargetWormhole(true);
						}
					}
				}
			}

			if (clickedSystem)
				UpdateAll();
		}
	}

	private void UpdateAll()
	{
		// todo inline when done
		mainWindow.UpdateAll();
	}

	private void picShortRangeChart_Paint(Object sender, jwinforms.PaintEventArgs e)
	{
		if (game != null)
		{
			StarSystem[] universe = game.Universe();
			int[] wormholes = game.Wormholes();
			StarSystem trackSys = game.TrackedSystem();
			StarSystem curSys = commander.getCurrentSystem();
			int fuel = commander.getShip().getFuel();

			int centerX = picShortRangeChart.getWidth() / 2;
			int centerY = picShortRangeChart.getHeight() / 2;
			int delta = picShortRangeChart.getHeight() / (Consts.MaxRange * 2);

			e.Graphics.DrawLine(DEFAULT_PEN, centerX - 1, centerY - 1, centerX + 1, centerY + 1);
			e.Graphics.DrawLine(DEFAULT_PEN, centerX - 1, centerY + 1, centerX + 1, centerY - 1);
			if (fuel > 0)
				e.Graphics.DrawEllipse(DEFAULT_PEN, centerX - fuel * delta, centerY - fuel * delta, fuel * delta * 2,
						fuel * delta * 2);

			if (trackSys != null)
			{
				int dist = Functions.Distance(curSys, trackSys);
				if (dist > 0)
				{
					int dX = (int)Math.round(25 * (trackSys.X() - curSys.X()) / (double)dist);
					int dY = (int)Math.round(25 * (trackSys.Y() - curSys.Y()) / (double)dist);

					int dX2 = (int)Math.round(4 * (trackSys.Y() - curSys.Y()) / (double)dist);
					int dY2 = (int)Math.round(4 * (curSys.X() - trackSys.X()) / (double)dist);

					e.Graphics.FillPolygon(new SolidBrush(new Color(220, 20, 60)), new Point[] {
							new Point(centerX + dX, centerY + dY), new Point(centerX - dX2, centerY - dY2),
							new Point(centerX + dX2, centerY + dY2) });
				}

				if (game.isShowTrackedRange())
					e.Graphics.DrawString(Functions.StringVars(Strings.ChartDistance, Functions.Multiples(dist,
							Strings.DistanceUnit), trackSys.Name()), font, new SolidBrush(Color.black), 0,
							picShortRangeChart.getHeight() - 13);
			}

			// Two loops: first draw the names and then the systems. The names
			// may
			// overlap and the systems may be drawn on the names, but at least
			// every
			// system is visible.
			for (int j = 0; j < 2; j++)
			{
				for (int i = 0; i < universe.length; i++)
				{
					if ((Math.abs(universe[i].X() - curSys.X()) * delta <= picShortRangeChart.getWidth() / 2 - 10)
							&& (Math.abs(universe[i].Y() - curSys.Y()) * delta <= picShortRangeChart.getHeight() / 2 - 10))
					{
						int x = centerX + (universe[i].X() - curSys.X()) * delta;
						int y = centerY + (universe[i].Y() - curSys.Y()) * delta;

						if (j == 1)
						{
							if (universe[i] == game.WarpSystem())
							{
								e.Graphics.DrawLine(DEFAULT_PEN, x - 6, y, x + 6, y);
								e.Graphics.DrawLine(DEFAULT_PEN, x, y - 6, x, y + 6);
							}

							if (universe[i] == game.TrackedSystem())
							{
								e.Graphics.DrawLine(DEFAULT_PEN, x - 5, y - 5, x + 5, y + 5);
								e.Graphics.DrawLine(DEFAULT_PEN, x - 5, y + 5, x + 5, y - 5);
							}

							ilChartImages.Draw(e.Graphics, x - OFF_X, y - OFF_Y, universe[i].Visited() ? IMG_G_V
									: IMG_G_N);

							if (Functions.WormholeExists(i, -1))
							{
								int xW = x + 9;
								if (game.TargetWormhole() && universe[i] == game.SelectedSystem())
								{
									e.Graphics.DrawLine(DEFAULT_PEN, xW - 6, y, xW + 6, y);
									e.Graphics.DrawLine(DEFAULT_PEN, xW, y - 6, xW, y + 6);
								}
								ilChartImages.Draw(e.Graphics, xW - OFF_X, y - OFF_Y, IMG_G_W);
							}
						} else
						{
							SizeF size = e.Graphics.MeasureString(universe[i].Name(), getFont());
							e.Graphics.DrawString(universe[i].Name(), smallFont, new SolidBrush(Color.black), x
									- size.width / 2 + OFF_X, y /*- size.Height*/- 5);
							// implementations differ as to which point we start the string at. --aviv
						}
					}
				}
			}
		} else
			e.Graphics
					.FillRectangle(DEFAULT_BRUSH, 0, 0, picShortRangeChart.getWidth(), picShortRangeChart.getHeight());
	}

	public void Refresh()
	{
		picShortRangeChart.Refresh();
	}

	private Font font;
	private Font smallFont;

	@Override
	public void setFont(Font font)
	{
		fixFonts(font);
		super.setFont(font);
	}

	private void fixFonts(Font base)
	{
		font = base;
		smallFont = base == null ? null : new Font(base.FontFamily, 7);
	}
}
