
package libro.cap04;

public class EmpDAOHSqlDBImple extends EmpDAO
{
	public String queryBuscarUltimosEmpleados()	
	{
			String sql = "";
			sql+="SELECT empno, ename, hiredate, deptno ROWNUM AS rn ";
			sql+="FROM emp ";
			sql+="ORDER BY hiredate DESC ";
			sql+="WHERE rn <= ? ";
			return sql;
	}
}


