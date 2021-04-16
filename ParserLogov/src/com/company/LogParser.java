package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LogParser {
    private Path logDir;


    public LogParser(Path logDir) {this.logDir = logDir;}

//    public void read() throws IOException{ 
//        List<String> list = Files.readAllLines(logDir);
//        List<String> log = new ArrayList<>();
//        for(String s : list) {
//            if(s.contains("DONE_TASK") && s.contains("OK")) {
//                log.add(s);
//            }
//        }
//        Files.write(logDir, log);
//    }
    public void readAndWrite() throws IOException, ParseException {
        List<Log> logList = new ArrayList<>();
        List<Log> logs = new ArrayList<>();
       // BufferedReader reader = new BufferedReader(new FileReader(logDir));
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy hh:mm:ss");
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(logDir);
        for(String s : list) {
            Log log = new Log();
            String[] strings = s.split("\\t");
            log.setIp(strings[0]);
            log.setUser(strings[1]);
            log.setDate(format.parse(strings[2]));
            log.setEvent(Event.valueOf(strings[3]));
            log.setStatus(Status.valueOf(strings[4]));
            logList.add(log);
        }
        for(Log l : logList) {
            if (l.getEvent() == Event.DONE_TASK && l.getStatus() == Status.OK)
                logs.add(l);
        }
//        for(Log l : logs) {
//            System.out.println(l);
//        } //вывод на экран студентов, выполнивших задачу
        Files.write(logDir, logs);


    //  while(Files.readString(logDir) != null) {
//            Log log = new Log();
//            String[] array = Files.readString(logDir).split("\\t");
//            log.setIp(array[0]);
//            log.setUser(array[1]);
//            log.setDate(format.parse(array[2]));
//            log.setEvent(Event.valueOf(array[3]));
//            log.setEventCode(array[4]);
//            log.setStatus(Status.valueOf(array[5]));
//            //logList.add(array);
//            System.out.println(Arrays.toString(array));
//        }
        //Files.write(logDir, logList);
    }
}

class Log implements CharSequence{
    private String ip;
    private String user;
    private Date date;
    private Event event;
    private Status status;

    public Log() {
    }

//    public Log(String ip, String user, Date date, Event event, Status status) {
//        this.ip = ip;
//        this.user = user;
//        this.date = date;
//        this.event = event;
//        this.status = status;
//    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public Status getStatus() {
        return status;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }

    @Override
    public String toString() {
        return "IP: " + ip + '\t' +
                "User: " + user + '\t' +
                "Date: " + date + '\t' +
                "Event: " + event + '\t' +
                "Status: " + status;
    }
}
