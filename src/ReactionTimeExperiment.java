import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.border.*;

/**
 * ReactionTimeExperiment - experiment software to measure various reaction time operations.
 * <p>
 * 
 * Five reaction-time operations are implemented:
 * <p>
 * 
 * <ul>
 * <li>Simple Reaction
 * <li>Physical Matching
 * <li>Name Matching
 * <li>Class Matching
 * <li>Visual Search
 * </ul>
 * 
 * For all operations except simple reaction, an initial visual stimulus is presented showing a code
 * (a letter, digit, or word) which the user perceives and stores in short-term memory. Following a
 * random delay of 2 to 5 seconds a second stimulus appears whereupon the user performs a cognitive
 * operation and then presses a key as quickly as possible according to the criterion of the
 * operation.
 * <p>
 * 
 * <h3>Related reference</h3>
 * 
 * <ul>
 * <li>
 * "The Psychology of Human-Computer Interaction", by Card, Moran, and Newell (1983), pages 65-76.
 * The first four operations are described in CM&N. The visual search operation is a variation of
 * the choice reaction time operation described in CM&N. Here, the emphasis is visual search rather
 * than choice reaction.
 * </ul>
 * 
 * <h3>Running the experiment software</h3>
 * <p>
 * 
 * <a href="http://www.yorku.ca/mack/HCIbook/Running/">Click here</a> for instructions on
 * launching/running the application.
 * <p>
 * 
 * Upon launching, the following setup dialog appears:
 * <p>
 * 
 * <center><img src="ReactionTimeExperiment-setup.jpg"></center>
 * <p>
 * 
 * The experimenter selects a participant code, a block code, the number of trials, and the reaction
 * time mode. The participant code and block code are used in naming the output data files. The
 * default number of trials in a block is 10. For the Visual Search mode, an additional selection is
 * required to choose the number of search items. Clicking "OK" begins a block of trials.
 * <p>
 * 
 * The operating modes are now described:
 * <p>
 * 
 * <h3>Simple reaction</h3> <center><img src="ReactionTimeExperiment-sr1.jpg"> <img
 * src="ReactionTimeExperiment-sr2.jpg"></center>
 * <p>
 * 
 * A window appears containing a grey box in the centre. This is the initial stimulus. After a
 * delay, the box turns red whereupon the user presses a key as quickly as possible. Any key may be
 * pressed.
 * <p>
 * 
 * <h3>Physical matching</h3> <center><img src="ReactionTimeExperiment-pm1.jpg"> <img
 * src="ReactionTimeExperiment-pm2.jpg"></center>
 * <p>
 * The initial stimulus is a five-letter word. After a delay, the second stimulus appears. The
 * second stimulus is also a five-letter word. Both words are presented in lowercase. If the second
 * word matches the first, the user presses "f" or "j" on the keyboard. If the second word does not
 * match the first, any other key is pressed.
 * <p>
 * 
 * For each trial, there is a 50% probability of a match. For trials in a block, half are match
 * trials and half are no-match trials.
 * <p>
 * 
 * A reasonable procedure for this mode (and the others below) is to instruct participants to
 * position their dominant hand on the home row of the system keyboard. Left-handed users can press
 * "f" with the index finger for a match, or "d" with the middle finger for no-match. Right-handed
 * users can press "j" with the index finger for a match or "k" with the middle finger for no-match.
 * See below:
 * <p>
 * 
 * <center> <img src="ReactionTimeExperiment-lefthand.jpg"> &nbsp;&nbsp;&nbsp;&nbsp; <img
 * src="ReactionTimeExperiment-righthand.jpg"> </center>
 * <p>
 * 
 * <h3>Name matching</h3> 
 * 
 * <center><img src="ReactionTimeExperiment-nm1.jpg"> <img
 * src="ReactionTimeExperiment-nm2.jpg"></center>
 * <p>
 * 
 * Name matching is the same as physical matching except the words may appear in uppercase or
 * lowercase, monospaced or sans serif, plain or bold, 18 point or 20 point. A match is deemed to
 * occur if the words are the same, regardless of the look.
 * <p>
 * 
 * For each trial, there is a 50% probability of a match. For trials in a block, half are match
 * trials and half are no-match trials.
 * <p>
 * 
 * Name matching takes longer than physical matching because an extra cognitive operation is
 * required to deduce equivalence (see Card et al., 1983, p. 69).
 * 
 * <h3>Class matching</h3> 
 * 
 * <center><img src="ReactionTimeExperiment-cm1.jpg"> <img
 * src="ReactionTimeExperiment-cm2.jpg"></center>
 * <p>
 * 
 * The initial stimulus contains a letter or digit. After a delay a second stimulus appears also
 * containing a letter or digit. The font is monospaced or sans serif, plain or italic, 18 pt or 20
 * pt. A match is deemed to occur if both symbols are of the same class; that is, both are letters
 * or both are digits.
 * <p>
 * 
 * To avoid confusion, 0 (digit) and O (letter) are not included, nor are 1 (digit) and I (letter).
 * <p>
 * 
 * For each trial, there is a 50% probability of a match. For trials in a block, half are match
 * trials and half are no-match trials.
 * <p>
 * 
 * Class matching takes longer than name matching because
 * "the user has to make multiple references to long-term memory" (Card et al., 1983, p. 70).
 * 
 * 
 * <h3>Visual Search</h3> <center><img src="ReactionTimeExperiment-vs1.jpg"> <img
 * src="ReactionTimeExperiment-vs2.jpg"></center>
 * <p>
 * 
 * The visual search mode requires specifying through the setup dialog a search space of 1, 2, 4, 8,
 * 16, or 32 items. (A choice of 16 is shown in the above screen snap.)
 * <p>
 * 
 * The initial stimulus contains a letter. After a delay the squares in the search space are
 * populated with letters selected a random. A match is deemed to occur if the initial letter
 * appears in the search space.
 * <p>
 * 
 * For each trial, there is a 50% probability of a match. For trials in a block, half are match
 * trials and half are no-match trials.
 * <p>
 * 
 * Note that visual searching with <i>n</i> = 1 is the same as physical matching. As implemented
 * here, the only difference is that the physical matching mode uses five-letter words whereas the
 * visual searching mode uses single letters.
 * <p>
 * 
 * <h3>Data and results</h3>
 * At the end of a block of trials, a popup dialog appears showing summary results. The following is
 * an example for the simple reaction time mode:
 * <p>
 * 
 * <center><img src="ReactionTimeExperiment-results-sr.jpg"></center>
 * <p>
 * 
 * The data are saved in two output files. An "sd1" file contains the data on a per-trial basis. An
 * "sd2" file contains summary data for the block. The data corresponding to the above dialog are as
 * follows:
 * <p>
 * 
 * SD1 data file:
 * <p>
 * 
 * <pre>
*     time,313,265,219,234,250,250,313,250,250,266 
* </pre>
 * <p>
 * 
 * SD2 data file:
 * <p>
 * 
 * <pre>
*     Participant,Block,Mode,mean,min,max,sd
*     P00,B00,SR,261.0,219,313,30.597748646301124
* </pre>
 * <p>
 * 
 * The data files are more elaborate for the other modes, since two different keys are used and the
 * possibility of errors exists. Furthermore, the reaction times may be different depending on
 * whether or not a match occurred. This is particularly true for the visual search mode, since
 * deducing no-match requires an exhaustive search whereas deducing a match only requires a partial
 * search. (The search ends when the letter is found.) An example of the results for the visual
 * search mode with <i>n</i> = 16 follows.
 * <p>
 * 
 * <center><img src="ReactionTimeExperiment-results-vs.jpg"></center>
 * <p>
 * 
 * SD1 data file:
 * <p>
 * 
 * <pre>
*     times,2188,1078,1187,1156,1313,1656,1782,1875,1391,1734,
*     keys,k,k,k,k,j,j,k,k,j,k,
*     match,0,1,0,0,1,1,0,1,1,0,
*     errors,0,1,0,0,0,0,0,1,0,0,
* </pre>
 * 
 * SD2 data file:
 * <p>
 * 
 * <pre>
*     Participant,Block,Mode,Number_of_Items,total_time,total_errors,total_match_time,n_match,n_match_errors,total_no-match_time,n_no-match,n_no-match_errors
*     P00,B00,VS,16,15360.0,2,7313.0,5,2,8047.0,5,0
* </pre>
 * 
 * <h3>Time measurements</h3>
 * 
 * Time measurements begin with the presentation of the second stimulus and end with the button-down
 * action in response to the stimulus:
 * <p>
 * 
 * <center> <img src="ReactionTimeExperiment-timing1.jpg"> </center>
 * <p>
 * 
 * Thus, the measurement includes both the time to react and the time to move the finger to a button
 * and press down the button. Videotaped analyses using VirtualDub reveal typically 10 frames from
 * the first movement of the finger to the dispatch of the button-down event. At 60 frames/s, this
 * is equivalent to 167 ms &#177;16.7 ms:
 * <p>
 * 
 * <center> <img src="ReactionTimeExperiment-timing2.jpg"> </center>
 * <p>
 * 
 * This may be important, depending on how the data from this software are interpreted. For example,
 * reaction time is typically defined as the time between the occurrence of a stimulus and the
 * <i>initiation</i> of a response assigned to it (Posner and Fitts, 1986, p. 95). If the objective
 * is to measure reaction time alone, then it is important to bear in mind that the measurements
 * include the time for a key press &mdash; about 167 ms.
 * <p>
 * 
 * When using this program in an experiment, it is a good idea to terminate all other applications
 * and disable the system's network connection. This will maintain the integrity of the data
 * collected and ensure that the program runs without hesitations.
 * <p>
 * 
 * @see <a href="ReactionTimeExperiment.java">source code</a>
 * @author Scott MacKenzie, 2008-2014
 * @author Steven Castellucci, 2014
 */
