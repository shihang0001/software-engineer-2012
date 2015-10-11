import javax.swing.JFrame;

/*
 * This interface is used to build and construct the GUI
 * and includes methods that used for GUI transition
 */
public interface GUIConstructor {
	//create frame
	public void create();
	
	//create content on the frame
	public void constructContent();
	
	//GUI transition
	public void transitToGUI(int i);
	
	//GUI return
	public void returnToGUI(JFrame frame);
}
