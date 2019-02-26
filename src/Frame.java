import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;
import java.awt.Event;

public class Frame {

	static Die die1 = new Die();
	static Die die2 = new Die();

	// North buttons

	JButton N0 = new JButton("5");
	JButton N1 = new JButton("5");
	JButton N2 = new JButton("5");
	JButton N3 = new JButton("5");
	JButton N4 = new JButton("5");
	JButton N5 = new JButton("5");
	JButton N6 = new JButton("5");
	JButton N7 = new JButton("5");
	JButton N8 = new JButton("5");
	JButton N9 = new JButton("5");
	JButton N10 = new JButton("5");
	JButton N11 = new JButton("5");
	JButton N12 = new JButton("5");
	JButton N13 = new JButton("5");
	JButton N14 = new JButton("5");

	// Riverrun buttons

	JButton R0 = new JButton("5");
	JButton R1 = new JButton("5");
	JButton R2 = new JButton("5");
	JButton R3 = new JButton("5");

	// Valley buttons

	JButton V0 = new JButton("5");
	JButton V1 = new JButton("5");
	JButton V2 = new JButton("5");
	JButton V3 = new JButton("5");

	// King's Landing buttons

	JButton C0 = new JButton("5");
	JButton C1 = new JButton("5");
	JButton C2 = new JButton("5");

	// Casterly Rock buttons

	JButton W0 = new JButton("5");
	JButton W1 = new JButton("5");
	JButton W2 = new JButton("5");

	// High Garden buttons

	JButton H0 = new JButton("5");
	JButton H1 = new JButton("5");
	JButton H2 = new JButton("5");
	JButton H3 = new JButton("5");
	JButton H4 = new JButton("5");
	JButton H5 = new JButton("5");
	JButton H6 = new JButton("5");

	// Storm's End buttons

	JButton S0 = new JButton("5");
	JButton S1 = new JButton("5");
	JButton S2 = new JButton("5");

	// Dorne buttons

	JButton D0 = new JButton("5");
	JButton D1 = new JButton("5");
	JButton D2 = new JButton("5");
	JButton D3 = new JButton("5");
	JButton D4 = new JButton("5");

	JButton d; // Dummy button to make rows same size

	// List of Adjacencies for each Button // Nei represent neighbor

	JButton[] N0nei = { N1, N2, N3 };
	JButton[] N1nei = { N0, N2, N3, N6 };
	JButton[] N2nei = { N0, N1, N3, N4, N5 };
	JButton[] N3nei = { N2 };
	JButton[] N4nei = { N2, N5, N12 };
	JButton[] N5nei = { N1, N2, N4, N6, N10, N12 };
	JButton[] N6nei = { N1, N5, N7, N10 };
	JButton[] N7nei = { N6, N8, N9, N10 };
	JButton[] N8nei = { N7, N9 };
	JButton[] N9nei = { N7, N8, N10, N11 };
	JButton[] N10nei = { N5, N6, N7, N9, N11, N12 };
	JButton[] N11nei = { N9, N10, N12, N13 };
	JButton[] N12nei = { N4, N5, N10, N11, N13 };
	JButton[] N13nei = { N11, N12, N14, R0, V0 };
	JButton[] N14nei = { N13 };

	JButton[] R0nei = { N13, R1, R2, V0, V3, C0 };
	JButton[] R1nei = { R0, R2, C0, C1, W0, W1 };
	JButton[] R2nei = { R0, R1, R3, W0 };
	JButton[] R3nei = { R1, R2, W0 };

	JButton[] V0nei = { V1, V2, V3, R0 };
	JButton[] V1nei = { V0, V2 };
	JButton[] V2nei = { V0, V3 };
	JButton[] V3nei = { R0, V0, V2 };

	JButton[] C0nei = { R0, R1, C1, V3 };
	JButton[] C1nei = { C0, R1, H0, C2, W1 };
	JButton[] C2nei = { C1, H0, S0, S1 };

	JButton[] W0nei = { R1, R2, R3, W1, W2, H0 };
	JButton[] W1nei = { C1, W0, R0, R1 };
	JButton[] W2nei = { W0, R0, R3 };

	JButton[] H0nei = { W0, W1, W2, C1, C2, S0, H1, H2, H3 };
	JButton[] H1nei = { H0, H2, H5, H6, S0 };
	JButton[] H2nei = { H0, H1, H3, H5 };
	JButton[] H3nei = { H0, H2, H4, H5, W2 };
	JButton[] H4nei = { H3, H5, D1 };
	JButton[] H5nei = { H0, H1, H3, H5, H0, H1, H3 };
	JButton[] H6nei = { S0, D0, H1, H5 };

	JButton[] S0nei = { H0, H1, H6, C2, D0, S1, S2 };
	JButton[] S1nei = { C2, S0, S2 };
	JButton[] S2nei = { S0, S1 };

	JButton[] D0nei = { H5, H6, S0, D1, D2 };
	JButton[] D1nei = { H4, H5, D0, D2 };
	JButton[] D2nei = { D0, D1, D3 };
	JButton[] D3nei = { D2, D4 };
	JButton[] D4nei = { D3 };