public class ReactionTimeExperiment
{
	public static void main(String[] args)
	{
		// use look and feel for my system (Win32)
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e)
		{
		}

		// use setup to configure program
		ReactionTimeExperimentConfiguration c = new ReactionTimeExperimentConfiguration();
		ReactionTimeExperimentSetup s = new ReactionTimeExperimentSetup(null, c);
		s.showLetterGuessingExperimentSetup(null);

		ReactionTimeExpFrame frame = new ReactionTimeExpFrame(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ReactionTimeExperiment");
		frame.pack();

		Dimension d1 = frame.getSize();
		Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d2.width - d1.width) / 2;
		int y = (d2.height - d1.height) / 2;
		frame.setLocation(new Point(x, y));
		frame.setVisible(true);
	}
}

// -----------------------------
// define the application window
// -----------------------------

class ReactionTimeExpFrame extends JFrame
{
	// -----------------------------------------------------------------
	// declare variables and components accessed by more than one method
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	SRDialog sr; // simple reaction
	PMDialog pm; // physical matching
	NMDialog nm; // name matching
	CMDialog cm; // class matching
	VSDialog vs; // visual search
	String[] word;
	int numberOfItems;
	int maxTrials;
	String modeName;

	JDialog resultsDialog;
	JOptionPane resultsPane;
	JTextArea resultsArea;

	final Dimension D = new Dimension(300, 200); // experiment panel size

	// private long t1;
	// private long t2;
	boolean begin = false;

	int[] time;
	char[] key;
	int[] match;
	int[] error;
	int count = 0;
	BufferedWriter bw1;
	BufferedWriter bw2;
	String mode;
	String participantCode;
	String blockCode;

	// -----------
	// constructor
	// -----------

