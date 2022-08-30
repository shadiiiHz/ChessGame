
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
																																																																																																									
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class ChessBoard extends JFrame {

	private JPanel contentPane;
	public static JButton[][] btnOverCome = new JButton[8][8];
	public static JButton[][] btn = new JButton[8][8];

	static ImageIcon King1 = new ImageIcon("image/Queen1.png");
	static ImageIcon Queen1 = new ImageIcon("image/King1.png");
	static ImageIcon Bishop1 = new ImageIcon("image/Bishop1.png");
	static ImageIcon Pawn1 = new ImageIcon("image/Pawn1.png");
	static ImageIcon Knight1 = new ImageIcon("image/Knight1.png");
	static ImageIcon Rook1 = new ImageIcon("image/Rook1.png");
	static ImageIcon King2 = new ImageIcon("image/Queen2.png");
	static ImageIcon Queen2 = new ImageIcon("image/King2.png");
	static ImageIcon Bishop2 = new ImageIcon("image/Bishop2.png");
	static ImageIcon Pawn2 = new ImageIcon("image/Pawn2.png");
	static ImageIcon Knight2 = new ImageIcon("image/Knight2.png");
	static ImageIcon Rook2 = new ImageIcon("image/Rook2.png");
	static ImageIcon circle = new ImageIcon("image/circle.png");
	public static ArrayList<Integer> MovesI = new ArrayList<Integer>();
	public static ArrayList<Integer> MovesJ = new ArrayList<Integer>();
	public static boolean turn = true;
	public static Border border = new LineBorder(Color.BLACK);
	static ImageIcon RedCircle = new ImageIcon("image/8888.png");
	private static ChessBoard frame;
//	public static JLabel lblturn;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessBoard frame = new ChessBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public static boolean EndGameWhite() {// checking white won or not
		for (int i = 0; i < btn.length; i++) {
			for (int j = 0; j < btn.length; j++) {
				if (btn[i][j].getIcon() == King2) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean EndGameBlack() {//checking black won or not
		for (int i = 0; i < btn.length; i++) {
			for (int j = 0; j < btn.length; j++) {
				if (btn[i][j].getIcon() == King1) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean Wait() {//wait for correct move from pieces
		for (int i = 0; i < btn.length; i++) {
			for (int j = 0; j < btn.length; j++) {
				if (btn[i][j].getIcon() == circle || btn[i][j].getBorder() == border) {
					return true;
				}
			}
		}
		return false;
	}


	public static void board(Icon icon) {//fill the array of jbutton btnovercome white overcome pieces
		lbl:for (int i = 0; i < btnOverCome.length; i++) {
			for (int j = 0; j < btnOverCome.length; j++) {
				if (btnOverCome[i][j].getIcon() == null) {
					btnOverCome[i][j].setIcon(icon);
					break lbl;
				}

			}
			
		}
	}
	public void checkTurn(JLabel turnShow) {//check turns
		if (turn == true) {

			turnShow.setText("White Turn");
		} else {

			turnShow.setText("Black Turn");
		}
	}

	public static void ClearBorder(int i, int j) {//clear all the borders
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				if (btn[m][n].getBorder() == border) {
					btn[m][n].setBorder(null);
				}
			}
		}

	}

	public static void ClearChoice(int i, int j) {//clear all the circles
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				if (btn[m][n].getIcon() == circle) {
					btn[m][n].setIcon(null);

				}
			}
		}

	}
	public static void ClearChoiceRed(int i, int j) {//clear all the circles
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				if (btn[m][n].getIcon() == RedCircle) {
					btn[m][n].setIcon(null);

				}
			}
		}

	}
	public static void PawnChoiceBlack(int i, int j) {
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				if (m == i + 1 && n == j && (btn[m][n].getIcon() == null)) {

					btn[m][n].setIcon(circle);
				}
			}
		}

	}

	public static void PawnChoiceBlackFirst(int i, int j) {
		// ----------------------------btn[i+1][j]--------------------------------
		if (btn[i + 1][j].getIcon() == null) {

			btn[i + 1][j].setIcon(circle);
		}
		// ----------------------------btn[i+2][j]--------------------------------
		if (btn[i + 2][j].getIcon() == null) {

			btn[i + 2][j].setIcon(circle);
		}
	}

