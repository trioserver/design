package design;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainView extends JFrame implements Observer{
	private String path;
	
	//int Width=800;
	//int Heigth=600;
	
	private JComponent _fileOpen;
	private JComponent _fileExit;
	private JComponent _btnPrev;
	private JComponent _btnNext;
	private JComponent _btnOne;
	private JComponent _btnFour;
	
	private Actions _next;
	
	/**
	 * @uml.property  name="_imgWindow"
	 * @uml.associationEnd  multiplicity="(1 1)" aggregation="composite" inverse="mainView:design.WindowFactory"
	 */
	private WindowFactory _imgWindow;

	/**
	 * @uml.property  name="_mainController"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="_mainView:design.MainController"
	 */
	private MainController _mainController = new design.MainController();
	
		
	public MainView()
	{
		_next = new DoNext();
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("/media/artur/Documents/foto/2008-09-03/Picture 009.jpg"));
		
		ArrayList<BufferedImage> list =new ArrayList<BufferedImage>();
		list.add(myPicture);
		_imgWindow = new Win1Fact(list);
		JLabel window = _imgWindow.getWindow();
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
	    fileExitInit();
        
        file.add(_fileOpen);	
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
					.addGap(99)
					.addComponent(_btnPrev, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(98))
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
					.addGap(102)
					.addComponent(_btnNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(95))
		);
		panel_4.setLayout(gl_panel_4);
		
		//Image Container
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.add(window);
		
		
		////////////////////////////////State Buttons/////////////////////////////////
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		initbtnOne();
		initbtnFour();
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_3.add(_btnOne);
		panel_3.add(_btnFour);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Initiate the OneState button 
	 * 
	 */
	private void initbtnOne(){
		_btnOne = new JButton("One");
		((JButton)_btnOne).setVerticalAlignment(SwingConstants.BOTTOM);
		((JButton)_btnOne).setHorizontalAlignment(SwingConstants.LEFT);
        evActionbtnOne();
	}
	private void evActionbtnOne(){
		
	}
	/**
	 * Initiate the FourState button 
	 * 
	 */
	private void initbtnFour(){
		_btnFour = new JButton("Four");
		((JButton)_btnFour).setVerticalAlignment(SwingConstants.BOTTOM);
		((JButton)_btnFour).setHorizontalAlignment(SwingConstants.LEFT);
        evActionbtnFour();
	}
	private void evActionbtnFour(){
		
	}
	/**
	 * Initiate the Previous button item
	 * 
	 */
	private void initbtnPrev(){
		_btnPrev = new JButton("Next");
        evActionbtnPrev();
	}
	private void evActionbtnPrev(){
		
	}
	/**
	 * Initiate the Next button item
	 * 
	 */
	private void initbtnNext(){
		_btnNext = new JButton("Next");
        evActionbtnNext();
	}
	private void evActionbtnNext(){
		_next.initAction();
	}
	
	/**
	 * Initiate the _fileOpen menu item
	 * 
	 */
	private void fileOpenInit(){
		_fileOpen= new JMenuItem("Open");
	    ((JMenuItem)_fileOpen).setMnemonic(KeyEvent.VK_O);
        _fileOpen.setToolTipText("Open new study");
        evActionFileOpen();
	}
	/**
	 * Set default action for fileOpen item
	 * Overriding actionPerformed method
	 * 
	 */
	private void evActionFileOpen()
	{
		((JMenuItem)_fileOpen).addActionListener(new ActionListener(){
	        
        	@Override
        	public void actionPerformed(ActionEvent arg0){
        		JFileChooser fileChooser = new JFileChooser();
        		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        		int returnVal = fileChooser.showOpenDialog(null);
        		if (returnVal == JFileChooser.APPROVE_OPTION)
        		{
        			path=fileChooser.getSelectedFile().toString();
        		}
        	}
        });
	}
	/**
	 * Initiate the _fileExit menu item
	 * 
	 */
	private void fileExitInit(){
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
	 * @uml.property name="_eventObj"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="_mainView:design.EventObj"
	 */
	private ArrayList _eventObj = new java.util.ArrayList();

	/** 
	 * Getter of the property <tt>_eventObj</tt>
	 * @return  Returns the _eventObj.
	 * @uml.property  name="_eventObj"
	 */
	public ArrayList get_eventObj() {
		return _eventObj;
	}

	/** 
	 * Getter of the property <tt>_eventObj</tt>
	 * @return  Returns the _eventObj.
	 * @uml.property  name="_eventObj"
	 */
	public EventObj get_eventObj(int i) {
		return (EventObj) _eventObj.get(i);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="_eventObj"
	 */
	public Iterator _eventObjIterator() {
		return _eventObj.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="_eventObj"
	 */
	public boolean is_eventObjEmpty() {
		return _eventObj.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="_eventObj"
	 */
	public boolean contains_eventObj(EventObj eventObj) {
		return _eventObj.contains(eventObj);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="_eventObj"
	 */
	public boolean containsAll_eventObj(Collection _eventObj) {
		return this._eventObj.containsAll(_eventObj);
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="_eventObj"
	 */
	public int _eventObjSize() {
		return _eventObj.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="_eventObj"
	 */
	public EventObj[] _eventObjToArray() {
		return (EventObj[]) _eventObj.toArray(new EventObj[_eventObj.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="_eventObj"
	 */
	public EventObj[] _eventObjToArray(EventObj[] _eventObj) {
		return (EventObj[]) this._eventObj.toArray(_eventObj);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="_eventObj"
	 */
	public void add_eventObj(int index, EventObj eventObj) {
		_eventObj.add(index, eventObj);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="_eventObj"
	 */
	public boolean add_eventObj(EventObj eventObj) {
		return _eventObj.add(eventObj);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="_eventObj"
	 */
	public Object remove_eventObj(int index) {
		return _eventObj.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="_eventObj"
	 */
	public boolean remove_eventObj(EventObj eventObj) {
		return _eventObj.remove(eventObj);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="_eventObj"
	 */
	public void clear_eventObj() {
		_eventObj.clear();
	}

	/** 
	 * Setter of the property <tt>_eventObj</tt>
	 * @param _eventObj  the _eventObj to set.
	 * @uml.property  name="_eventObj"
	 */
	public void set_eventObj(ArrayList _eventObj) {
		this._eventObj = _eventObj;
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