	public ReactionTimeExpFrame(ReactionTimeExperimentConfiguration c)
	{
		// --------------------------------------
		// declare and initialize local variables
		// --------------------------------------

		participantCode = c.getParticipantCode() < 10 ? "P0" + c.getParticipantCode() : "P" + c.getParticipantCode();
		blockCode = c.getBlockCode() < 10 ? "B0" + c.getBlockCode() : "B" + c.getBlockCode();
		maxTrials = c.getNumberOfTrials();
		// System.out.println("maxTrials=" + maxTrials);
		if (maxTrials == 0)
		{
			showError("Oops! Try again with number_of_trials > 0");
			System.exit(0);
		}
		mode = c.getMode();
		modeName = c.getModeName();
		numberOfItems = c.getNumberOfItems();

		time = new int[maxTrials];
		key = new char[maxTrials];
		match = new int[maxTrials];
		error = new int[maxTrials];

		// String modeInstructions = "";

		// -------------------------------
		// create and configure components
		// -------------------------------

		sr = new SRDialog(this); // simple reaction
		pm = new PMDialog(this); // physical matching
		nm = new NMDialog(this); // name matcing
		cm = new CMDialog(this); // class matching
		vs = new VSDialog(this, c.getNumberOfItems()); // visual search

		// read 5-letter words into array...
		BufferedReader br = null;
		try
		{
			// br = new BufferedReader(new FileReader("d1-word.txt"));
			// Added for executable Jar:
			br = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
					.getResourceAsStream("d1-word.txt")));
		} catch (Exception e)
		{
			showError("File not found: " + "d1-word.txt");
			System.exit(0);
		}
		Vector<String> v = new Vector<String>();
		String s = "";
		try
		{
			while ((s = br.readLine()) != null)
				if (s.length() == 5)
					v.add(s);
		} catch (IOException e)
		{
			showError("Error reading word file!");
			System.exit(0);
		}
		word = new String[v.size()];
		v.copyInto(word);
		// ... done

		resultsArea = new JTextArea(9, 20);
		resultsArea.setFont(new Font("sansserif", Font.PLAIN, 18));
		resultsArea.setBackground((new JButton()).getBackground());
		resultsPane = new JOptionPane(resultsArea, JOptionPane.INFORMATION_MESSAGE);
		resultsPane.setFont(new Font("sansserif", Font.PLAIN, 18));
		resultsDialog = resultsPane.createDialog(this, "Information");

		// open output data files
		try
		{
			String base = "ReactionTimeExperiment-" + participantCode + "-" + blockCode + "-" + mode;
			if (mode.equals("VS"))
				base += "-" + numberOfItems;
			bw1 = new BufferedWriter(new FileWriter(base + ".sd1"));
			bw2 = new BufferedWriter(new FileWriter(base + ".sd2"));
			String header = "";
			if (mode.equals("SR"))
				header = sr.SD2Header();
			else if (mode.equals("PM"))
				header = pm.SD2Header();
			else if (mode.equals("CM"))
				header = cm.SD2Header();
			else if (mode.equals("VS"))
				header = vs.SD2Header();
			bw2.write(header, 0, header.length());
			bw2.flush();
		} catch (IOException e)
		{
			showError("I/O error: can't open output data file(s)");
			System.exit(0);
		}

		// Now, determine mode and show appropriate dialog
		if (mode.equals("SR"))
		{
			sr.showSRDialog(this); // Simple Reaction Time Experiment

			try
			{
				s = sr.SD1Results();
				bw1.write(s, 0, s.length());
				bw1.flush();
				s = sr.SD2Results();
				bw2.write(s, 0, s.length());
				bw2.flush();
			} catch (IOException e)
			{
				showError("I/O error writing to output data file");
				System.exit(0);
			}
			showResults(modeName);
		} else if (mode.equals("PM"))
		{
			pm.showPMDialog(this); // Physical Matching Experiment

			try
			{
				s = pm.SD1Results();
				bw1.write(s, 0, s.length());
				bw1.flush();
				s = pm.SD2Results();
				bw2.write(s, 0, s.length());
				bw2.flush();
			} catch (IOException e)
			{
				showError("I/O error writing to output data file");
				System.exit(0);
			}
			showResults(modeName);
		} else if (mode.equals("NM"))
		{
			nm.showNMDialog(this); // Name Matching Experiment

			try
			{
				s = nm.SD1Results();
				bw1.write(s, 0, s.length());
				bw1.flush();
				s = nm.SD2Results();
				bw2.write(s, 0, s.length());
				bw2.flush();
			} catch (IOException e)
			{
				showError("I/O error writing to output data file");
				System.exit(0);
			}
			showResults(modeName);
		} else if (mode.equals("CM"))
		{
			cm.showCMDialog(this); // Class Matching Experiment

			try
			{
				s = cm.SD1Results();
				bw1.write(s, 0, s.length());
				bw1.flush();
				s = cm.SD2Results();
				bw2.write(s, 0, s.length());
				bw2.flush();
			} catch (IOException e)
			{
				showError("I/O error writing to output data file");
				System.exit(0);
			}
			showResults(modeName);
		} else if (mode.equals("VS"))
		{
			vs.showVSDialog(this); // Choice Reaction Time Experiment

			try
			{
				s = vs.SD1Results();
				bw1.write(s, 0, s.length());
				bw1.flush();
				s = vs.SD2Results();
				bw2.write(s, 0, s.length());
				bw2.flush();
			} catch (IOException e)
			{
				showError("I/O error writing to output data file");
				System.exit(0);
			}
			showResults(modeName);
		}
		System.exit(0); // probably a dumb way to exit, but it works!
	} // end of constructor

	void showError(String msg)
	{
		JOptionPane.showMessageDialog(null, msg, "I/O Error", JOptionPane.ERROR_MESSAGE);
	}

	void showResults(String mode)
	{
		String s = "Thank you!\n\n";
		s += String.format("  *** %s ***\n", mode);
		s += String.format("  Mean RT = %1.1f ms\n", mean(time));
		s += String.format("  min = %d ms\n", min(time));
		s += String.format("  max = %d ms\n", max(time));
		s += String.format("  SD = %1.2f ms\n", sd(time));
		s += String.format("  Errors = %d", (int)(mean(error) * error.length));
		resultsArea.setText(s);
		resultsDialog.setVisible(true);
	}

	Font getRandomFont()
	{
		Random r = new Random();
		String name = r.nextBoolean() ? "monospaced" : "sansserif";
		int style = r.nextBoolean() ? Font.PLAIN : Font.BOLD;
		int size = r.nextBoolean() ? 18 : 20;
		return new Font(name, style, size);
	}

	// calculate the mean of the values in an integer array
	public double mean(int n[])
	{
		double mean = 0.0;
		for (int j = 0; j < n.length; j++)
			mean += n[j];
		return mean / n.length;
	}

	// calculate the standard deviation of values in an integer array
	public double sd(int[] n)
	{
		double m = mean(n);
		double t = 0.0;
		for (int j = 0; j < n.length; j++)
			t += (m - n[j]) * (m - n[j]);
		return Math.sqrt(t / (n.length - 1.0));
	}

	// find the minimum value in an integer array
	public int min(int[] n)
	{
		int min = n[0];
		for (int j = 1; j < n.length; j++)
			if (n[j] < min)
				min = n[j];
		return min;
	}

	// find the maximum value in an integer array
	public int max(int[] n)
	{
		int max = n[0];
		for (int j = 1; j < n.length; j++)
			if (n[j] > max)
				max = n[j];
		return max;
	}

	// --------------------
	// Define inner classes
	// --------------------

	// --------------------------------------
	// Simple Reaction Time experiment dialog
	// --------------------------------------
	private class SRDialog extends JDialog implements ActionListener, KeyListener
	{
		private static final long serialVersionUID = 1L;

		Timer t;
		Random r;
		JPanel experimentPanel;
		JPanel stimulusPanel;
		long t1 = 0;
		boolean begin;

		SRDialog(Frame owner)
		{
			super(owner, "Simple Reaction Time", true);
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			t = new Timer(2000, this);
			r = new Random();
			begin = false;

			stimulusPanel = new JPanel();
			stimulusPanel.setBackground(Color.gray);
			stimulusPanel.setPreferredSize(new Dimension(50, 50));
			stimulusPanel.setMaximumSize(stimulusPanel.getPreferredSize());
			stimulusPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

			experimentPanel = new JPanel();
			experimentPanel.setLayout(new BoxLayout(experimentPanel, BoxLayout.Y_AXIS));
			experimentPanel.setPreferredSize(new Dimension(200, 200));
			experimentPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(stimulusPanel);
			experimentPanel.add(Box.createVerticalGlue());

			this.addKeyListener(this);

			this.setContentPane(experimentPanel);
			this.pack();
		}

		public int showSRDialog(Frame f)
		{
			count = 0;
			stimulusPanel.setBackground(Color.gray);
			this.setLocationRelativeTo(f);
			t.restart();
			begin = false; // don't think this is needed!?
			this.setVisible(true);
			return -1;
		}

		public void actionPerformed(ActionEvent ae)
		{
			// System.out.println("Action event");
			stimulusPanel.setBackground(Color.red);
			t1 = System.currentTimeMillis();
			begin = true;
		}

		public void keyPressed(KeyEvent ke)
		{
			// System.out.println("Key pressed event");
			if (!begin)
			{
				ke.consume();
				return;
			}
			time[count++] = (int)(System.currentTimeMillis() - t1);
			if (count == maxTrials)
			{
				begin = false;
				stimulusPanel.setBackground(Color.gray);
				this.setVisible(false); // does this cause an immediate return!?
			} else
			{
				t.setInitialDelay(2000 + r.nextInt(3000));
				t.restart();
				stimulusPanel.setBackground(Color.gray);
				begin = false;
			}
		}

		public void keyTyped(KeyEvent ke)
		{
		}

		public void keyReleased(KeyEvent ke)
		{
		}

		public String SD1Results()
		{
			String s = "time";
			for (int i = 0; i < time.length; ++i)
				s += "," + time[i];
			s += "\n";
			return s;
		}

		public String SD2Results()
		{
			return String.format("%s,%s,%s,%f,%d,%d,%f", participantCode, blockCode, mode, mean(time), min(time),
					max(time), sd(time));			
		}

		public String SD2Header()
		{
			return "Participant,Block,Mode,mean,min,max,sd\n";
		}
	}

	// -----------------------------------
	// Physical Matching experiment dialog
	// -----------------------------------
	private class PMDialog extends JDialog implements ActionListener, KeyListener
	{
		private static final long serialVersionUID = 1L;

		Timer t;
		Random r;
		JPanel experimentPanel;
		JLabel s1Label;
		JLabel s2Label;
		JPanel sPanel;
		long t1 = 0;
		RandomBooleanArray rba;

		PMDialog(Frame owner)
		{
			super(owner, "Physical Matching", true);
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			rba = new RandomBooleanArray(maxTrials);
			t = new Timer(2000, this);
			r = new Random();

			final Font F18 = new Font("sansserif", Font.PLAIN, 18);
			final Dimension D = new Dimension(90, 30);
			s1Label = new JLabel("          ", SwingConstants.CENTER);
			s1Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s1Label.setPreferredSize(D);
			s1Label.setMaximumSize(D);
			s1Label.setFont(F18);

			s2Label = new JLabel("          ", SwingConstants.CENTER);
			s2Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s2Label.setPreferredSize(D);
			s2Label.setMaximumSize(D);
			s2Label.setFont(F18);

			sPanel = new JPanel();
			sPanel.add(s1Label);
			sPanel.add(s2Label);

			experimentPanel = new JPanel();
			experimentPanel.setLayout(new BoxLayout(experimentPanel, BoxLayout.Y_AXIS));
			experimentPanel.setPreferredSize(new Dimension(200, 200));
			experimentPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(sPanel);
			experimentPanel.add(Box.createVerticalGlue());

			this.addKeyListener(this);

			this.setContentPane(experimentPanel);
			this.pack();
		}

		public int showPMDialog(Frame f)
		{
			rba.shuffle();
			count = 0;
			s1Label.setBackground(Color.gray);
			this.setLocationRelativeTo(f);
			t.restart();
			s1Label.setText("");
			s2Label.setText("");
			this.setVisible(true);
			t.stop();
			return -1;
		}

		boolean armed = false;
		String w1 = "";
		String w2 = "";

		public void actionPerformed(ActionEvent ae)
		{
			if (!armed)
			{
				w1 = word[r.nextInt(word.length)];
				s1Label.setText(w1);
				t.setInitialDelay(2000 + r.nextInt(3000));
				t.restart();
				armed = true;
			} else
			{
				t.stop();
				w2 = word[r.nextInt(word.length)];
				if (rba.nextBooleanArrayEntry())
					s2Label.setText(w1);
				else
					s2Label.setText(w2);
				t1 = System.currentTimeMillis();
			}
		}

		public void keyPressed(KeyEvent ke)
		{
			time[count] = (int)(System.currentTimeMillis() - t1);
			key[count] = Character.toLowerCase(ke.getKeyChar());
			match[count] = s1Label.getText().equals(s2Label.getText()) ? 1 : 0;
			error[count] = match[count] == 1 && (key[count] != 'j' && key[count] != 'f') || match[count] == 0
					&& (key[count] == 'j' || key[count] == 'f') ? 1 : 0;
			++count;
			if (count == maxTrials)
			{
				this.setVisible(false);
				rba = new RandomBooleanArray(maxTrials);
			}

			t.setInitialDelay(2000);
			t.restart();
			s1Label.setText("");
			s2Label.setText("");
			armed = false;
		}

		public void keyTyped(KeyEvent ke)
		{
		}

		public void keyReleased(KeyEvent ke)
		{
		}

		public String SD1Results()
		{
			String s = "";
			s += "time";
			for (int i = 0; i < time.length; ++i)
				s += "," + time[i];
			s += "\n";
			s += "keys,";
			for (int i = 0; i < time.length; ++i)
				s += key[i] + ",";
			s += "\n";
			s += "matches,";
			for (int i = 0; i < time.length; ++i)
				s += match[i] + ",";
			s += "\n";
			s += "errors,";
			for (int i = 0; i < time.length; ++i)
				s += error[i] + ",";
			s += "\n";
			return s;
		}

		public String SD2Results()
		{
			double meanMatchTime = 0.0;
			double meanNoMatchTime = 0.0;
			int nMatch = 0;
			int nNoMatch = 0;
			int nMatchError = 0;
			int nNoMatchError = 0;
			for (int i = 0; i < time.length; ++i)
			{
				if (match[i] == 1) // match
				{
					if (error[i] == 0)
					{
						meanMatchTime += time[i];
						++nMatch;
					} else
						++nMatchError;
				} else
				// no match
				{
					if (error[i] == 0)
					{
						meanNoMatchTime += time[i];
						++nNoMatch;
					} else
						++nNoMatchError;
				}
			}
			meanMatchTime /= nMatch;
			meanNoMatchTime /= nNoMatch;

			return participantCode + "," + blockCode + "," + mode + "," + meanMatchTime + "," + nMatch + ","
					+ nMatchError + "," + meanNoMatchTime + "," + nNoMatch + "," + nNoMatchError;
		}

		public String SD2Header()
		{
			return "Participant,Block,Mode,RT_match,n_match,error_match," + "RT_no-match,n_no-match,error_no-match\n";
		}
	}

	// -------------------------------
	// Name Matching experiment dialog
	// -------------------------------
	private class NMDialog extends JDialog implements ActionListener, KeyListener
	{
		private static final long serialVersionUID = 1L;

		Timer t;
		Random r;
		JPanel experimentPanel;
		JLabel s1Label;
		JLabel s2Label;
		JPanel sPanel;
		long t1 = 0;
		RandomBooleanArray rba;

		NMDialog(Frame owner)
		{
			super(owner, "Name Matching", true);
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			t = new Timer(2000, this);
			r = new Random();
			rba = new RandomBooleanArray(maxTrials);

			final Font F18 = new Font("sansserif", Font.PLAIN, 18);
			final Dimension D = new Dimension(90, 30);
			s1Label = new JLabel("          ", SwingConstants.CENTER);
			s1Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s1Label.setPreferredSize(D);
			s1Label.setMaximumSize(D);
			s1Label.setFont(F18);

			s2Label = new JLabel("          ", SwingConstants.CENTER);
			s2Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s2Label.setPreferredSize(D);
			s2Label.setMaximumSize(D);
			s2Label.setFont(F18);

			sPanel = new JPanel();
			sPanel.add(s1Label);
			sPanel.add(s2Label);

			experimentPanel = new JPanel();
			experimentPanel.setLayout(new BoxLayout(experimentPanel, BoxLayout.Y_AXIS));
			experimentPanel.setPreferredSize(new Dimension(200, 200));
			experimentPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(sPanel);
			experimentPanel.add(Box.createVerticalGlue());

			this.addKeyListener(this);
			this.setContentPane(experimentPanel);
			this.pack();
		}

		public int showNMDialog(Frame f)
		{
			rba.shuffle();
			count = 0;
			s1Label.setBackground(Color.gray);
			this.setLocationRelativeTo(f);
			t.restart();
			s1Label.setText("");
			s2Label.setText("");
			this.setVisible(true);
			t.stop();
			return -1;
		}

		boolean armed = false;
		String w1 = "";
		String w2 = "";

		public void actionPerformed(ActionEvent ae)
		{
			if (!armed)
			{
				w1 = word[r.nextInt(word.length)];
				if (r.nextBoolean())
					w1 = w1.toUpperCase();
				s1Label.setFont(getRandomFont());
				s1Label.setText(w1);
				t.setInitialDelay(2000 + r.nextInt(3000)); // 2 to 5 seconds delay
				t.restart();
				armed = true;
			} else
			{
				t.stop();

				// randomize word, case, font (family, style, size)
				w2 = word[r.nextInt(word.length)];
				if (r.nextBoolean())
					w2 = w2.toUpperCase();
				s2Label.setFont(getRandomFont());

				if (rba.nextBooleanArrayEntry())
					s2Label.setText(w1);
				else
					s2Label.setText(w2);
				t1 = System.currentTimeMillis();
			}
		}

		public void keyPressed(KeyEvent ke)
		{
			time[count] = (int)(System.currentTimeMillis() - t1);
			key[count] = Character.toLowerCase(ke.getKeyChar());
			match[count] = s1Label.getText().equals(s2Label.getText()) ? 1 : 0;
			error[count] = match[count] == 1 && (key[count] != 'j' && key[count] != 'f') || match[count] == 0
					&& (key[count] == 'j' || key[count] == 'f') ? 1 : 0;
			++count;
			if (count == maxTrials)
			{
				this.setVisible(false);
				rba = new RandomBooleanArray(maxTrials);
			}

			t.setInitialDelay(2000);
			t.restart();
			s1Label.setText("");
			s2Label.setText("");
			armed = false;
		}

		public void keyTyped(KeyEvent ke)
		{
		}

		public void keyReleased(KeyEvent ke)
		{
		}

		public String SD1Results()
		{
			String s = "";
			s += "time";
			for (int i = 0; i < time.length; ++i)
				s += "," + time[i];
			s += "\n";
			s += "keys,";
			for (int i = 0; i < time.length; ++i)
				s += key[i] + ",";
			s += "\n";
			s += "matches,";
			for (int i = 0; i < time.length; ++i)
				s += match[i] + ",";
			s += "\n";
			s += "errors,";
			for (int i = 0; i < time.length; ++i)
				s += error[i] + ",";
			s += "\n";
			return s;
		}

		public String SD2Results()
		{
			double meanMatchTime = 0.0;
			double meanNoMatchTime = 0.0;
			int nMatch = 0;
			int nNoMatch = 0;
			int nMatchError = 0;
			int nNoMatchError = 0;
			for (int i = 0; i < time.length; ++i)
			{
				if (match[i] == 1) // match
				{
					if (error[i] == 0)
					{
						meanMatchTime += time[i];
						++nMatch;
					} else
						++nMatchError;
				} else
				// no match
				{
					if (error[i] == 0)
					{
						meanNoMatchTime += time[i];
						++nNoMatch;
					} else
						++nNoMatchError;
				}
			}
			meanMatchTime /= nMatch;
			meanNoMatchTime /= nNoMatch;

			return participantCode + "," + blockCode + "," + mode + "," + meanMatchTime + "," + nMatch + ","
					+ nMatchError + "," + meanNoMatchTime + "," + nNoMatch + "," + nNoMatchError;
		}

		@SuppressWarnings("unused")
		public String SD2Header()
		{
			return "Participant,Block,Mode,RT_match,n_match,error_match," + "RT_no-match,n_no-match,error_no-match\n";
		}
	}

	// --------------------------------
	// Class Matching experiment dialog
	// --------------------------------
	private class CMDialog extends JDialog implements ActionListener, KeyListener
	{
		private static final long serialVersionUID = 1L;

		Timer t;
		Random r;
		JPanel experimentPanel;
		JLabel s1Label;
		JLabel s2Label;
		JPanel sPanel;
		long t1 = 0;
		RandomBooleanArray rba;

		CMDialog(Frame owner)
		{
			super(owner, "Class Matching", true);
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			t = new Timer(2000, this);
			r = new Random();
			rba = new RandomBooleanArray(maxTrials);

			final Font F18 = new Font("sansserif", Font.PLAIN, 18);
			final Dimension D = new Dimension(30, 30);
			s1Label = new JLabel("  ", SwingConstants.CENTER);
			s1Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s1Label.setPreferredSize(D);
			s1Label.setMaximumSize(D);
			s1Label.setFont(F18);

			s2Label = new JLabel("  ", SwingConstants.CENTER);
			s2Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s2Label.setPreferredSize(D);
			s2Label.setMaximumSize(D);
			s2Label.setFont(F18);

			sPanel = new JPanel();
			sPanel.add(s1Label);
			sPanel.add(s2Label);

			experimentPanel = new JPanel();
			experimentPanel.setLayout(new BoxLayout(experimentPanel, BoxLayout.Y_AXIS));
			experimentPanel.setPreferredSize(new Dimension(200, 200));
			experimentPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(sPanel);
			experimentPanel.add(Box.createVerticalGlue());

			this.addKeyListener(this);
			this.setContentPane(experimentPanel);
			this.pack();
		}

		public int showCMDialog(Frame f)
		{
			rba.shuffle();
			count = 0;
			s1Label.setBackground(Color.gray);
			s2Label.setText("");
			this.setLocationRelativeTo(f);
			t.restart();
			s1Label.setText("");
			s2Label.setText("");
			this.setVisible(true);
			t.stop();
			return -1;
		}

		boolean armed = false;
		char c1;
		char c2;
		String letters = "ABCDEFGHJKLNMPQRSTUVWXWZ"; // "I" and "O" omitted
		String numbers = "23456789"; // "0" and "1" omitted

		boolean matchMode;
		boolean letterMode;

		public void actionPerformed(ActionEvent ae)
		{
			if (!armed)
			{
				matchMode = rba.nextBooleanArrayEntry(); // 50% matches, 50% no-matches
				letterMode = r.nextBoolean();

				if (letterMode)
					c1 = letters.charAt(r.nextInt(letters.length()));
				else
					c1 = numbers.charAt(r.nextInt(numbers.length()));
				s1Label.setFont(getRandomFont());
				s1Label.setText("" + c1);
				t.setInitialDelay(2000 + r.nextInt(3000));
				t.restart();
				armed = true;
			} else
			{
				t.stop();

				if (matchMode)
					if (letterMode)
						c2 = letters.charAt(r.nextInt(letters.length()));
					else
						c2 = numbers.charAt(r.nextInt(numbers.length()));
				else if (letterMode)
					c2 = numbers.charAt(r.nextInt(numbers.length()));
				else
					c2 = letters.charAt(r.nextInt(letters.length()));
				s2Label.setFont(getRandomFont());
				s2Label.setText("" + c2);
				t1 = System.currentTimeMillis();
			}
		}

		public void keyPressed(KeyEvent ke)
		{
			time[count] = (int)(System.currentTimeMillis() - t1);
			key[count] = Character.toLowerCase(ke.getKeyChar());
			match[count] = (letters.indexOf(s1Label.getText()) >= 0 && letters.indexOf(s2Label.getText()) >= 0 || numbers
					.indexOf(s1Label.getText()) >= 0
					&& numbers.indexOf(s2Label.getText()) >= 0) ? 1 : 0;

			error[count] = match[count] == 1 && (key[count] != 'j' && key[count] != 'f') || match[count] == 0
					&& (key[count] == 'j' || key[count] == 'f') ? 1 : 0;
			++count;
			if (count == maxTrials)
			{
				this.setVisible(false);
				rba = new RandomBooleanArray(maxTrials);
			}

			t.setInitialDelay(2000);
			t.restart();
			s1Label.setText("");
			s2Label.setText("");
			armed = false;
		}

		public void keyTyped(KeyEvent ke)
		{
		}

		public void keyReleased(KeyEvent ke)
		{
		}

		public String SD1Results()
		{
			String s = "";
			s += "time";
			for (int i = 0; i < time.length; ++i)
				s += "," + time[i];
			s += "\n";
			s += "keys";
			for (int i = 0; i < time.length; ++i)
				s += "," + key[i];
			s += "\n";
			s += "matches";
			for (int i = 0; i < time.length; ++i)
				s += "," + match[i];
			s += "\n";
			s += "errors";
			for (int i = 0; i < time.length; ++i)
				s += "," + error[i];
			s += "\n";
			return s;
		}

		public String SD2Results()
		{
			double meanMatchTime = 0.0;
			double meanNoMatchTime = 0.0;
			int nMatch = 0;
			int nNoMatch = 0;
			int nMatchError = 0;
			int nNoMatchError = 0;
			for (int i = 0; i < time.length; ++i)
			{
				if (match[i] == 1) // match
				{
					if (error[i] == 0)
					{
						meanMatchTime += time[i];
						++nMatch;
					} else
						++nMatchError;
				} else
				// no match
				{
					if (error[i] == 0)
					{
						meanNoMatchTime += time[i];
						++nNoMatch;
					} else
						++nNoMatchError;
				}
			}
			meanMatchTime /= nMatch;
			meanNoMatchTime /= nNoMatch;

			return participantCode + "," + blockCode + "," + mode + "," + meanMatchTime + "," + nMatch + ","
					+ nMatchError + "," + meanNoMatchTime + "," + nNoMatch + "," + nNoMatchError;
		}

		public String SD2Header()
		{
			return "Participant,Block,Mode,RT_match,n_match,error_match," + "RT_no-match,n_no-match,error_no-match\n";
		}
	}

	// ------------------------------------
	// Visual Search Time experiment dialog
	// ------------------------------------
	private class VSDialog extends JDialog implements ActionListener, KeyListener
	{
		private static final long serialVersionUID = 1L;
		Timer t;
		Random r;
		JPanel experimentPanel;
		JLabel s1Label;
		JLabel[] s2Label;
		JPanel sPanel;
		long t1 = 0;
		int numberOfItems;
		RandomBooleanArray rba;

		VSDialog(Frame owner, int numberOfChoicesArg)
		{
			super(owner, "Visual Search", true);
			numberOfItems = numberOfChoicesArg;
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			t = new Timer(2000, this);
			r = new Random();
			rba = new RandomBooleanArray(maxTrials);

			final Font F18 = new Font("sansserif", Font.PLAIN, 18);
			final Dimension D = new Dimension(30, 30);
			s1Label = new JLabel(" ", SwingConstants.CENTER);
			s1Label.setBorder(BorderFactory.createLineBorder(Color.gray));
			s1Label.setPreferredSize(D);
			s1Label.setMaximumSize(D);
			s1Label.setFont(F18);

			s2Label = new JLabel[numberOfItems];
			JPanel s2Panel = null;
			if (numberOfItems == 1)
				s2Panel = new JPanel(new GridLayout(1, 1));
			else if (numberOfItems == 2)
				s2Panel = new JPanel(new GridLayout(2, 1));
			else if (numberOfItems == 4)
				s2Panel = new JPanel(new GridLayout(2, 2));
			else if (numberOfItems == 8)
				s2Panel = new JPanel(new GridLayout(2, 4));
			else if (numberOfItems == 16)
				s2Panel = new JPanel(new GridLayout(4, 4));
			else if (numberOfItems == 32)
				s2Panel = new JPanel(new GridLayout(4, 8));

			for (int i = 0; i < s2Label.length; ++i)
			{
				s2Label[i] = new JLabel(" ", SwingConstants.CENTER);
				s2Label[i].setBorder(BorderFactory.createLineBorder(Color.gray));
				s2Label[i].setPreferredSize(D);
				s2Label[i].setMaximumSize(D);
				s2Label[i].setFont(F18);
				s2Panel.add(s2Label[i]);
			}

			sPanel = new JPanel();
			sPanel.add(s1Label);
			sPanel.add(s2Panel);

			experimentPanel = new JPanel();
			experimentPanel.setLayout(new BoxLayout(experimentPanel, BoxLayout.Y_AXIS));
			experimentPanel.setPreferredSize(new Dimension(300, 300));
			experimentPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
			experimentPanel.add(Box.createVerticalGlue()); // kludge spacing
			experimentPanel.add(Box.createVerticalGlue());
			experimentPanel.add(sPanel);
			experimentPanel.add(Box.createVerticalGlue());

			this.addKeyListener(this);
			this.setContentPane(experimentPanel);
			this.pack();
		}

		public int showVSDialog(Frame f)
		{
			rba.shuffle();
			count = 0;
			s1Label.setBackground(Color.gray);
			for (int i = 0; i < s2Label.length; ++i)
				s2Label[i].setText("");
			this.setLocationRelativeTo(f);
			t.restart(); // !!!
			s1Label.setText("");
			for (int i = 0; i < numberOfItems; ++i)
				s2Label[i].setText("");
			this.setVisible(true);
			t.stop();
			return -1;
		}

		boolean armed = false;
		boolean matchMode = false;
		String c1 = "";

		public void actionPerformed(ActionEvent ae)
		{
			if (!armed)
			{
				matchMode = rba.nextBooleanArrayEntry();
				c1 = Character.toString((char)('A' + r.nextInt(26)));
				s1Label.setText(c1);
				t.setInitialDelay(2000 + r.nextInt(3000));
				t.restart();
				armed = true;
			} else
			{
				t.stop();
				// location of match random (but, of course, no-match 50% of time)
				int location = r.nextInt(numberOfItems);
				for (int i = 0; i < numberOfItems; ++i)
				{
					// choose second stimulus at random
					String c2 = Character.toString((char)('A' + r.nextInt(26)));
					// ensure second stimulus != first stimulus
					while (c2.equals(c1))
						c2 = Character.toString((char)('A' + r.nextInt(26)));
					if (matchMode && location == i)
						s2Label[i].setText(c1);
					else
						s2Label[i].setText(c2);
				}
				t1 = System.currentTimeMillis();
			}
		}

		public void keyPressed(KeyEvent ke)
		{
			time[count] = (int)(System.currentTimeMillis() - t1);
			key[count] = Character.toLowerCase(ke.getKeyChar());
			match[count] = matchMode ? 1 : 0;
			error[count] = matchMode && (key[count] != 'j' && key[count] != 'f') || !matchMode
					&& (key[count] == 'j' || key[count] == 'f') ? 1 : 0;
			++count;
			if (count == maxTrials)
			{
				this.setVisible(false);
				rba = new RandomBooleanArray(maxTrials);
			}

			t.setInitialDelay(2000);
			t.restart();
			s1Label.setText("");
			for (int i = 0; i < numberOfItems; ++i)
				s2Label[i].setText("");
			armed = false;
		}

		public void keyTyped(KeyEvent ke)
		{
		}

		public void keyReleased(KeyEvent ke)
		{
		}

		public String SD1Results()
		{
			String s = "";
			s += "times,";
			for (int i = 0; i < time.length; ++i)
				s += time[i] + ",";
			s += "\n";
			s += "keys,";
			for (int i = 0; i < time.length; ++i)
				s += key[i] + ",";
			s += "\n";
			s += "match,";
			for (int i = 0; i < time.length; ++i)
				s += match[i] + ",";
			s += "\n";
			s += "errors,";
			for (int i = 0; i < time.length; ++i)
				s += error[i] + ",";
			s += "\n";
			return s;
		}

		public String SD2Results()
		{
			double totalTime = 0.0;
			int totalErrors = 0;
			double totalMatchTime = 0.0;
			int nMatch = 0;
			int nMatchErrors = 0;
			double totalNoMatchTime = 0.0;
			int nNoMatch = 0;
			int nNoMatchErrors = 0;

			for (int i = 0; i < time.length; ++i)
			{
				totalTime += time[i];
				totalErrors += error[i];
				if (match[i] == 1)
				{
					totalMatchTime += time[i];
					++nMatch;
					nMatchErrors += error[i];
				} else
				{
					totalNoMatchTime += time[i];
					++nNoMatch;
					nNoMatchErrors += error[i];
				}
			}

			return participantCode + "," + blockCode + "," + mode + "," + numberOfItems + "," + totalTime + ","
					+ totalErrors + "," + totalMatchTime + "," + nMatch + "," + nMatchErrors + "," + totalNoMatchTime
					+ "," + nNoMatch + "," + nNoMatchErrors;
		}

		public String SD2Header()
		{
			return "Participant,Block,Mode,Number_of_Items," + "total_time,total_errors,"
					+ "total_match_time,n_match,n_match_errors," + "total_no-match_time,n_no-match,n_no-match_errors\n";
		}
	}

	private class RandomBooleanArray
	{
		int size;
		boolean[] booleanArray;
		int nextCounter;

		RandomBooleanArray(int sizeArg)
		{
			size = sizeArg;
			booleanArray = new boolean[size];

			// create boolean array; 50% = false, 50% = true
			for (int i = 0; i < size; ++i)
				booleanArray[i] = i < size / 2 ? false : true;
			shuffle();
			nextCounter = 0;
		}

		// shuffle entries in array (still 50% false, 50% true)
		void shuffle()
		{
			Random r = new Random();
			for (int i = 0; i < size / 2; ++i) // size must be even!
			{
				if (r.nextBoolean())
				{
					boolean temp = booleanArray[i];
					booleanArray[i] = booleanArray[i + size / 2];
					booleanArray[i + size / 2] = temp;
				}
			}
			return;
		}

		boolean nextBooleanArrayEntry()
		{
			return booleanArray[nextCounter++];
		}
	}
}

