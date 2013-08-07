import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import sites.kat.KATSimpleSearch;
import sites.pirate.PirateSimpleSearch;
import converters.torcache.*;
import java.awt.SystemColor;

public class MainPanel {
	public JTextPane txtpnWelcomeToQuick;
	public JCheckBox chckbxFilterResults;
	public JRadioButton rdbtnAlbum;
	public JRadioButton rdbtnSingle;
	public JRadioButton rdbtnMovie;
	public JButton searchButton;
	public JFrame frmQuickTorrent;
	public JTextField searchBox;
	
	SimpleAttributeSet error;
	SimpleAttributeSet info;
	SimpleAttributeSet success;
	
	public StyledDocument doc;
	
	public boolean consoleOn = true;
	public boolean filterOn = false;
	public String mediaType = "music";
	public String displayText = "Welcome to Quick Torrent!\n";
	private JCheckBox chckbxShowConsole;


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
		frmQuickTorrent.setBackground(Color.GRAY);
		frmQuickTorrent.getContentPane().setBackground(Color.GRAY);
		frmQuickTorrent.setTitle("Quick Torrent - Jamin B");
		frmQuickTorrent.setBounds(100, 100, 1200, 600);
		frmQuickTorrent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuickTorrent.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frmQuickTorrent.getContentPane().add(panel);
		
		searchBox = new JTextField();
		searchBox.setHorizontalAlignment(SwingConstants.LEFT);
		searchBox.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		searchBox.setColumns(15);
		
		chckbxFilterResults = new JCheckBox("Filter Results");
		chckbxFilterResults.setForeground(Color.WHITE);
		chckbxFilterResults.setBackground(Color.GRAY);
		chckbxFilterResults.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		
		searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		searchButton.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.WHITE);
		
		rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setForeground(Color.WHITE);
		rdbtnSingle.setBackground(Color.GRAY);
		rdbtnSingle.setSelected(true);
		rdbtnSingle.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		
		rdbtnAlbum = new JRadioButton("Album");
		rdbtnAlbum.setForeground(Color.WHITE);
		rdbtnAlbum.setBackground(Color.GRAY);
		rdbtnAlbum.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		
		rdbtnMovie = new JRadioButton("Movie");
		rdbtnMovie.setForeground(Color.WHITE);
		rdbtnMovie.setBackground(Color.GRAY);
		rdbtnMovie.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		
		chckbxShowConsole = new JCheckBox("Show Console");
		chckbxShowConsole.setSelected(true);
		chckbxShowConsole.setForeground(Color.WHITE);
		chckbxShowConsole.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		chckbxShowConsole.setBackground(Color.GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.BLACK);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(chckbxShowConsole, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(searchBox, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
								.addGap(6)
								.addComponent(chckbxFilterResults)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(searchButton)
								.addGap(171))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(rdbtnSingle, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnAlbum, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnMovie)
								.addContainerGap(947, Short.MAX_VALUE)))))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(chckbxShowConsole)
					.addGap(294)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
		);
		txtpnWelcomeToQuick = new JTextPane();
		scrollPane.setViewportView(txtpnWelcomeToQuick);
		txtpnWelcomeToQuick.setBackground(new Color(255, 255, 255));
		txtpnWelcomeToQuick.setForeground(Color.BLACK);
		txtpnWelcomeToQuick.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		txtpnWelcomeToQuick.setEditable(false);
		
		txtpnWelcomeToQuick.setText("Welcome to Quick Torrent by JaminB.\r\nSource available at: https://github.com/JaminB\r\n\r\nThank you for tying out the Alpha.\r\n\r\n1. Please allow up to 60 seconds after clicking start. The alpha does not have a loading bar.\r\n\r\n2. You can copy any text displayed in console with control-c.\r\n\r\n3. Please don't break any laws!\n\n");
		panel.setLayout(gl_panel);
		
		//Add actions
		error = new SimpleAttributeSet();
		StyleConstants.setForeground(error, Color.RED);
		StyleConstants.setFontFamily(error, "OCR A Extended");
		
		info = new SimpleAttributeSet();
		StyleConstants.setForeground(info, Color.BLACK);
		StyleConstants.setFontFamily(info, "OCR A Extended");
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				doc = txtpnWelcomeToQuick.getStyledDocument();
				try {
					if(searchBox.getText().isEmpty())
						doc.insertString(doc.getLength(),"\n> No search term entered!\n ", error );
					else if(!rdbtnSingle.isSelected() && !rdbtnAlbum.isSelected() && !rdbtnMovie.isSelected())
						doc.insertString(doc.getLength(),"\n> No category selected!\n ", error );
					else{
						if(filterOn){
							doc.insertString(doc.getLength(),"\n> Completed filtered search for \""+searchBox.getText() + "\" in category " + mediaType + ".", info );
						}
							
						else{
							doc.insertString(doc.getLength(),"\n> Completed unfiltered search for \""+searchBox.getText() + "\" in category " + mediaType + ".", info );
						}
						PirateSimpleSearch currentSearch = new PirateSimpleSearch(searchBox.getText(), mediaType, filterOn );
						
						String magnet = currentSearch.findBestDownload();
						doc.insertString(doc.getLength(), "\nBest Link: \n\n" + magnet, info);
						MagnetToTorrent torrent = new MagnetToTorrent(magnet);
						
						doc.insertString(doc.getLength(), "\n\nTorrent: "+torrent.getTorrentLink(torrent.getHash()), info);
					}
				}
				 catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		chckbxFilterResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				filterOn=!filterOn;
				doc = txtpnWelcomeToQuick.getStyledDocument();
				if(filterOn){
					try {
						doc.insertString(doc.getLength(),"\n> Filter On\n",info );
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
				else{
					try {
						doc.insertString(doc.getLength(),"\n> Filter Off\n",info );
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		rdbtnSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rdbtnAlbum.setSelected(false);
				rdbtnMovie.setSelected(false);
				doc = txtpnWelcomeToQuick.getStyledDocument();
				try {
					if(rdbtnSingle.isSelected()){
						mediaType = "music";
						doc.insertString(doc.getLength(),"\n> Search in category "+ mediaType + " for singles.\n",info );
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});
		rdbtnAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rdbtnMovie.setSelected(false);
				rdbtnSingle.setSelected(false);
				doc = txtpnWelcomeToQuick.getStyledDocument();
				try {
					if(rdbtnAlbum.isSelected()){
						mediaType = "albums";
						doc.insertString(doc.getLength(),"\n> Search in category " + mediaType + ".\n",info );
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		});
		rdbtnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				rdbtnAlbum.setSelected(false);
				rdbtnSingle.setSelected(false);
				doc = txtpnWelcomeToQuick.getStyledDocument();
				try {
					if(rdbtnMovie.isSelected()){
						mediaType = "movies";
						doc.insertString(doc.getLength(),"\n> Search in category "+ mediaType +".\n",info );
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		chckbxShowConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				consoleOn=!consoleOn;
				txtpnWelcomeToQuick.setVisible(consoleOn);

			}
		});
	}
}
