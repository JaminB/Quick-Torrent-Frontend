import java.awt.Color;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import sites.kat.KATSimpleSearch;
import sites.pirate.PirateSimpleSearch;

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
		searchButton.setBackground(Color.GRAY);
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
		
		JCheckBox chckbxShowConsole = new JCheckBox("Show Console");
		chckbxShowConsole.setForeground(Color.WHITE);
		chckbxShowConsole.setBackground(Color.GRAY);
		chckbxShowConsole.setSelected(true);
		chckbxShowConsole.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(searchBox, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
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
							.addContainerGap(369, Short.MAX_VALUE))))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxShowConsole)
					.addContainerGap(477, Short.MAX_VALUE))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
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
					.addGap(471))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GRAY);
		frmQuickTorrent.getContentPane().add(scrollPane);
		txtpnWelcomeToQuick = new JTextPane();
		txtpnWelcomeToQuick.setBackground(Color.BLACK);
		txtpnWelcomeToQuick.setForeground(new Color(255, 255, 255));
		txtpnWelcomeToQuick.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		txtpnWelcomeToQuick.setEditable(false);
		
		//Add actions
		error = new SimpleAttributeSet();
		StyleConstants.setForeground(error, Color.RED);
		StyleConstants.setFontFamily(error, "OCR A Extended");
		
		info = new SimpleAttributeSet();
		StyleConstants.setForeground(info, Color.BLUE);
		StyleConstants.setFontFamily(info, "OCR A Extended");
		
		success = new SimpleAttributeSet();
		StyleConstants.setForeground(info, Color.GREEN);
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
						KATSimpleSearch currentSearch = new KATSimpleSearch(searchBox.getText(), mediaType, filterOn );
						doc.insertString(doc.getLength(), "\nBest Link: " + currentSearch.findBestDownload(), success);
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
		//
		scrollPane.setViewportView(txtpnWelcomeToQuick);
		
		txtpnWelcomeToQuick.setText("Welcome to Quick Torrent!\r\n");
	}
}
