package example.one;

import java.sql.Connection;

public class NexusRunner {
    public static void main(String[] args) {
        String tableName="Employee";

        //generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

        //generating MySql HTML report and Oracle PDF report using Facade
        DbFacade.generateReport(DbFacade.DBTypes.MYSQL, DbFacade.ReportTypes.HTML, tableName);
        DbFacade.generateReport(DbFacade.DBTypes.ORACLE, DbFacade.ReportTypes.PDF, tableName);
    }
}
