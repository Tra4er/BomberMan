package com.bomberman.util;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RoundTimer extends JLabel {

	private static final long serialVersionUID = 1992980785863309224L;

	public RoundTimer(Timer timer) {
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}

	private TimerTask timerTask = new TimerTask() {
		private int time = -1;

		private Runnable refresher = new Runnable() {
			@Override
			public void run() {
				int t = time;
				RoundTimer.this.setText(String.format("%02d:%02d", t / 60, t % 60));
			}
		};

		@Override
		public void run() {
			time++;
			SwingUtilities.invokeLater(refresher);
		}
	};
}
