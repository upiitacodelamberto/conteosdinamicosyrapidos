package components;
//https://www.brushmyskills.com/java-8/lines-method-bufferedreader-files-factory-class-in-java-8/
//54808 Extension Dr. Miguel Angel Martinez Cruz
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
 
public class TextFileReaderDemo1 {
 
	public static void main(String[] args) {
		// java 7:try with resources
		String RutaAbsDFdC;
		RutaAbsDFdC="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/MEX_GOB_2017/MEX_GOB_2017.csv";
//		try(BufferedReader reader = new BufferedReader( new FileReader(
//				new File("C:\\DevLog\\mydev.log")));) {
		try(BufferedReader reader = new BufferedReader( new FileReader(new File(RutaAbsDFdC)));) {				
 
		Stream<String> stream = reader.lines();
		stream.filter(line -> line.contains("id_estado"))
		                          .findFirst()
		                          .ifPresent(System.out::println);
		reader.close();
		BufferedReader br=new BufferedReader( new FileReader(new File(RutaAbsDFdC)));
		long lineNo=br.lines().count();
		br.close();//Esto lo agrego hoy 2017.07.04
		br=new BufferedReader( new FileReader(new File(RutaAbsDFdC)));
		long lineNo2=br.lines().count();
		br.close();
		System.out.println(lineNo); // 18613
		System.out.println(lineNo2);// 18613
		} catch(IOException ioe ){
			ioe.printStackTrace();
		}
   }//end main()
 
}//end class TextFileReaderDemo1