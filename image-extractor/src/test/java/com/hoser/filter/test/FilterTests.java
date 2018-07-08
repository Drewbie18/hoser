package com.hoser.filter.test;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.ModuleDescription;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import java.io.File;
import java.util.List;

public class FilterTests {

    Logger logger = LogManager.getRootLogger();

    @Test
    public void getVlcFilters(){

        MediaPlayerFactory factory = new MediaPlayerFactory();

        List<ModuleDescription> audioFilters = factory.getAudioFilters();
        List<ModuleDescription> videoFilters = factory.getVideoFilters();

    }

    @Test
    public void loadNativeLibs(){

        File file = new File("src/main/resources/vlc");
        String vlcPath = file.getAbsolutePath();
        System.out.println(file.exists());
        System.out.println(vlcPath);

        System.out.println(RuntimeUtil.getLibVlcLibraryName());

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);


        MediaPlayerFactory factory = new MediaPlayerFactory();

        List<ModuleDescription> audioFilters = factory.getAudioFilters();
        List<ModuleDescription> videoFilters = factory.getVideoFilters();

        videoFilters.forEach(moduleDescription -> {
            logger.debug(moduleDescription.longName());
        });





    }

}