	JButton[][] MainList = {

			{ N0, N1, N2, N3, d, d, d, d, d, d }, { N1, N0, N2, N3, N6, d, d, d, d, d },
			{ N2, N0, N1, N3, N4, N5, d, d, d, d }, { N3, N2, d, d, d, d, d, d, d, d },
			{ N4, N2, N5, N12, d, d, d, d, d, d }, { N5, N1, N2, N4, N6, N10, N12, d, d, d },
			{ N6, N1, N5, N7, N10, d, d, d, d, d }, { N7, N6, N8, N9, N10, d, d, d, d, d },
			{ N8, N7, N9, d, d, d, d, d, d, d }, { N9, N7, N8, N10, N11, d, d, d, d, d },
			{ N10, N5, N6, N7, N9, N11, N12, d, d, d }, { N11, N9, N10, N12, N13, d, d, d, d, d },
			{ N12, N4, N5, N10, N11, N13, d, d, d, d }, { N13, N11, N12, N14, R0, V0, d, d, d, d },
			{ N14, N13, d, d, d, d, d, d, d, d }, { R0, N13, R1, R2, V0, V3, C0, d, d, d },
			{ R1, R0, R2, C0, C1, W0, W1, d, d, d }, { R2, R0, R1, R3, W0, d, d, d, d, d },
			{ R3, R1, R2, W0, d, d, d, d, d, d }, { V0, V1, V2, V3, R0, d, d, d, d, d },
			{ V1, V0, V2, d, d, d, d, d, d, d }, { V2, V0, V3, d, d, d, d, d, d, d },
			{ V3, R0, V0, V2, d, d, d, d, d, d }, { C0, R0, R1, C1, V3, d, d, d, d, d },
			{ C1, C0, R1, H0, C2, W1, d, d, d, d }, { C2, C1, H0, S0, S1, d, d, d, d, d },
			{ W0, R1, R2, R3, W1, W2, H0, d, d, d }, { W1, C1, W0, R0, R1, d, d, d, d, d },
			{ W2, W0, R0, R3, d, d, d, d, d, d }, { H0, W0, W1, W2, C1, C2, S0, H1, H2, H3 },
			{ H1, H0, H2, H5, H6, S0, d, d, d, d }, { H2, H0, H1, H3, H5, d, d, d, d, d },
			{ H3, H0, H2, H4, H5, W2, d, d, d, d }, { H4, H3, H5, D1, d, d, d, d, d, d },
			{ H5, H0, H1, H3, H5, H0, H1, H3, d, d }, { H6, S0, D0, H1, H5, d, d, d, d, d },
			{ S0, H0, H1, H6, C2, D0, S1, S2, d, d }, { S1, C2, S0, S2, d, d, d, d, d, d },
			{ S2, S0, S1, d, d, d, d, d, d, d }, { D0, H5, H6, S0, D1, D2, d, d, d, d },
			{ D1, H4, H5, D0, D2, d, d, d, d, d }, { D2, D0, D1, D3, d, d, d, d, d, d },
			{ D3, D2, D4, d, d, d, d, d, d, d }, { D4, D3, d, d, d, d, d, d, d, d } };

	// Following static integers tell us whether or not a button is clicked.

	public static int N0state = 0;
	public static int N1state = 0;
	public static int N2state = 0;
	public static int N3state = 0;
	public static int N4state = 0;
	public static int N5state = 0;
	public static int N6state = 0;
	public static int N7state = 0;
	public static int N8state = 0;
	public static int N9state = 0;
	public static int N10state = 0;
	public static int N11state = 0;
	public static int N12state = 0;
	public static int N13state = 0;
	public static int N14state = 0;

	public static int R0state = 0;
	public static int R1state = 0;
	public static int R2state = 0;
	public static int R3state = 0;

	public static int V0state = 0;
	public static int V1state = 0;
	public static int V2state = 0;
	public static int V3state = 0;

	public static int C0state = 0;
	public static int C1state = 0;
	public static int C2state = 0;

	public static int W0state = 0;
	public static int W1state = 0;
	public static int W2state = 0;

	public static int H0state = 0;
	public static int H1state = 0;
	public static int H2state = 0;
	public static int H3state = 0;
	public static int H4state = 0;
	public static int H5state = 0;
	public static int H6state = 0;

	public static int S0state = 0;
	public static int S1state = 0;
	public static int S2state = 0;

	public static int D0state = 0;
	public static int D1state = 0;
	public static int D2state = 0;
	public static int D3state = 0;
	public static int D4state = 0;

	public static int PhaseState = 0;
	public static int IncState = 0;
	public static int AttState = 0;
	public static int FortState = 0;

	JLabel Reserve = new JLabel("Reserve"); // Shows number of troops in reserve
	static JButton Increment = new JButton("Increment"); // Our Increment button
	JFrame frame;
	static JButton Attack = new JButton("Attack"); // Attack Button
	static JButton Fortify = new JButton("Fortify"); // Fortify button for
														// moving troops
	static JLabel Phase = new JLabel("Phase");