//
	//
	public static void PawnChoiceBlackAttack(int i, int j) {
		// ------------------btn[i+1][j+1]-----------------
		if (j < 7) {
			if ((btn[i + 1][j + 1].getIcon() == Pawn2) || (btn[i + 1][j + 1].getIcon() == King2)
					|| (btn[i + 1][j + 1].getIcon() == Knight2) || (btn[i + 1][j + 1].getIcon() == Bishop2)
					|| (btn[i + 1][j + 1].getIcon() == Queen2) || (btn[i + 1][j + 1].getIcon() == Rook2)) {
				btn[i + 1][j + 1].setBorder(border);

			}
		}
		// ------------------btn[i+1][j-1]------------------
		if (j > 0) {
			if ((btn[i + 1][j - 1].getIcon() == Pawn2) || (btn[i + 1][j - 1].getIcon() == King2)
					|| (btn[i + 1][j - 1].getIcon() == Knight2) || (btn[i + 1][j - 1].getIcon() == Bishop2)
					|| (btn[i + 1][j - 1].getIcon() == Queen2) || (btn[i + 1][j - 1].getIcon() == Rook2)) {
				btn[i + 1][j - 1].setBorder(border);

			}
		}
	}

	public static void PawnChoiceWhite(int i, int j) {
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				if (m == i - 1 && n == j && btn[m][n].getIcon() == null) {
					btn[m][n].setIcon(circle);

				}
			}
		}

	}

	public static void PawnChoiceWhiteFirst(int i, int j) {
		// ----------------------------btn[i-1][j]--------------------------------
		if (btn[i - 1][j].getIcon() == null) {

			btn[i - 1][j].setIcon(circle);
		}
		// ----------------------------btn[i-2][j]--------------------------------
		if (btn[i - 2][j].getIcon() == null) {

			btn[i - 2][j].setIcon(circle);
		}

	}

	public static void PawnChoiceWhiteAttack(int i, int j) {
		// ------------------btn[i-1][j+1]----------------------------
		if (j < 7) {
			if ((btn[i - 1][j + 1].getIcon() == Pawn1) || (btn[i - 1][j + 1].getIcon() == King1)
					|| (btn[i - 1][j + 1].getIcon() == Knight1) || (btn[i - 1][j + 1].getIcon() == Bishop1)
					|| (btn[i - 1][j + 1].getIcon() == Queen1) || (btn[i - 1][j + 1].getIcon() == Rook1)) {
				btn[i - 1][j + 1].setBorder(border);

			}
		}
		// ------------------btn[i-1][j-1]----------------------------
		if (j > 0) {
			if ((btn[i - 1][j - 1].getIcon() == Pawn1) || (btn[i - 1][j - 1].getIcon() == King1)
					|| (btn[i - 1][j - 1].getIcon() == Knight1) || (btn[i - 1][j - 1].getIcon() == Bishop1)
					|| (btn[i - 1][j - 1].getIcon() == Queen1) || (btn[i - 1][j - 1].getIcon() == Rook1)) {
				btn[i - 1][j - 1].setBorder(border);

			}
		}
	}

	public static void RookChoiceBlack(int i, int j) {

		int n = j;
		for (int m = i + 1; m < btn.length; m++) {
			if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
					|| (btn[m][n].getIcon() == Rook2)) {
				btn[m][n].setBorder(border);
				break;
			}
			if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
					|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
					|| (btn[m][n].getIcon() == Rook1)) {

				break;
			}
			if (btn[m][n].getIcon() == null) {
				btn[m][n].setIcon(circle);
			}
			if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == Bishop2)
					|| (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Queen2) || (btn[m][n].getIcon() == Rook2))) {
				btn[m][n].setBorder(border);
			}

		}
		int m = i;
		for (int k = j + 1; k < btn.length; k++) {
			if ((btn[m][k].getIcon() == Pawn2) || (btn[m][k].getIcon() == King2) || (btn[m][k].getIcon() == Knight2)
					|| (btn[m][k].getIcon() == Bishop2) || (btn[m][k].getIcon() == Queen2)
					|| (btn[m][k].getIcon() == Rook2)) {
				btn[m][k].setBorder(border);
				break;
			}
			if ((btn[m][k].getIcon() == Pawn1) || (btn[m][k].getIcon() == King1) || (btn[m][k].getIcon() == Knight1)
					|| (btn[m][k].getIcon() == Bishop1) || (btn[m][k].getIcon() == Queen1)
					|| (btn[m][k].getIcon() == Rook1)) {

				break;
			}
			if (btn[m][k].getIcon() == null) {
				btn[m][k].setIcon(circle);
			}
			if (btn[m][k].getIcon() != null && ((btn[m][k].getIcon() == Pawn2) || (btn[m][k].getIcon() == Bishop2)
					|| (btn[m][k].getIcon() == King2) || (btn[m][k].getIcon() == Knight2)
					|| (btn[m][k].getIcon() == Queen2) || (btn[m][k].getIcon() == Rook2))) {
				btn[m][k].setBorder(border);
			}

		}
		if (i > 0) {
			int p1 = j;
			for (int p2 = i - 1; p2 >= 0; p2--) {
				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == Bishop2)
								|| (btn[p2][p1].getIcon() == King2) || (btn[p2][p1].getIcon() == Knight2)
								|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2))) {
					btn[p2][p1].setBorder(border);
				}

			}
		}
		if (j > 0) {
			int u1 = i;
			for (int u2 = j - 1; u2 >= 0; u2--) {
				if ((btn[u1][u2].getIcon() == Pawn2) || (btn[u1][u2].getIcon() == King2)
						|| (btn[u1][u2].getIcon() == Knight2) || (btn[u1][u2].getIcon() == Bishop2)
						|| (btn[u1][u2].getIcon() == Queen2) || (btn[u1][u2].getIcon() == Rook2)) {
					btn[u1][u2].setBorder(border);
					break;
				}
				if ((btn[u1][u2].getIcon() == Pawn1) || (btn[u1][u2].getIcon() == King1)
						|| (btn[u1][u2].getIcon() == Knight1) || (btn[u1][u2].getIcon() == Bishop1)
						|| (btn[u1][u2].getIcon() == Queen1) || (btn[u1][u2].getIcon() == Rook1)) {

					break;
				}
				if (btn[u1][u2].getIcon() == null) {
					btn[u1][u2].setIcon(circle);
				}
				if (btn[u1][u2].getIcon() != null
						&& ((btn[u1][u2].getIcon() == Pawn2) || btn[u1][u2].getIcon() == Bishop2)
						|| (btn[u1][u2].getIcon() == King2) || (btn[u1][u2].getIcon() == Knight2)
						|| (btn[u1][u2].getIcon() == Queen2) || (btn[u1][u2].getIcon() == Rook2)) {
					btn[u1][u2].setBorder(border);
				}

			}
		}

	}

	public static void RookChoiceWhite(int i, int j) {
		int n = j;
		for (int m = i + 1; m < btn.length; m++) {
			if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
					|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
					|| (btn[m][n].getIcon() == Rook1)) {
				btn[m][n].setBorder(border);
				break;
			}
			if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
					|| (btn[m][n].getIcon() == Rook2)) {

				break;
			}
			if (btn[m][n].getIcon() == null) {
				btn[m][n].setIcon(circle);
			}
			if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == Bishop1)
					|| (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
					|| (btn[m][n].getIcon() == Queen1) || (btn[m][n].getIcon() == Rook1))) {
				btn[m][n].setBorder(border);
			}

		}
		int m = i;
		for (int k = j + 1; k < btn.length; k++) {
			if ((btn[m][k].getIcon() == Pawn1) || (btn[m][k].getIcon() == King1) || (btn[m][k].getIcon() == Knight1)
					|| (btn[m][k].getIcon() == Bishop1) || (btn[m][k].getIcon() == Queen1)
					|| (btn[m][k].getIcon() == Rook1)) {
				btn[m][k].setBorder(border);
				break;
			}
			if ((btn[m][k].getIcon() == Pawn2) || (btn[m][k].getIcon() == King2) || (btn[m][k].getIcon() == Knight2)
					|| (btn[m][k].getIcon() == Bishop2) || (btn[m][k].getIcon() == Queen2)
					|| (btn[m][k].getIcon() == Rook2)) {

				break;
			}
			if (btn[m][k].getIcon() == null) {
				btn[m][k].setIcon(circle);
			}
			if (btn[m][k].getIcon() != null && ((btn[m][k].getIcon() == Pawn1) || (btn[m][k].getIcon() == Bishop1)
					|| (btn[m][k].getIcon() == King1) || (btn[m][k].getIcon() == Knight1)
					|| (btn[m][k].getIcon() == Queen1) || (btn[m][k].getIcon() == Rook1))) {
				btn[m][k].setBorder(border);
			}

		}
		if (i > 0) {
			int p1 = j;
			for (int p2 = i - 1; p2 >= 0; p2--) {
				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == Bishop1)
								|| (btn[p2][p1].getIcon() == King1) || (btn[p2][p1].getIcon() == Knight1)
								|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1))) {
					btn[p2][p1].setBorder(border);
				}

			}
		}
		if (j > 0) {
			int u1 = i;
			for (int u2 = j - 1; u2 >= 0; u2--) {
				if ((btn[u1][u2].getIcon() == Pawn1) || (btn[u1][u2].getIcon() == King1)
						|| (btn[u1][u2].getIcon() == Knight1) || (btn[u1][u2].getIcon() == Bishop1)
						|| (btn[u1][u2].getIcon() == Queen1) || (btn[u1][u2].getIcon() == Rook1)) {
					btn[u1][u2].setBorder(border);
					break;
				}
				if ((btn[u1][u2].getIcon() == Pawn2) || (btn[u1][u2].getIcon() == King2)
						|| (btn[u1][u2].getIcon() == Knight2) || (btn[u1][u2].getIcon() == Bishop2)
						|| (btn[u1][u2].getIcon() == Queen2) || (btn[u1][u2].getIcon() == Rook2)) {

					break;
				}
				if (btn[u1][u2].getIcon() == null) {
					btn[u1][u2].setIcon(circle);
				}
				if (btn[u1][u2].getIcon() != null
						&& ((btn[u1][u2].getIcon() == Pawn1) || btn[u1][u2].getIcon() == Bishop1)
						|| (btn[u1][u2].getIcon() == King1) || (btn[u1][u2].getIcon() == Knight1)
						|| (btn[u1][u2].getIcon() == Queen1) || (btn[u1][u2].getIcon() == Rook1)) {
					btn[u1][u2].setBorder(border);
				}

			}
		}
	}

	public static void KnightChoiceBlack(int i, int j) {
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				int row = Math.abs(m - i);
				int colmn = Math.abs(n - j);
				if (((row == 1 && colmn == 2) || (row == 2 && colmn == 1))) {

					if (btn[m][n].getIcon() == null) {
						btn[m][n].setIcon(circle);
					}
					if (btn[m][n].getIcon() != null
							&& ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == Bishop2)
									|| (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
									|| (btn[m][n].getIcon() == Queen2) || (btn[m][n].getIcon() == Rook2))) {
						btn[m][n].setBorder(border);
					}

				}
			}
		}

	}

	public static void KnightChoiceWhite(int i, int j) {
		for (int m = 0; m < btn.length; m++) {
			for (int n = 0; n < btn.length; n++) {
				int row = Math.abs(m - i);
				int colmn = Math.abs(n - j);
				if (((row == 1 && colmn == 2) || (row == 2 && colmn == 1))) {

					if (btn[m][n].getIcon() == null) {
						btn[m][n].setIcon(circle);
					}
					if (btn[m][n].getIcon() != null
							&& ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == Bishop1)
									|| (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
									|| (btn[m][n].getIcon() == Queen1) || (btn[m][n].getIcon() == Rook1))) {
						btn[m][n].setBorder(border);
					}

				}
			}
		}
	}

	public static void KingChoicBlack(int i, int j) {
		int m = i + 1;
		for (int n = j - 1; n <= j + 1; n++) {
			if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
					|| (btn[m][n].getIcon() == Rook2)) {
				btn[m][n].setBorder(border);

			}

			if (btn[m][n].getIcon() == null) {
				btn[m][n].setIcon(circle);
			}
			if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == Bishop2)
					|| (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Queen2) || (btn[m][n].getIcon() == Rook2))) {
				btn[m][n].setBorder(border);
			}

		}
		if (i > 0) {
			int p = i - 1;
			for (int k = j - 1; k <= j + 1; k++) {
				if ((btn[p][k].getIcon() == Pawn2) || (btn[p][k].getIcon() == King2) || (btn[p][k].getIcon() == Knight2)
						|| (btn[p][k].getIcon() == Bishop2) || (btn[p][k].getIcon() == Queen2)
						|| (btn[p][k].getIcon() == Rook2)) {
					btn[p][k].setBorder(border);

				}

				if (btn[p][k].getIcon() == null) {
					btn[p][k].setIcon(circle);
				}
				if (btn[p][k].getIcon() != null && ((btn[p][k].getIcon() == Pawn2) || (btn[p][k].getIcon() == Bishop2)
						|| (btn[p][k].getIcon() == King2) || (btn[p][k].getIcon() == Knight2)
						|| (btn[p][k].getIcon() == Queen2) || (btn[p][k].getIcon() == Rook2))) {
					btn[p][k].setBorder(border);
				}

			}
		}
		// ----------------------------------------btn[i][j+1]-----------------------------------
		if ((btn[i][j + 1].getIcon() == Pawn2) || (btn[i][j + 1].getIcon() == King2)
				|| (btn[i][j + 1].getIcon() == Knight2) || (btn[i][j + 1].getIcon() == Bishop2)
				|| (btn[i][j + 1].getIcon() == Queen2) || (btn[i][j + 1].getIcon() == Rook2)) {
			btn[i][j + 1].setBorder(border);

		}

		if (btn[i][j + 1].getIcon() == null) {
			btn[i][j + 1].setIcon(circle);
		}
		if (btn[i][j + 1].getIcon() != null
				&& ((btn[i][j + 1].getIcon() == Pawn2) || (btn[i][j + 1].getIcon() == Bishop2)
						|| (btn[i][j + 1].getIcon() == King2) || (btn[i][j + 1].getIcon() == Knight2)
						|| (btn[i][j + 1].getIcon() == Queen2) || (btn[i][j + 1].getIcon() == Rook2))) {
			btn[i][j + 1].setBorder(border);
		}

		// ---------------------------------------btn[i][j-1]-----------------------------------
		if ((btn[i][j - 1].getIcon() == Pawn2) || (btn[i][j - 1].getIcon() == King2)
				|| (btn[i][j - 1].getIcon() == Knight2) || (btn[i][j - 1].getIcon() == Bishop2)
				|| (btn[i][j - 1].getIcon() == Queen2) || (btn[i][j - 1].getIcon() == Rook2)) {
			btn[i][j - 1].setBorder(border);

		}

		if (btn[i][j - 1].getIcon() == null) {
			btn[i][j - 1].setIcon(circle);
		}
		if (btn[i][j - 1].getIcon() != null
				&& ((btn[i][j - 1].getIcon() == Pawn2) || (btn[i][j - 1].getIcon() == Bishop2)
						|| (btn[i][j - 1].getIcon() == King2) || (btn[i][j - 1].getIcon() == Knight2)
						|| (btn[i][j - 1].getIcon() == Queen2) || (btn[i][j - 1].getIcon() == Rook2))) {
			btn[i][j - 1].setBorder(border);
		}
	}

	public static void KingChoicWhite(int i, int j) {
		if (i < 7) {
			int m = i + 1;
			for (int n = j - 1; n <= j + 1; n++) {
				if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
						|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
						|| (btn[m][n].getIcon() == Rook1)) {
					btn[m][n].setBorder(border);

				}

				if (btn[m][n].getIcon() == null) {
					btn[m][n].setIcon(circle);
				}
				if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == Bishop1)
						|| (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
						|| (btn[m][n].getIcon() == Queen1) || (btn[m][n].getIcon() == Rook1))) {
					btn[m][n].setBorder(border);
				}

			}
		}
		int p = i - 1;
		for (int k = j - 1; k <= j + 1; k++) {
			if ((btn[p][k].getIcon() == Pawn1) || (btn[p][k].getIcon() == King1) || (btn[p][k].getIcon() == Knight1)
					|| (btn[p][k].getIcon() == Bishop1) || (btn[p][k].getIcon() == Queen1)
					|| (btn[p][k].getIcon() == Rook2)) {
				btn[p][k].setBorder(border);

			}

			if (btn[p][k].getIcon() == null) {
				btn[p][k].setIcon(circle);
			}
			if (btn[p][k].getIcon() != null && ((btn[p][k].getIcon() == Pawn1) || (btn[p][k].getIcon() == Bishop1)
					|| (btn[p][k].getIcon() == King1) || (btn[p][k].getIcon() == Knight1)
					|| (btn[p][k].getIcon() == Queen1) || (btn[p][k].getIcon() == Rook1))) {
				btn[p][k].setBorder(border);
			}

		}

		// ----------------------------------------btn[i][j+1]-----------------------------------
		if ((btn[i][j + 1].getIcon() == Pawn1) || (btn[i][j + 1].getIcon() == King1)
				|| (btn[i][j + 1].getIcon() == Knight1) || (btn[i][j + 1].getIcon() == Bishop1)
				|| (btn[i][j + 1].getIcon() == Queen1) || (btn[i][j + 1].getIcon() == Rook1)) {
			btn[i][j + 1].setBorder(border);

		}

		if (btn[i][j + 1].getIcon() == null) {
			btn[i][j + 1].setIcon(circle);
		}
		if (btn[i][j + 1].getIcon() != null
				&& ((btn[i][j + 1].getIcon() == Pawn1) || (btn[i][j + 1].getIcon() == Bishop1)
						|| (btn[i][j + 1].getIcon() == King1) || (btn[i][j + 1].getIcon() == Knight1)
						|| (btn[i][j + 1].getIcon() == Queen1) || (btn[i][j + 1].getIcon() == Rook1))) {
			btn[i][j + 1].setBorder(border);
		}

		// ---------------------------------------btn[i][j-1]-----------------------------------
		if ((btn[i][j - 1].getIcon() == Pawn1) || (btn[i][j - 1].getIcon() == King1)
				|| (btn[i][j - 1].getIcon() == Knight1) || (btn[i][j - 1].getIcon() == Bishop1)
				|| (btn[i][j - 1].getIcon() == Queen1) || (btn[i][j - 1].getIcon() == Rook1)) {
			btn[i][j - 1].setBorder(border);

		}

		if (btn[i][j - 1].getIcon() == null) {
			btn[i][j - 1].setIcon(circle);
		}
		if (btn[i][j - 1].getIcon() != null
				&& ((btn[i][j - 1].getIcon() == Pawn1) || (btn[i][j - 1].getIcon() == Bishop1)
						|| (btn[i][j - 1].getIcon() == King1) || (btn[i][j - 1].getIcon() == Knight1)
						|| (btn[i][j - 1].getIcon() == Queen1) || (btn[i][j - 1].getIcon() == Rook1))) {
			btn[i][j - 1].setBorder(border);
		}
	}

	public static void KingSpecialWhite1(int i, int j) {
		if (btn[i][j + 1].getIcon() == null && btn[i][j + 2].getIcon() == null) {
			btn[i][j + 2].setIcon(RedCircle);
		}

	}

	public static void KingSpecialWhite2(int i, int j) {
		if (btn[i][j - 1].getIcon() == null && btn[i][j - 2].getIcon() == null && btn[i][j - 3].getIcon() == null) {
			btn[i][j - 2].setIcon(RedCircle);
		}

	}

	public static void KingSpecialBlack1(int i, int j) {
		if (btn[i][j + 1].getIcon() == null && btn[i][j + 2].getIcon() == null) {
			btn[i][j + 2].setIcon(RedCircle);
		}

	}

	public static void KingSpecialBlack2(int i, int j) {
		if (btn[i][j - 1].getIcon() == null && btn[i][j - 2].getIcon() == null && btn[i][j - 3].getIcon() == null) {
			btn[i][j - 2].setIcon(RedCircle);
		}

	}

	public static void BishopChoiceBlack(int i, int j) {
		int n = j + 1;
		for (int m = i + 1; m < btn.length; m++) {
			if (n < 8) {

				if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
						|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
						|| (btn[m][n].getIcon() == Rook2)) {
					btn[m][n].setBorder(border);
					break;
				}
				if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
						|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
						|| (btn[m][n].getIcon() == Rook1)) {

					break;
				}
				if (btn[m][n].getIcon() == null) {
					btn[m][n].setIcon(circle);
				}
				if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == Bishop2)
						|| (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
						|| (btn[m][n].getIcon() == Queen2) || (btn[m][n].getIcon() == Rook2))) {
					btn[m][n].setBorder(border);
				}

				n = n + 1;
			} else {
				break;
			}

		}
		int p1 = j - 1;
		for (int p2 = i + 1; p2 < btn.length; p2++) {
			if (p1 >= 0) {

				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == Bishop2)
								|| (btn[p2][p1].getIcon() == King2) || (btn[p2][p1].getIcon() == Knight2)
								|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2))) {
					btn[p2][p1].setBorder(border);
				}

				p1 = p1 - 1;
			} else {
				break;
			}

		}
		int a = j - 1;
		for (int b = i - 1; b >= 0; b--) {

			if (a >= 0) {

				if ((btn[b][a].getIcon() == Pawn2) || (btn[b][a].getIcon() == King2) || (btn[b][a].getIcon() == Knight2)
						|| (btn[b][a].getIcon() == Bishop2) || (btn[b][a].getIcon() == Queen2)
						|| (btn[b][a].getIcon() == Rook1)) {
					btn[b][a].setBorder(border);
					break;
				}
				if ((btn[b][a].getIcon() == Pawn1) || (btn[b][a].getIcon() == King1) || (btn[b][a].getIcon() == Knight1)
						|| (btn[b][a].getIcon() == Bishop1) || (btn[b][a].getIcon() == Queen1)
						|| (btn[b][a].getIcon() == Rook1)) {

					break;
				}
				if (btn[b][a].getIcon() == null) {
					btn[b][a].setIcon(circle);
				}
				if (btn[b][a].getIcon() != null && ((btn[b][a].getIcon() == Pawn2) || (btn[b][a].getIcon() == Bishop2)
						|| (btn[b][a].getIcon() == King2) || (btn[b][a].getIcon() == Knight2)
						|| (btn[b][a].getIcon() == Queen2) || (btn[b][a].getIcon() == Rook2))) {
					btn[b][a].setBorder(border);
				}
				a = a - 1;
			} else {
				break;
			}

		}
		int v = j + 1;
		for (int x = i - 1; x > 0; x--) {

			if (v < 8) {

				if ((btn[x][v].getIcon() == Pawn2) || (btn[x][v].getIcon() == King2) || (btn[x][v].getIcon() == Knight2)
						|| (btn[x][v].getIcon() == Bishop2) || (btn[x][v].getIcon() == Queen2)
						|| (btn[x][v].getIcon() == Rook2)) {
					btn[x][v].setBorder(border);
					break;
				}
				if ((btn[x][v].getIcon() == Pawn1) || (btn[x][v].getIcon() == King1) || (btn[x][v].getIcon() == Knight1)
						|| (btn[x][v].getIcon() == Bishop1) || (btn[x][v].getIcon() == Queen1)
						|| (btn[x][v].getIcon() == Rook1)) {

					break;
				}
				if (btn[x][v].getIcon() == null) {
					btn[x][v].setIcon(circle);
				}
				if (btn[x][v].getIcon() != null && ((btn[x][v].getIcon() == Pawn2) || (btn[x][v].getIcon() == Bishop2)
						|| (btn[x][v].getIcon() == King2) || (btn[x][v].getIcon() == Knight2)
						|| (btn[x][v].getIcon() == Queen2) || (btn[x][v].getIcon() == Rook2))) {
					btn[x][v].setBorder(border);
				}
				v = v + 1;
			} else {
				break;
			}

		}
	}

	public static void BishopChoiceWhite(int i, int j) {
		int n = j + 1;
		for (int m = i + 1; m < btn.length; m++) {
			if (n < 8) {

				if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
						|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
						|| (btn[m][n].getIcon() == Rook1)) {
					btn[m][n].setBorder(border);
					break;
				}
				if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
						|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
						|| (btn[m][n].getIcon() == Rook2)) {

					break;
				}
				if (btn[m][n].getIcon() == null) {
					btn[m][n].setIcon(circle);
				}
				if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == Bishop1)
						|| (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
						|| (btn[m][n].getIcon() == Queen1) || (btn[m][n].getIcon() == Rook1))) {
					btn[m][n].setBorder(border);
				}

				n = n + 1;
			} else {
				break;
			}

		}
		int p1 = j - 1;
		for (int p2 = i + 1; p2 < btn.length; p2++) {
			if (p1 >= 0) {

				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == Bishop1)
								|| (btn[p2][p1].getIcon() == King1) || (btn[p2][p1].getIcon() == Knight1)
								|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1))) {
					btn[p2][p1].setBorder(border);
				}

				p1 = p1 - 1;
			} else {
				break;
			}

		}
		int a = j - 1;
		for (int b = i - 1; b >= 0; b--) {

			if (a >= 0) {

				if ((btn[b][a].getIcon() == Pawn1) || (btn[b][a].getIcon() == King1) || (btn[b][a].getIcon() == Knight1)
						|| (btn[b][a].getIcon() == Bishop1) || (btn[b][a].getIcon() == Queen1)
						|| (btn[b][a].getIcon() == Rook1)) {
					btn[b][a].setBorder(border);
					break;
				}
				if ((btn[b][a].getIcon() == Pawn2) || (btn[b][a].getIcon() == King2) || (btn[b][a].getIcon() == Knight2)
						|| (btn[b][a].getIcon() == Bishop2) || (btn[b][a].getIcon() == Queen2)
						|| (btn[b][a].getIcon() == Rook2)) {

					break;
				}
				if (btn[b][a].getIcon() == null) {
					btn[b][a].setIcon(circle);
				}
				if (btn[b][a].getIcon() != null && ((btn[b][a].getIcon() == Pawn1) || (btn[b][a].getIcon() == Bishop1)
						|| (btn[b][a].getIcon() == King1) || (btn[b][a].getIcon() == Knight1)
						|| (btn[b][a].getIcon() == Queen1) || (btn[b][a].getIcon() == Rook1))) {
					btn[b][a].setBorder(border);
				}
				a = a - 1;
			} else {
				break;
			}

		}
		int v = j + 1;
		for (int x = i - 1; x > 0; x--) {

			if (v < 8) {

				if ((btn[x][v].getIcon() == Pawn1) || (btn[x][v].getIcon() == King1) || (btn[x][v].getIcon() == Knight1)
						|| (btn[x][v].getIcon() == Bishop1) || (btn[x][v].getIcon() == Queen1)
						|| (btn[x][v].getIcon() == Rook1)) {
					btn[x][v].setBorder(border);
					break;
				}
				if ((btn[x][v].getIcon() == Pawn2) || (btn[x][v].getIcon() == King2) || (btn[x][v].getIcon() == Knight2)
						|| (btn[x][v].getIcon() == Bishop2) || (btn[x][v].getIcon() == Queen2)
						|| (btn[x][v].getIcon() == Rook2)) {

					break;
				}
				if (btn[x][v].getIcon() == null) {
					btn[x][v].setIcon(circle);
					System.out.println("1");
				}
				if (btn[x][v].getIcon() != null && ((btn[x][v].getIcon() == Pawn1) || (btn[x][v].getIcon() == Bishop1)
						|| (btn[x][v].getIcon() == King1) || (btn[x][v].getIcon() == Knight1)
						|| (btn[x][v].getIcon() == Queen1) || (btn[x][v].getIcon() == Rook1))) {
					btn[x][v].setBorder(border);
				}
				v = v + 1;
			} else {
				break;
			}

		}

	}

	public static void QueenChoiceBlack(int i, int j) {
		int n = j;
		for (int m = i + 1; m < btn.length; m++) {
			if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
					|| (btn[m][n].getIcon() == Rook2)) {
				btn[m][n].setBorder(border);
				break;
			}
			if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
					|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
					|| (btn[m][n].getIcon() == Rook1)) {

				break;
			}
			if (btn[m][n].getIcon() == null) {
				btn[m][n].setIcon(circle);
			}
			if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == Bishop2)
					|| (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Queen2) || (btn[m][n].getIcon() == Rook2))) {
				btn[m][n].setBorder(border);
			}

		}
		int m = i;
		for (int k = j + 1; k < btn.length; k++) {
			if ((btn[m][k].getIcon() == Pawn2) || (btn[m][k].getIcon() == King2) || (btn[m][k].getIcon() == Knight2)
					|| (btn[m][k].getIcon() == Bishop2) || (btn[m][k].getIcon() == Queen2)
					|| (btn[m][k].getIcon() == Rook2)) {
				btn[m][k].setBorder(border);
				break;
			}
			if ((btn[m][k].getIcon() == Pawn1) || (btn[m][k].getIcon() == King1) || (btn[m][k].getIcon() == Knight1)
					|| (btn[m][k].getIcon() == Bishop1) || (btn[m][k].getIcon() == Queen1)
					|| (btn[m][k].getIcon() == Rook1)) {

				break;
			}
			if (btn[m][k].getIcon() == null) {
				btn[m][k].setIcon(circle);
			}
			if (btn[m][k].getIcon() != null && ((btn[m][k].getIcon() == Pawn2) || (btn[m][k].getIcon() == Bishop2)
					|| (btn[m][k].getIcon() == King2) || (btn[m][k].getIcon() == Knight2)
					|| (btn[m][k].getIcon() == Queen2) || (btn[m][k].getIcon() == Rook2))) {
				btn[m][k].setBorder(border);
			}

		}
		if (i > 0) {
			int p1 = j;
			for (int p2 = i - 1; p2 >= 0; p2--) {
				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == Bishop2)
								|| (btn[p2][p1].getIcon() == King2) || (btn[p2][p1].getIcon() == Knight2)
								|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2))) {
					btn[p2][p1].setBorder(border);
				}

			}

		}
		if (j > 0) {
			int u1 = i;
			for (int u2 = j - 1; u2 >= 0; u2--) {
				if ((btn[u1][u2].getIcon() == Pawn2) || (btn[u1][u2].getIcon() == King2)
						|| (btn[u1][u2].getIcon() == Knight2) || (btn[u1][u2].getIcon() == Bishop2)
						|| (btn[u1][u2].getIcon() == Queen2) || (btn[u1][u2].getIcon() == Rook2)) {
					btn[u1][u2].setBorder(border);
					break;
				}
				if ((btn[u1][u2].getIcon() == Pawn1) || (btn[u1][u2].getIcon() == King1)
						|| (btn[u1][u2].getIcon() == Knight1) || (btn[u1][u2].getIcon() == Bishop1)
						|| (btn[u1][u2].getIcon() == Queen1) || (btn[u1][u2].getIcon() == Rook1)) {

					break;
				}
				if (btn[u1][u2].getIcon() == null) {
					btn[u1][u2].setIcon(circle);
				}
				if (btn[u1][u2].getIcon() != null
						&& ((btn[u1][u2].getIcon() == Pawn2) || btn[u1][u2].getIcon() == Bishop2)
						|| (btn[u1][u2].getIcon() == King2) || (btn[u1][u2].getIcon() == Knight2)
						|| (btn[u1][u2].getIcon() == Queen2) || (btn[u1][u2].getIcon() == Rook2)) {
					btn[u1][u2].setBorder(border);
				}

			}
		}
		int n1 = j + 1;
		for (int m1 = i + 1; m1 < btn.length; m1++) {
			if (n1 < 8) {

				if ((btn[m1][n1].getIcon() == Pawn2) || (btn[m1][n1].getIcon() == King2)
						|| (btn[m1][n1].getIcon() == Knight2) || (btn[m1][n1].getIcon() == Bishop2)
						|| (btn[m1][n1].getIcon() == Queen2) || (btn[m1][n1].getIcon() == Rook2)) {
					btn[m1][n1].setBorder(border);
					break;
				}
				if ((btn[m1][n1].getIcon() == Pawn1) || (btn[m1][n1].getIcon() == King1)
						|| (btn[m1][n1].getIcon() == Knight1) || (btn[m1][n1].getIcon() == Bishop1)
						|| (btn[m1][n1].getIcon() == Queen1) || (btn[m1][n1].getIcon() == Rook1)) {

					break;
				}
				if (btn[m1][n1].getIcon() == null) {
					btn[m1][n1].setIcon(circle);
				}
				if (btn[m1][n1].getIcon() != null
						&& ((btn[m1][n1].getIcon() == Pawn2) || (btn[m1][n1].getIcon() == Bishop2)
								|| (btn[m1][n1].getIcon() == King2) || (btn[m1][n1].getIcon() == Knight2)
								|| (btn[m1][n1].getIcon() == Queen2) || (btn[m1][n1].getIcon() == Rook2))) {
					btn[m1][n1].setBorder(border);
				}

				n1 = n1 + 1;
			} else {
				break;
			}

		}
		int p1 = j - 1;
		for (int p2 = i + 1; p2 < btn.length; p2++) {
			if (p1 >= 0) {

				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == Bishop2)
								|| (btn[p2][p1].getIcon() == King2) || (btn[p2][p1].getIcon() == Knight2)
								|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2))) {
					btn[p2][p1].setBorder(border);
				}

				p1 = p1 - 1;
			} else {
				break;
			}

		}
		int a = j - 1;
		for (int b = i - 1; b >= 0; b--) {

			if (a >= 0) {

				if ((btn[b][a].getIcon() == Pawn2) || (btn[b][a].getIcon() == King2) || (btn[b][a].getIcon() == Knight2)
						|| (btn[b][a].getIcon() == Bishop2) || (btn[b][a].getIcon() == Queen2)
						|| (btn[b][a].getIcon() == Rook2)) {
					btn[b][a].setBorder(border);
					break;
				}
				if ((btn[b][a].getIcon() == Pawn1) || (btn[b][a].getIcon() == King1) || (btn[b][a].getIcon() == Knight1)
						|| (btn[b][a].getIcon() == Bishop1) || (btn[b][a].getIcon() == Queen1)
						|| (btn[b][a].getIcon() == Rook1)) {

					break;
				}
				if (btn[b][a].getIcon() == null) {
					btn[b][a].setIcon(circle);
				}
				if (btn[b][a].getIcon() != null && ((btn[b][a].getIcon() == Pawn2) || (btn[b][a].getIcon() == Bishop2)
						|| (btn[b][a].getIcon() == King2) || (btn[b][a].getIcon() == Knight2)
						|| (btn[b][a].getIcon() == Queen2) || (btn[b][a].getIcon() == Rook2))) {
					btn[b][a].setBorder(border);
				}
				a = a - 1;
			} else {
				break;
			}

		}
		int v = j + 1;
		for (int x = i - 1; x > 0; x--) {

			if (v < 8) {

				btn[x][v].setIcon(circle);
				if ((btn[x][v].getIcon() == Pawn2) || (btn[x][v].getIcon() == King2) || (btn[x][v].getIcon() == Knight2)
						|| (btn[x][v].getIcon() == Bishop2) || (btn[x][v].getIcon() == Queen2)
						|| (btn[x][v].getIcon() == Rook2)) {
					btn[x][v].setBorder(border);
					break;
				}
				if ((btn[x][v].getIcon() == Pawn1) || (btn[x][v].getIcon() == King1) || (btn[x][v].getIcon() == Knight1)
						|| (btn[x][v].getIcon() == Bishop1) || (btn[x][v].getIcon() == Queen1)
						|| (btn[x][v].getIcon() == Rook1)) {

					break;
				}
				if (btn[x][v].getIcon() == null) {
					btn[x][v].setIcon(circle);
				}
				if (btn[x][v].getIcon() != null && ((btn[x][v].getIcon() == Pawn2) || (btn[x][v].getIcon() == Bishop2)
						|| (btn[x][v].getIcon() == King2) || (btn[x][v].getIcon() == Knight2)
						|| (btn[x][v].getIcon() == Queen2) || (btn[x][v].getIcon() == Rook2))) {
					btn[x][v].setBorder(border);
				}
				v = v + 1;
			} else {
				break;
			}

		}
	}

	public static void QueenChoiceWhite(int i, int j) {
		int n = j;
		for (int m = i + 1; m < btn.length; m++) {
			if ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
					|| (btn[m][n].getIcon() == Bishop1) || (btn[m][n].getIcon() == Queen1)
					|| (btn[m][n].getIcon() == Rook1)) {
				btn[m][n].setBorder(border);
				break;
			}
			if ((btn[m][n].getIcon() == Pawn2) || (btn[m][n].getIcon() == King2) || (btn[m][n].getIcon() == Knight2)
					|| (btn[m][n].getIcon() == Bishop2) || (btn[m][n].getIcon() == Queen2)
					|| (btn[m][n].getIcon() == Rook2)) {

				break;
			}
			if (btn[m][n].getIcon() == null) {
				btn[m][n].setIcon(circle);
			}
			if (btn[m][n].getIcon() != null && ((btn[m][n].getIcon() == Pawn1) || (btn[m][n].getIcon() == Bishop1)
					|| (btn[m][n].getIcon() == King1) || (btn[m][n].getIcon() == Knight1)
					|| (btn[m][n].getIcon() == Queen1) || (btn[m][n].getIcon() == Rook1))) {
				btn[m][n].setBorder(border);
			}

		}
		int m = i;
		for (int k = j + 1; k < btn.length; k++) {
			if ((btn[m][k].getIcon() == Pawn1) || (btn[m][k].getIcon() == King1) || (btn[m][k].getIcon() == Knight1)
					|| (btn[m][k].getIcon() == Bishop1) || (btn[m][k].getIcon() == Queen1)
					|| (btn[m][k].getIcon() == Rook1)) {
				btn[m][k].setBorder(border);
				break;
			}
			if ((btn[m][k].getIcon() == Pawn2) || (btn[m][k].getIcon() == King2) || (btn[m][k].getIcon() == Knight2)
					|| (btn[m][k].getIcon() == Bishop2) || (btn[m][k].getIcon() == Queen2)
					|| (btn[m][k].getIcon() == Rook2)) {

				break;
			}
			if (btn[m][k].getIcon() == null) {
				btn[m][k].setIcon(circle);
			}
			if (btn[m][k].getIcon() != null && ((btn[m][k].getIcon() == Pawn1) || (btn[m][k].getIcon() == Bishop1)
					|| (btn[m][k].getIcon() == King1) || (btn[m][k].getIcon() == Knight1)
					|| (btn[m][k].getIcon() == Queen1) || (btn[m][k].getIcon() == Rook1))) {
				btn[m][k].setBorder(border);
			}

		}
		if (i > 0) {
			int p1 = j;
			for (int p2 = i - 1; p2 >= 0; p2--) {
				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == Bishop1)
								|| (btn[p2][p1].getIcon() == King1) || (btn[p2][p1].getIcon() == Knight1)
								|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1))) {
					btn[p2][p1].setBorder(border);
				}

			}
		}
		if (j > 0) {
			int u1 = i;
			for (int u2 = j - 1; u2 >= 0; u2--) {
				if ((btn[u1][u2].getIcon() == Pawn1) || (btn[u1][u2].getIcon() == King1)
						|| (btn[u1][u2].getIcon() == Knight1) || (btn[u1][u2].getIcon() == Bishop1)
						|| (btn[u1][u2].getIcon() == Queen1) || (btn[u1][u2].getIcon() == Rook1)) {
					btn[u1][u2].setBorder(border);
					break;
				}
				if ((btn[u1][u2].getIcon() == Pawn2) || (btn[u1][u2].getIcon() == King2)
						|| (btn[u1][u2].getIcon() == Knight2) || (btn[u1][u2].getIcon() == Bishop2)
						|| (btn[u1][u2].getIcon() == Queen2) || (btn[u1][u2].getIcon() == Rook2)) {

					break;
				}
				if (btn[u1][u2].getIcon() == null) {
					btn[u1][u2].setIcon(circle);
				}
				if (btn[u1][u2].getIcon() != null
						&& ((btn[u1][u2].getIcon() == Pawn1) || btn[u1][u2].getIcon() == Bishop1)
						|| (btn[u1][u2].getIcon() == King1) || (btn[u1][u2].getIcon() == Knight1)
						|| (btn[u1][u2].getIcon() == Queen1) || (btn[u1][u2].getIcon() == Rook1)) {
					btn[u1][u2].setBorder(border);
				}

			}
		}
		int n1 = j + 1;
		for (int m1 = i + 1; m1 < btn.length; m1++) {
			if (n1 < 8) {

				if ((btn[m1][n1].getIcon() == Pawn1) || (btn[m1][n1].getIcon() == King1)
						|| (btn[m1][n1].getIcon() == Knight1) || (btn[m1][n1].getIcon() == Bishop1)
						|| (btn[m1][n1].getIcon() == Queen1) || (btn[m1][n1].getIcon() == Rook1)) {
					btn[m1][n1].setBorder(border);
					break;
				}
				if ((btn[m1][n1].getIcon() == Pawn2) || (btn[m1][n1].getIcon() == King2)
						|| (btn[m1][n1].getIcon() == Knight2) || (btn[m1][n1].getIcon() == Bishop2)
						|| (btn[m1][n1].getIcon() == Queen2) || (btn[m1][n1].getIcon() == Rook2)) {

					break;
				}
				if (btn[m1][n1].getIcon() == null) {
					btn[m1][n1].setIcon(circle);
				}
				if (btn[m1][n1].getIcon() != null
						&& ((btn[m1][n1].getIcon() == Pawn1) || (btn[m1][n1].getIcon() == Bishop1)
								|| (btn[m1][n1].getIcon() == King1) || (btn[m1][n1].getIcon() == Knight1)
								|| (btn[m1][n1].getIcon() == Queen1) || (btn[m1][n1].getIcon() == Rook1))) {
					btn[m1][n1].setBorder(border);
				}

				n1 = n1 + 1;
			} else {
				break;
			}

		}
		int p1 = j - 1;
		for (int p2 = i + 1; p2 < btn.length; p2++) {
			if (p1 >= 0) {

				if ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == King1)
						|| (btn[p2][p1].getIcon() == Knight1) || (btn[p2][p1].getIcon() == Bishop1)
						|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1)) {
					btn[p2][p1].setBorder(border);
					break;
				}
				if ((btn[p2][p1].getIcon() == Pawn2) || (btn[p2][p1].getIcon() == King2)
						|| (btn[p2][p1].getIcon() == Knight2) || (btn[p2][p1].getIcon() == Bishop2)
						|| (btn[p2][p1].getIcon() == Queen2) || (btn[p2][p1].getIcon() == Rook2)) {

					break;
				}
				if (btn[p2][p1].getIcon() == null) {
					btn[p2][p1].setIcon(circle);
				}
				if (btn[p2][p1].getIcon() != null
						&& ((btn[p2][p1].getIcon() == Pawn1) || (btn[p2][p1].getIcon() == Bishop1)
								|| (btn[p2][p1].getIcon() == King1) || (btn[p2][p1].getIcon() == Knight1)
								|| (btn[p2][p1].getIcon() == Queen1) || (btn[p2][p1].getIcon() == Rook1))) {
					btn[p2][p1].setBorder(border);
				}

				p1 = p1 - 1;
			} else {
				break;
			}

		}
		int a = j - 1;
		for (int b = i - 1; b >= 0; b--) {

			if (a >= 0) {

				if ((btn[b][a].getIcon() == Pawn1) || (btn[b][a].getIcon() == King1) || (btn[b][a].getIcon() == Knight1)
						|| (btn[b][a].getIcon() == Bishop1) || (btn[b][a].getIcon() == Queen1)) {
					btn[b][a].setBorder(border);
					break;
				}
				if ((btn[b][a].getIcon() == Pawn2) || (btn[b][a].getIcon() == King2) || (btn[b][a].getIcon() == Knight2)
						|| (btn[b][a].getIcon() == Bishop2) || (btn[b][a].getIcon() == Queen2)
						|| (btn[b][a].getIcon() == Rook2)) {

					break;
				}
				if (btn[b][a].getIcon() == null) {
					btn[b][a].setIcon(circle);
				}
				if (btn[b][a].getIcon() != null && ((btn[b][a].getIcon() == Pawn1) || (btn[b][a].getIcon() == Bishop1)
						|| (btn[b][a].getIcon() == King1) || (btn[b][a].getIcon() == Knight1)
						|| (btn[b][a].getIcon() == Queen1) || (btn[b][a].getIcon() == Rook1))) {
					btn[b][a].setBorder(border);
				}
				a = a - 1;
			} else {
				break;
			}

		}
		int v = j + 1;
		for (int x = i - 1; x > 0; x--) {

			if (v < 8) {

				if ((btn[x][v].getIcon() == Pawn1) || (btn[x][v].getIcon() == King1) || (btn[x][v].getIcon() == Knight1)
						|| (btn[x][v].getIcon() == Bishop1) || (btn[x][v].getIcon() == Queen1)
						|| (btn[x][v].getIcon() == Rook1)) {
					btn[x][v].setBorder(border);
					break;
				}
				if ((btn[x][v].getIcon() == Pawn2) || (btn[x][v].getIcon() == King2) || (btn[x][v].getIcon() == Knight2)
						|| (btn[x][v].getIcon() == Bishop2) || (btn[x][v].getIcon() == Queen2)
						|| (btn[x][v].getIcon() == Rook2)) {

					break;
				}
				if (btn[x][v].getIcon() == null) {
					btn[x][v].setIcon(circle);
				}
				if (btn[x][v].getIcon() != null && ((btn[x][v].getIcon() == Pawn1) || (btn[x][v].getIcon() == Bishop1)
						|| (btn[x][v].getIcon() == King1) || (btn[x][v].getIcon() == Knight1)
						|| (btn[x][v].getIcon() == Queen1) || (btn[x][v].getIcon() == Rook1))) {
					btn[x][v].setBorder(border);
				}
				v = v + 1;
			} else {
				break;
			}

		}
	}

	public static void changeTurn() {
		turn = !turn;
	}

	public ChessBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1322, 761);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(572, 13, 699, 696);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 8, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 546, 543);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(8, 8, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 581, 237, 128);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblturn = new JLabel("White Turn");
		lblturn.setForeground(new Color(255, 0, 102));
		lblturn.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblturn.setBounds(43, 38, 213, 44);
		panel_2.add(lblturn);
		for (int i = 0; i < btnOverCome.length; i++) {
			for (int j = 0; j < btnOverCome.length; j++) {
				btnOverCome[i][j] = new JButton();
				btnOverCome[i][j].setBounds(0, 0, 100, 100);
				panel_1.add(btnOverCome[i][j]);
			}
		}

		for (int i = 0; i < btn.length; i++) {
			for (int j = 0; j < btn.length; j++) {
				btn[i][j] = new JButton();
				btn[i][j].setBounds(0, 0, 100, 100);
				panel.add(btn[i][j]);
				if ((i + j) % 2 != 0) {
					btn[i][j].setBackground(new Color(255, 51, 102));
				}
				if ((i + j) % 2 == 0) {
					btn[i][j].setBackground(new Color(255, 255, 255));
				}

			}
		}
		// ---------------------setIcone the buttons------------------------

		btn[0][0].setIcon(Rook1);
		btn[0][1].setIcon(Knight1);
		btn[0][2].setIcon(Bishop1);
		btn[0][3].setIcon(Queen1);
		btn[0][4].setIcon(King1);
		btn[0][5].setIcon(Bishop1);
		btn[0][6].setIcon(Knight1);
		btn[0][7].setIcon(Rook1);
		btn[1][0].setIcon(Pawn1);
		btn[1][1].setIcon(Pawn1);
		btn[1][2].setIcon(Pawn1);
		btn[1][3].setIcon(Pawn1);
		btn[1][4].setIcon(Pawn1);
		btn[1][5].setIcon(Pawn1);
		btn[1][6].setIcon(Pawn1);
		btn[1][7].setIcon(Pawn1);

		btn[7][0].setIcon(Rook2);
		btn[7][1].setIcon(Knight2);
		btn[7][2].setIcon(Bishop2);
		btn[7][3].setIcon(Queen2);
		btn[7][4].setIcon(King2);
		btn[7][5].setIcon(Bishop2);
		btn[7][6].setIcon(Knight2);
		btn[7][7].setIcon(Rook2);
		btn[6][0].setIcon(Pawn2);
		btn[6][1].setIcon(Pawn2);
		btn[6][2].setIcon(Pawn2);
		btn[6][3].setIcon(Pawn2);
		btn[6][4].setIcon(Pawn2);
		btn[6][5].setIcon(Pawn2);
		btn[6][6].setIcon(Pawn2);
		btn[6][7].setIcon(Pawn2);

		// ----------------------------------------------------------------------------
		for (int i = 0; i < btn.length; i++) {
			for (int j = 0; j < btn.length; j++) {
				final int tmpI = i;
				final int tmpJ = j;

				btn[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						MovesI.add(tmpI);
						MovesJ.add(tmpJ);
						if (EndGameWhite()) {
							JOptionPane.showMessageDialog(null, "Black won !!");

						}
						if (EndGameBlack()) {
							JOptionPane.showMessageDialog(null, "White won !!");

						}

						if (btn[tmpI][tmpJ].getIcon() == Pawn1 && turn == false) {// Black pawn move
							if (e.getSource() == btn[1][0] || e.getSource() == btn[1][1] || e.getSource() == btn[1][2]
									|| e.getSource() == btn[1][3] || e.getSource() == btn[1][4]
									|| e.getSource() == btn[1][5] || e.getSource() == btn[1][6]
									|| e.getSource() == btn[1][7]) {

								PawnChoiceBlackFirst(tmpI, tmpJ);
								PawnChoiceBlackAttack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}

								checkTurn(lblturn);

							} else {

								PawnChoiceBlack(tmpI, tmpJ);
								PawnChoiceBlackAttack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}

						}
						if (btn[tmpI][tmpJ].getIcon() == Pawn2 && turn == true) {// White pawn move
							if (e.getSource() == btn[6][0] || e.getSource() == btn[6][1] || e.getSource() == btn[6][2]
									|| e.getSource() == btn[6][3] || e.getSource() == btn[6][4]
									|| e.getSource() == btn[6][5] || e.getSource() == btn[6][6]
									|| e.getSource() == btn[6][7]) {

								PawnChoiceWhiteFirst(tmpI, tmpJ);
								PawnChoiceWhiteAttack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
								System.out.println(turn);

							} else {
								PawnChoiceWhite(tmpI, tmpJ);
								PawnChoiceWhiteAttack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
								System.out.println(turn);
							}

						}

						if (btn[tmpI][tmpJ].getIcon() == Rook1 || btn[tmpI][tmpJ].getIcon() == Rook2) {// Rook move
							if (btn[tmpI][tmpJ].getIcon() == Rook1 && turn == false) {
								RookChoiceBlack(tmpI, tmpJ);

								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}
							if (btn[tmpI][tmpJ].getIcon() == Rook2 && turn == true) {
								RookChoiceWhite(tmpI, tmpJ);

								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}

						}
						if (btn[tmpI][tmpJ].getIcon() == Knight1 || btn[tmpI][tmpJ].getIcon() == Knight2) {// Knight
																											// move
							if (btn[tmpI][tmpJ].getIcon() == Knight1 && turn == false) {
								KnightChoiceBlack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}
							if (btn[tmpI][tmpJ].getIcon() == Knight2 && turn == true) {
								KnightChoiceWhite(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}

						}
						if (btn[tmpI][tmpJ].getIcon() == King1 || btn[tmpI][tmpJ].getIcon() == King2) {// king move
							if (btn[tmpI][tmpJ].getIcon() == King1 && turn == false) {

								if ((e.getSource() == btn[0][4] && btn[0][7].getIcon() == Rook1
										&& btn[0][5].getIcon() == null && btn[0][6].getIcon() == null)
										|| (e.getSource() == btn[0][4] && btn[0][0].getIcon() == Rook1
												&& btn[0][3].getIcon() == null && btn[0][2].getIcon() == null
												&& btn[0][1].getIcon() == null)) {

									if ((e.getSource() == btn[0][4] && btn[0][7].getIcon() == Rook1
											&& btn[0][5].getIcon() == null && btn[0][6].getIcon() == null)) {
										System.out.println("8");
										KingSpecialBlack1(0, 4);
										KingChoicBlack(tmpI, tmpJ);
										changeTurn();
										checkTurn(lblturn);
									}
									if ((e.getSource() == btn[0][4] && btn[0][0].getIcon() == Rook1
											&& btn[0][3].getIcon() == null && btn[0][2].getIcon() == null
											&& btn[0][1].getIcon() == null)) {
										KingSpecialBlack2(0, 4);
										KingChoicBlack(tmpI, tmpJ);
										changeTurn();
										checkTurn(lblturn);
									}
								} else {
									KingChoicBlack(tmpI, tmpJ);
									if (Wait()) {
										changeTurn();
									}
									checkTurn(lblturn);
								}

							}

//							if (btn[tmpI][tmpJ].getIcon() == King1 && turn == false) {
//								KingChoicBlack(tmpI, tmpJ);
//								if (Wait()) {
//									changeTurn();
//								}
//								checkTurn(lblturn);
//							}
							if (btn[tmpI][tmpJ].getIcon() == King2 && turn == true) {

								if ((e.getSource() == btn[7][4] && btn[7][7].getIcon() == Rook2
										&& btn[7][5].getIcon() == null && btn[7][6].getIcon() == null)
										|| (e.getSource() == btn[7][4] && btn[7][0].getIcon() == Rook2
												&& btn[7][3].getIcon() == null && btn[7][2].getIcon() == null
												&& btn[7][1].getIcon() == null)) {

									if ((e.getSource() == btn[7][4] && btn[7][7].getIcon() == Rook2
											&& btn[7][5].getIcon() == null && btn[7][6].getIcon() == null)) {
										System.out.println("8");
										KingSpecialWhite1(7, 4);
										KingChoicWhite(tmpI, tmpJ);
										changeTurn();
										checkTurn(lblturn);
									}
									if ((e.getSource() == btn[7][4] && btn[7][0].getIcon() == Rook2
											&& btn[7][3].getIcon() == null && btn[7][2].getIcon() == null
											&& btn[7][1].getIcon() == null)) {
										KingSpecialWhite2(7, 4);
										KingChoicWhite(tmpI, tmpJ);
										changeTurn();
										checkTurn(lblturn);
									}
								} else {
									KingChoicWhite(tmpI, tmpJ);
									if (Wait()) {
										changeTurn();
									}
									checkTurn(lblturn);
								}

							}

						}
						if (btn[tmpI][tmpJ].getIcon() == Bishop1 || btn[tmpI][tmpJ].getIcon() == Bishop2) {

							if (btn[tmpI][tmpJ].getIcon() == Bishop1 && turn == false) {
								BishopChoiceBlack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}
							if (btn[tmpI][tmpJ].getIcon() == Bishop2 && turn == true) {
								BishopChoiceWhite(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							} // Bishop move

						}
						if (btn[tmpI][tmpJ].getIcon() == Queen1 || btn[tmpI][tmpJ].getIcon() == Queen2) {

							if (btn[tmpI][tmpJ].getIcon() == Queen1 && turn == false) {
								QueenChoiceBlack(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}
							if (btn[tmpI][tmpJ].getIcon() == Queen2 && turn == true) {
								QueenChoiceWhite(tmpI, tmpJ);
								if (Wait()) {
									changeTurn();
								}
								checkTurn(lblturn);
							}

						} // Queen move

						if (btn[tmpI][tmpJ].getIcon() == RedCircle) {
							if (e.getSource() == btn[7][6]) {

								btn[tmpI][tmpJ].setIcon(King2);
								btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)].setIcon(null);
								btn[tmpI][tmpJ - 1].setIcon(Rook2);
								btn[7][7].setIcon(null);
								ClearChoice(tmpI, tmpJ);
								ClearBorder(tmpI, tmpJ);
							}
							if (e.getSource() == btn[7][2]) {
								btn[tmpI][tmpJ].setIcon(King2);
								btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)].setIcon(null);
								btn[tmpI][tmpJ + 1].setIcon(Rook2);
								btn[7][0].setIcon(null);
								ClearChoice(tmpI, tmpJ);
								ClearBorder(tmpI, tmpJ);
							}
							if (e.getSource() == btn[0][6]) {

								btn[tmpI][tmpJ].setIcon(King1);
								btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)].setIcon(null);
								btn[tmpI][tmpJ - 1].setIcon(Rook1);
								btn[0][7].setIcon(null);
								ClearChoice(tmpI, tmpJ);
								ClearBorder(tmpI, tmpJ);
							}
							if (e.getSource() == btn[0][2]) {
								btn[tmpI][tmpJ].setIcon(King1);
								btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)].setIcon(null);
								btn[tmpI][tmpJ + 1].setIcon(Rook1);
								btn[0][0].setIcon(null);
								ClearChoice(tmpI, tmpJ);
								ClearBorder(tmpI, tmpJ);
							}

						}
						if (btn[tmpI][tmpJ].getIcon() == circle || btn[tmpI][tmpJ].getBorder() == border) {
							if (btn[tmpI][tmpJ].getIcon() == circle) {
								if (((e.getSource() == btn[0][0] || e.getSource() == btn[0][1]
										|| e.getSource() == btn[0][2] || e.getSource() == btn[0][3]
										|| e.getSource() == btn[0][4] || e.getSource() == btn[0][5]
										|| e.getSource() == btn[0][6] || e.getSource() == btn[0][7])
										&& (btn[tmpI + 1][tmpJ].getIcon() == Pawn2))
										|| ((e.getSource() == btn[7][0] || e.getSource() == btn[7][1]
												|| e.getSource() == btn[7][2] || e.getSource() == btn[7][3]
												|| e.getSource() == btn[7][4] || e.getSource() == btn[7][5]
												|| e.getSource() == btn[7][6] || e.getSource() == btn[7][7])
												&& (btn[tmpI - 1][tmpJ].getIcon() == Pawn1))) {
									if (((e.getSource() == btn[0][0] || e.getSource() == btn[0][1]
											|| e.getSource() == btn[0][2] || e.getSource() == btn[0][3]
											|| e.getSource() == btn[0][4] || e.getSource() == btn[0][5]
											|| e.getSource() == btn[0][6] || e.getSource() == btn[0][7])
											&& (btn[tmpI + 1][tmpJ].getIcon() == Pawn2))) {
										String result;
										result = JOptionPane.showInputDialog(null, "Enter Your desired piece");
										if (result.equals("king")) {
											btn[tmpI][tmpJ].setIcon(King2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("bishop")) {
											btn[tmpI][tmpJ].setIcon(Bishop2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("queen")) {
											btn[tmpI][tmpJ].setIcon(Queen2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("rook")) {
											btn[tmpI][tmpJ].setIcon(Rook2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("knight")) {
											btn[tmpI][tmpJ].setIcon(Knight2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}

									}
									if (((e.getSource() == btn[7][0] || e.getSource() == btn[7][1]
											|| e.getSource() == btn[7][2] || e.getSource() == btn[7][3]
											|| e.getSource() == btn[7][4] || e.getSource() == btn[7][5]
											|| e.getSource() == btn[7][6] || e.getSource() == btn[7][7])
											&& (btn[tmpI - 1][tmpJ].getIcon() == Pawn1))) {
										String result;
										result = JOptionPane.showInputDialog(null, "Enter Your desired piece");
										if (result.equals("king")) {
											btn[tmpI][tmpJ].setIcon(King1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("bishop")) {
											btn[tmpI][tmpJ].setIcon(Bishop1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("queen")) {
											btn[tmpI][tmpJ].setIcon(Queen1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("rook")) {
											btn[tmpI][tmpJ].setIcon(Rook1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}
										if (result.equals("knight")) {
											btn[tmpI][tmpJ].setIcon(Knight1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
										}

									}
								} else {
									btn[tmpI][tmpJ]
											.setIcon(btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.getIcon());

									btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)].setIcon(null);
									ClearChoice(tmpI, tmpJ);
									ClearChoiceRed(tmpI, tmpJ);
									ClearBorder(tmpI, tmpJ);
								}
							}
							if (btn[tmpI][tmpJ].getBorder() == border) {
								if (((e.getSource() == btn[0][0] || e.getSource() == btn[0][1]
										|| e.getSource() == btn[0][2] || e.getSource() == btn[0][3]
										|| e.getSource() == btn[0][4] || e.getSource() == btn[0][5]
										|| e.getSource() == btn[0][6] || e.getSource() == btn[0][7])
										&& (btn[tmpI + 1][tmpJ + 1].getIcon() == Pawn2
												|| btn[tmpI + 1][tmpJ - 1].getIcon() == Pawn2))
										|| ((e.getSource() == btn[7][0] || e.getSource() == btn[7][1]
												|| e.getSource() == btn[7][2] || e.getSource() == btn[7][3]
												|| e.getSource() == btn[7][4] || e.getSource() == btn[7][5]
												|| e.getSource() == btn[7][6] || e.getSource() == btn[7][7])
												&& (btn[tmpI - 1][tmpJ + 1].getIcon() == Pawn1
														|| btn[tmpI - 1][tmpJ - 1].getIcon() == Pawn1))) {
									if (((e.getSource() == btn[0][0] || e.getSource() == btn[0][1]
											|| e.getSource() == btn[0][2] || e.getSource() == btn[0][3]
											|| e.getSource() == btn[0][4] || e.getSource() == btn[0][5]
											|| e.getSource() == btn[0][6] || e.getSource() == btn[0][7])
											&& (btn[tmpI + 1][tmpJ + 1].getIcon() == Pawn2
													|| btn[tmpI + 1][tmpJ - 1].getIcon() == Pawn2))) {
										String result;
										result = JOptionPane.showInputDialog(null, "Enter Your desired piece");
										if (result.equals("king")) {
											btn[tmpI][tmpJ].setIcon(King2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);

										}
										if (result.equals("bishop")) {
											btn[tmpI][tmpJ].setIcon(Bishop2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);

										}
										if (result.equals("queen")) {
											btn[tmpI][tmpJ].setIcon(Queen2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
										if (result.equals("rook")) {
											btn[tmpI][tmpJ].setIcon(Rook2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
										if (result.equals("knight")) {
											btn[tmpI][tmpJ].setIcon(Knight2);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}

									}
									if (((e.getSource() == btn[7][0] || e.getSource() == btn[7][1]
											|| e.getSource() == btn[7][2] || e.getSource() == btn[7][3]
											|| e.getSource() == btn[7][4] || e.getSource() == btn[7][5]
											|| e.getSource() == btn[7][6] || e.getSource() == btn[7][7])
											&& (btn[tmpI - 1][tmpJ + 1].getIcon() == Pawn1
													|| btn[tmpI - 1][tmpJ - 1].getIcon() == Pawn1))) {

										String result;
										result = JOptionPane.showInputDialog(null, "Enter Your desired piece");
										if (result.equals("king")) {
											btn[tmpI][tmpJ].setIcon(King1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
										if (result.equals("bishop")) {
											btn[tmpI][tmpJ].setIcon(Bishop1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
										if (result.equals("queen")) {
											btn[tmpI][tmpJ].setIcon(Queen1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
										if (result.equals("rook")) {
											btn[tmpI][tmpJ].setIcon(Rook1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
										if (result.equals("knight")) {
											btn[tmpI][tmpJ].setIcon(Knight1);
											btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.setIcon(null);
											board(btn[tmpI][tmpJ].getIcon());
											ClearChoice(tmpI, tmpJ);
											ClearBorder(tmpI, tmpJ);
											changeTurn();
											checkTurn(lblturn);
										}
									}

								} else {
									board(btn[tmpI][tmpJ].getIcon());

									btn[tmpI][tmpJ]
											.setIcon(btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)]
													.getIcon());
									btn[MovesI.get(MovesI.size() - 2)][MovesJ.get(MovesJ.size() - 2)].setIcon(null);

									ClearChoice(tmpI, tmpJ);
									ClearChoiceRed(tmpI, tmpJ);
									ClearBorder(tmpI, tmpJ);
									changeTurn();
									checkTurn(lblturn);
								}

							}
						}

					}

				});

			}

		}

	}

}
