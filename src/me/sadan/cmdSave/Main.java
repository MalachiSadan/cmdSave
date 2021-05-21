package me.sadan.cmdSave;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args[0].equals("-add")) {
            try {
                StringBuilder s = new StringBuilder();
                FileWriter file = new FileWriter("./cmds.txt");
                File file1 = new File("./cmds.txt");
                Scanner read = new Scanner(file1);
                while (read.hasNextLine()) {
                    s.append(read.nextLine());
                }
                s.append("\n").append(args[1]).append(" ").append(args[2]);
                file.append(s);
                file.close();
                System.out.println("Added command successfully");
            } catch (IOException e ) {
                System.out.println("an error has occurred");
                e.printStackTrace();
            }

        } else if (args[0].equals("-run")) {
            try {
                File file = new File("C:\\Users\\SadanKids\\Desktop\\cmdSave\\cmds.txt");
                Scanner read = new Scanner(file);
                String name,cmd;
                while (read.hasNextLine()) {
                    name = read.nextLine();
                    if (name.startsWith(args[1])) {
                        try {
                            cmd=name.substring(args[1].length()+1);
                            Runtime.getRuntime().exec(cmd);
                            return;
                        } catch (IOException e) {
                            System.out.println("an error has occurred while running the command");
                            return;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("an error has occurred. try to reinstall the program");
                return;
            }
            System.out.println("no command named "+args[1]);
        }
    }
}