	static JLabel Die1 = new JLabel("Die1 = ");
	static JLabel Die2 = new JLabel("Die2 = ");

	static JButton playerturn = new JButton("Turn for player");

	// Our list of province states // bsl stands for button state list

	int[] bsl = { N0state, N1state, N2state, N3state, N4state, N5state, N6state, N7state, N8state, N9state, N10state,
			N11state, N12state, N13state, N14state, R0state, R1state, R2state, R3state, V0state, V1state, V2state,
			V3state, C0state, C1state, C2state, W0state, W1state, W2state, H0state, H1state, H2state, H3state, H4state,
			H5state, H6state, S0state, S1state, S2state, D0state, D1state, D2state, D3state, D4state };

	// Our list of actions states // absl stands for action button state list

	ArrayList<Integer> absl = new ArrayList<Integer>();

	// List of buttons for tiles

	ArrayList<JButton> buttonlist = new ArrayList<JButton>();

	static Color color1; // PINK
	static Color color2; // GRAY
	static Color color3; // CYAN
	static Color color4; // YELLOW

	public Frame() {

		Conquerer efe = new Conquerer(Color.PINK, "Efe Berk Ergüleç", 0);
		Conquerer arda = new Conquerer(Color.LIGHT_GRAY, "Arda Andýrýn", 0);
		Conquerer tayfunhocam = new Conquerer(Color.CYAN, "Tayfun Kucukyilmaz", 0);
		Conquerer yigithocam = new Conquerer(Color.YELLOW, "Yigit Sever", 0);

		ArrayList<Player> players = new ArrayList<Player>();
		players.add(efe);
		players.add(arda);
		players.add(tayfunhocam);
		players.add(yigithocam);

		color1 = efe.getColor();
		color2 = arda.getColor();
		color3 = tayfunhocam.getColor();
		color4 = yigithocam.getColor();

		frame = new JFrame("Risk of Thrones");

		frame.getContentPane().setLayout(new FlowLayout());
		JLabel map = new JLabel("");
		map.setLocation(0, 0);
		map.setSize(518, 1000);

		map.setIcon(new ImageIcon("RISKMAP.jpg")); 
																	

		// North Buttons

		N0.setBounds(300, 55, 50, 50);
		frame.getContentPane().add(N0);

		N1.setBounds(250, 125, 50, 50);
		frame.getContentPane().add(N1);

		N2.setBounds(333, 147, 50, 50);
		frame.getContentPane().add(N2);

		N3.setBounds(407, 132, 50, 50);
		frame.getContentPane().add(N3);

		N4.setBounds(391, 240, 50, 50);
		frame.getContentPane().add(N4);

		N5.setBounds(279, 228, 50, 50);
		frame.getContentPane().add(N5);

		N6.setBounds(159, 182, 50, 50);
		frame.getContentPane().add(N6);

		N7.setBounds(80, 165, 50, 50);
		frame.getContentPane().add(N7);

		N8.setBounds(48, 240, 50, 50);
		frame.getContentPane().add(N8);

		N9.setBounds(70, 304, 50, 50);
		frame.getContentPane().add(N9);

		N10.setBounds(200, 240, 50, 50);
		frame.getContentPane().add(N10);

		N11.setBounds(165, 300, 50, 50);
		frame.getContentPane().add(N11);

		N12.setBounds(320, 300, 50, 50);
		frame.getContentPane().add(N12);

		N13.setBounds(200, 375, 50, 50);
		frame.getContentPane().add(N13);

		N14.setBounds(75, 376, 50, 50);
		frame.getContentPane().add(N14);

		// Riverlands buttons

		R0.setBounds(215, 460, 50, 50);
		frame.getContentPane().add(R0);

		R1.setBounds(230, 570, 50, 50);
		frame.getContentPane().add(R1);

		R2.setBounds(190, 520, 50, 50);
		frame.getContentPane().add(R2);

		R3.setBounds(115, 530, 50, 50);
		frame.getContentPane().add(R3);

		// Valley buttons

		V0.setBounds(295, 490, 50, 50);
		frame.getContentPane().add(V0);

		V1.setBounds(345, 425, 50, 50);
		frame.getContentPane().add(V1);

		V2.setBounds(415, 475, 50, 50);
		frame.getContentPane().add(V2);

		V3.setBounds(360, 535, 50, 50);
		frame.getContentPane().add(V3);

		// King's Landing buttons

		C0.setBounds(395, 590, 50, 50);
		frame.getContentPane().add(C0);

		C1.setBounds(305, 635, 50, 50);
		frame.getContentPane().add(C1);

		C2.setBounds(340, 695, 50, 50);
		frame.getContentPane().add(C2);

		// Casterly Rock buttons

		W0.setBounds(125, 600, 50, 50);
		frame.getContentPane().add(W0);

		W1.setBounds(195, 625, 50, 50);
		frame.getContentPane().add(W1);

		W2.setBounds(73, 677, 50, 50);
		frame.getContentPane().add(W2);

		// High Garden buttons

		H0.setBounds(200, 683, 50, 50);
		frame.getContentPane().add(H0);

		H1.setBounds(240, 745, 50, 50);
		frame.getContentPane().add(H1);

		H2.setBounds(160, 745, 50, 50);
		frame.getContentPane().add(H2);

		H3.setBounds(100, 755, 50, 50);
		frame.getContentPane().add(H3);

		H4.setBounds(60, 835, 50, 50);
		frame.getContentPane().add(H4);

		H5.setBounds(145, 810, 50, 50);
		frame.getContentPane().add(H5);

		H6.setBounds(220, 800, 50, 50);
		frame.getContentPane().add(H6);

		// Storm's End buttons

		S0.setBounds(310, 770, 50, 50);
		frame.getContentPane().add(S0);

		S1.setBounds(400, 730, 50, 50);
		frame.getContentPane().add(S1);

		S2.setBounds(380, 800, 50, 50);
		frame.getContentPane().add(S2);

		// Dorne buttons

		D0.setBounds(220, 852, 50, 50);
		frame.getContentPane().add(D0);

		D1.setBounds(100, 890, 50, 50);
		frame.getContentPane().add(D1);

		D2.setBounds(205, 915, 50, 50);
		frame.getContentPane().add(D2);

		D3.setBounds(300, 920, 50, 50);
		frame.getContentPane().add(D3);

		D4.setBounds(400, 930, 50, 50);
		frame.getContentPane().add(D4);

		// Our list of buttons in array list

		// North

		buttonlist.add(N0);
		buttonlist.add(N1);
		buttonlist.add(N2);
		buttonlist.add(N3);
		buttonlist.add(N4);
		buttonlist.add(N5);
		buttonlist.add(N6);
		buttonlist.add(N7);
		buttonlist.add(N8);
		buttonlist.add(N9);
		buttonlist.add(N10);
		buttonlist.add(N11);
		buttonlist.add(N12);
		buttonlist.add(N13);
		buttonlist.add(N14);

		// Riverrun

		buttonlist.add(R0);
		buttonlist.add(R1);
		buttonlist.add(R2);
		buttonlist.add(R3);

		// Valley

		buttonlist.add(V0);
		buttonlist.add(V1);
		buttonlist.add(V2);
		buttonlist.add(V3);

		// King's Landing

		buttonlist.add(C0);
		buttonlist.add(C1);
		buttonlist.add(C2);

		// Casterly Rock

		buttonlist.add(W0);
		buttonlist.add(W1);
		buttonlist.add(W2);

		// High Garden

		buttonlist.add(H0);
		buttonlist.add(H1);
		buttonlist.add(H2);
		buttonlist.add(H3);
		buttonlist.add(H4);
		buttonlist.add(H5);
		buttonlist.add(H6);

		// Casterly Rock

		buttonlist.add(S0);
		buttonlist.add(S1);
		buttonlist.add(S2);

		// Dorne

		buttonlist.add(D0);
		buttonlist.add(D1);
		buttonlist.add(D2);
		buttonlist.add(D3);
		buttonlist.add(D4);

		// Increment State variables

		absl.add(IncState);
		absl.add(AttState);
		absl.add(FortState);

		// Action Buttons Bounds and other necessities

		Increment.setBounds(552, 60, 100, 100);
		frame.getContentPane().add(Increment, BorderLayout.NORTH);
		frame.getContentPane().add(Increment);

		Attack.setBounds(552, 170, 100, 100);
		frame.getContentPane().add(Attack);

		Fortify.setBounds(552, 280, 100, 100);
		frame.getContentPane().add(Fortify);

		Phase.setBounds(552, 390, 100, 50);
		Phase.setBackground(Color.green);
		Phase.setHorizontalAlignment(SwingConstants.CENTER);
		Phase.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(Phase);

		Phase.setHorizontalAlignment(SwingConstants.CENTER);

		Reserve.setBackground(Color.BLUE);
		Reserve.setHorizontalAlignment(SwingConstants.CENTER);
		Reserve.setBounds(525, 13, 156, 32);
		frame.getContentPane().add(Reserve, BorderLayout.NORTH);

		Die1.setHorizontalAlignment(SwingConstants.CENTER);
		Die1.setBounds(552, 450, 100, 100);
		Die1.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(Die1);

		Die2.setHorizontalAlignment(SwingConstants.CENTER);
		Die2.setBounds(552, 560, 100, 100);
		Die2.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(Die2);

		playerturn.setHorizontalAlignment(SwingConstants.CENTER);
		playerturn.setBounds(552, 670, 100, 50);
		playerturn.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(playerturn);

		frame.getContentPane().add(map, BorderLayout.NORTH);

		frame.getContentPane().setLayout(new BorderLayout()); // DO NOT DELETE
																// THIS CODE

		frame.setSize(new Dimension(712, 1250));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Gives buttons color according to player color //

		int c = 0;
		int count = 0;
		for (int i = 0; i < buttonlist.size(); i++) {
			if (c == players.size()) {
				buttonlist.get(i).setBackground(players.get(c - 1).getColor());
				players.get(c - 1).setCount(count + 1);
				c = 0;
				count++;
			}
			buttonlist.get(i).setBackground(players.get(c).getColor());
			players.get(c).setCount(count + 1);
			c++;
		}

		for (Player player : players) {
			System.out.println(player.getName() + "\t\t" + player.getCount());
		}

		/// **** FOLLOWING CODES ARE ACTIONLISTENERS AND EACH TIME A BUTTON
		/// ****///
		/// **** IS CKLICKED IT WILL MEAN IT'S STATE IS 1 AND IF YOU CLICK AGAIN
		/// ****///
		/// **** IT'S STATE WILL BE 0 MEANING THE BUTTON IS NOT SELECTED.
		/// ****///

		Increment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Frame.IncState == 1) {
					AttState = 0;
					FortState = 0;
					Frame.Phase.setText("Deployment");

				}

