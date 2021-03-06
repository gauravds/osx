/*
 * JBoss, the OpenSource J2EE webOS
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */

package org.jboss.test.jca.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;


/**
 * TestStatement.java
 *
 *
 * Created: Sat Apr 20 14:29:19 2002
 *
 * @author <a href="mailto:d_jencks@users.sourceforge.net">David Jencks</a>
 * @version
 */

public class TestStatement
   implements Statement
{

   private final TestDriver driver;

   public TestStatement(final TestDriver driver)
   {
      this.driver = driver;
   }
   // implementation of java.sql.Statement interface

   /**
    *
    * @exception java.sql.SQLException <description>
    */
   public void close() throws SQLException
   {
   }

   /**
    *
    * @param param1 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public boolean execute(String sql) throws SQLException
   {
      if (driver.getFail())
      {
         throw new SQLException("asked to fail");
      } // end of if ()
      return false;

   }

   /**
    *
    * @param param1 <description>
    * @param param2 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public boolean execute(String sql, int autoGeneratedKeys) throws SQLException
   {
      return execute(sql);
   }

   /**
    *
    * @param param1 <description>
    * @param param2 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public boolean execute(String sql, int[] columnIndexes) throws SQLException
   {
      return execute(sql);
   }

   /**
    *
    * @param param1 <description>
    * @param param2 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public boolean execute(String sql, String[]columnNames ) throws SQLException
   {
      return execute(sql);
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public Connection getConnection() throws SQLException
   {
      return null;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public SQLWarning getWarnings() throws SQLException
   {
      return null;
   }

   /**
    *
    * @exception java.sql.SQLException <description>
    */
   public void clearWarnings() throws SQLException
   {
   }

   /**
    *
    * @param param1 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public ResultSet executeQuery(String sql) throws SQLException
   {
      execute(sql);
      return null;
   }

   /**
    *
    * @param param1 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int executeUpdate(String sql) throws SQLException
   {
      execute(sql);
      return 0;
   }

   /**
    *
    * @param param1 <description>
    * @param param2 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException
   {
      return executeUpdate(sql);
   }

   /**
    *
    * @param param1 <description>
    * @param param2 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int executeUpdate(String sql, int[] columnIndexes) throws SQLException
   {
      return executeUpdate(sql);
   }

   /**
    *
    * @param param1 <description>
    * @param param2 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int executeUpdate(String sql, String[] columnNames) throws SQLException
   {
      return executeUpdate(sql);
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getMaxFieldSize() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setMaxFieldSize(int max) throws SQLException
   {
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getMaxRows() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setMaxRows(int max) throws SQLException
   {
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setEscapeProcessing(boolean enable) throws SQLException
   {
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getQueryTimeout() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setQueryTimeout(int timeout) throws SQLException
   {
   }

   /**
    *
    * @exception java.sql.SQLException <description>
    */
   public void cancel() throws SQLException
   {
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setCursorName(String name) throws SQLException
   {
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public ResultSet getResultSet() throws SQLException
   {
      return null;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getUpdateCount() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public boolean getMoreResults() throws SQLException
   {
      return false;
   }

   /**
    *
    * @param param1 <description>
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public boolean getMoreResults(int current) throws SQLException
   {
      return false;
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setFetchDirection(int direction) throws SQLException
   {
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getFetchDirection() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void setFetchSize(int rows) throws SQLException
   {
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getFetchSize() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getResultSetConcurrency() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getResultSetType() throws SQLException
   {
      return 0;
   }

   /**
    *
    * @param param1 <description>
    * @exception java.sql.SQLException <description>
    */
   public void addBatch(String sql) throws SQLException
   {
   }

   /**
    *
    * @exception java.sql.SQLException <description>
    */
   public void clearBatch() throws SQLException
   {
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int[] executeBatch() throws SQLException
   {
      return null;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public ResultSet getGeneratedKeys() throws SQLException
   {
      return null;
   }

   /**
    *
    * @return <description>
    * @exception java.sql.SQLException <description>
    */
   public int getResultSetHoldability() throws SQLException
   {
      return 0;
   }


}// LocalStatement
