
import javax.swing.JFrame;


public interface GUIConstuctor {
	//create frame
		public void create();
		
		//create content on the frame
		public void constructContent();
		
		//GUI transition
		public void transitToGUI(int i);
		
		//GUI return
		public void returnToGUI(JFrame frame);
}
