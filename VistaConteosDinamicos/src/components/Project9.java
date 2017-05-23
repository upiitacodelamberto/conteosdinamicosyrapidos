package components;
import java.awt.*;

import java.awt.event.*;

import java.io.*;

  

public class Project9 extends Frame

{

    TextField textfield1;

    Button button;

    TextArea textarea = new TextArea("",20,20,20);

     

    File outFile = new File("I://TextField.txt");;

    FileOutputStream outFileStream = new FileOutputStream(outFile);

    PrintWriter outStream = new PrintWriter(outFileStream);

     

    File inFile = new File("I://TextField.txt");

    FileReader myFileReader = new FileReader(inFile);

    BufferedReader myBufReader = new BufferedReader(myFileReader);

 

    public Project9() throws IOException

    {

        setTitle("Project9");

        setSize(400,400);

        setLayout(new FlowLayout());

  

        textfield1 = new TextField("",10);

        button = new Button("Click");

       

        add(textfield1);

        add(button);

        add(textarea);

         

        addWindowListener(new WindowAdapter()

        {

            public void windowClosing(WindowEvent e)

            {

                System.exit(0);

            }

        });

         

        button.addActionListener(new ActionListener()

        {

            public void actionPerformed(ActionEvent e)

            {  

                outStream.write(textfield1.getText());

                        //textarea.append(myBufReader.readLine());

                        //myBufReader.close();

                        outStream.close();

            }

        });

    }

 

    public static void main(String[] args) throws IOException

    {

        Project9 guiInterface = new Project9();

        guiInterface.setVisible(true);

    }

}
