package ventanas;

import java.awt.Dimension;
import java.awt.List;

import javax.swing.*;

//PanelDividido itself is not a visible component.
public class PanelDividido extends JPanel {
	private List listE,listW;
	private JSplitPane splitPane;
//	private String imageNames[ ]={"Partido 1","Partido 2","Partido 3","Partido 4","Partido 5",
//			"Partido 6","Partido 7","Partido 8","Partido 9","Partido 10"};
	public PanelDividido(List listW,List listE){
		//Create the list of images and put it in a scroll pane
//		listW=new JList(imageNames);
		this.listW=listW;
//		listE=new JList();
		this.listE=listE;
		//listW.setSelectedIndex(0);
		
		JScrollPane listWScrollPane=new JScrollPane(listW);
		JScrollPane listEScrollPane=new JScrollPane(listE);
		
		//Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   listWScrollPane, listEScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(400);
        
      //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(100, 50);
        listWScrollPane.setMinimumSize(minimumSize);
        listEScrollPane.setMinimumSize(minimumSize);

        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(800, 300));
	}//end PanelDividido()
	
    //Used by SplitPaneDemo2
    public List getImageList() {
        return listE;
    }	
	
    public JSplitPane getSplitPane() {
        return splitPane;
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PanelDividido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        List listE,listW;
        String imageNames[ ]={"Partido 1","Partido 2","Partido 3","Partido 4","Partido 5",
    			"Partido 6","Partido 7","Partido 8","Partido 9","Partido 10"};
        listW=new List();
        for(int i=0;i<imageNames.length;i++)
        	listW.add(imageNames[i]);
        listE=new List();
        PanelDividido panelDividido = new PanelDividido(listW,listE);
        frame.getContentPane().add(panelDividido.getSplitPane());

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }	
	
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }	
}//end class PanelDividido
