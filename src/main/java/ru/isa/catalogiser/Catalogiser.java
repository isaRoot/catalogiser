package ru.isa.catalogiser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class Catalogiser {
    public static void main(String[] args) {
        String catpath = "../";
        /*try {
            List<Path> collect = Files.walk(Paths.get(catpath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            for (Path p: collect) {
//                System.out.println(p.toFile().getName());
                System.out.println(p.toString());
                if(p.toString().contains("20180202_092025")){
                    System.out.println("Tada");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        PropertiesWork pwrk = new PropertiesWork();
        pwrk.readProps();
        getFileNames(pwrk);

    }

    public static void testProps(PropertiesWork pwrk) {
        String testkey = pwrk.getProp("testkey");
        String message = pwrk.getProp("message");
        System.out.println(testkey);
        System.out.println(message);
    }

    public static void getFileNames(PropertiesWork pwrk){
        String cataloguePath = pwrk.getProp("cataloguePath");
        System.out.println(cataloguePath);
        try {
            //v1
            List<Path> collect = Files.walk(Paths.get(cataloguePath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            List<File> collect1 = Files.walk(Paths.get(cataloguePath))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
//            collect.get(1).toString();
/*            for (File f:collect1) {
                System.out.println(f.toString());
            }
            for (File f:collect1) {
                System.out.println(f.getName());
            }
            for (Path p: collect) {
                System.out.println(p.toString());
            }
*/
            for (Path p: collect) {
                System.out.println(p.toFile().getName());
                if(p.toString().contains("20180202_092025")){
                    System.out.println("Tada");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
