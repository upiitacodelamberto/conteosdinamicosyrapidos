//package libro.cap04;
//
//import java.util.Collection;
//import java.util.Scanner;
//
//public class TestDeptDAO2
//{
//	public static void main(String[] args)
//	{
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.print("Ingrese un Nro. de Departamento (deptno): ");
//		int deptno = scanner.nextInt();
//		
//		DeptDAO dept = (DeptDAO)UConnection.getDAO("DEPT");
//		DeptDTO dto = dept.buscar(deptno);
//		
//		System.out.println( dto );
//		
//		Collection<DeptDTO> coll = dept.buscarXLoc("Santa Fe");
//		
//		for( DeptDTO aux: coll)
//		{
//			System.out.println(aux);
//		}
//		
//		dto.setDeptno(43);
//		dto.setDname("pepe");
//		dept.insertar(dto);
//	}
//}
