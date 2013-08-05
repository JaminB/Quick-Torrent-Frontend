import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class MainPanel {

	private JFrame frmQuickTorrent;
	private JTextField textField;
	private final Action action = new SwingAction();

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
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		textField.setColumns(15);
		
		JCheckBox chckbxFilterResults = new JCheckBox("Filter Results");
		chckbxFilterResults.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		
		JRadioButton rdbtnMovie = new JRadioButton("Single");
		rdbtnMovie.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		
		JRadioButton rdbtnAlbum = new JRadioButton("Album");
		rdbtnAlbum.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		
		JRadioButton rdbtnMovie_1 = new JRadioButton("Movie");
		rdbtnMovie_1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(chckbxFilterResults)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSearch)
							.addGap(171))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rdbtnMovie, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnAlbum, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMovie_1)
							.addContainerGap(388, Short.MAX_VALUE))))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnMovie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnAlbum)
								.addComponent(rdbtnMovie_1))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxFilterResults)
								.addComponent(btnSearch)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(28)))
					.addGap(2)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(496))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		frmQuickTorrent.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