// ---------
// S E T U P
// ---------

class ReactionTimeExperimentSetup extends JDialog implements ActionListener
{
	// the following avoids a "warning" with Java 1.5.0 complier (?)
	static final long serialVersionUID = 42L;

	ReactionTimeExperimentConfiguration c, cSave;
	JLabel banner;
	JTextArea modeDescription;
	JComboBox participantCode;
	JComboBox blockCode;
	JComboBox numberOfTrials;

	JRadioButton srButton;
	JRadioButton pmButton;
	JRadioButton nmButton;
	JRadioButton cmButton;
	JRadioButton vsButton;

	JRadioButton vs1Button;
	JRadioButton vs2Button;
	JRadioButton vs4Button;
	JRadioButton vs8Button;
	JRadioButton vs16Button;
	JRadioButton vs32Button;

	JButton okButton;
	JButton resetButton;
	JButton exitButton;

	final Font F16 = new Font("sansserif", Font.PLAIN, 16);
	// kludgy spaces below to fix alignment problem
	final String[] NUMBERS = { "0                      ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
			"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }; // NOTE:
																									// numbers
																									// =
																									// indices

	ReactionTimeExperimentSetup(Frame owner, ReactionTimeExperimentConfiguration cArg)
	{
		super(owner, "Reaction Time Experiment", true);
		c = cArg;

		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		banner = new JLabel("Setup", SwingConstants.CENTER);
		banner.setFont(new Font("sansserif", Font.PLAIN, 24));
		banner.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		participantCode = new JComboBox(NUMBERS);
		participantCode.setFont(F16);
		participantCode.addActionListener(this);

		blockCode = new JComboBox(NUMBERS);
		blockCode.setFont(F16);
		blockCode.addActionListener(this);

		numberOfTrials = new JComboBox(NUMBERS);
		numberOfTrials.setSelectedIndex(10);
		numberOfTrials.setFont(F16);
		numberOfTrials.addActionListener(this);

		srButton = new JRadioButton("Simple Reaction");
		pmButton = new JRadioButton("Physical Matching");
		nmButton = new JRadioButton("Name Matching");
		cmButton = new JRadioButton("Class Matching");
		vsButton = new JRadioButton("Visual Search");

		srButton.setActionCommand("SR");
		pmButton.setActionCommand("PM");
		nmButton.setActionCommand("NM");
		cmButton.setActionCommand("CM");
		vsButton.setActionCommand("VS");

		vs1Button = new JRadioButton("1");
		vs2Button = new JRadioButton("2");
		vs4Button = new JRadioButton("4");
		vs8Button = new JRadioButton("8");
		vs16Button = new JRadioButton("16");
		vs32Button = new JRadioButton("32");

		srButton.setFont(F16);
		nmButton.setFont(F16);
		pmButton.setFont(F16);
		cmButton.setFont(F16);

		vsButton.setFont(F16);
		vs1Button.setFont(F16);
		vs2Button.setFont(F16);
		vs4Button.setFont(F16);
		vs8Button.setFont(F16);
		vs16Button.setFont(F16);
		vs32Button.setFont(F16);
		disableNumbers();

		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(srButton);
		bg1.add(pmButton);
		bg1.add(nmButton);
		bg1.add(cmButton);
		bg1.add(vsButton);
		srButton.setSelected(true); // default

		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(vs1Button);
		bg2.add(vs2Button);
		bg2.add(vs4Button);
		bg2.add(vs8Button);
		bg2.add(vs16Button);
		bg2.add(vs32Button);
		vs1Button.setSelected(true); // default

		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setLayout(new BoxLayout(rightButtonPanel, BoxLayout.Y_AXIS));
		rightButtonPanel.add(srButton);
		rightButtonPanel.add(pmButton);
		rightButtonPanel.add(nmButton);
		rightButtonPanel.add(cmButton);
		rightButtonPanel.add(vsButton);
		modeDescription = new JTextArea();
		modeDescription.setLineWrap(true);
		modeDescription.setWrapStyleWord(true);
		modeDescription.setBackground(rightButtonPanel.getBackground());
		setModeDescription(c.getMode());
		JPanel modeButtonPanel = new JPanel(new GridLayout(1, 2));
		modeButtonPanel.add(modeDescription);
		modeButtonPanel.add(rightButtonPanel);

		JPanel itemsButtonPanel = new JPanel();
		// itemsButtonPanel.setLayout(new BoxLayout(itemsButtonPanel, BoxLayout.X_AXIS));
		itemsButtonPanel.add(vs1Button);
		itemsButtonPanel.add(vs2Button);
		itemsButtonPanel.add(vs4Button);
		itemsButtonPanel.add(vs8Button);
		itemsButtonPanel.add(vs16Button);
		itemsButtonPanel.add(vs32Button);

		srButton.addActionListener(this);
		pmButton.addActionListener(this);
		nmButton.addActionListener(this);
		cmButton.addActionListener(this);
		vsButton.addActionListener(this);
		vs1Button.addActionListener(this);
		vs2Button.addActionListener(this);
		vs4Button.addActionListener(this);
		vs8Button.addActionListener(this);
		vs16Button.addActionListener(this);
		vs32Button.addActionListener(this);

		JPanel modePanel = new JPanel();
		modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
		modePanel.add(modeButtonPanel);
		modePanel.add(itemsButtonPanel);
		modePanel.setBorder(new TitledBorder(new EtchedBorder(), "Mode"));

		// more here

		okButton = new JButton("OK");
		okButton.setFont(F16);
		okButton.addActionListener(this);

		resetButton = new JButton("Reset");
		resetButton.setFont(F16);
		resetButton.addActionListener(this);

		exitButton = new JButton("Exit");
		exitButton.setFont(F16);
		exitButton.addActionListener(this);

		okButton.setPreferredSize(resetButton.getPreferredSize());
		exitButton.setPreferredSize(resetButton.getPreferredSize());

		setDefaults();

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1, 0, 10));
		JLabel l5 = new JLabel("Participant code ", SwingConstants.RIGHT);
		l5.setFont(F16);
		labelPanel.add(l5);
		JLabel l6 = new JLabel("Block code ", SwingConstants.RIGHT);
		l6.setFont(F16);
		labelPanel.add(l6);
		JLabel l6a = new JLabel("Number of trials ", SwingConstants.RIGHT);
		l6a.setFont(F16);
		labelPanel.add(l6a);

