package libro.cap08.app.ver1;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import libro.cap04.DeptDTO;
import libro.cap04.EmpDTO;

public class UDto
{
	public static DeptDTO stringToDeptDTO(String s)
	{
		DeptDTO dto = new DeptDTO();
		StringTokenizer st = new StringTokenizer(s,",");		
		
		dto.setDeptno(Integer.parseInt(st.nextToken()));
		dto.setDname(st.nextToken());
		dto.setLoc(st.nextToken());
		
		return dto;
	}
	
	public static EmpDTO stringToEmpDTO(String s)
	{
		EmpDTO dto = new EmpDTO();
		StringTokenizer st = new StringTokenizer(s,",");		
		
		dto.setEmpno(Integer.parseInt(st.nextToken()));
		dto.setEname(st.nextToken());
		
		String sHiredate = st.nextToken();
		
		dto.setDeptno(Integer.parseInt(st.nextToken().trim()));
		
		StringTokenizer stDate = new StringTokenizer(sHiredate,"-");
		int anio = Integer.parseInt(stDate.nextToken().trim());
		int mes = Integer.parseInt(stDate.nextToken().trim());
		int dia = Integer.parseInt(stDate.nextToken().trim());
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR,anio);
		gc.set(Calendar.MONTH,mes);
		gc.set(Calendar.DAY_OF_MONTH,dia);
		
		dto.setHiredate(new Date(gc.getTimeInMillis()));
		
		return dto;	
	}
}