				if (e.getSource() == Increment) {
					IncState++;

					if (IncState % 2 == 0) {
						IncState = 0;

					}
					System.out.println("IncState is " + Frame.IncState);
				}

			}
		});

		Attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Frame.AttState == 1) {
					Frame.Phase.setText("Attack");
					IncState = 0;
					FortState = 0;
				}

				if (e.getSource() == Attack) {
					AttState++;

					if (AttState % 2 == 0) {
						AttState = 0;

					}
					attack();

					System.out.println("AttState is " + Frame.AttState);
				}
			}
		});

		Fortify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Fortify) {
					FortState++;

					if (FortState % 2 == 0) {
						FortState = 0;
					}

					fortify();

					if (Frame.FortState == 1) {
						Frame.Phase.setText("Fortify");
						IncState = 0;
						AttState = 0;
					}

					System.out.println("FortState is " + Frame.FortState);
				}
			}
		});

		N0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bsl[0] = ++N0state;
				if (N0state % 2 == 0) {
					N0state = 0;
				}

				if ((N0state == 0 || N0state == 1) && IncState == 1) { /// Increases
																		/// troops
					N0.setText(incrementTroops(N0));

				}
				if (N0state == 1 && AttState == 1) {

				}
				System.out.println("N0 state is" + N0state);

			}
		});

		N1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[1] = ++N1state;
				if (e.getSource() == N1) {

					if (N1state % 2 == 0) {
						N1state = 0;
					}

					if ((N1state == 0 || N1state == 1) && IncState == 1) {
						N1.setText(incrementTroops(N1));
					}

					System.out.println("N1 state is" + N1state);
				}
			}
		});

		N2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[2] = ++N2state;
				if (e.getSource() == N2) {

					if (N2state % 2 == 0) {
						N2state = 0;
					}
					if ((N2state == 0 || N2state == 1) && IncState == 1) {
						N2.setText(incrementTroops(N2));
					}
					System.out.println("N2 state is" + N2state);
				}
			}
		});

		N3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[3] = ++N3state;
				if (e.getSource() == N3) {

					if (N3state % 2 == 0) {
						N3state = 0;
					}
					if ((N3state == 0 || N3state == 1) && IncState == 1) {
						N3.setText(incrementTroops(N3));
					}
					System.out.println("N3 state is" + N3state);
				}
			}
		});

		N4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[4] = ++N4state;
				if (e.getSource() == N4) {

					if (N4state % 2 == 0) {
						N4state = 0;
					}
					if ((N4state == 0 || N4state == 1) && IncState == 1) {
						N4.setText(incrementTroops(N4));
					}
					System.out.println("N4 state is" + N4state);
				}
			}
		});

		N5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[5] = ++N5state;
				if (e.getSource() == N5) {

					if (N5state % 2 == 0) {
						N5state = 0;
					}
					if ((N5state == 0 || N5state == 1) && IncState == 1) {
						N5.setText(incrementTroops(N5));
					}
					System.out.println("N5 state is" + N5state);
				}
			}
		});

		N6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[6] = ++N6state;
				if (e.getSource() == N6) {

					if (N6state % 2 == 0) {
						N6state = 0;
					}
					if ((N6state == 0 || N6state == 1) && IncState == 1) {
						N6.setText(incrementTroops(N6));
					}
					System.out.println("N6 state is" + N6state);
				}
			}
		});

		N7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[7] = ++N7state;
				if (e.getSource() == N7) {

					if (N7state % 2 == 0) {
						N7state = 0;
					}
					if ((N7state == 0 || N7state == 1) && IncState == 1) {
						N7.setText(incrementTroops(N7));
					}
					System.out.println("N7 state is" + N7state);
				}
			}
		});

		N8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[8] = ++N8state;
				if (e.getSource() == N8) {

					if (N8state % 2 == 0) {
						N8state = 0;
					}
					if ((N8state == 0 || N8state == 1) && IncState == 1) {
						N8.setText(incrementTroops(N8));
					}
					System.out.println("N8 state is" + N8state);
				}
			}
		});

		N9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[9] = ++N9state;
				if (e.getSource() == N9) {

					if (N9state % 2 == 0) {
						N9state = 0;
					}
					if ((N9state == 0 || N9state == 1) && IncState == 1) {
						N9.setText(incrementTroops(N9));
					}
					System.out.println("N9 state is" + N9state);
				}
			}
		});

		N10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[10] = ++N10state;
				if (e.getSource() == N10) {

					if (N10state % 2 == 0) {
						N10state = 0;
					}
					if ((N10state == 0 || N10state == 1) && IncState == 1) {
						N10.setText(incrementTroops(N10));
					}
					System.out.println("N10 state is" + N10state);
				}
			}

		});

		N11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[11] = ++N11state;
				if (e.getSource() == N11) {

					if (N11state % 2 == 0) {
						N11state = 0;
					}
					if ((N11state == 0 || N11state == 1) && IncState == 1) {
						N11.setText(incrementTroops(N11));
					}
					System.out.println("N11 state is" + N11state);
				}
			}
		});

		N12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[12] = ++N12state;
				if (e.getSource() == N12) {

					if (N12state % 2 == 0) {
						N12state = 0;
					}
					if ((N12state == 0 || N12state == 1) && IncState == 1) {
						N12.setText(incrementTroops(N12));
					}
				}
				System.out.println("N12 state is " + N12state);
			}
		});

		N13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[13] = ++N13state;
				if (e.getSource() == N13) {

					if (N13state % 2 == 0) {
						N13state = 0;
					}
					if ((N13state == 0 || N13state == 1) && IncState == 1) {
						N13.setText(incrementTroops(N13));
					}
					System.out.println("N13 state is" + N13state);
				}
			}
		});

		N14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[14] = ++N14state;
				if (e.getSource() == N14) {

					if (N14state % 2 == 0) {
						N14state = 0;
					}
					if ((N14state == 0 || N14state == 1) && IncState == 1) {
						N14.setText(incrementTroops(N14));
					}
					System.out.println("N14 state is" + N14state);
				}
			}
		});

		R0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[15] = ++R0state;
				if (e.getSource() == R0) {

					if (R0state % 2 == 0) {
						R0state = 0;
					}
					if ((R0state == 0 || R0state == 1) && IncState == 1) {
						R0.setText(incrementTroops(R0));
					}
					System.out.println("R0 state is" + R0state);
				}
			}
		});

		R1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[16] = ++R1state;
				if (e.getSource() == R1) {

					if (R1state % 2 == 0) {
						R1state = 0;
					}
					if ((R1state == 0 || R1state == 1) && IncState == 1) {
						R1.setText(incrementTroops(R1));
					}
					System.out.println("R1 state is" + R1state);
				}
			}
		});

		R2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[17] = ++R2state;
				if (e.getSource() == R2) {

					if (R2state % 2 == 0) {
						R2state = 0;
					}
					if ((R2state == 0 || R2state == 1) && IncState == 1) {
						R2.setText(incrementTroops(R2));
					}
					System.out.println("R2 state is" + R2state);
				}
			}
		});

		R3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[18] = ++R3state;
				if (e.getSource() == R3) {

					if (R3state % 2 == 0) {
						R3state = 0;
					}
					if ((R3state == 0 || R3state == 1) && IncState == 1) {
						R3.setText(incrementTroops(R3));
					}
					System.out.println("R3 state is" + R3state);
				}
			}
		});

		V0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[19] = ++V0state;
				if (e.getSource() == V0) {

					if (V0state % 2 == 0) {
						V0state = 0;
					}
					if ((V0state == 0 || V0state == 1) && IncState == 1) {
						V0.setText(incrementTroops(V0));
					}
					System.out.println("V0 state is" + V0state);
				}
			}
		});

		V1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[20] = ++V1state;
				if (e.getSource() == V1) {

					if (V1state % 2 == 0) {
						V1state = 0;
					}
					if ((V1state == 0 || V1state == 1) && IncState == 1) {
						V1.setText(incrementTroops(V1));
					}
					System.out.println("V1 state is" + V1state);
				}
			}
		});

		V2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[21] = ++V2state;
				if (e.getSource() == V2) {

					if (V2state % 2 == 0) {
						V2state = 0;
					}
					if ((V2state == 0 || V2state == 1) && IncState == 1) {
						V2.setText(incrementTroops(V2));
					}
					System.out.println("V2 state is" + V2state);
				}
			}
		});

		V3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[22] = ++V3state;
				if (e.getSource() == V3) {

					if (V3state % 2 == 0) {
						V3state = 0;
					}
					if ((V3state == 0 || V3state == 1) && IncState == 1) {
						V3.setText(incrementTroops(V3));
					}
					System.out.println("V3 state is" + V3state);
				}
			}
		});

		C0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[23] = ++C0state;
				if (e.getSource() == C0) {

					if (C0state % 2 == 0) {
						C0state = 0;
					}
					if ((C0state == 0 || C0state == 1) && IncState == 1) {
						C0.setText(incrementTroops(C0));
					}
					System.out.println("C0 state is" + C0state);
				}
			}
		});

		C1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[24] = ++C1state;
				if (e.getSource() == C1) {

					if (C1state % 2 == 0) {
						C1state = 0;
					}
					if ((C1state == 0 || C1state == 1) && IncState == 1) {
						C1.setText(incrementTroops(C1));
					}
					System.out.println("C1 state is" + C1state);
				}
			}
		});

		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[25] = ++C2state;
				if (e.getSource() == C2) {

					if (C2state % 2 == 0) {
						C2state = 0;
					}
					if ((C2state == 0 || C2state == 1) && IncState == 1) {
						C2.setText(incrementTroops(C2));
					}
					System.out.println("C2 state is" + C2state);
				}
			}
		});

		W0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[26] = ++W0state;
				if (e.getSource() == W0) {

					if (W0state % 2 == 0) {
						W0state = 0;
					}
					if ((W0state == 0 || W0state == 1) && IncState == 1) {
						W0.setText(incrementTroops(W0));
					}
					System.out.println("W0 state is" + W0state);
				}
			}
		});

		W1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[27] = ++W1state;
				if (e.getSource() == W1) {

					if (W1state % 2 == 0) {
						W1state = 0;
					}
					if ((W1state == 0 || W1state == 1) && IncState == 1) {
						W1.setText(incrementTroops(W1));
					}
					System.out.println("W1 state is" + W1state);
				}
			}
		});

		W2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[28] = ++W2state;
				if (e.getSource() == W2) {

					if (W2state % 2 == 0) {
						W2state = 0;
					}
					if ((W2state == 0 || W2state == 1) && IncState == 1) {
						W2.setText(incrementTroops(W2));
					}
					System.out.println("W2 state is" + W2state);
				}
			}
		});

		H0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[29] = ++H0state;
				if (e.getSource() == H0) {

					if (H0state % 2 == 0) {
						H0state = 0;
					}
					if ((H0state == 0 || H0state == 1) && IncState == 1) {
						H0.setText(incrementTroops(H0));
					}
					System.out.println("H0 state is" + H0state);
				}
			}
		});

		H1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[30] = ++H1state;
				if (e.getSource() == H1) {

					if (H1state % 2 == 0) {
						H1state = 0;
					}
					if ((H1state == 0 || H1state == 1) && IncState == 1) {
						H1.setText(incrementTroops(H1));
					}
					System.out.println("H1 state is" + H1state);
				}
			}
		});

		H2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[31] = ++H2state;
				if (e.getSource() == H2) {

					if (H2state % 2 == 0) {
						H2state = 0;
					}
					if ((H2state == 0 || H2state == 1) && IncState == 1) {
						H2.setText(incrementTroops(H2));
					}
					System.out.println("H2 state is" + H2state);
				}
			}
		});

		H3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[32] = ++H3state;
				if (e.getSource() == H3) {

					if (H3state % 2 == 0) {
						H3state = 0;
					}
					if ((H3state == 0 || H3state == 1) && IncState == 1) {
						H3.setText(incrementTroops(H3));
					}
					System.out.println("H3 state is" + H3state);
				}
			}
		});

		H4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[33] = ++H4state;
				if (e.getSource() == H4) {

					if (H4state % 2 == 0) {
						H4state = 0;
					}
					if ((H4state == 0 || H4state == 1) && IncState == 1) {
						H4.setText(incrementTroops(H4));
					}
					System.out.println("H4 state is" + H4state);
				}
			}
		});

		H5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[34] = ++H5state;
				if (e.getSource() == H5) {

					if (H5state % 2 == 0) {
						H5state = 0;
					}
					if ((H5state == 0 || H5state == 1) && IncState == 1) {
						H5.setText(incrementTroops(H5));
					}
					System.out.println("H5 state is" + H5state);
				}
			}
		});

		H6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[35] = ++H6state;
				if (e.getSource() == H6) {

					if (H6state % 2 == 0) {
						H6state = 0;
					}
					if ((H6state == 0 || H6state == 1) && IncState == 1) {
						H6.setText(incrementTroops(H6));
					}
					System.out.println("H6 state is" + H6state);
				}
			}
		});

		S0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[36] = ++S0state;
				if (e.getSource() == S0) {

					if (S0state % 2 == 0) {
						S0state = 0;
					}
					if ((S0state == 0 || S0state == 1) && IncState == 1) {
						S0.setText(incrementTroops(S0));
					}
					System.out.println("S0 state is" + S0state);
				}
			}
		});

		S1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[37] = ++S1state;
				if (e.getSource() == S1) {

					if (S1state % 2 == 0) {
						S1state = 0;
					}
					if ((S1state == 0 || S1state == 1) && IncState == 1) {
						S1.setText(incrementTroops(S1));
					}
					System.out.println("S1 state is" + S1state);
				}
			}
		});

		S2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[38] = ++S2state;
				if (e.getSource() == S2) {

					if (S2state % 2 == 0) {
						S2state = 0;
					}
					if ((S2state == 0 || S2state == 1) && IncState == 1) {
						S2.setText(incrementTroops(S2));
					}
					System.out.println("S2 state is" + S2state);
				}
			}
		});

		D0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[39] = ++D0state;
				if (e.getSource() == D0) {

					if (D0state % 2 == 0) {
						D0state = 0;
					}
					if ((D0state == 0 || D0state == 1) && IncState == 1) {
						D0.setText(incrementTroops(D0));
					}
					System.out.println("D0 state is" + D0state);
				}
			}
		});

		D1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[40] = ++D1state;
				if (e.getSource() == D1) {

					if (D1state % 2 == 0) {
						D1state = 0;
					}
					if ((D1state == 0 || D1state == 1) && IncState == 1) {
						D1.setText(incrementTroops(D1));
					}
					System.out.println("D1 state is" + D1state);
				}
			}
		});

		D2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[41] = ++D2state;
				if (e.getSource() == D2) {

					if (D2state % 2 == 0) {
						D2state = 0;
					}
					if ((D2state == 0 || D2state == 1) && IncState == 1) {
						D2.setText(incrementTroops(D2));
					}
					System.out.println("D2 state is" + D2state);
				}
			}
		});

		D3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[42] = ++D3state;
				if (e.getSource() == D3) {

					if (D3state % 2 == 0) {
						D3state = 0;
					}
					if ((D3state == 0 || D3state == 1) && IncState == 1) {
						D3.setText(incrementTroops(D3));
					}
					System.out.println("D3 state is" + D3state);
				}
			}
		});

		D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsl[43] = ++D4state;
				if (e.getSource() == D4) {

					if (D4state % 2 == 0) {
						D4state = 0;
					}
					if ((D4state == 0 || D4state == 1) && IncState == 1) {
						D4.setText(incrementTroops(D4));
					}
					System.out.println("D4 state is" + D4state);
				}
			}
		});

	}

	// Increments troops by 1 per tile
	public String incrementTroops(JButton j) {

		String s = j.getText();
		int i = Integer.parseInt(s);
		i += 1;
		s = (i + "");
		playerturn.setBackground(j.getBackground());
		return s;

	}

	// Decrements troops by 1 per tile
	public String decrementTroops(JButton j) {
		String s = j.getText();
		int i = Integer.parseInt(s);
		i -= 1;
		s = (i + "");
		return s;
	}

	JButton b1 = new JButton();
	int b1index;
	Color b1color = null;
	int counter = 0;
	int counter1 = 0;
	JButton b2 = new JButton();

	int b2index = 0;
	int ilen;

	Color b2color = null;

	// Method for getting button values. Used in fortify and Attack methods.
	
	public void bvalues() {

		

		for (int m = 0; m < bsl.length; m++) {
			if (bsl[m] == 1) {
				b1 = buttonlist.get(m);
				counter = m;
				b1index = m;

				b1color = buttonlist.get(m).getBackground();

				b1.setBackground(b1color);
				
				if(bsl[m] == 1) {
					break;
				}
			}

		}
		

		for (int a = counter + 1; a < bsl.length; a++) {
			if (bsl[a] == 1) {
				b2 = buttonlist.get(a);
				counter1 = a;
				b2color = buttonlist.get(a).getBackground();
				b2.setBackground(b2color);

			}

		}

		if(counter>counter1) {
			b1 = b2;
			b2 = b1;
		}
		
	}

	public void attack() {
		bvalues();
		
		

		for (int c = 0; c < MainList[b1index].length; c++) {
			if (b2 == MainList[b1index][c]) {
				b2index = c;
			
			}
		}
		playerturn.setBackground(b1color);

		ilen = MainList[b1index].length;
		
		int j = 0;
		if (b2 == (MainList[b1index][b2index]) && (b1.getBackground() != b2.getBackground())) {
			System.out.println("You can attack there");

			int die1int = die1.roll();
			int die2int = die2.roll();
			System.out.println("die1 = " + die1int);
			System.out.println("die2 = " + die2int);
			Die1.setText("Die1 = " + Integer.toString(die1int));
			Die2.setText("Die2 = " + Integer.toString(die2int));

			if (die1int > die2int) {
				
				b2.setText(decrementTroops(b2));
				j++;
				

			} else if(die1int < die2int){
				b1.setText(decrementTroops(b1));
				j++;
				

			}
			
		}

		else {
			System.out.println("Nope, you cannot attack there!");
			
		
		}
		if(Integer.parseInt(b1.getText()) == 1) {
			b1.setText("1");
			System.out.println("Insufficient troops to attack");
		}
		
		if (Integer.parseInt(b2.getText()) == 0) {
		
			int b1int = Integer.parseInt(b1.getText()); // if the attacker wins
															// he transfers all
															// his troops except
															// 1 to the next
															// tile.
			if(b1int == 1) {
				
			}
			else {
				b1int = b1int - 1;
			b1.setText("1");
			b2.setBackground(b1color);
			b2.setText(Integer.toString(b1int));
			}
			
		}

	}

	// With this method we can transfer troops form one tile to another by one
	// :) //

	public void fortify() {
		bvalues();
		if((FortState == 1) && (b1.getBackground() == b2.getBackground())) {
			b1.setText(decrementTroops(b1));
			b2.setText(incrementTroops(b2));
			
		}
		else {
			System.out.println("Can not Fortify!");
		}
		
		
		
		}

	
}