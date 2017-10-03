
package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

public class DeptDAO
{
	public Collection<DeptDTO> buscarTodos()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = UConnection.getConnection();
			String sql = "";
			sql+="SELECT deptno, dname, loc ";
			sql+="FROM dept ";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			DeptDTO dto = null;
			
			while( rs.next() )
			{
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno") );
				dto.setDname( rs.getString("dname") );
				dto.setLoc( rs.getString("loc") );
				ret.add(dto);
			}
			
			return ret;
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public Collection<DeptDTO> buscarXLoc(String loc)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = UConnection.getConnection();
			String sql = "";
			sql+="SELECT deptno, dname, loc ";
			sql+="FROM dept ";
			sql+="WHERE loc = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,loc);
			
			rs = pstm.executeQuery();
			
			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			DeptDTO dto = null;
			
			while( rs.next() )
			{
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno") );
				dto.setDname( rs.getString("dname") );
				dto.setLoc( rs.getString("loc") );
				ret.add(dto);
			}
			
			return ret;
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public DeptDTO buscar(int deptno)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = UConnection.getConnection();
			String sql = "";
			sql+="SELECT deptno, dname, loc ";
			sql+="FROM dept ";
			sql+="WHERE deptno = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,deptno);
			
			rs = pstm.executeQuery();
			
			DeptDTO dto = null;
			
			if( rs.next() )
			{
				dto = new DeptDTO();
				dto.setDeptno(deptno);
				dto.setDname( rs.getString("dname") );
				dto.setLoc( rs.getString("loc") );
			}
			
			return dto;
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	
	// popopo
	// sklskflskf
	
	
	public void insertar(DeptDTO dto)
	{
		// popo
		Connection con = null;
		PreparedStatement pstm = null;
		
		try
		{
			con = UConnection.getConnection();
			String sql = "INSERT INTO dept (deptno, dname, loc) VALUES(?,?,?)";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,dto.getDeptno());
			pstm.setString(2,dto.getDname());
			pstm.setString(3,dto.getLoc());
			
			int rtdo = pstm.executeUpdate();
			
			if( rtdo!=1  )
			{
				throw new RuntimeException("Error en insert");
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public void modificar(DeptDTO dto)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try
		{
			con = UConnection.getConnection();
			String sql = "";
			sql += "UPDATE dept set dname=?, loc=? ";
			sql += "WHERE deptno = ? ";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,dto.getDname());
			pstm.setString(2,dto.getLoc());
			pstm.setInt(3,dto.getDeptno());
			int rtdo = pstm.executeUpdate();
			
			if( rtdo!=1  )
			{
				throw new RuntimeException("Error en update");
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public void eliminiar(int deptno)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try
		{
			con = UConnection.getConnection();
			String sql = "";
			sql += "DELETE FROM dept WHERE deptno = ? ";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,deptno);
			
			int rtdo = pstm.executeUpdate();
			
			if( rtdo!=1  )
			{
				throw new RuntimeException("Error en delete");
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}	
	
   // retorna los n departamentos con mayor cantidad de empleados
//	public int departamentosXCantEmps(int n)
//	{
//		Connection con = null;
//		PreparedStatement pstm = null;
//		ResultSet rs = null;
//		
//		try
//		{
//			con = UConnection.getConnection();
//			String sql = "";
//			sql+="SELECT d.deptno, count(*) as c "; 
//			sql+="FROM emp e, dept d ";
//			sql+="WHERE e.deptno = d.deptno ";
//			sql+="GROUP BY d.deptno ";
//			sql+="ORDER BY c desc ";
//			sql+="LIMIT ? ";
//			
//			pstm = con.prepareStatement(sql);
//			pstm.setInt(1,n);
//			
//			rs = pstm.executeQuery();
//			
//			Vector<DeptDTO> ret = new Vector<DeptDTO>();
//			DeptDTO dto = null;
//			
//			while( rs.next() )
//			{
//				dto = new DeptDTO();
//				dto.setDeptno(rs.getInt("deptno") );
//				dto.setDname( rs.getString("dname") );
//				dto.setLoc( rs.getString("loc") );
//				ret.add(dto);
//			}
//			
//			return ret;
//		}		
	
	
}