		JPanel paramPanel = new JPanel();
		paramPanel.setLayout(new GridLayout(0, 1, 0, 10));
		paramPanel.add(participantCode);
		paramPanel.add(blockCode);
		paramPanel.add(numberOfTrials);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(paramPanel, "East");
		centerPanel.add(labelPanel, "West");
		centerPanel.setBorder(new TitledBorder(new EtchedBorder(), "Parameters"));

		JPanel OKExitPanel = new JPanel();
		OKExitPanel.add(okButton);
		OKExitPanel.add(resetButton);
		OKExitPanel.add(exitButton);
		OKExitPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		JPanel pp = new JPanel();
		pp.setLayout(new BorderLayout());
		pp.add("North", centerPanel);
		pp.add("South", modePanel);

		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add("North", banner);
		top.add("Center", pp);
		top.add("South", OKExitPanel);
		top.add("West", new JLabel("            "));
		top.add("East", new JLabel("            "));
		this.setContentPane(top);
		this.pack();
		okButton.requestFocus();
	}

	void enableNumbers()
	{
		vs1Button.setEnabled(true);
		vs2Button.setEnabled(true);
		vs4Button.setEnabled(true);
		vs8Button.setEnabled(true);
		vs16Button.setEnabled(true);
		vs32Button.setEnabled(true);
	}

	void disableNumbers()
	{
		vs1Button.setEnabled(false);
		vs2Button.setEnabled(false);
		vs4Button.setEnabled(false);
		vs8Button.setEnabled(false);
		vs16Button.setEnabled(false);
		vs32Button.setEnabled(false);
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		if (source == exitButton)
			System.exit(0);
		else if (source == resetButton)
			setDefaults();
		else if (source == okButton)
			this.setVisible(false);

		else if (source == participantCode)
			c.setParticipantCode(participantCode.getSelectedIndex());
		else if (source == blockCode)
			c.setBlockCode(blockCode.getSelectedIndex());
		else if (source == numberOfTrials)
			c.setNumberOfTrials(numberOfTrials.getSelectedIndex());

		else if (source == srButton || source == pmButton || source == nmButton || source == cmButton
				|| source == vsButton)
		{
			c.setMode(((JRadioButton)source).getActionCommand());
			setModeDescription(c.getMode());

			if (source == vsButton)
				enableNumbers();
			else
				disableNumbers();
		}

		else if (source == vs1Button || source == vs2Button || source == vs4Button || source == vs8Button
				|| source == vs16Button || source == vs32Button)
		{
			c.setNumberOfItems(Integer.parseInt(((JRadioButton)source).getText()));
		}
		return;
	}

	private void setModeDescription(String mode)
	{
		String description = "";
		if (mode.equals("SR"))
		{
			description = "Press any key after the box turns red.";
		} else if (mode.equals("PM"))
		{
			description = "Press F or J if the word pairs match. " + "Press D or K if they do not match.";
		} else if (mode.equals("NM"))
		{
			description = "Press F or J if the words are the same, "
					+ "regardless of appearence. Press D or K if they are not the same.";
		} else if (mode.equals("CM"))
		{
			description = "Press F or J if the characters are both "
					+ "letters or are both digits, regardless of appearence. " + "Press D or K otherwise.";
		} else if (mode.equals("VS"))
		{
			description = "Press F or J if the letter also appears in the "
					+ "grid. Press D or K otherwise. Select the grid size below.";
		}
		modeDescription.setText(description);
	}

	private void setDefaults()
	{
		c.setParticipantCode(0);
		c.setBlockCode(0);
		c.setNumberOfTrials(10);
		c.setMode("SR");
		c.setNumberOfItems(1);
	}

	public boolean showLetterGuessingExperimentSetup(Frame f)
	{
		this.setLocationRelativeTo(f);
		this.setVisible(true);
		return true;
	}
}

