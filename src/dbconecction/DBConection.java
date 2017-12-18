/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconecction;
import java.sql.*;
/**
 *
 * @author Chronos-Laptop
 */ 
public class DBConection {
    private Connection myDBCon;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cst;
    
    public DBConection()
    {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (Exception e) {
            System.err.printf("Error: "+e);
        }
            
        try {
            myDBCon = DriverManager.getConnection("jdbc:db2://192.168.56.101:50000/coop", "db2admin", "hitler45");
            st = myDBCon.createStatement();
            System.out.printf("succes");
        } catch (Exception e) {
            System.err.printf("ERROR"+e);
        }
    }
    public ResultSet getData(String query)
    {
        try {
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.err.printf("Error query"+e);
            return null;
        }
    }
    
//    CallableStatement.executeUpdate
//Invoke this method if the stored procedure does not return result sets.
//CallableStatement.executeQuery
//Invoke this method if the stored procedure returns one result set.
//You can invoke CallableStatement.executeQuery for a stored procedure that returns no result sets if you set property allowNullResultSetForExecuteQuery to DB2BaseDataSource.YES (1). In that case, CallableStatement.executeQuery returns null. This behavior does not conform to the JDBC standard.
//CallableStatement.execute
//Invoke this method if the stored procedure returns multiple result sets, or an unknown number of result sets.
   
}
