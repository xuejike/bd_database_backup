package com.bidanet.bdcms.plugin.bdbackup;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.*;

/**
 * Created by xuejike on 2017/1/5.
 */
public class DbBackupTool {
    private Executor exec=new DefaultExecutor();
//    private String mysqlDumpPath;
    private String host;
    private String username;
    private String pwd;
    private String dbname;



    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    protected void checkFiles(){
//        File file = new File(mysqlPath + "/mysqldump.exe");

    }

    public boolean backup(String path) throws IOException {
        CommandLine mysqldump = new CommandLine("mysqldump -h "+host+" -u "+username+" -p"+pwd+" "+dbname);

//        PipedOutputStream stdout = new PipedOutputStream();
//        PipedOutputStream stderr = new PipedOutputStream();
//        PipedInputStream stdin = new PipedInputStream();
//        PumpStreamHandler streamHandler=new PumpStreamHandler(stdout,stderr,stdin);
//        exec.setStreamHandler(streamHandler);
//        BufferedOutputStream ins = new BufferedOutputStream(new PipedOutputStream(stdin));

        return false;
    }
    public boolean recover(String path) throws IOException {
        CommandLine mysqldump = new CommandLine("mysql -h "+host+" -u "+username+" -p"+pwd+" "+dbname);

        PipedOutputStream stdout = new PipedOutputStream();
        PipedOutputStream stderr = new PipedOutputStream();
        PipedInputStream stdin = new PipedInputStream();
        PumpStreamHandler streamHandler=new PumpStreamHandler(stdout,stderr,stdin);

        exec.setStreamHandler(streamHandler);

        exec.execute(mysqldump);

        BufferedOutputStream ins = new BufferedOutputStream(new PipedOutputStream(stdin));
        ins.write(path.getBytes());

        return false;
    }

    public static void main(String[] p) throws IOException {
        DbBackupTool tool = new DbBackupTool();
        tool.setHost("116.62.52.225");
        tool.setUsername("admin");
        tool.setPwd("password");
        tool.setDbname("bjtest");
        tool.recover("ss.sql");
    }

}
