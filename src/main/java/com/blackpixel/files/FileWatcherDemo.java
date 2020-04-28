package com.blackpixel.files;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatcherDemo {
    public static void main(String[] args) {
        try{
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path watchedDir = Paths.get("C:/Temp");
            watchedDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            System.out.println("Watching " + watchedDir);
            while(true){
                /* When an event for an object is detected the key is signalled,
                 and if not currently signalled, it is queued to the watch service
                  so that it can be retrieved by consumers that invoke the poll
                  or take methods to retrieve keys and process events.*/
                WatchKey key = watcher.take();
                for(WatchEvent<?> event : key.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    WatchEvent<Path> watchEvent = (WatchEvent<Path>)event;
                    Path pathName = watchEvent.context();
                    if(kind == ENTRY_MODIFY){
                        System.out.println(pathName + " modified!");
                    }else if (kind == ENTRY_DELETE){
                        System.out.println(pathName + " deleted!");
                    }else{
                        System.out.println(pathName + " created");
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
