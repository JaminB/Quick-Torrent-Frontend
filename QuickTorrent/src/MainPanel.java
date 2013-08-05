import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JSeparator;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import java.awt.SystemColor;


public class MainPanel {
	public JTextPane textPane;
	public JCheckBox chckbxFilterResults;
	public JRadioButton rdbtnAlbum;
	public JRadioButton rdbtnSingle;
	public JRadioButton rdbtnMovie;
	public StyledDocument doc;
	public boolean consoleOn = true;
	public String displayText = "Welcome to Quick Torrent!\n";

	private JFrame frmQuickTorrent;
	private JTextField searchBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
					window.frmQuickTorrent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuickTorrent = new JFrame();
		frmQuickTorrent.setTitle("Quick Torrent - Jamin B");
		frmQuickTorrent.setBounds(100, 100, 1200, 600);
		frmQuickTorrent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuickTorrent.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frmQuickTorrent.getContentPane().add(panel);
		
		searchBox = new JTextField();
		searchBox.setHorizontalAlignment(SwingConstants.LEFT);
		searchBox.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		searchBox.setColumns(15);
		
		chckbxFilterResults = new JCheckBox("Filter Results");
		chckbxFilterResults.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		
		JButton searchButton = new JButton("Search");
		searchButton.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		
		rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setSelected(true);
		rdbtnSingle.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		
		rdbtnAlbum = new JRadioButton("Album");
		rdbtnAlbum.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		
		rdbtnMovie = new JRadioButton("Movie");
		rdbtnMovie.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		
		JCheckBox chckbxShowConsole = new JCheckBox("Show Console");
		chckbxShowConsole.setSelected(true);
		chckbxShowConsole.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(searchBox, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(chckbxFilterResults)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchButton)
							.addGap(171))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rdbtnSingle, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnAlbum, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMovie)
							.addContainerGap(396, Short.MAX_VALUE))))
				.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxShowConsole)
					.addContainerGap(489, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnSingle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnAlbum)
								.addComponent(rdbtnMovie)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxFilterResults)
								.addComponent(searchButton)
								.addComponent(searchBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(28)))
					.addGap(4)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxShowConsole)
					.addGap(464))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		frmQuickTorrent.getContentPane().add(scrollPane);
		textPane = new JTextPane();
		//Add actions
		rdbtnSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rdbtnAlbum.setSelected(false);
				rdbtnMovie.setSelected(false);
				doc = textPane.getStyledDocument();
				try {
					if(rdbtnSingle.isSelected())
						doc.insertString(doc.getLength(),"\nSearch for singles.\n",null );
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rdbtnAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rdbtnMovie.setSelected(false);
				rdbtnSingle.setSelected(false);
				doc = textPane.getStyledDocument();
				try {
					if(rdbtnAlbum.isSelected())
						doc.insertString(doc.getLength(),"\nSearch for albums.\n",null );
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rdbtnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rdbtnAlbum.setSelected(false);
				rdbtnSingle.setSelected(false);
				doc = textPane.getStyledDocument();
				try {
					if(rdbtnMovie.isSelected())
						doc.insertString(doc.getLength(),"\nSearch for movies.\n",null );
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		chckbxShowConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				consoleOn=!consoleOn;
				textPane.setVisible(consoleOn);
				
			}
		});
		//
		scrollPane.setViewportView(textPane);
		Actions displayOutput = new Actions();
		textPane.setText(textPane.getText() + displayText);
	}
}