// -------------------------
// C O N F I G U R A T I O N
// -------------------------

class ReactionTimeExperimentConfiguration
{
	int participantCode;
	int blockCode;
	int numberOfTrials;
	String mode;
	int numberOfItems;

	ReactionTimeExperimentConfiguration()
	{
		participantCode = 0;
		blockCode = 0;
		numberOfTrials = 10;
		mode = "SR";
		numberOfItems = 1;
	}

	public void setParticipantCode(int participantCodeArg)
	{
		participantCode = participantCodeArg;
	}

	public void setBlockCode(int blockCodeArg)
	{
		blockCode = blockCodeArg;
	}

	public void setNumberOfTrials(int numberOfTrialsArg)
	{
		numberOfTrials = numberOfTrialsArg;
	}

	public void setMode(String modeArg)
	{
		mode = modeArg;
	}

	public void setNumberOfItems(int numberOfItemsArg)
	{
		numberOfItems = numberOfItemsArg;
	}

	public int getParticipantCode()
	{
		return participantCode;
	}

	public int getBlockCode()
	{
		return blockCode;
	}

	public int getNumberOfTrials()
	{
		return numberOfTrials;
	}

	public String getMode()
	{
		return mode;
	}

	public int getNumberOfItems()
	{
		return numberOfItems;
	}

	public String getModeName()
	{
		if (mode.equals("SR"))
			return "Simple Reaction";
		else if (mode.equals("PM"))
			return "Physical Matching";
		else if (mode.equals("NM"))
			return "Name Matching";
		else if (mode.equals("CM"))
			return "Class Matching";
		else
			return "Visual Search";
	}

	@Override
	public String toString()
	{
		return "ReactionTimeExperiment Configuration\n" + "====================================\n"
				+ "Participant code = " + participantCode + "\n" + "Block code = " + blockCode + "\n"
				+ "Number of trials = " + numberOfTrials + "\n" + "Mode = " + mode + "\n" + "Number of items = "
				+ numberOfItems + "\n";
	}
}