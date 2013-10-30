/*
 * Author: 		Brendan Kirby
 * Author: 		Artur Braga
 * Author:		Michael Surdouski
 * Author:		William Dougherty
 * Author: 		Jason McEvoy
 * File: 		MainView.java
 * Description: 
 */

package design;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/** Main View */
@SuppressWarnings("serial")
public class MainView extends JFrame implements Observer{
	private String path;
	
	//int Width=800;
	//int Heigth=600;
	
	private JComponent _fileOpen;
	private JComponent _fileSave;
	private JComponent _fileExit;
	private JComponent _btnPrev;
	private JComponent _btnNext;
	private JComponent _btnOne;
	private JComponent _btnFour;
	private JComponent _imgContainer;
	private Actions _next;
	private Actions _prev;
	private Actions _init;
	private Actions _chgState;
	private Actions _saveStudy;
	
	/** Image Window */
	private WindowFactory _imgWindow;

	/** Main Controller */
	private MainController _mainController = new design.MainController();
		
	/**
	 * Constructs a MainView
	 */
	public MainView() {
		_imgWindow = new Win1Fact();
		_next = new DoNext();
		_prev = new DoPrev();
		_saveStudy = new SaveStudy();
		_chgState = new ChgState();
		_imgContainer = new JPanel();
		_imgContainer.setLayout(new CardLayout(0, 0));
		/*ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
				try {
				list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head01.jpg")));
				list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head02.jpg")));
				list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head03.jpg")));
				list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head04.jpg")));
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		
		initGUI();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			_init = new InitStudy(fileChooser.getSelectedFile().toString(),this);
		}
		//ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
		//try {
		//list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head01.jpg")));
		//list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head02.jpg")));
		//list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head03.jpg")));
		//list.add(ImageIO.read(new File("/home/artur/Downloads/MedImageViewerStudies/axial_head_mri/head04.jpg")));
		//_imgWindow = new Win4Fact(list);
		//_imgContainer = _imgWindow.getWindow();
		//initGUI();
		//} catch (IOException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
	/**
	 * Initiate the OneState button 
	 */
	private void initbtnOne(){
		_btnOne = new JButton("One");
		((JButton)_btnOne).setVerticalAlignment(SwingConstants.BOTTOM);
		((JButton)_btnOne).setHorizontalAlignment(SwingConstants.LEFT);
		((JButton)_btnOne).addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent arg0){
	    	 evActionbtnOne();
	    	}
		});
	}
	
	/** 
	 * 
	 */
	private void evActionbtnOne(){
		_imgWindow = new Win1Fact();
		_chgState.initAction(1);
		((JButton) _btnOne).disable();
		((JButton) _btnFour).enable();
	}
	
	/**
	 * Initiate the FourState button 
	 */
	private void initbtnFour(){
		_btnFour = new JButton("Four");
		((JButton)_btnFour).setVerticalAlignment(SwingConstants.BOTTOM);
		((JButton)_btnFour).setHorizontalAlignment(SwingConstants.LEFT);
		((JButton)_btnFour).addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
	    		evActionbtnFour();
	    	}
		});
	}
	
	/**
	 * 
	 */
	private void evActionbtnFour() {
		_imgWindow = new Win4Fact();
		_chgState.initAction(4);
		((JButton) _btnFour).disable();
		((JButton) _btnOne).enable();
	}
	
	/**
	 * Initiate the Previous button item
	 */
	private void initbtnPrev() {
		_btnPrev = new JButton("Prev");
		((JButton)_btnPrev).addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
	    		evActionbtnPrev();
	    	}
		});
	}
	
	/**
	 * 
	 */
	private void evActionbtnPrev() {
		_prev.initAction(-1);
	}
	
	/**
	 * Initiate the Next button item
	 */
	private void initbtnNext() {
		_btnNext = new JButton("Next");
		((JButton)_btnNext).addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
	    		evActionbtnNext();
	    	}
		});
	}
	
	/**
	 * 
	 */
	private void evActionbtnNext() {
		_next.initAction(-1);
	}
	
	/**
	 * Initiate the _fileOpen menu item
	 */
	private void fileOpenInit() {
		_fileOpen= new JMenuItem("Open");
	    ((JMenuItem)_fileOpen).setMnemonic(KeyEvent.VK_O);
        _fileOpen.setToolTipText("Open new study");
        evActionFileOpen();
	}
	
	/**
	 * Set default action for fileOpen item
	 * Overriding actionPerformed method
	 */
	private void evActionFileOpen() {
		((JMenuItem)_fileOpen).addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		JFileChooser fileChooser = new JFileChooser();
        		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        		int returnVal = fileChooser.showOpenDialog(null);
        		if (returnVal == JFileChooser.APPROVE_OPTION) {
        			initStudy(fileChooser.getSelectedFile().toString());
        		}
        	}
        });
	}
	
	/**
	 * 
	 */
	private void fileSaveInit(){
		_fileSave= new JMenuItem("Save as..");
	    ((JMenuItem)_fileSave).setMnemonic(KeyEvent.VK_S);
        _fileSave.setToolTipText("Sace current study in a different directory");
        evActionFileSave();
	}
	
	/**
	 * Set default action for fileOpen item
	 * Overriding actionPerformed method
	 */
	private void evActionFileSave() {
		((JMenuItem)_fileSave).addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		JFileChooser fileChooser = new JFileChooser();
        		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        		int returnVal = fileChooser.showOpenDialog(null);
        		if (returnVal == JFileChooser.APPROVE_OPTION) {
        			_saveStudy.initAction(fileChooser.getSelectedFile().toString());
        		}
        	}
        });
	}
	
	/**
	 * 
	 * @param path
	 */
	public void initStudy(String path) {
		_init = new InitStudy(path,this);
	}
	
	/**
	 * Initiate the _fileExit menu item
	 */
	private void fileExitInit() {
		_fileExit = new JMenuItem("Exit");
		((JMenuItem)_fileExit).setMnemonic(KeyEvent.VK_E);
        _fileExit.setToolTipText("Exit application");
        ((JMenuItem)_fileExit).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if (arg1 instanceof ArrayList<?>) {
			_imgWindow.update((ArrayList<BufferedImage>)arg1);
			_imgContainer.removeAll();
			_imgContainer.add(_imgWindow.getWindow());
			validate();
			repaint();
			//getContentPane().add(_imgContainer, BorderLayout.CENTER);
			//repaint();
		}
	}
	
	/**
	 * 
	 */
	private void initGUI() {
		//setResizable(false);
		setTitle("Medical Image Viewing Console");
		setSize(800, 600);
	    //setExtendedState(Frame.MAXIMIZED_BOTH);
		//setSize(Width,Heigth);
		//setSize(xSize,ySize);
		setLocationRelativeTo(null);
	    
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    
		/////////////////////////////////////////Menu Bar generation/////////////////////////////////////
	    
	    JMenuBar menubar= new JMenuBar();
	    //ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));
	    
	    JMenu file=new JMenu("File");
	    file.setMnemonic(KeyEvent.VK_F);
	    
	    fileOpenInit();
	    fileSaveInit();
	    fileExitInit();
        
        file.add(_fileOpen);
        file.add(_fileSave);
        file.add(_fileExit);
        menubar.add(file);
        setJMenuBar(menubar);
        
        ///////////////////////////////Next, Prev, Image Container/////////////////////////////////////:
        
        //Previous
        JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		
		initbtnPrev();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(_btnPrev, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(_btnPrev, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(95))
		);
		panel.setLayout(gl_panel);
		
		//Next
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.EAST);
		
		initbtnNext();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(_btnNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(100)
					.addComponent(_btnNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(95))
		);
		panel_4.setLayout(gl_panel_4);
		
		//Image Container
		//JPanel panel_1 = new JPanel();
		getContentPane().add(_imgContainer, BorderLayout.CENTER);
		//JScrollPane scrollPane = new JScrollPane();
		//panel_1.add(scrollPane);
		//
		//panel_1.add(_imgContainer);
		

		////////////////////////////////State Buttons/////////////////////////////////
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		initbtnOne();
		initbtnFour();
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_3.add(_btnOne);
		panel_3.add(_btnFour);
	}
}
