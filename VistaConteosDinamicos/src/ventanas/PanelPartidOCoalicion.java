package ventanas;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;//1/5
//import java.awt.ActiveEvent;
import java.awt.event.KeyEvent;

public class PanelPartidOCoalicion {
	JPanel JP;
	JLabel DL;
	static int gr=0;
	public static int LONGI=12;//Se usa aqui en createAndShowGUI() y en la clase 
								//MostrandoElec en createAndShowGUI()
	
	public PanelPartidOCoalicion(JButton Banterior,
			String par, //Nombre de Part/Coal
			String cand,//Nombre de Candidato(a)
			int LONGI){// LONGItudes de linea en los nombre de Part/Coal y de Cand
		JP=new JPanel();
		JP.setLayout(new GridBagLayout());
		GridBagConstraints GBC=new GridBagConstraints();
		
		DL=new JLabel(" ");
		GBC.gridx=0;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
		
		GBC.gridx=1;
		GBC.gridy=1;
		GBC.gridwidth=1;
		GBC.gridheight=1;
		JP.add(Banterior, GBC);

//		DL=new JLabel("          ");
//		GBC.gridx=2;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
//		JP.add(DL,GBC);
		
		DL=new JLabel(" ");
		GBC.gridx=1;
		GBC.gridy=2;
		GBC.gridwidth=1;
		GBC.gridheight=1;
		JP.add(DL, GBC);
		
		GBC.gridx=1;
		GBC.gridy=3;
		GBC.gridwidth=1;
		GBC.gridheight=1;
//		JP.add(new JLabel(par), GBC);
		JP.add(new JTextArea(formaCad(par,LONGI)), GBC);
		
		DL=new JLabel(" ");
		GBC.gridx=1;GBC.gridy=4;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
		
		GBC.gridx=1;GBC.gridy=5;GBC.gridwidth=GBC.gridheight=1;
		JP.add(new JTextArea(formaCad(cand,LONGI)), GBC);
		
		DL=new JLabel(" ");
		GBC.gridx=6;GBC.gridy=6;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL, GBC);
	}//end PanelPartidOCoalicion()
	public PanelPartidOCoalicion(){
		
	}
	
	static String formaCad(String s,int longi){
		String S="";
//		System.out.println("S.length()="+S.length());
		Boolean status=true;/* -\n needed*/
		char vocal[]={'a','e','i','o','u','A','E','I','O','U'};
		char rol[]={'r','l','R','L','m','M','n','N'};
		int longitud=longi,inc=0;
		for(int i=0;i<s.length();i++){
//				S+=s.charAt(i);
			switch(i){
				case 0:{
					S+=s.charAt(i);break;
				}
				default:{
					if(!((S.charAt(S.length()-1)=='\n')&&(s.charAt(i)==' ')))
						S+=s.charAt(i);
				}
			}
			inc++;
			if(i+2<=s.length()-1){
				if(((i>=longitud&&
						status&&
						FnotInS(s.charAt(i),vocal)&&
						FnotInS(s.charAt(i+1),rol)&&
						!(FnotInS(s.charAt(i),vocal)&&FyesInS(s.charAt(i+1),vocal)))||
						(i>=longitud&&status&&(s.charAt(i)==' ')))&&(S.charAt(S.length()-1)!='\n')&&(inc>=longitud)){
//					System.out.println("---------------------------____________________");
					quienmasgrand(inc);
					if(s.charAt(i+1)==' '||(s.charAt(i)==' ')){
						S+="\n";//if(i+1<=s.length()-1)i++;
					}
					else
						S+="-\n";
					status=false;
//					longitud+=inc;
					inc=0;
				}
				if((((i>0)&&((i%longitud)==0)&&
						FnotInS(s.charAt(i),vocal)&&  //esto evita que se
						FnotInS(s.charAt(i+1),vocal)&&//rompan los diptongos
						FnotInS(s.charAt(i+1),rol)&&
						!(FnotInS(s.charAt(i-1),vocal)&&FyesInS(s.charAt(i),vocal)))||
						((i>0)&&((i%longitud)==0)&&(s.charAt(i)==' ')))&&
						(S.charAt(S.length()-1)!='\n')&&(inc>=longitud)){
//					System.out.println("---------------------------");
					quienmasgrand(inc);
					if(inc+distAspace(s,i)<=gr)status=false;
//					if(s.charAt(i+1)==' '||(s.charAt(i)==' ')){
//						S+="\n";//if(i+1<=s.length()-1)i++;
//					}
//					else
//						S+="-\n";
//					inc=0;
//					System.out.println("-->i="+i+" "+s.charAt(i)+" status="+status+" inc="+inc);
				}
				else{
//					System.out.println("i="+i+" "+s.charAt(i)+" status="+status+" inc="+inc);
				}
				if(((i>0)&&(i%longitud==0)&&FyesInS(s.charAt(i+1),vocal))||
						((i>0)&&(i%longitud==0)&&
								FnotInS(s.charAt(i+1),vocal)&&
								FnotInS(s.charAt(i+2),vocal))||
//								(inc==10)){
								(inc>=longitud)){
										status=true;
										if(inc+distAspace(s,i)<=gr)status=false;
//										System.out.println("i="+i+" "+s.charAt(i)+" status="+status);
				}
			}
		}
		return S;
	}
	
    public JPanel getJPanel() {
        return JP;
    }
    
    protected static Boolean FyesInS(char c,char ar[]){/*First yes In Second*/
    	for(int i=0;i<ar.length;i++)
    		if(ar[i]==c) return true;
    	return false;
    }
    protected static Boolean FnotInS(char c,char ar[]){/*First not In Second*/
    	for(int i=0;i<ar.length;i++)
    		if(ar[i]==c) return false;
    	return true;
    }
    protected static void quienmasgrand(int arg){
    	if(arg>gr)gr=arg;
//    	return gr;
    }
    protected static int distAspace(String str, int k){
    	int r=0;
    	for(int i=k;i<str.length();i++){
    		if(str.charAt(i)!=' ')r++;
    	}
    	return r;
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
//    protected static ImageIcon createImageIcon(String path) {
    public static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = ButtonDemo.class.getResource(path);
        java.net.URL imgURL = PanelPartidOCoalicion.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	JButton  BPartidoCoal;
    	ImageIcon partidoButtonIcon = createImageIcon("images/middle.gif");
    	BPartidoCoal=new JButton("PARTIDO/COALICION",partidoButtonIcon);
    	BPartidoCoal.setVerticalTextPosition(AbstractButton.BOTTOM);
    	BPartidoCoal.setHorizontalTextPosition(AbstractButton.CENTER);
    	BPartidoCoal.setMnemonic(KeyEvent.VK_M);
    	PanelPartidOCoalicion ventana=new 
    			PanelPartidOCoalicion(BPartidoCoal,
    					"PARTIDO DE NOMBRE LARGO MUY LARGO",
    					"CANDIDATO DE NOMBRE LARGO PROBANDO "
    					+ "UN NOMBRE DE CANDIDATO MUY LARGO",LONGI);
    	//contd.F.pack();
    	//ventana.JF.setPreferredSize(new Dimension(400, 300));
    	
    	JFrame frame=new JFrame("     ");
    	frame.add(ventana.JP);
    	frame.setLocationRelativeTo(null);
//    	frame.setSize(100, 200);
    	frame.pack();
    	frame.setVisible(true);
    }//end createAndShowGUI()
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}//end class PanelPartidOCoalicion
